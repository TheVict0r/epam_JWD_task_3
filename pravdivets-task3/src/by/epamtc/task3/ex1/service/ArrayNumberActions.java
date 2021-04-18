package by.epamtc.task3.ex1.service;

import java.util.Random;

import by.epamtc.task3.ex1.entity.Array;

public class ArrayNumberActions {

	public static int[] defineSimpleNum(Array arrayObject) {
		if (arrayObject == null) {
			// throw new NullArrayObjectException("Variable is not initialized") - пока
			// без реализации
		}
		int[] array = arrayObject.getArray();
		int[] tmp = new int[array.length];
		int count = 0;

		for (int i = 0; i < array.length; i++) {
			if (isSimple(array[i])) {
				tmp[count] = array[i];
				count++;
			}
		}

		int[] result = cutArray(tmp, count);
		return result;
	}

	
	public static boolean isSimple(int num) {
		boolean result = true;
		if (num < 2) {
			result = false;
		} else if (num == 2) {
			result = true;
		} else
			for (int i = 2; i < num; i++) {
				if (num % i == 0) {
					result = false;
					break;
				}
			}

		return result;
	}

	public static int[] defineFibonacci(Array arrayObject) {
		if (arrayObject == null) {
			// throw new NullArrayObjectException("Variable is not initialized") - пока без реализации
		}

		int[] array = arrayObject.getArray();
		int[] tmp = new int[array.length];
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			if(isFibonacci(array[i])) {
				tmp[count] = array[i];
				count++;
			}
		}
		
		int[] result = cutArray(tmp, count);
		return result;
	}

	
	public static boolean isFibonacci (int num) {
		double first = Math.sqrt(5 * num * num + 4);
		double second = Math.sqrt(5 * num * num - 4);
		boolean result = false;
		result = (first % 1 == 0) || (second % 1 == 0);
		return result;
	}
	
	
	public static int[] defineThreeDigtNoIdentical(Array arrayObject) {
		if (arrayObject == null) {
			// throw new NullArrayObjectException("Variable is not initialized") - пока без реализации
		}
		int[] array = arrayObject.getArray();
		int[] tmp = new int[array.length];
		int count = 0;

		for (int i = 0; i < array.length; i++) {
			if (isThreeDigtNoIdentical(array[i])) {
				tmp[count] = array[i];
				count++;
			}
		}
		int[] result = cutArray(tmp, count);
		return result;

	}

	public static boolean isThreeDigtNoIdentical(int num) {
		boolean result = false;

		if (Math.abs(num) < 100 || Math.abs(num) > 999) {
			result = false;
		} else {
			int digit1 = num / 100;
			int digit2 = num / 10 % 10;
			int digit3 = num % 10;

			if (digit1 != digit2 && digit2 != digit3 && digit1 != digit3) {

				result = true;
			}
		}
		return result;
	}

	
	
	
	public static int[] cutArray(int[] longArray, int shortArrayLength ) {
		int[] shortArray = new int[shortArrayLength];
		
		for(int i = 0; i < shortArray.length; i++) {
			shortArray[i] = longArray[i];
		}
		return shortArray;
	}
	

}
