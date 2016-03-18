package com.zjjf.analysis.mapper.analysis;

import java.util.List;

import com.zjjf.analysis.beans.analysis.ItemBase;

public interface ItemBaseMapper {

	List<ItemBase> selectByIndex(Integer idIndex);
}