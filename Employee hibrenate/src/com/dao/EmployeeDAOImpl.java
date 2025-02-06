package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Employee;
import com.utility.HibernatUtility;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void insertEmployee(Employee emp) {

		SessionFactory factory = HibernatUtility.getSessionFactory();

		Session session = factory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(emp);
			tx.commit();
			System.out.println("added success");
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}

	}

	@Override
	public void deleteEmployee(int id) {
		SessionFactory factory = HibernatUtility.getSessionFactory();

		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee emp = (Employee) session.get(Employee.class, id);
			if (emp != null) {

				session.delete(emp);
				tx.commit();
				System.out.println("Delete data Success  ");
			} else {
				System.out.println("Not Existed Data In database");
			}
		} catch (Exception e) {
			System.out.println("EmployeeDAOImpl deleteEmployee... " + e);
		}
		session.close();

	}

	@Override
	public void updateEmployee(Employee emp) {
		SessionFactory factory = HibernatUtility.getSessionFactory();
		Session session = factory.openSession();

		Employee emp1 = (Employee) session.get(Employee.class, emp.getId());

		if (emp1 != null) {
			emp1.setName(emp.getName());
			emp1.setSalary(emp.getSalary());
			Transaction tx = session.beginTransaction();

			session.update(emp1);

			tx.commit();
			System.out.println("Update Success...");

		} else {
			System.out.println("Id Not Found");

		}

		session.close();


	}

	@Override
	public Employee readEmployee(int id) {

		SessionFactory factory = HibernatUtility.getSessionFactory();
		Session session = factory.openSession();
		Employee emp = (Employee) session.get(Employee.class, id);
		if (emp != null) {
			return emp;
		}
		return null;
	}

}
