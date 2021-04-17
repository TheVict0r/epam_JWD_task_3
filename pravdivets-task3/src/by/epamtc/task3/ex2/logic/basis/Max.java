package by.epamtc.task3.ex2.logic.basis;

public class Max implements SortingBasis{

	@Override
	public int sortBy(int[] array) {
		int max = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

}
