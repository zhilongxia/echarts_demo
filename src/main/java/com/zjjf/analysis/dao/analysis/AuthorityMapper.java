package com.zjjf.analysis.dao.analysis;

import java.util.Set;

import com.zjjf.analysis.beans.analysis.users.UserInfos;
import com.zjjf.analysis.beans.login.ScManager;

public interface AuthorityMapper {

	ScManager getUserByScManagerCredential(String credential);

	UserInfos getUserByUserInfosCredential(String credential);

	public Set<String> getRolesByUserId(String userId);

	public Set<String> getAuthsByUserId(String userId);

}