package com.zq.dao.basic.capex;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.basic.capex.BasCAPEXRequirment;

public interface IBasCAPEXRequirmentRepository extends JpaRepository<BasCAPEXRequirment, Long> {

	BasCAPEXRequirment findById(int parseInt);
	

}
