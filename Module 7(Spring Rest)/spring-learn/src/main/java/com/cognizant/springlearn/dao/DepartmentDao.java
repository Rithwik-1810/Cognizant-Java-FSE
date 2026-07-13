package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentDao {

    private static ArrayList<Department> DEPARTMENT_LIST;

    public DepartmentDao() {
        // Mock implementation to populate from employee.xml (or department.xml if it exists)
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        Department dept1 = context.getBean("dept1", Department.class);
        Department dept2 = context.getBean("dept2", Department.class);
        DEPARTMENT_LIST = new ArrayList<>();
        DEPARTMENT_LIST.add(dept1);
        DEPARTMENT_LIST.add(dept2);
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}
