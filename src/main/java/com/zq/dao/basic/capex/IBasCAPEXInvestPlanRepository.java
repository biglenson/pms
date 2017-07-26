package com.zq.dao.basic.capex;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zq.entity.basic.capex.BasCAPEXInvestPlan;

public interface IBasCAPEXInvestPlanRepository extends JpaRepository<BasCAPEXInvestPlan, Long> {


	BasCAPEXInvestPlan findByYearAndProjCode(String year, String projCode);

	BasCAPEXInvestPlan findByProjCode(String projCode);
	
	Page<BasCAPEXInvestPlan> findByYear(String year, Pageable request);

	List<BasCAPEXInvestPlan> findByYear(String year);

	BasCAPEXInvestPlan findById(long longValue);

	BasCAPEXInvestPlan findById(int i);
	

}
