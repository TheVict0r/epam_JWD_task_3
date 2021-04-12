package by.epamtc.task3.ex2.presentation;

public class Print {

	public static void print(int[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.printf("%3d  ", array[i][j]);
			}
			System.out.println();
		}
	}
	
	
}
