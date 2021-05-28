package test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Employee {

	private String empName;
	private LocalDate dob;

	public Employee(String empName, LocalDate dob) {
		super();
		this.empName = empName;
		this.dob = dob;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

}

public class Test4 {

	public static void main(String[] args) {

		/*
		 * Integer arr[] = {1,6,8,3,5}; Comparator<Integer> c = (Integer i1, Integer i2)
		 * -> i2.compareTo(i1); //c.reversed(); Arrays.sort(arr,c);
		 * System.out.println(Arrays.toString(arr));
		 */

		List<Employee> list = new ArrayList<>();
		list.add(new Employee("Suneel", LocalDate.of(2021, 5, 11)));
		list.add(new Employee("punya", LocalDate.of(2021, 5, 11)));
		list.add(new Employee("Ram", LocalDate.of(2021, 8, 11)));
		list.add(new Employee("sita", LocalDate.of(2021, 1, 11)));

		List<Employee> list2 = list.stream().filter(e -> e.getDob().getMonth() == Month.MAY)
				.collect(Collectors.toList());

		for (Employee e : list2) {
			System.out.println("Name:" + e.getEmpName() + "-- dob:" + e.getDob());
		}
	}

}
