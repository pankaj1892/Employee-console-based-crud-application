package com.service;

import com.entity.Employee;

public interface EmployeeService {

	void addEmployee(Employee emp);

	void deleteEmployee(int id);

	void modifyEmployee(Employee emp);

	Employee showEmployee(int id);

}
