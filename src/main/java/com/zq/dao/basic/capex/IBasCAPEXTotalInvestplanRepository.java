package com.zq.dao.basic.capex;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.basic.capex.BasCAPEXTotalInvestplan;

public interface IBasCAPEXTotalInvestplanRepository extends JpaRepository<BasCAPEXTotalInvestplan, Long>{

	List<BasCAPEXTotalInvestplan> findByYear(int year);

}
