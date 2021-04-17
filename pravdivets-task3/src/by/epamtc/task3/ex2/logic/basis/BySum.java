package by.epamtc.task3.ex2.logic.basis;

public class BySum implements SortingBasis{

	@Override
	public int sortBy(int[] array) {
		int sum = 0;
		
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		
		return sum;
	}

}
