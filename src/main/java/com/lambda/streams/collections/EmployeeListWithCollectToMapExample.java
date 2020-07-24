package com.lambda.streams.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.mapping;

public class EmployeeListWithCollectToMapExample {
	
	public static void main(String[] args) {
		EmployeeListWithCollectToMapExample obj = new EmployeeListWithCollectToMapExample();
		List<Employee> listEmp = new ArrayList<>();
		listEmp.add(new Employee("Kiran","123","MALE","SSE"));
		listEmp.add(new Employee("Dharma","124","MALE","SSE"));
		listEmp.add(new Employee("Kiran","125","MALE","SE"));
		listEmp.add(new Employee("Ravindra","126","MALE","PSE"));
		listEmp.add(new Employee("Jennifer","127","FEMALE","SM"));
		listEmp.add(new Employee("Charlie","128","FEMALE","BA"));
		listEmp.add(new Employee("Savani","129","FEMALE","PM"));
		listEmp.add(new Employee("Bindu","130","FEMALE","SSE"));
		listEmp.add(new Employee("Dharma","131","MALE","SE"));


		obj.mapNameDesgKeyEmpValue(listEmp);
		obj.groupEmployeesWithDesg(listEmp);
		obj.groupEmployeeNamesWithDesg(listEmp); //<desg, List<Name>>
	}

	private void mapNameDesgKeyEmpValue(List<Employee> listEmp) {
		Map<String, Employee> map =
			listEmp.stream()
					.collect(toMap(
								emp -> emp.getEmpName()+ " - "+emp.getDesg(),
								emp -> emp));
		System.out.println("listToMap = "+map);
	}
	
	private void groupEmployeesWithDesg(List<Employee> listEmp) {
		Map<String, List<Employee>> desgMap = listEmp.stream()
				.collect(
						groupingBy(Employee::getDesg));
		System.out.println("desgMap = "+desgMap);
	}
	
	private void groupEmployeeNamesWithDesg(List<Employee> listEmp) {
		Map<String, List<String>> desgNamesMap = listEmp.stream()
				.collect(
						groupingBy(Employee::getDesg,
									mapping(Employee::getEmpName, toList())
								  )
						);
		System.out.println("desgnamesmap "+desgNamesMap);
				
		
	}

}
