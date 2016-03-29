package com.zjjf.analysis.services.security;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.zjjf.analysis.beans.login.ScManager;
import com.zjjf.analysis.beans.vo.LoginVo;
import com.zjjf.analysis.beans.vo.ModelMsg;
import com.zjjf.analysis.constants.SessionConfig;
import com.zjjf.analysis.dao.analysis.AuthorityMapper;
import com.zjjf.analysis.dao.datasource.ScManagerMapper;

@Service
public class AuthorityServiceImpl {

	private static Logger logger = LoggerFactory.getLogger(AuthorityServiceImpl.class);

	@Autowired
	private AuthorityMapper authorityMapper;

	@Autowired
	private ScManagerMapper scManagerMapper;

	public ModelMsg dealSuccessLogin(LoginVo loginRo, HttpServletRequest request, Model model) {

		ScManager userInfos = authorityMapper.getUserByScManagerCredential(loginRo.getUserName());
		if (userInfos == null) {
			return new ModelMsg(false, "未找到用户");
		} else {
			SecurityUtils.getSubject().getSession().setAttribute(SessionConfig.user_session_code, userInfos);
			ScManager scManager = new ScManager();
			scManager.setId(userInfos.getId());
			scManager.setLoginIP(request.getRemoteAddr());
			scManager.setLastTime(new Date());
			int count = scManagerMapper.updateByPrimaryKeySelective(scManager);
			if (count == 1) {
				logger.info("用户登陆成功,id:{},手机号：{},名称,{}", userInfos.getId(), userInfos.getMobile());
				return new ModelMsg(true, "登陆成功");
			} else {
				return new ModelMsg(false, "数据异常");
			}
		}
	}
}
