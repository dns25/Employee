package com.example.employee.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employee.dao.EmployeeDAO;
import com.example.employee.model.Employee;

import java.util.List;
import java.util.Map;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
    private EmployeeDAO employeeDAO;

 

    @Override
    @Transactional
    public void addEmployee(Employee e) {
        this.employeeDAO.addEmployee(e);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee e) {
        this.employeeDAO.updateEmployee(e);
    }

    @Override
    @Transactional
    public List<Employee> listEmployees() {
        return this.employeeDAO.listEmployees();
    }

    @Override
    @Transactional
    public Employee getEmployeeById(Long id) {
        return this.employeeDAO.getEmployeeById(id);
    }

    @Override
    @Transactional
    public void removeEmployee(Long id) {
        this.employeeDAO.removeEmployee(id);
    }

    @Override
    @Transactional
    public List<Employee> listEmployees(Map<String, Object> list) {
        return this.employeeDAO.listEmployees(list);
    }
}
