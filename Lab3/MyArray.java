package Lab3;

public class MyArray {
	private int[] array;
	
	public MyArray(int[] array) {
		this.array = array;
	}
	
	//IterativeLinearSearch method
	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if(array[i] == target)
				return i;
		}
		return -1;
	}
	
	//RecursiveLinearSearch method
	public int recursiveLinearSearchHelp(int target, int pos) {
		if(pos == array.length)
			return -1;
		else if(array[pos] == target)
			return pos;
		else
			return recursiveLinearSearchHelp(target, ++pos);
	}
	public int recursiveLinearSearch(int target) {
		int pos = 0;
		return recursiveLinearSearchHelp(target, pos);
	}
	
	//isAscending
	public boolean isAscending(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if(arr[i+1] < arr[i])
				return false;
		}
		return true;
	}
	
	//iterativeBinarySearch method
	public int iterativeBinarySearch(int target) {
		if(isAscending(array)) {
			int low = 0;
			int high = array.length - 1;
			while(low <= high) {
				int mid = (low + high) / 2;
				if(target == array[mid])
					return mid;
				else if(target < array[mid])
					high = mid - 1;
				else
					low = mid + 1;
			}
			return -1;
		}else {
			int low = 0;
			int high = array.length - 1;
			while(low <= high) {
				int mid = (low + high) / 2;
				if(target == array[mid])
					return mid;
				else if(target < array[mid])
					low = mid - 1;
				else
					high = mid + 1;
			}
			return -1;
		}
	}
	
	//recursiveBinarySearch method
	public int recursiveBinarySearchHelp(int target, int low, int high) {
		if(isAscending(array)) {
			if(low > high)
				return -1;
			else {
				int mid = (low + high) / 2;
				if(target == array[mid])
					return mid;
				else if(target < array[mid])
					return recursiveBinarySearchHelp(target, low, mid - 1);
				else
					return recursiveBinarySearchHelp(target, mid + 1, high);
			}
		}else {
			if(low > high)
				return -1;
			else {
				int mid = (low + high) / 2;
				if(target == array[mid])
					return mid;
				else if(target < array[mid])
					return recursiveBinarySearchHelp(target, mid + 1, high);
				else
					return recursiveBinarySearchHelp(target, low, mid - 1);
			}
		}
	}
	public int recursiveBinarySearch(int target) {
			int low = 0;
			int high = array.length - 1;
			return recursiveBinarySearchHelp(target, low, high);
	}
	
	public static void main(String[] args) {
		//Testing for iterativeLinearSearch method
		int[] arr1 = {12, 10, 9, 45, 2, 10, 10, 45};
		MyArray ma1 = new MyArray(arr1);
		System.out.println("position: " + ma1.iterativeLinearSearch(45));
		
		//Testing for recursiveLinearSearch method
		MyArray ma2 = new MyArray(arr1);
		System.out.println("position: " + ma2.recursiveLinearSearch(15));
		System.out.println();
		
		//Testing for iterativeBinarySearch method
		int[] arr3 = {2,9,10,12,45};
		int[] arr4 = {45,12,10,9,2};
		MyArray ma3 = new MyArray(arr3);
		MyArray ma4 = new MyArray(arr4);
		System.out.println("position(Ascending): " + ma3.recursiveLinearSearch(2));
		System.out.println("position(Descending): " + ma4.recursiveLinearSearch(2));
		System.out.println();
		
		//Tesing for recursiveBinarySearch method
		MyArray ma5 = new MyArray(arr3);
		MyArray ma6 = new MyArray(arr4);
		System.out.println("position(Ascending): " + ma5.recursiveLinearSearch(9));
		System.out.println("position(Descending): " + ma6.recursiveLinearSearch(9));
	}
}
