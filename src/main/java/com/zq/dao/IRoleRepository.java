package com.zq.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zq.entity.Resource;
import com.zq.entity.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {

	@Query("SELECT res FROM Resource res JOIN Role r WHERE r.id = ?0")
	List<Resource> selectResourcesByRoleId(Long roleId);

	Role findById(Long roleId);

}
