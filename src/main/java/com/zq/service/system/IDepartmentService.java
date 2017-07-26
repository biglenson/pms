package com.zq.service.system;

import java.util.List;

import com.zq.commons.result.Tree;
import com.zq.entity.system.Department;


/**
 *
 * Department 表数据服务层接口
 *
 */
public interface IDepartmentService{

    List<Tree> selectTree();

    List<Department> selectTreeGrid();

	Department getDepById(int depMnt);

}