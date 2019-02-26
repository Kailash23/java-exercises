package org;

import java.util.*;
import org.Department;

public class Operations {
	
	/**
	 * List for maintaining all employee objects
	 */
	private LinkedList<Employee> employeeList = new LinkedList<Employee>();
	
	/**
	 * Map for maintaining all employee objects
	 */
	private HashMap<String, ArrayList<Employee>> map = new HashMap<>();
	
	/**
	 * List to store the name of the department
	 */
	ArrayList<String> deptList = new ArrayList<>();
	

	void addEmployee(String name, boolean bool, Department dept) {
		if(!(deptList.contains(dept.getDeptName()))) {
			deptList.add(dept.getDeptName());
		}
		employeeList.add(new Employee(name, bool, dept));
	}

	void removeEmployee(long eid) {
		Iterator<Employee> itr = employeeList.iterator();
		while (itr.hasNext()) {
			if (itr.next().getEid() == eid) {
				itr.remove();
			}
		}
	}

	boolean workingStatus(long eid) {
		Iterator<Employee> itr = employeeList.iterator();
		while (itr.hasNext()) {
			if (itr.next().getEid() == eid) {
				return itr.next().getCurrentlyWorking();
			}
		}
		return false;
	}

	void displayEmpDetails() {
		Iterator<Employee> itr = employeeList.iterator();
		System.out.println("Employee Details :");
		while (itr.hasNext()) {
			System.out.println(itr.next().showEmpDetails());
		}
	}

	public int getEmployeeCount() {
		return Employee.noOfEmployee;
	}

	ArrayList<Employee> getEmpList(String deptName) {
		ArrayList<Employee> deptEmpList = new ArrayList<>();

		for (Employee emp : employeeList) {
			if (emp.getDept().deptName == deptName) {
				deptEmpList.add(emp);
			}
		}
		return deptEmpList;
	}
	
	public void addEmpToMap() {
		for (Employee emp : employeeList) {
			String key = emp.getDeptName();
			if (map.get(key) == null) {
			    map.put(key, new ArrayList<Employee>());
			}
			map.get(key).add(emp);
		}
	}
	
	ArrayList<Employee> getEmployeeList(String deptName) {
		if (map.containsKey(deptName)) {
			return map.get(deptName);
		}
		return null;
	}
	
}
