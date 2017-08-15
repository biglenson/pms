package com.zq.dao.process;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zq.entity.process.*;
import java.util.List;

public interface EvalCodeGenRepository extends JpaRepository<EvalCodeGen, Long>{

	List<EvalCodeGen> getByDeptShortNameAndCodeType(String deptShortName, String codeType);
	int incrementEvalCode(String deptShortName, String codeType);
	
}
	
