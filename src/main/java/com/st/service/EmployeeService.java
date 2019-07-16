package com.st.service;

import java.util.List;

import com.st.entity.Employee;

public interface EmployeeService {

	public 	List<Employee> findAllEmps();
	public abstract Integer saveEmps(Employee e);
	public Employee getEmpById(Integer id);
	public void delete(Integer id); 
}
