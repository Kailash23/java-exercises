package database;

import java.sql.Date;

public class Employee {

	private String name;
	private int empid;
	private Date doj;
	private String dept;
	private int salary;

	public Employee(String name, int empid, Date doj, String dept, int salary) {
		this.name = name;
		this.empid = empid;
		this.doj = doj;
		this.dept = dept;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}