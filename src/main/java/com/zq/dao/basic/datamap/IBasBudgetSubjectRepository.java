package com.zq.dao.basic.datamap;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.basic.datamap.BasBudgetSubject;

public interface IBasBudgetSubjectRepository extends JpaRepository<BasBudgetSubject, Long>{

	BasBudgetSubject findById(int parseInt);


}
