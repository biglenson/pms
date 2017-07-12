package com.zq.service.Impl.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.zq.commons.result.PageInfo;
import com.zq.dao.system.IUserRepository;
import com.zq.entity.system.User;
import com.zq.service.system.IUserService;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	IUserRepository iUserRepository;
	public List<User> selectByLoginName(User user) {
		return iUserRepository.findByloginName(user.getLoginName());
	}

	public void insert(User user) {
		// TODO Auto-generated method stub
		
	}

	public User selectById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	public void updatePwdByUserId(Long userId, String md5Hex) {
		// TODO Auto-generated method stub
		
	}

	public void selectDataGrid(PageInfo pageInfo) {
		// TODO Auto-generated method stub
		
	}

	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		
	}



}