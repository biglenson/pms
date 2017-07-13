package com.zq.dao.basic.capex;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.basic.capex.BasCAPEXExpendplan;

public interface IBasCAPEXExpendplanRepository extends JpaRepository<BasCAPEXExpendplan, Long> {

	List<BasCAPEXExpendplan> findByYear(int year);

	BasCAPEXExpendplan findByYearAndProjCode();
	

}
