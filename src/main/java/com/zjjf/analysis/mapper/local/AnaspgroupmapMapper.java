package com.zjjf.analysis.mapper.local;

import com.zjjf.analysis.beans.local.AnaspgroupmapKey;

public interface AnaspgroupmapMapper {
	
    int deleteByPrimaryKey(AnaspgroupmapKey key);

    int insert(AnaspgroupmapKey record);

    int insertSelective(AnaspgroupmapKey record);
}