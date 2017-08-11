package com.zq.dao.system;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.system.SysDic;

public interface ISysDicRepository extends JpaRepository<SysDic, Long> {


	List<SysDic> findByClasscode(String string);	

	
	SysDic findByClasscodeAndCode(String classcode, Integer code);	

}
