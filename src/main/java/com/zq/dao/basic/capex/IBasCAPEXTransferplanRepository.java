package com.zq.dao.basic.capex;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.basic.capex.BasCAPEXTransferplan;

public interface IBasCAPEXTransferplanRepository extends JpaRepository<BasCAPEXTransferplan, Long>{

	List<BasCAPEXTransferplan> findByYear(int year);

	BasCAPEXTransferplan findByYearAndProjCode(int year, String projCode);

}
