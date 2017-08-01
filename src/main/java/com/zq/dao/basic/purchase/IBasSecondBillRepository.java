package com.zq.dao.basic.purchase;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zq.entity.basic.purchase.BasSecondBill;

public interface IBasSecondBillRepository extends JpaRepository<BasSecondBill, Long> {

	@Query(value="select * from bas_second_bill where year=?1 and contract_frame_status=0", nativeQuery = true)
	List<BasSecondBill> findByYear(String year);
	

}
