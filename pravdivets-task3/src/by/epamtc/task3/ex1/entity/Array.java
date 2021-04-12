package by.epamtc.task3.ex1.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
			// throw new IllegalArrayLengthException("The array length can't be less than 0")
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

	// common array methods

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

	public int searchBinary(int item) {
		if (!isSorted()) {
			// throws NotSortedArrayException("The array is not sorted. Binary search impossible") 
			// пока без реализации
		}

		int idx = -1; // это значение индекса будет выдано, если искомое число не будет найдено
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

	public boolean isSorted() {
		boolean result = true;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				result = false;
			}
		}
		return result;
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
		for (int i = 0; i < array.length; i++) {
			array[i] = DataScanner.enterIntFromConsole();
		}

	}

	//предполагается, что файл содержит числа, разделенные пробелом
	public static Array fillFromFile(String fileName) throws IOException {
		if(fileName == null) {
			//throw new NoFileNameException("No file name")
		}
		
		File file = new File(fileName);

		StringBuilder strTemp = new StringBuilder();
		FileInputStream fileInputStream = new FileInputStream(file);
		try {
			int a;
			while ((a = fileInputStream.read()) != -1) {
				strTemp.append((char) a);
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			fileInputStream.close();
		}
		
		String strTemp2 = strTemp.toString();

		String[] strArr = strTemp2.split(" ");

		int[] intArr = new int[strArr.length];
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = Integer.parseInt(strArr[i]);
		}
		
		Array array = new Array(intArr);
		
		return array;
		
	}

}		

