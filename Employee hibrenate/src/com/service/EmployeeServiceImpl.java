package com.service;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO dao = new EmployeeDAOImpl();

	@Override
	public void addEmployee(Employee emp) {
		dao.insertEmployee(emp);

	}

	@Override
	public void deleteEmployee(int id) {
		dao.deleteEmployee(id);
	}

	@Override
	public void modifyEmployee(Employee emp) {
		dao.updateEmployee(emp);
	}

	@Override
	public Employee showEmployee(int id) {
		Employee emp = dao.readEmployee(id);
		return emp;
	}

}
