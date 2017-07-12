package com.zq.service.Impl.system;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.zq.commons.result.Tree;
import com.zq.dao.system.IDepartmentRepository;
import com.zq.entity.system.Department;
import com.zq.service.system.IDepartmentService;

/**
 *
 * Department 表数据服务层接口实现类
 *
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private IDepartmentRepository iDepartmentRepository;
    
    public List<Tree> selectTree() {
        List<Department> DepartmentList = selectTreeGrid();

        List<Tree> trees = new ArrayList<Tree>();
        if (DepartmentList != null) {
            for (Department Department : DepartmentList) {
                Tree tree = new Tree();
                tree.setId(Department.getId());
                tree.setText(Department.getName());
                tree.setIconCls(Department.getIcon());
                tree.setPid(Department.getPid());
                trees.add(tree);
            }
        }
        return trees;
    }

    public List<Department> selectTreeGrid() {
    	Sort sort = new Sort("seq");
        return iDepartmentRepository.findAll(sort);
    }


}