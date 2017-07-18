package com.zq.dao.basic.capex;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.basic.capex.BasCAPEXProject;

public interface IBasCAPEXProjectRepository extends JpaRepository<BasCAPEXProject, Long> {

	List<BasCAPEXProject> findByProjStartYear(String year);

	double findByProjCode(String projCode);	

}
