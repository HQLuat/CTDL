package Lab5;

public class Task1_3 {
	public static void print(int[][] ma) {
		for (int i = 0; i < ma.length; i++) {
			for (int j = 0; j < ma[i].length; j++) {
				System.out.print(ma[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static int[][] multiply(int[][] a, int[][] b){
		int[][] result = new int[a.length][b[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = 0;
				for (int j2 = 0; j2 < a[0].length; j2++) {
					result[i][j] += a[i][j2] * b[j2][j];
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[][] a = {{1,2,3,4},
				 	 {1,2,3,4}};
		int[][] b = {{1,2,3},
			 	 	 {1,2,3},
					 {1,2,3},
					 {1,2,3}};
	
		print(multiply(a,b));
	}
}
