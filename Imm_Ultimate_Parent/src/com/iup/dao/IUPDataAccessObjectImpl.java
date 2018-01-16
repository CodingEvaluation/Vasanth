
package com.iup.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iup.Idao.IDao;
import com.iup.bo.ChildParentRel;
import com.iup.constant.SQLConstants;
import com.iup.vo.ParentChildVO;

/**
 * This class will be called from the BO layer, 'PatientHealthRecordBO'
 *
 */
@Repository
public class IUPDataAccessObjectImpl implements IDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ChildParentRel getAllParentChildRecords(String childId) {
		// ChildParentRel ChildParentRel =
		// jdbcTemplate.query(SQLConstants.GET_PARENT_CHILD_RECORD, new
		// Object[]{childId},ChildParentRel.class);
		ChildParentRel childParentRel = null;

		try {
			jdbcTemplate.queryForObject(SQLConstants.GET_PARENT_CHILD_RECORD, new Object[] { childId },
					ChildParentRel.class);
		} catch (EmptyResultDataAccessException e) {
			// Do nothing, as the parent object will be null in case record not
			// found
		} catch (Exception e) {
			// Log the exception and exit the flow
		}
		return childParentRel;
	}

	/*
	 * public int insertChildParentRecord(ParentChildVO pcVo){ int res =
	 * jdbcTemplate.update(SQLConstants.INSERT_CHILD_PARAENT_RECORD, new
	 * Object[]{pcVo.getChildId(), pcVo.getParentId()}); return res; }
	 */

}
