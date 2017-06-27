package com.zq.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.zq.entity.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {

	Role findById(Long roleId);
}
