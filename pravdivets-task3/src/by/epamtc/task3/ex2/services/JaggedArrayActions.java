package by.epamtc.task3.ex2.services;

public class JaggedArrayActions {

	/*
	 * делает пустую копию исходного массива, shift - добавляет/убирает столбцы
	 */
	public static int[][] makeEmptyCopy(int[][] original, int shift){
		int[][] copy = new int[original.length][];
		for(int i = 0; i < original.length; i++) {
			copy[i] = new int[original[i].length + shift];
		}
		return copy;
	}
	

	public static int[][] addFirstEmptyColumn(int[][] jagArr) {
		int[][] widerArr = makeEmptyCopy(jagArr, 1);//каждая строка на 1 ячейку длиннее 
		//копируем исходные данные с отступом на 1 столбец (остается пустым)
		for(int i = 0; i < jagArr.length; i++) {
			for(int j = 0; j < jagArr[i].length; j++) {
				widerArr[i][j+1] = jagArr[i][j];
			}
		}
		return widerArr;
	}

	public static int[][] cutFirstColumn(int[][] widerArr){
		int[][] shortArr = makeEmptyCopy(widerArr, -1);//каждая строка на 1 ячейку короче
		//копируем исходные данные начиная со второго столбца (т.е. удаляем его)
		for(int i = 0; i < shortArr.length; i++) {
			for(int j = 0; j < shortArr[i].length; j++) {
				shortArr[i][j] = widerArr[i][j+1];
			}
		}
		return shortArr;
	}
	
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
	
	
	
}
