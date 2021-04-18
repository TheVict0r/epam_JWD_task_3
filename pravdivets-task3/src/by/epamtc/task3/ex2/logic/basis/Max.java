package by.epamtc.task3.ex2.logic.basis;

public class Max implements SortingBasis{

	@Override
	public int sortBy(int[] array) {
		if(array == null) {
			//throw new NullArrayException("Variable is not initialized");
			//пока не реализовано
		}
		int max = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

}
