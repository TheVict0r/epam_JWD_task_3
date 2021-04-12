package by.epamtc.task3.ex2.services;

public class JaggedArrayActions {

	/*
	 * делает пустую копию исходного массива, 
	 * shift - добавляет/убирает столбцы
	 */
	public static int[][] makeEmptyCopy(int[][] original, int shift){
		int[][] copy = new int[original.length][];
		for(int i = 0; i < original.length; i++) {
			copy[i] = new int[original[i].length + shift];
		}
		return copy;
	}
	
	/*
	 * копирует исходные данные в новый массив с отступом на 1 столбец 
	 * (т.е. первый остается пустым)
	 */
	public static int[][] addFirstEmptyColumn(int[][] jagArr) {
		int[][] widerArr = makeEmptyCopy(jagArr, 1);//каждая строка на 1 ячейку длиннее 
		for(int i = 0; i < jagArr.length; i++) {
			for(int j = 0; j < jagArr[i].length; j++) {
				widerArr[i][j+1] = jagArr[i][j];
			}
		}
		return widerArr;
	}

	/*
	 * создает новый массив равный исходному, но без первого столбца
	 */
	public static int[][] deleteFirstColumn(int[][] widerArr){
		int[][] shortArr = makeEmptyCopy(widerArr, -1);//каждая строка на 1 ячейку короче
		for(int i = 0; i < shortArr.length; i++) {
			for(int j = 0; j < shortArr[i].length; j++) {
				shortArr[i][j] = widerArr[i][j+1];
			}
		}
		return shortArr;
	}

	/*
	 * возвращает первый столбец многомерного массива в виде одномерного массива
	 */
	public static int[] exportFirstColumn(int[][] widerArr){
		int[] firstColumn = new int[widerArr.length];
		for(int i = 0; i < widerArr.length; i++) {
			firstColumn[i] = widerArr[i][0];
		}
		return firstColumn;
	}
	
	/*
	 * обычная "пузырьковая" сортировка
	 */
	public static int[] bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			boolean noSwaps = true;
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					noSwaps = false;
				}
			}
			if (noSwaps) {
				break;
			}
		}
		return array;
	}
	
	public static int[][] sortWithGuideLine(int[][] widerArr, int[] guideArr){
		if(widerArr.length != guideArr.length) {
			//throw new ArrayLengthInconsistencyException("Arrays have different length") 
			// пока что не реализовано
		}
		
		int[][] sorted = makeEmptyCopy(widerArr, 0);
		
		for(int i = 0; i < sorted.length; i++) {
			for(int j = 0; j < guideArr.length; j++) {
				for(int k = 0; k < widerArr.length; k++) {
					if(guideArr[j] == widerArr[i][0]) {
						sorted[i] = widerArr[k];
					}
				}
			}
		}
		
		return sorted;
		
	}
	
	
	/*
	 * добавляет в первую пустую ячейку каждой строки нового массива СУММУ по этой строке
	 */
	public static int[][] defineRowSum(int[][] jagArr){
		int[][] sumArr = addFirstEmptyColumn(jagArr);
		for(int i = 0; i < jagArr.length; i++) {
			int sum = 0;
			for(int j = 0; j < jagArr[i].length; j++) {
				sum += jagArr[i][j];
			}
			sumArr[i][0] = sum;
		}
		return sumArr;
	}

	
	/*
	 * добавляет в первую пустую ячейку каждой строки нового массива МАКСИМАЛЬНОЕ значение по этой строке
	 */
	public static int[][] defineMax(int[][] jagArr){
		int[][] maxArr = addFirstEmptyColumn(jagArr);
		for(int i = 0; i < jagArr.length; i++) {
			int max = jagArr[i][0];
			for(int j = 0; j < jagArr[i].length; j++) {
				if(jagArr[i][j] > max) {
					max = jagArr[i][j];
				}
			}
			maxArr[i][0] = max;
		}
		return maxArr;
	}

	
	/*
	 * добавляет в первую пустую ячейку каждой строки нового массива МИНИМАЛЬНОЕ значение по этой строке
	 */
	public static int[][] defineMin(int[][] jagArr){
		int[][] minArr = addFirstEmptyColumn(jagArr);
		for(int i = 0; i < jagArr.length; i++) {
			int min = jagArr[i][0];
			for(int j = 0; j < jagArr[i].length; j++) {
				if(jagArr[i][j] < min) {
					min = jagArr[i][j];
				}
			}
			minArr[i][0] = min;
		}
		return minArr;
	}
	

	
}
