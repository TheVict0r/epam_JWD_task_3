package by.epamtc.task3.ex1.entity;

import java.io.File;
import java.util.Arrays;

public class Array {

	private int[] array;
	
	public Array() {
		
	}
	
	public Array (int[] array) {
		if (array == null) {
			// throws NullArrayException - пока без реализации
		}
		this.array = array;
	}
	
	public Array (int length) {
		array = new int [length];
	}

	public int[] getArray() {
		if (array == null) {
		// throws NullArrayException - пока без реализации
		}
		return array;
	}

	public void setArray(int[] array) {
		if (array == null) {
			// throws NullArrayException - пока без реализации
		}
		this.array = array;
	}

	
	public void sort1() { // bubble sort
		for(int i = 0; i < array.length - 1; i++) {
			boolean noSwaps = true;
			for(int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					noSwaps = false;
				}
			}
			if(noSwaps) {
				break;
			}
		}
		
	}

	
	public void sort2() { // selection sort
		for(int i = 0; i < array.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < array.length; j++) {
				if(array[j] < array[minIdx]) {
					minIdx = j;
				}
			}
			
			int tmp = array[minIdx];
			array[minIdx] = array[i];
			array[i] = tmp;
		}
		
	}

	
	public void sort3() { // Shell sort
		int gap = array.length / 2;
		while(gap >= 1) {
			for(int i = 0; i < array.length; i++) {
				for (int j = i - gap; j >= 0; j -= gap) {
					if (array[j] > array[j + gap]) {
						int tmp = array[j];
						array[j] = array[j + gap];
						array[j + gap] = tmp;
				}
			}
		}
		gap /= 2;
		}	
	}

	
	public int searchBinary(int item) {
		this.sort1(); // this для наглядности
		int idx = -1; // это значение индекса и будет выдано, если искомое число не будет найдено
		int low = 0;
		int high = array.length;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] < item) {
				low = mid + 1;
			} else if (array[mid] > item) {
				high = mid - 1;
			} else if (array[mid] == item) {
				idx = mid;
				break;
			}
		}
		return idx;
	}

	
	public int defineMax() {
		int max = array[0];
		
		for(int i = 1; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	
	public int defineMin() {
		int min = array[0];
		
		for(int i = 1; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

	
	public int[] fillFromConsole(Array arrayObject) {
		if (arrayObject == null) {
			// throws NullArrayObjectException - пока без реализации
		}
		int[] array = arrayObject.getArray();
		
		return null;
	}

	
	public int[] fillFromFile(Array arrayObject, File file) {
		if (arrayObject == null) {
			// throws NullArrayObjectException - пока без реализации
		}
		int[] array = arrayObject.getArray();
		
		
		return null;
	}

	
	
	@Override
	public int hashCode() {
		if (array == null) {
			return 0;
		}
		
		int result = 1;
        for (int element : array) {
            result = 42 * result + element;
        }
        return result;
	}

	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Array other = (Array) obj;
		int [] otherInnerArray = other.getArray();
		if (array.length != otherInnerArray.length)
			return false;
		for(int i = 0; i < array.length; i++) {
			if(array[i] != otherInnerArray[i])
			return false;	
		}
		return true;
	}

	@Override
	public String toString() {
		    if (array.length == 0)
	            return "[]";
	        StringBuilder b = new StringBuilder();
	        b.append(getClass().getSimpleName());
	        b.append(" [");
	        for (int i = 0; i < array.length; i++) {
	        	b.append(array[i]);
	            b.append(", ");
	        }
	      b.deleteCharAt(b.lastIndexOf(", "));
	      b.append(']'); 
	     
	     return b.toString();
	}
	
	
	
	
}
