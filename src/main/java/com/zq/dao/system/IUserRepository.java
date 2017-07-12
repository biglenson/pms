package com.zq.dao.system;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.system.User;
public interface IUserRepository extends JpaRepository<User, Long> {

	User findUserById(Long id);

	List<User> findByloginName(String user);

}
