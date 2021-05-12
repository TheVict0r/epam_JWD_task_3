package by.epamtc.task3.ex2.presentation;

public class Printer {

		public static void print(int[] arr) {
		if (arr == null) {
			// throw new NullArrayException("Variable is not initialized")
			// пока что не реализовано
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

		
	public static void print(int[][] jagArr) {
		if (jagArr == null) {
			// throw new NullArrayException("Variable is not initialized"")
			// пока что не реализовано
		}
		for(int i = 0; i < jagArr.length; i++) {
			for(int j = 0; j < jagArr[i].length; j++) {
				System.out.printf("%3d  ", jagArr[i][j]);
			}
			System.out.println();
		}
	}
	
}
