package com.zjjf.analysis.mapper.local;

import com.zjjf.analysis.beans.local.AnaSporderinfo;

public interface AnaSporderinfoMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(AnaSporderinfo record);

    int insertSelective(AnaSporderinfo record);

    AnaSporderinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnaSporderinfo record);

    int updateByPrimaryKey(AnaSporderinfo record);
}