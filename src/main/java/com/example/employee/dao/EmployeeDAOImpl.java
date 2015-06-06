package com.example.employee.dao;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.employee.model.Employee;

import java.util.List;
import java.util.Map;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);
   
    @Autowired
    private SessionFactory sessionFactory;

    

    @Override
    public void addEmployee(Employee e) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(e);
        logger.info("Employee saved successfully, Employee Details="+e);
    }

    @Override
    public void updateEmployee(Employee e) {

        Session session = this.sessionFactory.getCurrentSession();
        session.update(e);
        logger.info("Employee updated successfully, Employee Details="+e);
    }

    @Override
    public List<Employee> listEmployees() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> employeeList = session.createQuery("from Employee").list();
        for(Employee e : employeeList){
            logger.info("Employee List::"+e);
        }
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee e = (Employee) session.load(Employee.class, new Long(id));
        logger.info("Employee loaded successfully, Employee details="+e);
        return e;
    }

    @Override
    public void removeEmployee(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee e = (Employee) session.load(Employee.class, new Long(id));
        if(null != e){
            session.delete(e);
        }
        logger.info("Employee deleted successfully, Employee details="+e);
    }

    @Override
    public List<Employee> listEmployees(Map<String, Object> list) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.add(Restrictions.allEq(list));
        return criteria.list();
    }
}
