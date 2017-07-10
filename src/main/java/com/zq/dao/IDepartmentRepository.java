package com.zq.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Long> {
	

}
