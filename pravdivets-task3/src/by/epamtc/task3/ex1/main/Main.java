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
		printArray(simple);
		
		//==========5. ВСЕ ЧИСЛА ФИБОНАЧЧИ ИЗ МАССИВА ====================
		Array arrayFibo = new Array(new int[] {1, 2, 3, 4, 5, 8, 13, 14, 15, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765});
		int[] fibFib = ArrayNumberActions.defineFibonacci(arrayFibo);
		System.out.print("Fibonacci numbers:   ");
		printArray(fibFib);
		
		//==========6. ТРЁХЗНАЧНЫЕ ЧИСЛА БЕЗ ОДИНАКОВЫХ ЦИФР ============
		Array array6 = new Array(new int[]{2, 3, 5, 7, 122, 123, 199, 595, 596, 555, 808, 703});
		int[] threeDigit = ArrayNumberActions.defineThreeDigtNoIdentical(array6);
		System.out.print("three unique digit numbers:   ");
		printArray(threeDigit);
		
		//==========7. ЗАПОЛНЕНИЕ МАССИВА =============
		
		//7.3 случайные числа
		Array array731 = new Array(10);
		Array array732 = new Array(10);
		Array.fillWithRandom(array731);
		Array.fillWithRandom(array732, 100);
		System.out.println("fill random without bound: " + array731);
		System.out.println("fill random with    bound: " + array732);

		//7.1 из файла
		Array array71 = null;
		String filePath = "C:\\file.txt";
		try {
			array71 = Array.fillFromFile(filePath);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("fill from file: " + array71);

	
		//7.2 с консоли
		Array array72 = new Array(5);
		array72.fillFromConsole();
		System.out.println("Array from console:  " + array72);

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//вспомогательный метод, делал исключительно для тестирования, 
	//не предполагается, что будет использоваться кем-то кроме меня
	//поэтому Exception на входной массив не делал
	public static void printArray(int[] array) {
		for(int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	

}
