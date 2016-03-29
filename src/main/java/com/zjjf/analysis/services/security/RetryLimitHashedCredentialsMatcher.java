package com.zjjf.analysis.services.security;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

	private static final Logger logger = LoggerFactory.getLogger(RetryLimitHashedCredentialsMatcher.class);

	@Autowired
	private EhCacheCacheManager springCacheManager;

	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		
		logger.info("..........................................正在密码验证...............................................................");
		Cache passwordRetryCache = springCacheManager.getCache("passwordRetryCache");
		String username = (String) token.getPrincipal();
		AtomicInteger count = (AtomicInteger) passwordRetryCache.get(username);
		logger.debug("在当前缓存{}，获取用户名：{}, 获取登陆次数：{}", passwordRetryCache.getName(), username);
		if (count == null) {
			count = new AtomicInteger(0);
			passwordRetryCache.put(username, count);
		}
		if (count.incrementAndGet() > 5) {
			throw new ExcessiveAttemptsException();
		}
		boolean matches = super.doCredentialsMatch(token, info);
		logger.info("..........................................验证结果{}..............................................................", matches);
		if (matches) {
			passwordRetryCache.evict(username);
		}
		return matches;
	}

}
