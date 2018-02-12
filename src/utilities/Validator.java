/*
 * Class of validation methods
 */

package utilities;

import java.util.Scanner;

public class Validator {

	public static String getString(Scanner sc, String prompt) {
		System.out.print(prompt);
		String s = sc.next(); // read user entry
		sc.nextLine(); // discard any other data entered on the line
		return s;
	}

	// Allows user to enter in three possible options (i,e, cash, credit, check)
	public static String getString(Scanner sc, String prompt, String opt1, String opt2, String opt3) {
		String s = "";
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			s = sc.next(); // read user entry
			sc.nextLine(); // discard any other data entered on the line
			if (s.equalsIgnoreCase(opt1)) {
				isValid = true;
			} else if (s.equalsIgnoreCase(opt2)) {
				isValid = true;
			} else if (s.equalsIgnoreCase(opt3)) {
				isValid = true;
			} else {
				System.out.println("Invalid input, please try again!");
			}
		}

		return s;
	}

	// Allows user to enter in two possible options (i,e, yes/no)
	public static String getString(Scanner sc, String prompt, String opt1, String opt2) {
		String s = "";
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			s = sc.next(); // read user entry
			sc.nextLine(); // discard any other data entered on the line
			if (s.equalsIgnoreCase(opt1)) {
				isValid = true;
			} else if (s.equalsIgnoreCase(opt2)) {
				isValid = true;
			} else {
				System.out.println("Invalid input, please try again!");
			}
		}

		return s;
	}

	public static int getInt(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return i;
	}

	public static int getInt(Scanner sc, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(sc, prompt);
			if (i < min)
				System.out.println("Error! Number must be " + min + " or greater.");
			else if (i > max)
				System.out.println("Error! Number must be " + max + " or less.");
			else
				isValid = true;
		}
		return i;
	}

	public static double getDouble(Scanner sc, String prompt) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			} else {
				System.out.println("Error! Invalid decimal value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return d;
	}

	public static double getDouble(Scanner sc, String prompt, double min, double max) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			d = getDouble(sc, prompt);
			if (d < min)
				System.out.println("Error! Number must be " + min + " or greater.");
			else if (d > max)
				System.out.println("Error! Number must be " + max + " or less.");
			else
				isValid = true;
		}
		return d;
	}

	// double with just a minimum (i.e. non-negative)
	public static double getDouble(Scanner sc, String prompt, double min) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			d = getDouble(sc, prompt);
			if (d < min)
				System.out.println("Error! Number must be " + min + " or greater.");
			else
				isValid = true;
		}
		return d;
	}

	// int with just a minimum (i.e. non-negative)
	public static int getInt(Scanner sc, String prompt, int min) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(sc, prompt);
			if (i < min)
				System.out.println("Error! Number must be " + min + " or greater.");	
			else
				isValid = true;
		}
		return i;
	}

	// long with just a minimum (i.e. non-negative)
	public static long getLong(Scanner sc, String prompt, long min) {
		long i = 1l;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			i = sc.nextLong();
			if (i < min)
				System.out.println("Error! Number must be positive");
			else
				isValid = true;
		}
		return i;
	}
}