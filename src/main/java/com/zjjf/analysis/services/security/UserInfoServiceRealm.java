package com.zjjf.analysis.services.security;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.zjjf.analysis.beans.analysis.users.UserInfos;

public class UserInfoServiceRealm extends AuthorizingRealm {

	private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceRealm.class);

	@Autowired
	private AuthorityService authorityService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub

		logger.debug("================doGetAuthorizationInfo====================");
		String userId = (String) principals.fromRealm(getName()).iterator().next();
		logger.debug("============当前用户:" + userId + "================");
		if (!StringUtils.isEmpty(userId)) {
			SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
			Set<String> rolesSet = authorityService.getRolesByUserId(userId);
			authorizationInfo.setRoles(rolesSet);
			Set<String> auths = authorityService.getAuthsByUserId(userId);
			authorizationInfo.setStringPermissions(auths);
			return authorizationInfo;
		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

		logger.info("================doGetAuthenticationInfo====================");
		if (authcToken == null) {
			return null;
		} else {
			UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
			String credential = token.getUsername();
			if (StringUtils.isEmpty(credential)) {
				return null;
			}
			UserInfos userInfo = null;
			try {
				userInfo = authorityService.getUserByUserInfosCredential(credential);
				logger.info("根据手机号获取当前用户：id：{},密码：{}，手机号：{}，用户名：{}", userInfo.getId(), userInfo.getPassword());
			} catch (Exception e) {
				return null;
			} finally {
				if (userInfo == null)
					throw new UnknownAccountException();
			}
			SimpleAuthenticationInfo sauth = new SimpleAuthenticationInfo(userInfo.getId(), userInfo.getPassword(), getName());
			return sauth;
		}
	}
}
