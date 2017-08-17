package com.zq.service.process;

import com.zq.entity.process.*;
import com.zq.dao.process.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.lang.String;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class EvalCodeGenSvc {

	private List<EvalCodeGen> evalCodeInfo = null;
	String evalCode = "";
	@Autowired
	EvalCodeGenRepository evalCodeGenRepo;
	@Transactional
	public String getEvalCode(String deptShortName, int  iCodeType){
        String codeType = null;
        if ( iCodeType == 0 ) {
            codeType = new String("BF"); 
        }else  {
            codeType = new String("AF"); 
        }

		evalCodeGenRepo.incrementEvalCode(deptShortName, codeType);
		evalCodeInfo=evalCodeGenRepo.getByDeptShortNameAndCodeType(deptShortName, codeType);
		evalCode = "000" + evalCodeInfo.get(0).getCurrValue();
		evalCode = deptShortName +"-" + codeType  + "-" + evalCodeInfo.get(0).getYearMonth() + "-" + evalCode.substring(evalCode.length()-3);
		return evalCode;
	}
}
