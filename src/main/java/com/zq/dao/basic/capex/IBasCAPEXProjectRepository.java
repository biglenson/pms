package com.zq.dao.basic.capex;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.basic.capex.BasCAPEXProject;

public interface IBasCAPEXProjectRepository extends JpaRepository<BasCAPEXProject, Long> {

	List<BasCAPEXProject> findByProjStartYear(String year);

	double findByProjCode(String projCode);

	Page<BasCAPEXProject> findByProjStartYear(String year, Pageable request);	

	BasCAPEXProject findById(int parseInt);	

}
