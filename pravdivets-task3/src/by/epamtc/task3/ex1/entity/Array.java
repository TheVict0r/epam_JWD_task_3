package by.epamtc.task3.ex1.entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import by.epamtc.task3.ex1.scanner.DataScanner;

public class Array {

	private int[] array;

	public Array(int[] array) {
		/*
		 * раньше здесь была проверка на null, но Вы сказали, 
		 * что в сущностях проверку не делают, поэтому убрал
		 */
		this.array = array;
	}

	public Array(int length) {
		if (length < 0) {
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

	/*
	 *  common array methods 
	 *  так как сравнение объектов можно организовать и через comparator, 
	 *  оставил сортировку, а также min и max в основном классе
	 */
	
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
			sort1();
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

	/* 
	 * генерируем новый Array т.к. не знаем заранее объём файла
	 * возможно есть смысл реализовать этот метод в виде ещё одного конструктора
	 */
	public static Array fillFromFile(String fileName) throws FileNotFoundException {
		if (fileName == null) {
			// throw new NoFileNameException("No file name")
		}
		File file = new File(fileName);
		List<Integer> list = new ArrayList<>();

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(file);
		int i = 0;
		while (scanner.hasNext()) {
			while (!scanner.hasNextInt()) {
				scanner.next();
			}
			
			
			i = scanner.nextInt();
			list.add(i);
		}
		int[] innerArray = new int[list.size()];
		for (int j = 0; j < innerArray.length; j++) {
			innerArray[j] = list.get(j);
		}

		Array result = new Array(innerArray);
		return result;
	}
	
	
	/*
	 * оставил в Array, т.к. методы заполнения случайными числами можно трансформировать 
	 * в заполнение случайными объектами,
	 * что-то подобное я реализовал в task2 - корзина заполняется случайными мячами
	 */
	public static void fillWithRandom(Array arrayObject) {
		if (arrayObject == null) {
			// throw new NullArrayObjectException("Variable is not initialized") - пока без реализации
		}
		
		int[] array = arrayObject.getArray();
		Random random = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt();
		}
		
	}

	//перегрузил предыдущий метод с возможностью ограничения диапазона случайных чисел
	public static void fillWithRandom(Array arrayObject, int bound) {
		if (arrayObject == null) {
			// throw new NullArrayObjectException("Variable is not initialized") - пока без реализации
		}
		
		int[] array = arrayObject.getArray();
		Random random = new Random();
		
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(bound);
		}
		
	}

	
	
}		

