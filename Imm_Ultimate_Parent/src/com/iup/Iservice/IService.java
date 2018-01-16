package com.iup.Iservice;

import com.iup.exception.GenericException;
import com.iup.exception.NoDataFoundException;
import com.iup.vo.ParentChildVO;

public interface IService {

	public ParentChildVO getImmediateUltimateParentDetail(int childId) throws NoDataFoundException, GenericException;
}
