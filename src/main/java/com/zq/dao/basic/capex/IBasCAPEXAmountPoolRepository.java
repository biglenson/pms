package com.zq.dao.basic.capex;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.basic.capex.BasCAPEXAmountPool;

public interface IBasCAPEXAmountPoolRepository extends JpaRepository<BasCAPEXAmountPool, Long>{

	List<BasCAPEXAmountPool> findByYear(String year);

}
