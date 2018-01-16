package com.iup.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iup.Idao.IDao;
import com.iup.exception.GenericException;
import com.iup.exception.NoDataFoundException;
import com.iup.vo.ParentChildVO;

@Component
public class ParentChildBusinessObject {

	@Autowired
	private IDao iupDao;

	public ParentChildVO getImmediateUltimateParent(ParentChildVO pcVo) throws NoDataFoundException, GenericException {
		try {
			if (null != pcVo && !pcVo.getChildId().isEmpty()) {

				ChildParentRel childParentRel = getChildParentObject(pcVo.getChildId());
				if (null != childParentRel) {
					pcVo.setImmediateParentId(String.valueOf(childParentRel.getParentId()));
				} else {
					throw new NoDataFoundException("Record not found in Database");
				}
				pcVo.setUltimateParentId(String.valueOf(recursive(pcVo.getChildId()))); // setting
																						// ultimate
																						// parent
																						// id
			} else {
				throw new GenericException("Inappropriate Input");
			}
		} catch (Exception exception) {
			throw new GenericException("Couldn't process your transaction. Please contact your system administor.");
		}
		return pcVo;
	}

	private String recursive(String childId) {

		// assuming ultimate parent
		// id would be present
		// within the 100
		// records else setting
		// 100th record as
		// ultimate parent id
		for (int count = 0; count <= 100; count++) { 
			ChildParentRel childParentRel = getChildParentObject(childId);
			if (null == childParentRel) {
				break;
			} else {
				childId = String.valueOf(childParentRel.getParentId());
			}
		}

		return childId;
	}

	private ChildParentRel getChildParentObject(String childId) {
		ChildParentRel childParent = iupDao.getAllParentChildRecords(childId);
		return childParent;
	}

	/*
	 * @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	 * public void insertChildParentRel(ParentChildVO pcVo){ TransactionStatus
	 * status = transactionManager.getTransaction(new
	 * DefaultTransactionDefinition()); try {
	 * iupDao.insertChildParentRecord(pcVo); transactionManager.commit(status);
	 * }catch(DataAccessException e) {
	 * System.out.println("Error in creating record, rolling back");
	 * transactionManager.rollback(status); } }
	 */
}
