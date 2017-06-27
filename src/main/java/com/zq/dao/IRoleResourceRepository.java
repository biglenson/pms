package com.zq.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zq.entity.RoleResource;

public interface IRoleResourceRepository extends JpaRepository<RoleResource, Long> {
	@Query("SELECT resourceId FROM RoleResource  WHERE roleId = ?1")
	List<Long> selectResourceIdListByRoleId(Long id);


}
