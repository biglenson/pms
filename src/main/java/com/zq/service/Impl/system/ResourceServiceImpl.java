package com.zq.service.Impl.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zq.commons.result.Tree;
import com.zq.commons.shiro.ShiroUser;
import com.zq.commons.utils.CMCCConstant;
import com.zq.dao.system.IResourceRepository;
import com.zq.dao.system.IRoleRepository;
import com.zq.dao.system.IUserRepository;
import com.zq.dao.system.IUserRoleRepository;
import com.zq.entity.system.Resource;
import com.zq.service.system.IResourceService;


/**
 *
 * Resource 表数据服务层接口实现类
 *
 */
@Service
public class ResourceServiceImpl implements IResourceService {
  
	@Autowired
	IResourceRepository iResourceRepository;
	@Autowired
	IRoleRepository iRoleRepository;
	@Autowired
	IUserRepository iUserRepository;
	@Autowired
	IUserRoleRepository iUserRoleRepository;

	@Transactional
    public List<Resource> selectAll() {
		return iResourceRepository.findAll();
    }
	@Transactional
    public List<Resource> selectByType(int type) {
		return iResourceRepository.findByResourceType(type);
    }
	@Transactional
	private List<Resource> selectByTypeAndAppid(int type,int appid) {
		return iResourceRepository.findByResourceTypeAndAppid(type,appid);
	}
    
    public List<Tree> selectAllMenu() {
        List<Tree> trees = new ArrayList<Tree>();
        // 查询所有菜单
        List<Resource> resources = this.selectByType(CMCCConstant.RESOURCE_MENU);
        if (resources == null) {
            return trees;
        }
        for (Resource resource : resources) {
            Tree tree = new Tree();
            tree.setId(resource.getId());
            tree.setPid(resource.getPid());
            tree.setText(resource.getName());
            tree.setIconCls(resource.getIcon());
            tree.setAttributes(resource.getUrl());
            tree.setState(resource.getOpened());
            tree.setAppid(resource.getAppid());
            trees.add(tree);
        }
        return trees;
    }
    
    public List<Tree> selectAllTree() {
        // 获取所有的资源 tree形式，展示
        List<Tree> trees = new ArrayList<Tree>();
        List<Resource> resources = this.selectAll();
        if (resources == null) {
            return trees;
        }
        for (Resource resource : resources) {
            Tree tree = new Tree();
            tree.setId(resource.getId());
            tree.setPid(resource.getPid());
            tree.setText(resource.getName());
            tree.setIconCls(resource.getIcon());
            tree.setAttributes(resource.getUrl());
            tree.setState(resource.getOpened());
            tree.setAppid(resource.getAppid());
            trees.add(tree);
        }
        return trees;
    }
    
    public List<Tree> selectTree(ShiroUser shiroUser) {
        List<Tree> trees = new ArrayList<Tree>();
        // shiro中缓存的用户角色
        Set<String> roles = shiroUser.getRoles();
        if (roles == null) {
            return trees;
        }
        // 如果有超级管理员权限
        if (roles.contains("admin")) {
            List<Resource> resourceList = this.selectByType(CMCCConstant.RESOURCE_MENU);
            if (resourceList == null) {
                return trees;
            }
            for (Resource resource : resourceList) {
                Tree tree = new Tree();
                tree.setId(resource.getId());
                tree.setPid(resource.getPid());
                tree.setText(resource.getName());
                tree.setIconCls(resource.getIcon());
                tree.setAttributes(resource.getUrl());
                tree.setOpenMode(resource.getOpenMode());
                tree.setState(resource.getOpened());
                tree.setAppid(resource.getAppid());
                trees.add(tree);
            }
            return trees;
        }
        // 普通用户
        List<Long> roleIdList = iUserRoleRepository.selectRoleIdListByUserId(shiroUser.getId());
        if (roleIdList == null) {
            return trees;
        }
        List<Resource> resourceLists = new ArrayList<>();
        for(Long roleId:roleIdList){
        	List<Resource> res = iRoleRepository.findById(roleId).getResources();
        	resourceLists.addAll(res);
        }
        
        for (Resource resource : resourceLists) {
            Tree tree = new Tree();
            tree.setId(resource.getId());
            tree.setPid(resource.getPid());
            tree.setText(resource.getName());
            tree.setIconCls(resource.getIcon());
            tree.setAttributes(resource.getUrl());
            tree.setOpenMode(resource.getOpenMode());
            tree.setState(resource.getOpened());
            tree.setAppid(resource.getAppid());
            trees.add(tree);
        }
        return trees;
    }

	public boolean deleteById(Serializable resourceId) {
		return iResourceRepository.deleteById(resourceId);
	}
	@Override
	public Resource findByUrlNotRoot(String url) {
		return iResourceRepository.findByUrlNotRoot(url);
	}	

}