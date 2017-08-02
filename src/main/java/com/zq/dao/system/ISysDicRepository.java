package com.zq.dao.system;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.system.SysDic;

public interface ISysDicRepository extends JpaRepository<SysDic, Long> {
	
	SysDic findByClasscodeAndCode(String classcode, Integer code);	

}
