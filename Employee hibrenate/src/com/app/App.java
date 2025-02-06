package com.app;

import java.util.Scanner;

import com.entity.Employee;
import com.service.EmployeeService;
import com.service.EmployeeServiceImpl;

public class App {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		EmployeeService es = new EmployeeServiceImpl();

		int option = 0;
		int x = 0;

		do {

			System.out.println("******************************");
			System.out.println("****1 : ADD EMPLOYEE**********");
			System.out.println("****2 : DELETE EMPLOYEE*******");
			System.out.println("****3 : UPDATE EMPLOYEE*******");
			System.out.println("****4 : READ EMPLOYEE*********");
			System.out.println("******************************");

			System.out.println("Enter The Option ");
			option = scanner.nextInt();

			switch (option) {
			case 1:
				System.out.println("Enter the id ");
				int id = scanner.nextInt();
				System.out.println("Enter the name ");
				scanner.nextLine();
				String name = scanner.nextLine();
				System.out.println("Enter the salary");
				double salary = scanner.nextDouble();

				Employee emp = new Employee(id, name, salary);
				es.addEmployee(emp);
				break;
			case 2:
				System.out.println("Enter the id to delete Data");
				int did = scanner.nextInt();
				es.deleteEmployee(did);
				break;
			case 3:
				System.out.println("Enter the id to update data ");
				int uid = scanner.nextInt();
				System.out.println("Enter the New Name ");
				scanner.nextLine();
				String newname = scanner.nextLine();
				System.out.println("Enter the New Salary");
				double newsalary = scanner.nextDouble();

				Employee emp1 = new Employee(uid, newname, newsalary);

				es.modifyEmployee(emp1);
				break;
			case 4:
				System.out.println("Enter the id to Read Data");
				int rid = scanner.nextInt();
				Employee emp3 = es.showEmployee(rid);
				System.out.println(emp3);

			default:
				System.out.println("Invalid Option");

			}

			System.out.println("For Continue Press 1  ");
			x = scanner.nextInt();

		} while (x == 1);

	}

}
