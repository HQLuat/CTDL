package Lab4;

import java.util.Arrays;

public class Task1_1 {
	public static void swap(int[] a, int i, int j) {
		int index = a[i];
		a[i] = a[j];
		a[j] = index;
	}
	public static int[] selectionSort_Min(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int currentMinimum = i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j] < arr[currentMinimum]) {
					currentMinimum = j;
				}
			}
			swap(arr, i, currentMinimum);
			
		}
		return arr;
	}
	public static void main(String[] args) {
		int[] arr = {7,3,8,2,10,4,9,6,5,1};
		System.out.println(Arrays.toString(selectionSort_Min(arr)));
	}
}
