package com.zjjf.analysis.mapper.local;

import com.zjjf.analysis.beans.local.BaseItembase;

public interface BaseItembaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseItembase record);

    int insertSelective(BaseItembase record);

    BaseItembase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseItembase record);

    int updateByPrimaryKeyWithBLOBs(BaseItembase record);

    int updateByPrimaryKey(BaseItembase record);
}