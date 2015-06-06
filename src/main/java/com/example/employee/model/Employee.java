package com.example.employee.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name = "employeeId", nullable = false, insertable = true, updatable = true)
	private Long id;

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true)
    private String employeeName;

    @Basic
    @Column(name = "designation", nullable = true, insertable = true, updatable = true)
    private String designation;

    @Basic
    @Column(name = "emailId", nullable = true, insertable = true, updatable = true)
    private String emailId;

    @Basic
    @Column(name = "salary", nullable = true, insertable = true, updatable = true)
    private Long salary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}
    
    
    
    
    
	
}
