package by.epamtc.task3.ex2.logic.action;

import by.epamtc.task3.ex2.logic.basis.SortingBasis;

public class ArrayAction {
	
	public static void sortBy(int[][] array, SortingBasis by, boolean decreasing) {
		if(array == null) {
			//throw new NullArrayException("Variable is not initialized");
			//пока не реализовано
		}
		
		if(by == null) {
			//throw new NullSortingBasisException("Variable is not initialized");
			//пока не реализовано
		}
		
		for(int i = 0; i < array.length - 1; i++) {
			boolean noSwaps = true;
			for(int j = 0; j < array.length - i - 1; j++) {
				if(by.sortBy(array[j]) > by.sortBy(array[j + 1])){
					int[] tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
					noSwaps = false;
				}
			}
			if(noSwaps) {
				break;
			}
		}
		if(decreasing) {
			reverse(array);
		}
	}
	
	public static void reverse(int[][] array) {
		if(array == null) {
			//throw new NullArrayException("Variable is not initialized");
			//пока не реализовано
		}
		for(int i = 0; i < array.length / 2; i++) {
			int[] tmp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = tmp;
		}
	}
	
	/*
	 * решил не перегружать, а сделать для удобства 
	 * два дополнительных метода с новыми "говорящими" названиями
	 */
	public static void sortIncreasingBy(int[][] array, SortingBasis by) {
		//проверка входных параметров уже реализована в исходном методе sortBy
		sortBy(array, by, false);
	}
	
	public static void sortDecreasingBy(int[][] array, SortingBasis by) {
		sortBy(array, by, true);
	}

	
	
	
}
