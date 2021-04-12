package by.epamtc.task3.ex2.services;

public class JaggedArrayActions {

	/*
	 * сортировка в порядке возрастания / убывания сумм элементов строк матрицы
	 */
	public static int[][] sortRowsSum(int[][] jagArr, boolean reverse) {
		if (jagArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[][] withSum = defineRowSum(jagArr);
		int[][] result = transformIntoSorted(withSum, reverse);
		
		return result;
	}

	/*
	 * сортировка в порядке возрастания / убывания максимальных элементов строк матрицы
	 */
	public static int[][] sortMaxElement(int[][] jagArr, boolean reverse) {
		if (jagArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[][] withMax = defineMax(jagArr);
		int[][] result = transformIntoSorted(withMax, reverse);

		return result;
	}

	/*
	 * сортировка в порядке возрастания / убывания минимальных элементов строк матрицы
	 */
	public static int[][] sortMinElement(int[][] jagArr, boolean reverse) {
		if (jagArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[][] withMin = defineMin(jagArr);
		int[][] result = transformIntoSorted(withMin, reverse);

		return result;
	}

	/*
	 * сортирует массив по временной первой колонке с промежуточными расчетами после чего удаляет ее
	 */
	public static int[][] transformIntoSorted(int[][] widerArr, boolean reverse){
		if (widerArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[] firstCol = exportFirstColumn(widerArr); //извлекаем первый столбец
		int[] sortedFirstCol = bubbleSort(firstCol);  //сортируем первый столбец
		if (reverse) {
			sortedFirstCol = reverse(sortedFirstCol);
		}
		int[][] wideSoreted = sortWithGuideLine(widerArr, sortedFirstCol);//сортируем двумерный массив в соответствии с первым столбцом
		int[][] result = deleteFirstColumn(wideSoreted); //удаляем временный первый столбец

		return result;
	}
	
	/*
	 * сортирует двумерный массив по первому столбцу в соответствии с одномерным массивом
	 */
	public static int[][] sortWithGuideLine(int[][] widerArr, int[] guideArr) {
		if (widerArr == null || guideArr == null) {
			// throw new NullArrayException("Array variable equals to null")
			// пока что не реализовано
		}
		if (widerArr.length != guideArr.length) {
			// throw new ArrayLengthInconsistencyException("Arrays have different lengths")
			// пока что не реализовано
		}
		int[][] sorted = makeEmptyCopy(widerArr, 0);
		for (int i = 0; i < sorted.length; i++) { // перебираем финальный массив i - актуальная строка
			for (int j = 0; j < guideArr.length; j++) { // перебираем отсортированный одномерный массив j - актуальное значение
				for (int k = 0; k < widerArr.length; k++) {// перебираем исходный массив k - актуальная строка
					if (widerArr[k][0] == guideArr[j]) {
						sorted[j] = widerArr[k];
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

	public static int[] exportFirstColumn(int[][] widerArr) {
		if (widerArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[] firstColumn = new int[widerArr.length];
		for (int i = 0; i < widerArr.length; i++) {
			firstColumn[i] = widerArr[i][0];
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

	public static int[][] deleteFirstColumn(int[][] widerArr) {
		if (widerArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[][] shortArr = makeEmptyCopy(widerArr, -1);// каждая строка на 1 ячейку короче
		for (int i = 0; i < shortArr.length; i++) {
			for (int j = 0; j < shortArr[i].length; j++) {
				shortArr[i][j] = widerArr[i][j + 1];
			}
		}
		return shortArr;
	}

	/*
	 * добавляет в первую пустую ячейку каждой строки нового массива СУММУ по этой строке
	 */
	public static int[][] defineRowSum(int[][] jagArr) {
		if (jagArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[][] sumArr = addFirstEmptyColumn(jagArr);
		for (int i = 0; i < jagArr.length; i++) {
			int sum = 0;
			for (int j = 0; j < jagArr[i].length; j++) {
				sum += jagArr[i][j];
			}
			sumArr[i][0] = sum;
		}
		return sumArr;
	}

	/*
	 * добавляет в первую пустую ячейку каждой строки нового массива МАКСИМАЛЬНОЕ
	 * значение по этой строке
	 */
	public static int[][] defineMax(int[][] jagArr) {
		if (jagArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[][] maxArr = addFirstEmptyColumn(jagArr);
		for (int i = 0; i < jagArr.length; i++) {
			int max = jagArr[i][0];
			for (int j = 0; j < jagArr[i].length; j++) {
				if (jagArr[i][j] > max) {
					max = jagArr[i][j];
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
	public static int[][] defineMin(int[][] jagArr) {
		if (jagArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[][] minArr = addFirstEmptyColumn(jagArr);
		for (int i = 0; i < jagArr.length; i++) {
			int min = jagArr[i][0];
			for (int j = 0; j < jagArr[i].length; j++) {
				if (jagArr[i][j] < min) {
					min = jagArr[i][j];
				}
			}
			minArr[i][0] = min;
		}
		return minArr;
	}

}
