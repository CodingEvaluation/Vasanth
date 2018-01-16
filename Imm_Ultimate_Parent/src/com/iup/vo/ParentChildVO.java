package com.iup.vo;

public class ParentChildVO {

	private String parentId;
	private String childId;
	private String immediateParentId;
	private String ultimateParentId;

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getChildId() {
		return childId;
	}

	public void setChildId(String childId) {
		this.childId = childId;
	}

	public String getImmediateParentId() {
		return immediateParentId;
	}

	public void setImmediateParentId(String immediateParentId) {
		this.immediateParentId = immediateParentId;
	}

	public String getUltimateParentId() {
		return ultimateParentId;
	}

	public void setUltimateParentId(String ultimateParentId) {
		this.ultimateParentId = ultimateParentId;
	}

}
