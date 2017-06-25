package com.zq.service;

import java.util.List;

import com.zq.commons.result.PageInfo;
import com.zq.entity.User;


/**
 *
 * User 表数据服务层接口
 *
 */
public interface IUserService {

    List<User> selectByLoginName(User user);

    void insert(User user);

    User selectById(Long id);

    void update(User user);

    void updatePwdByUserId(Long userId, String md5Hex);

    void selectDataGrid(PageInfo pageInfo);

    void deleteUserById(Long id);
}