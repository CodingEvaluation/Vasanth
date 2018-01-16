package com.iup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.iup.Iservice.IService;
import com.iup.bo.ParentChildBusinessObject;
import com.iup.exception.GenericException;
import com.iup.exception.NoDataFoundException;
import com.iup.vo.ParentChildVO;

@Service("IUPServiceImpl")
public class IUPServiceImpl implements IService {

	@Autowired
	private ParentChildBusinessObject parentChildBo;

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ParentChildVO getImmediateUltimateParentDetail(int childId) throws NoDataFoundException, GenericException {
		ParentChildVO pcVo = new ParentChildVO();
		pcVo.setChildId(String.valueOf(childId));
		return parentChildBo.getImmediateUltimateParent(pcVo);
	}

	/*
	 * public void insertChildParentRel(ParentChildVO pcVo){
	 * parentChildBo.insertChildParentRel(pcVo); }
	 */
}
