package com.zq.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zq.entity.UserRole;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
	@Query("SELECT ur.roleId FROM UserRole ur WHERE userId = ?0")
	List<Long> selectRoleIdListByUserId(Long userId);


}
