package com.zjjf.analysis.services.security;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.zjjf.analysis.beans.analysis.users.UserInfos;
import com.zjjf.analysis.dao.analysis.AuthorityMapper;

public class AuthorityService {

	@Autowired
	AuthorityMapper authorityMapper;

	public UserInfos getUserByUserInfosCredential(String userName) {
		return authorityMapper.getUserByUserInfosCredential(userName);
	}

	public Set<String> getRolesByUserId(String userId) {
		return authorityMapper.getRolesByUserId(userId);
	}

	public Set<String> getAuthsByUserId(String userId) {
		return authorityMapper.getAuthsByUserId(userId);
	}
}
