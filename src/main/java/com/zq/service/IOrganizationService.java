package com.zq.service;

import java.util.List;

import com.zq.commons.result.Tree;
import com.zq.entity.Organization;


/**
 *
 * Organization 表数据服务层接口
 *
 */
public interface IOrganizationService{

    List<Tree> selectTree();

    List<Organization> selectTreeGrid();

}