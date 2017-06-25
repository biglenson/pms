package com.zq.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.SysLog;

public interface ISysLogRepository extends JpaRepository<SysLog, Long> {
	

}
