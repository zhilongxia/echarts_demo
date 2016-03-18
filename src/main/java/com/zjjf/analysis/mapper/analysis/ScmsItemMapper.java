package com.zjjf.analysis.mapper.analysis;

import java.util.List;

import com.zjjf.analysis.beans.analysis.ScmsItem;

public interface ScmsItemMapper {
	
	List<ScmsItem> selectByIndex(String idIndex);
}