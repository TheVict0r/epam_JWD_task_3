package by.epamtc.task3.ex1.service;

import java.util.Random;

import by.epamtc.task3.ex1.entity.Array;

public class ArrayNumberActions {

	public static int[] defineSimpleNum(Array arrayObject) {
		if (arrayObject == null) {
			// throw new NullArrayObjectException(The Array object equals to null) - пока без реализации
		}
		int[] array = arrayObject.getArray();
		int[] tmp = new int[array.length];
		int count = 0;

		for (int i = 0; i < array.length; i++) {
			if (isSimpleNum(array[i])) {
				tmp[count] = array[i];
				count++;
			}
		}

		int[] result = new int[count];
		for (int i = 0; i < result.length; i++) {
			result[i] = tmp[i];
		}

		return result;
	}

	public static boolean isSimpleNum(int num) {
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
			// throw new NullArrayObjectException(The Array object equals to null) - пока без реализации
		}
		int[] array = arrayObject.getArray();

		
		
		
		return null;
	}

	public static int[] defineThreeDigtNoIdentical(Array arrayObject) {
		if (arrayObject == null) {
			// throw new NullArrayObjectException(The Array object equals to null) - пока без реализации
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
		int[] result = new int[count];
		for (int i = 0; i < result.length; i++) {
			result[i] = tmp[i];
		}

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

	public static void fillRandomNumbers(Array arrayObject, int bound) {
		if (arrayObject == null) {
			// throw new NullArrayObjectException(The Array object equals to null) - пока без реализации
		}
		
		int[] array = arrayObject.getArray();
		Random random = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(bound);
			
		}
		
	}
}
