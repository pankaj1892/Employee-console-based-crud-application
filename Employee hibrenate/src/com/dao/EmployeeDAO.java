package com.dao;

import com.entity.Employee;

public interface EmployeeDAO {
	void insertEmployee(Employee emp);

	void deleteEmployee(int id);

	void updateEmployee(Employee emp);

	Employee readEmployee(int id);

}
