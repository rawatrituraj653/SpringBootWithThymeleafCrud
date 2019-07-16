package com.st.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.dao.EmployeeRepository;
import com.st.entity.Employee;
import com.st.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public List<Employee> findAllEmps() {

		return repo.findAll();
	}

	@Override
	public Integer saveEmps(Employee e) {
			Employee emp=repo.save(e);
		
		return emp.getEmpId();
	}

	@Override
	public Employee getEmpById(Integer id) {
		Optional<Employee> oo=repo.findById(id);
			
		return oo.get();
	
	}
	
	@Override
	public void delete(Integer id) {
		repo.deleteById(id);		
	}
	
}
