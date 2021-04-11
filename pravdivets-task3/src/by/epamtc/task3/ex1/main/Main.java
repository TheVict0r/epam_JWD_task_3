package by.epamtc.task3.ex1.main;

import java.io.IOException;

import by.epamtc.task3.ex1.entity.Array;
import by.epamtc.task3.ex1.service.ArrayNumberActions;


public class Main {

	public static void main(String[] args)  {
		//========1. СОРТИРОВКА ТРЕМЯ СПОСОБАМИ ===============
		Array array1v1 = new Array(new int[]{42, 999, 3, 4, 8, 85, 942});
		Array array1v2 = new Array(new int[]{42, 999, 3, 4, 8, 85, 942});
		Array array1v3 = new Array(new int[]{42, 999, 3, 4, 8, 85, 942});
		
		array1v1.sort1();
		System.out.println("sort 1:  " + array1v1);
		
		array1v2.sort2();
		System.out.println("sort 2:  " + array1v2);
		
		array1v3.sort1();
		System.out.println("sort 3:  " + array1v3);
		
		//========2. БИНАРНЫЙ ПОИСК============================
		Array array2 = new Array(new int[]{1, 2, 3, 4, 42, 85, 942});
		System.out.println("searchBinary:  " + array2.searchBinary(42));
		
		//========3. МИНИМАЛЬНОЕ И МАКСИМАЛЬНОЕ ЧИСЛО============
		Array array3 = new Array(new int[]{42, 999, 3, 4, 8, 85, 942, -1});
		System.out.println("defineMin:  " + array3.defineMin());
		System.out.println("defineMax:  " + array3.defineMax());
		
		//========4. ПРОСТЫЕ ЧИСЛА =================
		Array array4 = new Array(new int[]{2, 3, 5, 7, 11, 13, 17, 179, 181, 191, 193, 197, 42, 33, 99});
		int[] simple = ArrayNumberActions.defineSimpleNum(array4);
		System.out.print("simple numbers:  ");
		for(int i : simple) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		
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
		
		//==========ФИБОНАЧЧИ
		Array arrayFibo = new Array(new int[] {1, 2, 3, 4, 5, 8, 13, 14, 15, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765});
		int[] fibFib = ArrayNumberActions.defineFibonacci(arrayFibo);
		System.out.print("Fibonacci numbers:   ");
		for(int i : fibFib) {
			System.out.print(i + " ");
		}
		System.out.println();
		//===========================
	}

}
