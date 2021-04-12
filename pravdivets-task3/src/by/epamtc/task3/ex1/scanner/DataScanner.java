package by.epamtc.task3.ex1.scanner;

import java.util.Scanner;

public class DataScanner {

	@SuppressWarnings("resource")
	public static int enterIntFromConsole() {

		Scanner scanner = new Scanner(System.in);

		int i = 0;

		while (!scanner.hasNextInt()) {
			scanner.next();
		}

		i = scanner.nextInt();

		return i;
	}

	
	
	
	@SuppressWarnings("resource")
	public static double enterDoubleFromConsole() {

		Scanner scanner = new Scanner(System.in);

		double d = 0.0;

		while (!scanner.hasNextDouble()) {
			scanner.next();
		}

		d = scanner.nextDouble();

		return d;
	}

	@SuppressWarnings("resource")
	public static long enterLongFromConsole() {
		
		Scanner scanner = new Scanner(System.in);
		
		long j = 0L;
		
		while (!scanner.hasNextLong()) {
			scanner.next();
		}
		
		j = scanner.nextLong();
		
		return j;
	}
	
	
	
	
}
