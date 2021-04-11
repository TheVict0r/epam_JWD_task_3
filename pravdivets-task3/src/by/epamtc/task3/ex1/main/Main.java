package by.epamtc.task3.ex1.main;

import by.epamtc.task3.ex1.entity.Array;
import by.epamtc.task3.ex1.service.ArrayNumberActions;


public class Main {

	public static void main(String[] args) {
//		Array array1 = new Array(new int[]{1, 2, 3, 4, 853, -256, 666, 128, 42});
//
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
		
		ArrayNumberActions actions = new ArrayNumberActions();
		
		Array array2 = actions.fillRandomNumbers(15, 5);
		System.out.println(array2);
		
		
//		int[] out = actions.defineThreeDigtNoIdenticalInArray(array1);
//		
//		for(int i : out) {
//			System.out.print(i + " ");
//		}
		
//		System.out.println(actions.isThreeDigtNoIdentical(855));
		
	}

}
