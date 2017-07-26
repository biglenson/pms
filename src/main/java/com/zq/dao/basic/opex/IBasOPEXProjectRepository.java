package com.zq.dao.basic.opex;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.basic.opex.BasOPEXProject;

public interface IBasOPEXProjectRepository extends JpaRepository<BasOPEXProject, Long> {

	BasOPEXProject findByBudgetProjCode(String opexProjCode);

	BasOPEXProject findById(Integer opexProjCode);	

}
