package by.epamtc.task3.ex2.services;

public class JaggedArrayActions {

	public static int[][] addFirstEmptyColumn(int[][] jagArr) {
		//делаем пустую копию исходного массива - каждая строка на 1 длиннее 
		int[][] widerArr = new int[jagArr.length][];
		for (int i = 0; i < jagArr.length; i++) {
			widerArr[i] = new int[jagArr[i].length + 1];
		}

		//копируем исходные данные с отступом на 1 столбец (он - пустой)
		for(int i = 0; i < jagArr.length; i++) {
			for(int j = 0; j < jagArr[i].length; j++) {
				widerArr[i][j+1] = jagArr[i][j];
			}
		}
		
		return widerArr;
	}

	public static int[][] cutFirstColumn(int[][] widerArr){
		//делаем пустую копию исходного массива - каждая строка на 1 короче
		int[][] shortArr = new int[widerArr.length][];
		for (int i = 0; i < widerArr.length; i++) {
			shortArr[i] = new int[widerArr[i].length - 1];
		}
		//копируем исходные данные начиная со второго столбца (т.е. удаляем его)
		for(int i = 0; i < shortArr.length; i++) {
			for(int j = 0; j < shortArr[i].length; j++) {
				shortArr[i][j] = widerArr[i][j+1];
			}
		}
		
		return shortArr;
	}
	
	
	public static int[][] defineRowSum(int[][] widerArr){
		int[][] sumArr = null;
		
		
		
		
		
		return sumArr;
	}
	
	
	
}
