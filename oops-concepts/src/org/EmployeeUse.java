package org;


import org.Operations;

public class EmployeeUse {
	
	public static void main(String args[]) {

		Operations operation = new Operations();
		operation.addEmployee("Jordan", true, new Department(89, "tech")); // doubt
		operation.addEmployee("Ragnar", false, new Department(56, "sales"));
		operation.addEmployee("Jugger", false, new Department(45, "tech"));
		operation.addEmployee("FullPower", false, new Department(32, "tech"));
		operation.addEmployee("Godspeed", false, new Department(34, "hr"));
		operation.addEmployee("Bajaj", false, new Department(54, "hr"));
		operation.addEmployee("Bjorn", false, new Department(52, "tech"));
		operation.addEmployee("Lagretha", false, new Department(12, "sales"));
		operation.addEmployee("Fin", false, new Department(45, "finance"));
		operation.addEmployee("Rolo", false, new Department(45, "R&D"));
		operation.addEmployee("Hemant", false, new Department(45, "finance"));
		operation.addEmployee("Vishal", false, new Department(27, "marketing"));
		
		

//		Assignment 1
//
//		operation.displayEmpDetails();
//		System.out.println(operation.getEmployeeCount());
//
//		operation.removeEmployee(Utils.generateEmpId("Jordan"));
//		operation.displayEmpDetails();
//		System.out.println(operation.getEmployeeCount());
//
//		System.out.println(operation.workingStatus(Utils.generateEmpId("Ragnar")));
//
//		operation.addEmployee("Bjorn", false, new Department(23, "sales"));
//		operation.displayEmpDetails();
//		System.out.println(operation.getEmployeeCount());

//		Assignment 2 : Normal way
//
//		System.out.println("tech");
//		
//		ArrayList<Employee> list = operation.getEmpListUsingDeptName("tech");
//		for (Employee deptEmpList : list)
//			System.out.println(deptEmpList.showEmpDetails());

//		Assignment 3 : Hashmap Way

		operation.addEmpToMap();
		
		for (String deptName : operation.deptList) {
			System.out.println();
			System.out.println("Department name: " + deptName);
			for (Employee deptEmpList : operation.getEmployeeList(deptName)) {
				System.out.println(deptEmpList.showEmpDetails());
			}
		}

	}
}
