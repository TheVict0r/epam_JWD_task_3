package by.epamtc.task3.ex2.services;

public class JaggedArrayActions {

	public static int[][] sortBySum(int[][] jagArr, boolean reverse) {
		if (jagArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[][] withSum = defineRowSum(jagArr);
		int[][] sorted = sortByFirstColumn(withSum, reverse);
		int[][] result = deleteFirstColumn(sorted); //специально не стал добавлять в предыдущий метод - single responsibility
		
		return result;
	}

	public static int[][] sortByMax(int[][] jagArr, boolean reverse) {
		if (jagArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[][] withMax = defineRowMax(jagArr);
		int[][] sorted = sortByFirstColumn(withMax, reverse);
		int[][] result = deleteFirstColumn(sorted);
		
		return result;
	}

	public static int[][] sortByMin(int[][] jagArr, boolean reverse) {
		if (jagArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[][] withMin = defineRowMin(jagArr);
		int[][] sorted = sortByFirstColumn(withMin, reverse);
		int[][] result = deleteFirstColumn(sorted);
		
		return result;
	}

	/*
	 * добавляет первую пустую ячейку в каждую строку, 
	 * в ней рассчитывается СУММА по этой строке
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
	 * добавляет первую пустую ячейку в каждую строку, 
	 * в ней рассчитывается МАКСИМАЛЬНОЕ значение по этой строке
	 */
	public static int[][] defineRowMax(int[][] jagArr) {
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
	 * добавляет первую пустую ячейку в каждую строку, 
	 * в ней рассчитывается  МИНИМАЛЬНОЕ значение по этой строке
	 */
	public static int[][] defineRowMin(int[][] jagArr) {
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

	
	
	
	public static int[][] sortByFirstColumn(int[][] wideArr, boolean reverse) {
		if (wideArr == null) {
			// throw new NullArrayException("Jagged array variable equals to null")
			// пока что не реализовано
		}
		int[] firstCol = exportFirstColumn(wideArr);
		int[] sortedFirstCol = bubbleSort(firstCol);
				if (reverse) {
					sortedFirstCol = reverse(sortedFirstCol);
				}

		int[][] sortedArr = makeEmptyCopy(wideArr, 0);

		for (int i = 0; i < sortedArr.length; i++) { // перебираем финальный массив - туда сортируем
			for (int j = 0; j < sortedFirstCol.length; j++) { // перебираем отсортированный первый столбец 
				for (int k = 0; k < wideArr.length; k++) {// перебираем исходный неотсортированный массив 
					if (wideArr[k][0] == sortedFirstCol[j]) {
						sortedArr[j] = wideArr[k];
					}
				}
			}
		}

		return sortedArr;
	}


	

	public static int[][] makeEmptyCopy(int[][] original, int shift) { //shift - добавляет/убирает столбцы
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


}
