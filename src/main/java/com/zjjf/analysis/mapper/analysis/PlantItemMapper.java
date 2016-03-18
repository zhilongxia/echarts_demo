package com.zjjf.analysis.mapper.analysis;

import java.util.List;

import com.zjjf.analysis.beans.analysis.PlantItem;

public interface PlantItemMapper {

	List<PlantItem> selectByIndex(Integer idIndex);
}