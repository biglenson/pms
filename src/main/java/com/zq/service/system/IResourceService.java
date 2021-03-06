package com.zq.service.system;

import java.util.List;

import com.zq.commons.result.Tree;
import com.zq.commons.shiro.ShiroUser;
import com.zq.entity.system.Resource;

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

	Resource findByUrlNotRoot(String url);

}