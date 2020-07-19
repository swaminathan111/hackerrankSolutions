package com.java.priorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * Create the Student and Priorities classes here.
 */
class Priorities {

	/**
	 * 
	 * @param events
	 * @return
	 */
	public List<Student> getStudents(List<String> events) {
		PriorityQueue<Student> remaining = new PriorityQueue<Student>(Comparator.comparing(Student::getCgpa).reversed()
				.thenComparing(Student::getName).thenComparing(Student::getId));

		List<Student> students = new ArrayList<Student>();

		for (String event : events) {
			Scanner scan = new Scanner(event);
			String operation = scan.next();
			if (operation.equals("ENTER")) {
				String name = scan.next();
				double cgpa = scan.nextDouble();
				int id = scan.nextInt();
				Student std = new Student(id, name, cgpa);
				remaining.add(std);
			} else if (event.equals("SERVED")) {
				Student first = remaining.poll();
			}
			scan.close();
		}

//		Dan
//		Ashley
//		Maria
//		Shafaet
//		List<Student> students  = new ArrayList<Student>(remaining);
		Student first = remaining.poll();
		if (first == null) {
			return students;
		} else {
			while (first != null) {

				students.add(first);
				first = remaining.poll();

			}
		}

//		System.out.println("Final List" + remaining);
		return students;
	}
}

/**
 * 
 * @author 91944
 *
 */
class Student {
	int id;
	String name;
	double cgpa;

	public Student() {

	}

	public Student(int id, String name, double cgpa) {
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public double getCgpa() {
		return this.cgpa;
	}

	@Override
	public String toString() {
		return name;
	}

}

/**
 * 
 * @author 91944
 *
 */
public class JavaPriorityQueue {
	private final static Scanner scan = new Scanner(System.in);
	private final static Priorities priorities = new Priorities();

	public static void main(String[] args) {
		int totalEvents = Integer.parseInt(scan.nextLine());
		List<String> events = new ArrayList<>();

		while (totalEvents-- != 0) {
			String event = scan.nextLine();
			events.add(event);
		}

		List<Student> students = priorities.getStudents(events);

		if (students.isEmpty()) {
			System.out.println("EMPTY");
		} else {
			for (Student st : students) {
				System.out.println(st.getName());
			}
		}
	}
}
