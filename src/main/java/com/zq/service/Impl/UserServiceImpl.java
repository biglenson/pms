package com.zq.service.Impl;

import java.util.List;
import org.springframework.stereotype.Service;


import com.zq.commons.result.PageInfo;
import com.zq.entity.User;
import com.zq.service.IUserService;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl implements IUserService {

	public List<User> selectByLoginName(User user) {
		// TODO Auto-generated method stub
		return null;
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