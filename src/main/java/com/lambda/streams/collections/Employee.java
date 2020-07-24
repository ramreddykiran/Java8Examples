package com.lambda.streams.collections;

public class Employee {
	
	private String empName;
	private String empid;
	private String gender;
	private String desg;
	
	public Employee(String empName, String empid, String gender, String desg) {
		super();
		this.empName = empName;
		this.empid = empid;
		this.gender = gender;
		this.desg = desg;
		
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empid=" + empid + ", gender=" + gender + 
				", desg=" + desg +"]";
	}
	
	

}
