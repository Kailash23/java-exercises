package database;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Operation {

	List<Employee> employeeList = new ArrayList<Employee>();

	public String getCurrentDate() {
		long millis = System.currentTimeMillis();
		return String.valueOf(new Date(millis));
	}

	public void addEmp(Connection connection, Employee employee) throws SQLException {
		String query = "insert into empdetails(name, empid, doj, dept, salary)" + "values(?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, employee.getName());
		ps.setInt(2, employee.getEmpid());
		ps.setDate(3, employee.getDoj());
		ps.setString(4, employee.getDept());
		ps.setInt(5, employee.getSalary());
		ps.execute();
		ps.close();
	}

	public void findEmpByName(Connection connection, String empName) throws SQLException {
		String query = "select * from empdetails where name = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, empName);
		ResultSet rs = ps.executeQuery();

		if (rs.first()) {
			String name = rs.getString("name");
			int empId = rs.getInt("empid");
			Date doj = rs.getDate("doj");
			int salary = rs.getInt("salary");
			System.out.format("Name : %s\nEmployee id : %s\n" + "Date of Joining : %s\nSalary : %s\n", name, empId, doj,
					salary);
			calcExperience(connection, empId);
		} else {
			System.out.println("Employee doesn't exist!");
		}

		ps.close();
	}

	public void findEmpByEid(Connection connection, int empId) throws SQLException {
		String query = "select * from empdetails where empid = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, empId);
		ResultSet rs = ps.executeQuery();

		if (rs.first()) {
			String name = rs.getString("name");
			int id = rs.getInt("empid");
			Date doj = rs.getDate("doj");
			int salary = rs.getInt("salary");
			System.out.format("Name : %s\nEmployee id : %s\n" + "Date of Joining : %s\nSalary : %s\n", name, id, doj,
					salary);
		} else {
			System.out.println("Employee doesn't exist!");
		}

		ps.close();
	}

	public void findMaxSalary(Connection connection) throws SQLException {
		String query = "select name, salary from empdetails where salary = (select MAX(salary) from empdetails)";
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		if (rs.first()) {
			System.out.println("Name : " + rs.getString("name"));
			System.out.println("Salary : " + rs.getInt("salary"));
			System.out.println();
		} else {
			System.out.println("Database empty!");
		}
		ps.close();
	}

	public void findMinSalary(Connection connection) throws SQLException {
		String query = "select name, salary from empdetails where salary = (select MIN(salary) from empdetails)";
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		if (rs.first()) {
			System.out.println("Name : " + rs.getString("name"));
			System.out.println("Salary : " + rs.getInt("salary"));
			System.out.println();
		} else {
			System.out.println("Database empty!");
		}
		ps.close();
	}

	public void findAvgSalary(Connection connection) throws SQLException {
		String query = "select AVG(salary) from empdetails";
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		if (rs.first()) {
			System.out.println(rs.getInt("AVG(salary)"));
		} else {
			System.out.println("Database empty!");
		}
		ps.close();
	}

	public void calcExperience(Connection connection, int empId) throws SQLException {
		String query = "select doj from empdetails where empid = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, empId);

		ResultSet rs = ps.executeQuery();
		String doj = null;
		if (rs.first()) {
			doj = rs.getString("doj");
			Period period = Period.between(LocalDate.parse(doj), LocalDate.parse(getCurrentDate()));
			System.out.print("Experience : ");
			display(period.getYears(), "year");
			display(period.getMonths(), "month");
			display(period.getDays(), "day");
			System.out.println();
		} else {
			System.out.println("You have entered a wrong employee id!");
		}
		ps.close();

	}

	public void display(int val, String str) {
		if (val <= 1) {
			System.out.print(val + " " + str + " ");
		} else {
			System.out.print(val + " " + str + "s ");
		}
	}

	public String getEmployeeName(Connection connection, int empId) throws SQLException {
		String query = "select name from empdetails where empid = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, empId);
		ResultSet rs = ps.executeQuery();
		String name = null;
		ps.close();
		if (rs.first()) {
			name = rs.getString("name");
			return name;
		} else {
			System.out.println("You have entered wrong employee id!");
			return null;
		}
	}

	public void showAllEmployee(Connection connection) throws SQLException {
		String query = "select * from empdetails";
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		System.out.println("--------------------------------------------------------------------");
		System.out.printf("%10s %10s %13s %10s %10s", "name", "empid", "doj", "dept", "salary");
		System.out.println();
		System.out.println("--------------------------------------------------------------------");
		while (rs.next()) {
			System.out.format("%10s %10d %15s %10d %10d", rs.getString("name"), rs.getInt("empid"), rs.getDate("doj"),
					rs.getInt("salary"), rs.getInt("salary"));
			System.out.println();
		}
		System.out.println("--------------------------------------------------------------------");
	}
}