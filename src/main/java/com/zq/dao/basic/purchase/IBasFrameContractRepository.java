package com.zq.dao.basic.purchase;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.basic.purchase.BasFrameContract;

public interface IBasFrameContractRepository extends JpaRepository<BasFrameContract, Long> {

	List<BasFrameContract> findByYear(String year);
	

}
