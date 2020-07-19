package com.java.important.utils;

import java.util.Scanner;

/**
 * Using scanner to read a String of Objects with spaces
 * 
 * @author 91944
 *
 */
public class ScannerUsage {

	public static void main(String[] args) {

		String words = "797 23rdcross Sector2 HSR-Layout";
		Scanner scan = new Scanner(words);
		try {
			System.out.println("Hno-" + scan.next());
			System.out.println("Cross-" + scan.next());
			System.out.println("Sector?-" + scan.next());
			System.out.println("Area" + scan.next());
		} catch (Exception e) {

		} finally {
			scan.close();
		}
	}
}
