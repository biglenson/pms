package com.zq.dao.system;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.system.SysLog;

public interface ISysLogRepository extends JpaRepository<SysLog, Long> {
	

}
