package com.tjc.dao;

import com.tjc.pojo.Department;
import com.tjc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: TJC
 * @Date: 2020/6/10 20:53
 * @description: 员工Dao
 */
@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    private static Integer initId = 1006;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>();

        employees.put(1001, new Employee(1001, "Zhao", "101@springboot.com", 1, new Department(101, "财务部")));
        employees.put(1002, new Employee(1002, "Qian", "102@springboot.com", 0, new Department(102, "技术部")));
        employees.put(1003, new Employee(1003, "Sun", "103@springboot.com", 1, new Department(103, "产品部")));
        employees.put(1004, new Employee(1004, "Li", "104@springboot.com", 0, new Department(104, "运营部")));
        employees.put(1005, new Employee(1005, "Zhou", "105@springboot.com", 1, new Department(105, "市场部")));
    }

    // 增加员工
    public void addEmployee(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.findById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> findAll() {
        return employees.values();
    }
}
