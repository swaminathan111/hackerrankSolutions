package com.java.exceptionhandling;

import java.util.Scanner;
class MyCalculator {

	public char[] power(int n, int p) {
		// TODO Auto-generated method stub
		return null;
	}
  
}

public class Solution1 {
    public static final MyCalculator my_calculator = new MyCalculator();
    public static final Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (in .hasNextInt()) {
            int n = in .nextInt();
            int p = in .nextInt();
            
            try {
                System.out.println(my_calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
