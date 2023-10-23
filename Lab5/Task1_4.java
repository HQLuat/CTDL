package Lab5;

public class Task1_4 {
	public static void print(int[][] ma) {
		for (int i = 0; i < ma.length; i++) {
			for (int j = 0; j < ma[i].length; j++) {
				System.out.print(ma[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static int[][] transpose(int[][] a){
		int[][] result = new int[a[0].length][a.length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = a[j][i];
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[][] a = {{1,2},
				 	 {3,4},
					 {5,6}};
		int[][] b = {{1,3,5}, 
					 {2,4,6}}; 
	
		print(transpose(a));
		System.out.println();
		print(transpose(b));
	}
}
