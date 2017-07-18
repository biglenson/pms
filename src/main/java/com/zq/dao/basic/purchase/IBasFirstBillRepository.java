package com.zq.dao.basic.purchase;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.basic.purchase.BasFirstBill;

public interface IBasFirstBillRepository extends JpaRepository<BasFirstBill, Long> {

	List findByYear(String year);
	

}
