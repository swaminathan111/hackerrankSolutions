package com.java.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

class Employee implements Comparable<Employee> {
	int id;
	String name;
	double salary;

	public Employee() {

	}

	Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public double getSalary() {
		return this.salary;
	}

	@Override
	public int compareTo(Employee o) {
		if (salary > o.salary) {
//			if (name.compareTo(o.name) < 1) {
			return 1;
//			} else
//				return 0;
		} else
			return 0;
	}

	@Override
	public String toString() {
		return "{ID:" + id + "-Name:" + name + "-Salary:"+salary+"}";
	}
}

public class PriorityQueueExample {

	public static void main(String[] args) {

		PriorityQueue<Integer> elements = new PriorityQueue<>();

		elements.add(10);
		elements.add(5);
		elements.add(7);
		System.out.println("Before Poll" + elements.toString());
		System.out.println("Poll->" + elements.poll());
		System.out.println("After Poll" + elements.toString());

		PriorityQueue<Employee> employees = new PriorityQueue<Employee>(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getName).thenComparing(Employee::getId));
		employees.add(new Employee(21, "John", 30000.10));
		employees.add(new Employee(9, "blake", 500000));
		employees.add(new Employee(34, "katy", 500000));
		employees.comparator();
		employees.poll();

		System.out.println("Employee Priority Queue: " + employees.toString());

	}

}
