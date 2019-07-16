package com.st.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.st.entity.Employee;
import com.st.service.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping(value="/reg",method = RequestMethod.GET)
	public String showEmpRegPage(Model map) {
		System.out.println(service.getClass().getName());
		map.addAttribute("employee", new Employee());
		return "employee/Register";
	}
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String  saveEmployee(@ModelAttribute Employee employee,Model map ) {
			Integer id=service.saveEmps(employee);
			map.addAttribute("msg", "Employee inserted with Id: "+id);
			map.addAttribute("employee", new Employee());
		return "redirect:/emp/all";
	}
	
	@RequestMapping("/all")
	public String getAllEmps(Model map) {
		List<Employee> list=service.findAllEmps();
		map.addAttribute("emps",list);
		return"employee/Emplist";
	}
	
	@RequestMapping(value="/showUpdateForm",method = RequestMethod.POST)
	public String showUpdateForm(@RequestParam Integer id,Model map) {
			Employee e=service.getEmpById(id);
			map.addAttribute("employee", e);
		return "employee/UpdateEmployee";
	}
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public String delete(@RequestParam Integer id) {
		service.delete(id);
		
		return "redirect:/emp/all";
	}
	
}
