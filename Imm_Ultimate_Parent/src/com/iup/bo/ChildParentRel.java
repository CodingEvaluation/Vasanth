package com.iup.bo;

import org.springframework.stereotype.Component;

@Component
public class ChildParentRel {

	private Integer parentId;
	private Integer childId;

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getChildId() {
		return childId;
	}

	public void setChildId(Integer childId) {
		this.childId = childId;
	}

}
