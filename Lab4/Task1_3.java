package Lab4;

import java.util.Arrays;

public class Task1_3 {
	public static void swap(int[] arr, int j) {
		 int index = arr[j];
         arr[j] = arr[j-1];
         arr[j-1] = index;
	}
	public static int[] insertionSort(int[] arr) {
		for(int i=0; i < arr.length; i++){
	        int j = i;
	        while(j > 0 && arr[j-1] > arr[j]){
	        	swap(arr, j);
	        	j--;
	        }
	      }
		return arr;
	}
	public static void main(String[] args) {
		int[] arr = {7,3,8,2,10,4,9,6,5,1};
		System.out.println(Arrays.toString(insertionSort(arr)));
	}
}
