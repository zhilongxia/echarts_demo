package com.zjjf.analysis.mapper.local;

import com.zjjf.analysis.beans.local.BasePlantitem;

public interface BasePlantitemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BasePlantitem record);

    int insertSelective(BasePlantitem record);

    BasePlantitem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasePlantitem record);

    int updateByPrimaryKey(BasePlantitem record);
}