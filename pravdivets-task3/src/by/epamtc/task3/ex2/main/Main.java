package by.epamtc.task3.ex2.main;

import by.epamtc.task3.ex2.presentation.Print;
import by.epamtc.task3.ex2.services.JaggedArrayActions;

public class Main {

	public static void main(String[] args) {
		int[][] jagArr = new int[5][];
		jagArr[0] = new int[]{5,  8,  9,   42};
		jagArr[1] = new int[]{25, 1,  348};
		jagArr[2] = new int[]{99, 7,  52,  42, 73, 72};
		jagArr[3] = new int[]{24, 37, 569, 42, 99};
		jagArr[4] = new int[]{29, 48, 18,  24, 81, 54, 3};

		Print.print(jagArr);
		System.out.println("=====================================");
		
		int[][] wideArr = JaggedArrayActions.addFirstEmptyColumn(jagArr);
		Print.print(wideArr);
		System.out.println("=====================================");

		Print.print(JaggedArrayActions.defineRowSum(jagArr));
		System.out.println("=====================================");
		Print.print(JaggedArrayActions.defineMax(jagArr));
		System.out.println("=====================================");
		Print.print(JaggedArrayActions.defineMin(jagArr));
	}

}
