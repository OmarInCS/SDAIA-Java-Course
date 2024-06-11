package com.example.DemoGroup.day4.session3;

import com.example.DemoGroup.day4.session1.Department;

public class DepartmentDAO extends GenericDAO<Department> {

    public DepartmentDAO() {
        super(Department.class);
    }

    @Override
    protected String getTableName() {
        return "departments";
    }

    @Override
    protected String getIdColumnName() {
        return "department_id";
    }
}
