package by.epamtc.task3.ex2.logic.basis;

public class Min implements SortingBasis{

	@Override
	public int sortBy(int[] array) {
		if(array == null) {
			//throw new NullArrayException("Variable is not initialized");
			//пока не реализовано
		}
		int min = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

}
