package com.infotech.client;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infotech.config.EmployeeApplicationConfig;
import com.infotech.model.Employee;
import com.infotech.service.EmployeeService;
import com.infotech.service.impl.EmployeeServiceImpl;

public class Test {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx= null;
		
		try {
			ctx = new AnnotationConfigApplicationContext(EmployeeApplicationConfig.class);
			EmployeeService employeeService = ctx.getBean("employeeService", EmployeeServiceImpl.class);
			//createEmployee(employeeService);
			//getEmployeeById(employeeService);
			
			fetchAllEmployeesInfo(employeeService);
			
			//employeeService.updateEmployeeEmailById("Jimmy.s2016@yahoo.com", 2);
			//employeeService.deleteEmployeeById(1);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ctx != null)
				ctx.close();
		}
		
	}

	private static void fetchAllEmployeesInfo(EmployeeService employeeService) {
		List<Employee> empList = employeeService.getAllEmployeesInfo();
		for (Employee employee : empList) {
			System.out.println(employee.getEmployeeId()+"\t"+employee.getEmployeeName()+"\t"+employee.getEmail()+"\t"+employee.getGender()+"\t"+employee.getSalary());
		}
	}

	private static void getEmployeeById(EmployeeService employeeService) {
		Employee employee = employeeService.fetchEmployeeById(1);
		System.out.println(employee.getEmployeeId()+"\t"+employee.getEmployeeName()+"\t"+employee.getEmail()+"\t"+employee.getGender()+"\t"+employee.getSalary());
	}

	private static void createEmployee(EmployeeService employeeService) {
		Employee employee = new Employee();
		employee.setEmail("sean.s@yahoo.com");
		employee.setEmployeeName("Sean");
		employee.setGender("Male");
		employee.setSalary(90000.00);
		
		employeeService.addEmployee(employee);
	}

}
