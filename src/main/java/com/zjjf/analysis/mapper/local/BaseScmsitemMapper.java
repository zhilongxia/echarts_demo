package com.zjjf.analysis.mapper.local;

import com.zjjf.analysis.beans.local.BaseScmsitem;

public interface BaseScmsitemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseScmsitem record);

    int insertSelective(BaseScmsitem record);

    BaseScmsitem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseScmsitem record);

    int updateByPrimaryKey(BaseScmsitem record);
}