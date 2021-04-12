package by.epamtc.task3.ex2.services;

public class JaggedArrayActions {

	public static int[][] sortBySum(int[][] jagArr, boolean reverse) {
		if (jagArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[][] withSum = defineRowSum(jagArr);
		int[][] result = transformToSorted(withSum, reverse);
		
		return result;
	}

	public static int[][] sortByMax(int[][] jagArr, boolean reverse) {
		if (jagArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[][] withMax = defineRowMax(jagArr);
		int[][] result = transformToSorted(withMax, reverse);

		return result;
	}

	public static int[][] sortByMin(int[][] jagArr, boolean reverse) {
		if (jagArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[][] withMin = defineRowMin(jagArr);
		int[][] result = transformToSorted(withMin, reverse);

		return result;
	}

	/*
	 * сортирует массив по временной первой колонке с промежуточными расчетами после чего удаляет ее
	 */
	public static int[][] transformToSorted(int[][] wideArr, boolean reverse){
		if (wideArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[] firstCol = exportFirstColumn(wideArr); 
		int[] sortedFirstCol = bubbleSort(firstCol);  
			if (reverse) {
				sortedFirstCol = reverse(sortedFirstCol);
			}
		int[][] wideSoreted = sortWithGuideLine(wideArr, sortedFirstCol);
		int[][] result = deleteFirstColumn(wideSoreted); 

		return result;
	}
	
	/*
	 * сортирует двумерный массив по первому столбцу в соответствии с одномерным массивом
	 */
	public static int[][] sortWithGuideLine(int[][] wideArr, int[] guideArr) {
		if (wideArr == null || guideArr == null) {
			// throw new NullArrayException("Array variable equals to null")
			// пока что не реализовано
		}
		if (wideArr.length != guideArr.length) {
			// throw new ArrayLengthInconsistencyException("Arrays have different lengths")
			// пока что не реализовано
		}
		int[][] sorted = makeEmptyCopy(wideArr, 0);
		for (int i = 0; i < sorted.length; i++) { // перебираем финальный массив i - актуальная строка
			for (int j = 0; j < guideArr.length; j++) { // перебираем отсортированный одномерный массив j - актуальное значение
				for (int k = 0; k < wideArr.length; k++) {// перебираем исходный массив k - актуальная строка
					if (wideArr[k][0] == guideArr[j]) {
						sorted[j] = wideArr[k];
					}
				}
			}
		}
		return sorted;
	}

	/*
	 * делает пустую копию исходного массива, 
	 * shift - добавляет/убирает столбцы
	 */
	public static int[][] makeEmptyCopy(int[][] original, int shift) {
		if (original == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[][] copy = new int[original.length][];
		for (int i = 0; i < original.length; i++) {
			copy[i] = new int[original[i].length + shift];
		}
		return copy;
	}

	public static int[][] addFirstEmptyColumn(int[][] jagArr) {
		if (jagArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[][] widerArr = makeEmptyCopy(jagArr, 1);// каждая строка на 1 ячейку длиннее
		for (int i = 0; i < jagArr.length; i++) {
			for (int j = 0; j < jagArr[i].length; j++) {
				widerArr[i][j + 1] = jagArr[i][j];
			}
		}
		return widerArr;
	}

	public static int[] exportFirstColumn(int[][] wideArr) {
		if (wideArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[] firstColumn = new int[wideArr.length];
		for (int i = 0; i < wideArr.length; i++) {
			firstColumn[i] = wideArr[i][0];
		}
		return firstColumn;
	}

	
	public static int[] bubbleSort(int[] array) {
		if (array == null) {
			// throw new NullArrayException("Array variable equals to null")
			// пока что не реализовано
		}
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

	public static int[] reverse(int[] array) {
		if (array == null) {
			// throw new NullArrayException("Array variable equals to null")
			// пока что не реализовано
		}
		int[] reversed = new int[array.length];
		for (int i = 0; i < reversed.length; i++) {
			reversed[i] = array[array.length - i - 1];
		}
		return reversed;
	}

	public static int[][] deleteFirstColumn(int[][] wideArr) {
		if (wideArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[][] shortArr = makeEmptyCopy(wideArr, -1);// каждая строка на 1 ячейку короче
		for (int i = 0; i < shortArr.length; i++) {
			for (int j = 0; j < shortArr[i].length; j++) {
				shortArr[i][j] = wideArr[i][j + 1];
			}
		}
		return shortArr;
	}

	/*
	 * добавляет в первую пустую ячейку каждой строки нового массива СУММУ по этой строке
	 */
	public static int[][] defineRowSum(int[][] wideArr) {
		if (wideArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[][] sumArr = addFirstEmptyColumn(wideArr);
		for (int i = 0; i < wideArr.length; i++) {
			int sum = 0;
			for (int j = 0; j < wideArr[i].length; j++) {
				sum += wideArr[i][j];
			}
			sumArr[i][0] = sum;
		}
		return sumArr;
	}

	/*
	 * добавляет в первую пустую ячейку каждой строки нового массива МАКСИМАЛЬНОЕ
	 * значение по этой строке
	 */
	public static int[][] defineRowMax(int[][] wideArr) {
		if (wideArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[][] maxArr = addFirstEmptyColumn(wideArr);
		for (int i = 0; i < wideArr.length; i++) {
			int max = wideArr[i][0];
			for (int j = 0; j < wideArr[i].length; j++) {
				if (wideArr[i][j] > max) {
					max = wideArr[i][j];
				}
			}
			maxArr[i][0] = max;
		}
		return maxArr;
	}

	/*
	 * добавляет в первую пустую ячейку каждой строки нового массива МИНИМАЛЬНОЕ
	 * значение по этой строке
	 */
	public static int[][] defineRowMin(int[][] wideArr) {
		if (wideArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[][] minArr = addFirstEmptyColumn(wideArr);
		for (int i = 0; i < wideArr.length; i++) {
			int min = wideArr[i][0];
			for (int j = 0; j < wideArr[i].length; j++) {
				if (wideArr[i][j] < min) {
					min = wideArr[i][j];
				}
			}
			minArr[i][0] = min;
		}
		return minArr;
	}

}
