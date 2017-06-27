package com.zq.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zq.entity.UserRole;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
	@Query("SELECT roleId FROM UserRole WHERE userId = ?1")
	List<Long> selectRoleIdListByUserId(Long userId);


}
