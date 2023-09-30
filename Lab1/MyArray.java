package Lab1;

import java.util.Arrays;

public class MyArray {
	int[] arr;
	public MyArray(int[] arr) {
		this.arr = arr;
	}
	//Mirror
	public int[] mirror() {
		int[] result = new int[arr.length*2];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
			result[result.length-1-i] = arr[i];
		}
		return result;
	}
	//RemoveDuplicates
	public int removeDuplicatesHelp() {
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] == arr[j]) {
					result++;
					break;
				}
			}
		}
		return arr.length - result;
	}
	public int[] removeDuplicates() {
		int[] result = new int[removeDuplicatesHelp()];
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] == arr[j]) {
					arr[j] = 0;
				}
			}
		}
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				result[index++] = arr[i];
			}
		}
		return result;
	}
	//GetMissingValues
	public int[] getMissingValues() {
		int length = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if(arr[i+1] - arr[i] > 1)
				length += arr[i+1] - arr[i] - 1;
		}
		int[] result = new int[length];
		int index = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if(arr[i+1] - arr[i] > 1)
				for (int j = 1; j < (arr[i+1] - arr[i]); j++) {
					result[index++] = arr[i] + 1;
				}
		}
		return result;
	}
	//FillMissingValues
	public int[] fillMissingValues(int k) {
		int[] result = arr.clone();
		int y = 0;
		for (int i = 0; i < arr.length; i++) {
			int index1 = i - ((k + 1) / 2); // cốt lõi
			int index2 = i + ((k + 1) / 2); // cốt lõi
			if (arr[0] == -1 && i == 0) {
				for (int a = 1; a <= k; a++) {
					y += arr[a];
				}
				result[0] = y / k;
			}
			if (arr[i] == -1 && i == arr.length - 1) {
				for (int b = arr.length - 1; b >= arr.length - 1 - k; b--) {
					y += arr[b];
				}
				result[arr.length - 1] = y / k;
			}
			if (arr[i] == -1 && arr[0] != -1 && arr[arr.length - 1] != -1) {
				if (k % 2 == 0) {
					for (int j = index1; j <= index2; j++) {
						if (arr[j] != -1) {
							y += arr[j];
						}
					}
				} else {
					if (arr[index1] < arr[index2]) {
						for (int z = index1; z < index2; z++) {
							if (arr[z] != -1) {
								y += arr[z];
							}
						}
					}
					if (arr[index1] > arr[index2]) {
						for (int z = index2; z > index1; z--) {
							if (arr[z] != -1) {
								y += arr[z];
							}
						}
					}
				}
				result[i] = y / k;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		//Testing for mirror method
		System.out.println("Result of the mirror method: ");
		int[] arr1 = {1,2,3};
		MyArray ma1 = new MyArray(arr1);
		System.out.println(Arrays.toString(ma1.mirror()));
		System.out.println();
		
		//Testing for removeDuplicates
		System.out.println("Result of the removeDuplicates method: ");
		int[] arr2 = {1,3,5,1,3,7,9,8};
//		int[] arr2 = {1,3,3,3,3,3,5,6,6,6,6};
		MyArray ma2 = new MyArray(arr2);
		System.out.println(Arrays.toString(ma2.removeDuplicates()));
		System.out.println();
		
		//Testing for getMissingValues
		System.out.println("Result of the getMissingValues method: ");
		int[] arr3 = {10,11,12,13,14,16,17,19,20};
		MyArray ma3 = new MyArray(arr3);
		System.out.println(Arrays.toString(ma3.getMissingValues()));
		System.out.println();
		
		//Testing for fillMissingValues
		System.out.println("Result of the fillMissingValues method: ");
		int[] arr4 = {10,11,12,-1,14,10,17,19,20};
		MyArray ma4 = new MyArray(arr4);
		System.out.println(Arrays.toString(ma4.fillMissingValues(3)));
	}
}
