package by.epamtc.task3.ex2.logic.basis;

public class ByMin implements SortingBasis{

	@Override
	public int sortBy(int[] array) {
		int min = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

}
