package com.zjjf.analysis.mapper.analysis;

import java.util.List;

import com.zjjf.analysis.beans.analysis.SpOrderInfo;

public interface SpOrderInfoMapper {

    SpOrderInfo selectByPrimaryKey(String id);
    
    List<SpOrderInfo> selectByIndex(Integer addTimeIndex);
}