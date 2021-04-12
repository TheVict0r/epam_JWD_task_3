package by.epamtc.task3.ex2.main;

import by.epamtc.task3.ex2.presentation.Printer;
import by.epamtc.task3.ex2.services.JaggedArrayActions;

public class Main {

	public static void main(String[] args) {
		int[][] jagArr = new int[5][];
		jagArr[0] = new int[]{5,  8,  9,   42};
		jagArr[1] = new int[]{25, 1,  348};
		jagArr[2] = new int[]{99, 7,  52,  42, 73, 72};
		jagArr[3] = new int[]{24, 37, 569, 42, 99};
		jagArr[4] = new int[]{29, 48, 18,  24, 81, 54, 3};

		
		System.out.println("======First Array===================");
		Printer.print(jagArr);
		
		System.out.println("======Wider Array=======================");
		int[][] wideArr = JaggedArrayActions.addFirstEmptyColumn(jagArr);
		Printer.print(wideArr);
		
		
		System.out.println("======Row Sum===================");
		int[][] rowSum = JaggedArrayActions.defineRowSum(jagArr);
		Printer.print(rowSum);
		
//		System.out.println("======MAX============================");
//		int[][] maxArr = JaggedArrayActions.defineMax(jagArr);
//		Printer.print(maxArr );
//		
//		System.out.println("======min============================");
//		int[][] minArr = JaggedArrayActions.defineMin(jagArr);
//		Printer.print(minArr);
		
		System.out.println("======First Column (Row Sum)============================");
		int[] firstColumn = JaggedArrayActions.exportFirstColumn(rowSum);
		Printer.print(firstColumn);
		
		System.out.println("======Bubble Sort First Column (Row Sum)============================");
		JaggedArrayActions.bubbleSort(firstColumn);
		Printer.print(firstColumn);
		
		System.out.println("======Sum Sorted============================");
		int[][] sumSorted = JaggedArrayActions.sortWithGuideLine(rowSum, firstColumn);
		Printer.print(sumSorted);
				
		
		
	}

}
