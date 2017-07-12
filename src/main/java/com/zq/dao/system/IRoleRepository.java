package com.zq.dao.system;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.system.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {

	Role findById(Long roleId);
}
