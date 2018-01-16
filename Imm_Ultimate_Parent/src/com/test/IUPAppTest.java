package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iup.config.AppConfig;
import com.iup.exception.GenericException;
import com.iup.exception.NoDataFoundException;
import com.iup.service.IUPServiceImpl;
import com.iup.vo.ParentChildVO;

public class IUPAppTest {

	public static void main(String args[]) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		IUPServiceImpl appService = applicationContext.getBean(IUPServiceImpl.class);
		int input1 = 4;
		try {
			ParentChildVO pcVo = appService.getImmediateUltimateParentDetail(input1);
			System.out.println("Immediate Parent :" + (null != pcVo ? pcVo.getImmediateParentId() : null)
					+ " and Ultimate Parent:" + (null != pcVo ? pcVo.getUltimateParentId() : null));
		} catch (NoDataFoundException e) {
			System.out.println("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (GenericException e) {
			System.out.println("Error:" + e.getMessage());
			e.printStackTrace();
		}

		// ParentChildVO newPCVo = new ParentChildVO();
		// newPCVo.setChildId("6");
		// newPCVo.setParentId("5");
		// appService.insertChildParentRel(newPCVo);
	}
}
