package com.tjc.dao;

import com.tjc.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: TJC
 * @Date: 2020/6/10 20:45
 * @description: 部门Dao, 模拟数据库中的数据和对数据库的操作
 */
@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<>();
        departments.put(101, new Department(101, "财务部"));
        departments.put(102, new Department(102, "技术部"));
        departments.put(103, new Department(103, "产品部"));
        departments.put(104, new Department(104, "运营部"));
        departments.put(105, new Department(105, "市场部"));
    }

    // 查询所有
    public Collection<Department> findAll() {
        return departments.values();
    }

    // 通过id查询
    public Department findById(Integer id) {
        return departments.get(id);
    }
}
