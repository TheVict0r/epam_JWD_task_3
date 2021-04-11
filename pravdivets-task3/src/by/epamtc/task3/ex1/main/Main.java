package by.epamtc.task3.ex1.main;

import java.io.IOException;

import by.epamtc.task3.ex1.entity.Array;
import by.epamtc.task3.ex1.service.ArrayNumberActions;


public class Main {

	public static void main(String[] args)  {
//		Array array1 = new Array(new int[]{1, 2, 3, 4, 42, 85, 942});
//		
//		
//		System.out.println(array1);
//		
//		System.out.println(array1.searchBinary(42));
//		
//		System.out.println(array1);
//		
		
//		for(int i : array1.getArray()) {
//			System.out.print(i + " ");
//		}
		
		//System.out.println(array1.defineMin());
		
		//ArrayNumberActions actions = new ArrayNumberActions();
		
		//
//		
		
//		int[] out = actions.defineThreeDigtNoIdenticalInArray(array1);
//		
//		for(int i : out) {
//			System.out.print(i + " ");
//		}
		
//		System.out.println(actions.isThreeDigtNoIdentical(855));
//		
//		Array array3 = new Array(10);
//		System.out.println(array3);
//		String s = "C:\\file.txt";
//		System.out.println(s);
//		try {
//			array3.fillFromFile(s);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(array3);
//		
		
		//ФИБОНАЧЧИ
		
		Array arrayFibo = new Array(new int[] {1, 2, 3, 4, 5, 8, 13, 14, 15, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765});
		int[] fibFib = ArrayNumberActions.defineFibonacci(arrayFibo);
		for(int i : fibFib) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
