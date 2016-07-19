package com.javatest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author MrSourcePlex
 * @version 1.0
 * @since 2016-07-19
 */
public class JavaTest {
	
	private Scanner scanner;
	
	private final int MAX_TRIES = 5;
	
	private float[] values = { 9.81f, 7.24f, 6.15f, 1.65f, 8.29f, 2, 6.47f, 9.9f };
	
	public JavaTest() {
		System.out.println(Arrays.toString(values));
		System.out.println("(1) Average");
		System.out.println("(2) Max");
		System.out.println("(3) Min");
		int choice = -1;
		String input = "";
		for(int i = 1; i <= MAX_TRIES; i++) {
			try{
				System.out.print(">> ");
				input = getInput();
				choice = Integer.parseInt(input);
				if(choice > 0 && choice <= 3) {
					break;
				}else{
					System.out.println("Error: Available options : 1 - 3");
				}
			}catch(NumberFormatException e) {
				System.err.println("The input " + "'" + input + "'" + " is not valid!");
			}finally{
				if(i >= MAX_TRIES) {
					System.err.println("You reached the maximum of tries! MAX_TRIES[" + MAX_TRIES +"]");
					System.exit(0);
				}
			}
		}
		
		switch(choice) {
		case 1:
			System.out.println("Average: " + average(values));
			break;
		case 2:
			System.out.println("Max: " + max(values));
			break;
		case 3:
			System.out.println("Min: " + min(values));
			break;
		default:
			System.err.println("Error : No Operation selected");
			break;
		}
	}
	
	public static void main(String[] args) {
		new JavaTest();
	}
	
	public String getInput() {
		if(scanner == null) {
			scanner = new Scanner(System.in);
		}
		return scanner.nextLine();
	}
	
	public float min(float...values) {
		float min = max(values);
		for(float f : values) {
			if(f < min) min = f;
		}
		return min;
	}
	
	public float max(float...values) {
		float max = 0;
		for(float f : values) {
			if(f > max) max = f;
		}
		return max;
	}
	
	public float average(float...values) {
		float sum = 0;
		for(float f : values) {
			sum += f;
		}
		return sum / values.length;
	}
}