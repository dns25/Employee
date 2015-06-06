package com.example.employee.dao;



import java.util.List;
import java.util.Map;

import com.example.employee.model.Employee;


public interface EmployeeDAO {


    public void addEmployee(Employee e);
    public void updateEmployee(Employee e);
    public List<Employee> listEmployees();
    public Employee getEmployeeById(Long id);
    public void removeEmployee(Long id);
    public List<Employee> listEmployees(Map<String,Object> list);
}
