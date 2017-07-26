package com.zq.service.system;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zq.commons.result.PageInfo;
import com.zq.entity.system.Role;


/**
 *
 * Role 表数据服务层接口
 *
 */
public interface IRoleService{

    void selectDataGrid(PageInfo pageInfo);

    Object selectTree();

    List<Long> selectResourceIdListByRoleId(Long id);

    void updateRoleResource(Long id, String resourceIds);

    Map<String, Set<String>> selectResourceMapByUserId(Long userId);

	Role getRoleById(int depMnt);

}