package Lab4;

import java.util.Arrays;
import java.util.Random;

public class Task2_2 {
	public static void quickSort(int[] a) {
		if (a.length <= 1) {
			return;
		}
		quickSortRandom(a, 0, a.length - 1);
	}

	private static void quickSortRandom(int[] a, int l, int r) {
		if (l < r) {
			int pivotIndex = getPivotRandom(l, r);
			int k = partition(a, l, r, pivotIndex);
			quickSortRandom(a, l, k - 1);
			quickSortRandom(a, k + 1, r);
		}
	}

	public static int getPivotRandom(int l, int r) {
		Random rand = new Random();
		return rand.nextInt(r - l + 1) + l;
	}

	private static int partition(int[] a, int l, int r, int pivotIndex) {
		int pivotValue = a[pivotIndex];
		
		int temp = a[r];
		a[r] = a[pivotIndex];
		a[pivotIndex] = temp;

		int i = l - 1;
		for (int j = l; j < r; j++) {
			if (a[j] <= pivotValue) {
				i++;
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		
		temp = a[i + 1];
		a[i + 1] = a[r];
		a[r] = temp;
		return i + 1;
	}

	public static void main(String[] args) {
		int[] a = { 6, 7, 8, 1, 5, 2, 3, 4 };
		quickSort(a);
		System.out.println(Arrays.toString(a));
	}
}
