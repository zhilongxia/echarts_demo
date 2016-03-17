package com.zjjf.analysis.mapper.local;

import com.zjjf.analysis.beans.local.Anaspgroup;

public interface AnaspgroupMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Anaspgroup record);

    int insertSelective(Anaspgroup record);

    Anaspgroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Anaspgroup record);

    int updateByPrimaryKey(Anaspgroup record);
}