package com.zq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zq.commons.result.Tree;
import com.zq.commons.shiro.ShiroUser;
import com.zq.entity.Resource;

/**
 *
 * Resource 表数据服务层接口
 *
 */

public interface IResourceService {

    List<Resource> selectAll();

    List<Tree> selectAllMenu();

    List<Tree> selectAllTree();

    List<Tree> selectTree(ShiroUser shiroUser);
    
    /** 
    * @Title: selectTopMenu 
    * @Description: TODO(根据用户ID和appid筛选顶级菜单) 
    * @author shujukuss 
    * @date 2017年7月2日 下午12:16:46 
    * @param @param shiroUser
    * @param @param appid
    * @param @return    设定文件 
    * @return List<Tree>    返回类型 
    * @throws 
    */

}