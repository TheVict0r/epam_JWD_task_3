package by.epamtc.task3.ex2.main;

import by.epamtc.task3.ex2.logic.action.ArrayAction;
import by.epamtc.task3.ex2.logic.basis.Max;
import by.epamtc.task3.ex2.logic.basis.Min;
import by.epamtc.task3.ex2.logic.basis.Sum;
import by.epamtc.task3.ex2.presentation.Printer;

public class Main {

	public static void main(String[] args) {
		int[][] testArr = new int[5][];
		testArr[0] = new int[]{5,  8,  9,   42};
		testArr[1] = new int[]{25, 1,  348};
		testArr[2] = new int[]{99, 7,  52,  42, 73, 72};
		testArr[3] = new int[]{24, 37, 569, 42, 99};
		testArr[4] = new int[]{29, 48, 18,  24, 81, 54, 3};

		System.out.println("======First Array=========================================");
		Printer.print(testArr);

		System.out.println("======Sorted by increasing MIN element ===================");
		ArrayAction.sortBy(testArr, new Min(), false);
		Printer.print(testArr);
		System.out.println("======Sorted by decreasing MIN element ===================");
		ArrayAction.sortBy(testArr, new Min(), true);
		Printer.print(testArr);
		
		System.out.println("======Sorted by increasing MAX element ===================");
		ArrayAction.sortBy(testArr, new Max(), false);
		Printer.print(testArr);
		System.out.println("======Sorted by decreasing MAX element ===================");
		ArrayAction.sortBy(testArr, new Max(), true);
		Printer.print(testArr);
		
		System.out.println("======Sorted by increasing SUM============================");
		ArrayAction.sortBy(testArr, new Sum(), false);
		Printer.print(testArr);
		System.out.println("======Sorted by decreasing SUM============================");
		ArrayAction.sortBy(testArr, new Sum(), true);
		Printer.print(testArr);
		
	}

}
