package com.hxzy.controller;


import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hxzy.entity.Employee;
import com.hxzy.service.EmployeeService;

import net.sf.json.JSONObject;

@RestController
public class EmployeeController {
	private EmployeeService employeeService;

	@Resource(name="employeeServiceImpl")
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getemployee")
	public String getEmployee(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		Page<Employee> emps = employeeService.fy(page-1, limit);
		JSONObject obj = JSONObject.fromObject(emps);
		System.out.println(obj.toString());
		return obj.toString();
	}
	
	@PostMapping("/addemployee")
	public String addEmployee(@ModelAttribute Employee employee) {
		Employee temp = employeeService.addEmployee(employee);
		if(temp == null) {
			return "N";
		}
		if(temp.getEid()!=0) {
			return "Y";
		}
		return "N";
	}
	
	@PostMapping("/updateemployee")
	public String updateEmployee(@ModelAttribute Employee employee) {
		try {
			employeeService.updateEmployee(employee);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "N";
		}
		return "Y";
	}
	
	@PostMapping("/delemployee")
	public String deleteEmployee(@ModelAttribute Employee employee) {
		try {
			employeeService.delEmployee(employee);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "N";
		}
		return "Y";
	}
}
