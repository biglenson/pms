package com.zq.service.Impl.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zq.commons.result.PageInfo;
import com.zq.commons.result.Tree;
import com.zq.commons.utils.StringUtils;
import com.zq.dao.system.IRoleRepository;
import com.zq.dao.system.IRoleResourceRepository;
import com.zq.dao.system.IUserRepository;
import com.zq.dao.system.IUserRoleRepository;
import com.zq.entity.system.Resource;
import com.zq.entity.system.Role;
import com.zq.service.system.IRoleService;



/**
 *
 * Role 表数据服务层接口实现类
 *
 */
@Service
public class RoleServiceImpl  implements IRoleService {
	@Autowired
	IRoleRepository iRoleRepository;
	@Autowired
	IUserRepository iUserRepository;
	@Autowired
	IUserRoleRepository iUserRoleRepository;
	@Autowired
	IRoleResourceRepository iRoleResourceRepository;
	@Transactional
    public List<Role> selectAll() {
        Sort sort = new Sort("seq");
        return iRoleRepository.findAll(sort);
    }    
 
	@Transactional
    public Object selectTree() {
        List<Tree> trees = new ArrayList<Tree>();
        List<Role> roles = this.selectAll();
        for (Role role : roles) {
            Tree tree = new Tree();
            tree.setId(role.getId());
            tree.setText(role.getName());

            trees.add(tree);
        }
        return trees;
    }
	@Transactional
    public List<Long> selectResourceIdListByRoleId(Long id) {
        return iRoleResourceRepository.selectResourceIdListByRoleId(id);
    }
    
	@Transactional
    public Map<String, Set<String>> selectResourceMapByUserId(Long userId) {
        Map<String, Set<String>> resourceMap = new HashMap<String, Set<String>>();
        List<Long> roleIdList = iUserRoleRepository.selectRoleIdListByUserId(userId);
        Set<String> urlSet = new HashSet<String>();
        Set<String> roles = new HashSet<String>();
        for (Long roleId : roleIdList) {
            List<Resource> resourceList = iRoleRepository.findById(roleId).getResources();
            if (resourceList != null) {
                for (Resource resource : resourceList) {
                    if (StringUtils.isNotBlank(resource.getUrl())) {
                        urlSet.add(resource.getUrl());
                    }
                }
            }
            Role role = iRoleRepository.findById(roleId);
            if (role != null) {
                roles.add(role.getName());
            }
        }
        resourceMap.put("urls", urlSet);
        resourceMap.put("roles", roles);
        return resourceMap;
    }

	
	public void selectDataGrid(PageInfo pageInfo) {
		// TODO Auto-generated method stub
		
	}


	public void updateRoleResource(Long id, String resourceIds) {
		// TODO Auto-generated method stub
		
	}


}