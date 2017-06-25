package com.zq.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.User;
public interface IUserRepository extends JpaRepository<User, Long> {

	User findUserById(Long id);

}
