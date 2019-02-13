package org;

import org.Utils;

public class Employee {
	
	private String name;
	private long eid;
	private boolean currentlyWorking;
	static int noOfEmployee = 0;
	private Department dept;
	
	public Employee(String name, boolean currentlyWorking, Department dept) {
		this.name = name;
		this.eid = Utils.generateEmpId(name);
		this.currentlyWorking = currentlyWorking;
		this.dept = dept;
		noOfEmployee++;
	}

	public String getDeptName() {
		return this.dept.deptName;
	}

	public void setDeptName(String deptName) {
		this.dept.deptName = deptName;
	}
	
	public Department getDept() {
		return dept;
	}
	
	public boolean getCurrentlyWorking() {
		return currentlyWorking;
	}

	public void setCurrentlyWorking(boolean currentlyWorking) {
		this.currentlyWorking = currentlyWorking;
	}

	public static int getNoOfEmployee() {
		return noOfEmployee;
	}

	public long getEid() {
		return eid;
	}

	public String showEmpDetails() {
		return "Employee [name = " + name + ", eid = " + eid + ", currentlyWorking = " + currentlyWorking + "]";
	}
}
