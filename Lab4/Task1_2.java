package Lab4;

import java.util.Arrays;

public class Task1_2 {
	public static void swap(int[] a, int i) {
		int index = a[i];
		a[i] = a[i+1];
		a[i+1] = index;
	}
	public static int[] bubbleSort(int[] array) {
		for (int k = 0; k < array.length - 1; k++) {
			boolean swapped = true;
			for (int i = 0; i < array.length - 1 - k; i++) {
				if(array[i] > array[i + 1]) {
					swap(array,i);
					swapped = false;
				}
			}
			if(swapped) return array;
		}
		return array;
	}
	public static void main(String[] args) {
		int[] array = {7,3,8,2,10,4,9,6,5,1};
		System.out.println(Arrays.toString(bubbleSort(array)));
	}
}
