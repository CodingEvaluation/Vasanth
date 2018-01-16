package com.iup.Idao;

import com.iup.bo.ChildParentRel;

public interface IDao {
	public ChildParentRel getAllParentChildRecords(String childId);
}
