package com.zq.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.Organization;

public interface IOrganizationRepository extends JpaRepository<Organization, Long> {
	

}
