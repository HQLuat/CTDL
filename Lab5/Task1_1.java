package Lab5;

public class Task1_1 {
	public static void print(int[][] ma) {
		for (int i = 0; i < ma.length; i++) {
			for (int j = 0; j < ma[i].length; j++) {
				System.out.print(ma[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static int[][] add(int[][] a, int[][] b){
		int[][] result = new int[a.length][a[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = a[i][j] + b[i][j];
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[][] a = {{7,2},
					 {5,3}};
		int[][] b = {{2,1},
				 	 {3,1}};
		
		print(add(a,b));
	}
}
