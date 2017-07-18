package com.zq.dao.basic.purchase;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.basic.purchase.BasSecondBill;

public interface IBasSecondBillRepository extends JpaRepository<BasSecondBill, Long> {

	List findByYear(String year);
	

}
