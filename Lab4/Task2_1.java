package Lab4;

import java.util.Arrays;

public class Task2_1 {
	public static void merge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1; 
        int n2 = r - m; 
        
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 
        
        for (int i = 0; i < n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = arr[m + 1 + j];
        
        int i = 0, j = 0; 
        
        int k = l; 
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) { 
                arr[k] = L[i]; 
                i++; 
            } 
            else { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        }
        
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        }
        
        while (j < n2) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        }
	}
	public static int[] mergeSort(int[] arr, int l, int r) {
        while(l < r) {
            int m = (l + r) / 2;
            
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            
            merge(arr, l, m, r);
        }
        return arr;
    } 
	public static void main(String[] args) {
		int[] arr = {7,3,8,2,10,4,9,6,5,1};
		System.out.println(Arrays.toString(mergeSort(arr, 0, 10)));
	}
}
