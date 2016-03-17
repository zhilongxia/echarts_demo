package com.zjjf.analysis.beans.local;

public class AnaspgroupmapKey {
    private String spId;

    private Integer groupId;

    public String getSpId() {
        return spId;
    }

    public void setSpId(String spId) {
        this.spId = spId == null ? null : spId.trim();
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}