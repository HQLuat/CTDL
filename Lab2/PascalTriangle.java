package Lab2;

public class PascalTriangle {
	public static void printPascalTriangle(int row) {
		for (int i = 1; i <= row; i++) {
			int[] result = getPascalTriangle(i);
			for (int j = 0; j < result.length; j++) {
				System.out.print(result[j] + " ");
			}
			System.out.println();
		}
	}
	public static int[] getPascalTriangle(int n) {
		if(n==1)
			return new int[] {1};
		else {
			int[] prevRow = getPascalTriangle(n-1);
			return generateNextRow(prevRow);
		}
	}
	public static int[] generateNextRow(int[] prevRow) {
		int[] result = new int[prevRow.length + 1];
		result[0] = 1;
		result[prevRow.length] = 1;
		for (int i = 1; i < result.length - 1; i++) {
			result[i] = prevRow[i-1] + prevRow[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int row =5;
		printPascalTriangle(row);
	}
}
