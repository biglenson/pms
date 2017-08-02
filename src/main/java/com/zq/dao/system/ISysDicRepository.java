package com.zq.dao.system;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.system.SysDic;

public interface ISysDicRepository extends JpaRepository<SysDic, Long> {

	SysDic findByClassAndCode(String string, Integer code);

	List<SysDic> findByClasscode(String string);	

}
