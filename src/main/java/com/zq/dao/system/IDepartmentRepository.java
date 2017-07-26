package com.zq.dao.system;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.system.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Long> {

	Department findById(long depMnt);
	

}
