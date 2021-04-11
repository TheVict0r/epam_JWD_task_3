package by.epamtc.task3.ex1.service;

import java.util.Random;

import by.epamtc.task3.ex1.entity.Array;

public class ArrayNumberActions {
	
	
	public int[] defineSimpleNumbersInArray(Array arrayObject) {
		if (arrayObject == null) {
			// throws NullArrayObjectException - пока без реализации
		}
		int[] array = arrayObject.getArray();
		int[] simpleNumTmp = new int[array.length];
		int count = 0;
		
		for(int i = 0; i < array.length; i++) {
				if (isSimpleNumber(array[i])) {
					simpleNumTmp[count] = array[i];
					count++;
				}
		}
		
		int[] simpleNumFinal = new int[count];
		for(int i = 0; i < simpleNumFinal.length; i++) {
			simpleNumFinal[i] = simpleNumTmp[i];
		}
		
		return simpleNumFinal;
	}

	public boolean isSimpleNumber(int num) {
		boolean result = true;
		if(num < 2) {
			result = false;
		} else if (num == 2) {
			result = true;
		} else
			for (int i = 2; i < num; i++) {
				if(num % i == 0) {
					result = false;
					break;
				}
			}
		
		return result;
	}
	
	
	
	public int[] defineFibonacci(Array arrayObject) {
		if (arrayObject == null) {
			// throws NullArrayObjectException - пока без реализации
		}
		int[] array = arrayObject.getArray();
		
		
		return null;
	}

	
	public int[] defineThreeDigtNoIdenticalInArray(Array arrayObject) {
		if (arrayObject == null) {
			// throws NullArrayObjectException - пока без реализации
		}
		int[] array = arrayObject.getArray();
		int[] noIdenticalTmp = new int[array.length];
		int count = 0;
		
		for(int i = 0; i < array.length; i++) {
				if (isThreeDigtNoIdentical(array[i])) {
					noIdenticalTmp[count] = array[i];
					count++;
				}
		}
		
		int[] noIdenticalFinal = new int[count];
		for(int i = 0; i < noIdenticalFinal.length; i++) {
			noIdenticalFinal[i] = noIdenticalTmp[i];
		}
		
		return noIdenticalFinal;
		
	}

	public boolean isThreeDigtNoIdentical(int num) {
		boolean result = false;
		
		if (Math.abs(num) < 100 ||  Math.abs(num) > 999) {
			result = false;
		} else {
			int digit1 = num / 100;
			int digit2 = num / 10 % 10;
			int digit3 = num % 10;
			
			if (digit1 != digit2 && 
				digit2 != digit3 && 
				digit1 != digit3) {
				
				result = true;
			}
		}
		return result;
	}
	
	
	
	public Array fillRandomNumbers(int arrLength, int bound) { 
		Array arrayObject = new Array(arrLength);
		int[] array = arrayObject.getArray();
		Random random = new Random();
		
		for(int i = 0; i < array.length; i++) {
			int sign = random.nextInt(2);
			if (sign == 1) {
				array[i] = random.nextInt(bound);
			} else {
				array[i] = -1 * random.nextInt(bound);
			}
		}
		return arrayObject;
	}
}
