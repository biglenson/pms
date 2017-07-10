package com.zq.service;

import java.util.List;

import com.zq.commons.result.Tree;
import com.zq.entity.Department;


/**
 *
 * Department 表数据服务层接口
 *
 */
public interface IDepartmentService{

    List<Tree> selectTree();

    List<Department> selectTreeGrid();

}