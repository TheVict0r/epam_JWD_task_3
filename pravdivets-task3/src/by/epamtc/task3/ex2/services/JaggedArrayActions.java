package by.epamtc.task3.ex2.services;

public class JaggedArrayActions {

	public static int[][] sortIncreasingRowsSum(int[][] jagArr){
		int[][] wideSummed = defineRowSum(jagArr);
		int[] firstCol = exportFirstColumn(wideSummed);
		int[] sortFirstCol = bubbleSort(firstCol);
		int[][] wideSummedSoreted = sortWithGuideLine(wideSummed, sortFirstCol);
		int[][] result = deleteFirstColumn(wideSummedSoreted);
		
		return result;
	}
	
	public static int[][] sortDecreasingRowsSum(int[][] jagArr){
		int[][] wideSummed = defineRowSum(jagArr);
		int[] firstCol = exportFirstColumn(wideSummed);
		int[] sortFirstCol = bubbleSort(firstCol);
		int[] sortDecrFirstCol = reverse(sortFirstCol);
		int[][] wideSummedSoreted = sortWithGuideLine(wideSummed, sortDecrFirstCol);
		int[][] result = deleteFirstColumn(wideSummedSoreted);
		
		return result;
	}
	
	
	
	
	/*
	 * делает пустую копию исходного массива, 
	 * параметр shift - добавляет/убирает столбцы
	 */
	public static int[][] makeEmptyCopy(int[][] original, int shift){
		int[][] copy = new int[original.length][];
		for(int i = 0; i < original.length; i++) {
			copy[i] = new int[original[i].length + shift];
		}
		return copy;
	}
	
	/*
	 * копирует исходные данные в новый массив с отступом в 1 столбец 
	 * (т.е. первый столбец остается пустым)
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
	 * обычная "пузырьковая" сортировка одномерного массива
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

	
	public static int[] reverse(int[] array) {
		int[] reversed = new int[array.length];
		for(int i = 0; i < reversed.length; i++) {
			reversed[i] = array[array.length - i -1];
		}
		return reversed;
	}
	
	/*
	 * создает новый массив равный исходному, но без первого столбца
	 * (т.е. удаляет первый столбец)
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
	 * сортирует двумерный массив(1) в соответствии с одномерным массивом(2), 
	 * который соотвествует первому столбцу (1)
	 * метод создает новый двумерный массив 
	 * в который копирует строки из (1) в порядке, определенном в (2)
	 */
	public static int[][] sortWithGuideLine(int[][] widerArr, int[] guideArr){
		if(widerArr.length != guideArr.length) {
			//throw new ArrayLengthInconsistencyException("Arrays have different length") 
			// пока что не реализовано
		}
		int[][] sorted = makeEmptyCopy(widerArr, 0);
		for(int i = 0; i < sorted.length; i++) { //перебираем финальный массив i - актуальная строка
			for(int j = 0; j < guideArr.length; j++) { //перебираем отсортированный одномерный массив j - актуально значение
				for(int k = 0; k < widerArr.length; k++) {//перебираем исходный массив k - актуальная строка
					if(widerArr[k][0] == guideArr[j]) {
						sorted[j] = widerArr[k];
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
