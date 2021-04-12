package by.epamtc.task3.ex2.presentation;

public class Printer {

	public static void print(int[][] jagArr) {
		for(int i = 0; i < jagArr.length; i++) {
			for(int j = 0; j < jagArr[i].length; j++) {
				System.out.printf("%3d  ", jagArr[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void print(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
}
