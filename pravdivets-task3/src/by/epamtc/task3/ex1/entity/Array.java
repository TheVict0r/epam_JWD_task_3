package by.epamtc.task3.ex1.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import by.epamtc.task3.ex1.scanner.DataScanner;

public class Array {

	private int[] array;

	public Array(int[] array) {
		if (array == null) {
			// throws NullArrayException("The array equals to null") - пока без реализации
		}
		this.array = array;
	}

	public Array(int length) {
		if (length < 0) {
			// throw new IllegalArrayLengthException("The array length can't be less than
			// 0")
			// пока без реализации
		}

		array = new int[length];
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public void sort1() { // bubble sort
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

	}

	public void sort2() { // selection sort
		for (int i = 0; i < array.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIdx]) {
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
		while (gap >= 1) {
			for (int i = 0; i < array.length; i++) {
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

	public boolean isSorted() {
		boolean result = true;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				result = false;
			}
		}
		return result;
	}

	public int searchBinary(int item) {
		if (!isSorted()) {
			// throws NotSortedArrayException("The array is not sorted. Binary search
			// impossible") - пока без реализации
		}

		int idx = -1; // это значение индекса и будет выдано, если искомое число не будет найдено
		int low = 0;
		int high = array.length;

		while (low <= high) {
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
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	public int defineMin() {
		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

	public void fillFromConsole() {
		for(int i = 0; i < array.length; i++) {
			array[i] = DataScanner.enterIntFromConsole();
		}
		
	}

	public void fillFromFile(String fileName) throws IOException {

		FileInputStream fileInputStream = new FileInputStream(fileName);

		Scanner scanner = new Scanner(fileInputStream);
		
			while (scanner.hasNext()) {
				int i = scanner.nextInt();
				System.out.print(i + " ");
			}
			fileInputStream.close();
		}
		

		
//		
//		@SuppressWarnings("resource")
//		Scanner scanner = new Scanner(fileInputStream);
//		while (scanner.hasNext()) {
//			for (int i = 0; i < array.length; i++) {
//				while (!scanner.hasNextInt()) {
//					scanner.next();
//				}
//				array[i] = scanner.nextInt();
//			}
//		}
//		fileInputStream.close();

	
	
	
	

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
		int[] otherInnerArray = other.getArray();
		if (array.length != otherInnerArray.length)
			return false;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != otherInnerArray[i])
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
