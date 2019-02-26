package database;

import java.sql.*;
import java.util.Scanner;

public class MainMenu {

	private static Connection conn;

	private static void options() {
		System.out.println("");
		System.out.println("1 - Add Employee");
		System.out.println("2 - Find Employee by Name");
		System.out.println("3 - Find Employee by ID");
		System.out.println("4 - Find Max Salary");
		System.out.println("5 - Find Min Salary");
		System.out.println("6 - Find Avg Salary");
		System.out.println("7 - Calculate Experience");
		System.out.println("8 - Show All Employee");
		System.out.println("9 - Exit");
		System.out.println("");
	}

	public static int generateEmpId(String name) {
		int var = 0;
		for (int i = 0; i < name.length(); i++) {
			var += name.charAt(i);
		}
		return var;
	}

	public static void main(String[] args) throws SQLException {
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/empdb", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		options();

		Scanner in = new Scanner(System.in);
		int choice = Integer.parseInt(in.next());

		Operation op = new Operation();
		int empId;

		while (choice != 9) {

			switch (choice) {

			case 1:

				String name, dept, doj;
				int salary;

				System.out.println("Enter name of employee : ");
				name = in.next();

				empId = generateEmpId(name);

				System.out.println("Enter date of joining : ");
				doj = in.next();

				System.out.println("Enter department name : ");
				dept = in.next();

				System.out.println("Enter salary : ");
				salary = in.nextInt();

				op.addEmp(conn, new Employee(name, empId, Date.valueOf(doj), dept, salary));
				break;

			case 2:

				System.out.println("Enter name to find : ");
				String empName = in.next();
				op.findEmpByName(conn, empName);
				break;

			case 3:

				System.out.println("Enter id to find : ");
				empId = in.nextInt();
				op.findEmpByEid(conn, empId);
				break;

			case 4:

				op.findMaxSalary(conn);
				break;

			case 5:

				op.findMinSalary(conn);
				break;

			case 6:

				op.findAvgSalary(conn);
				break;

			case 7:
				
				System.out.println("Enter employee id : ");
				empId = in.nextInt();
				op.calcExperience(conn, empId);
				break;
				
			case 8:
				
				op.showAllEmployee(conn);
				break;	
				
			default:
				System.out.println("Invalid input!");
				break;
			}

			options();

			choice = Integer.parseInt(in.next());
			
		}
		in.close();

	}
}