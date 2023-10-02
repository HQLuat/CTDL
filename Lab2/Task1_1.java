package Lab2;

public class Task1_1 {
	//cau1
	public static int getSn1(int n) {
		if(n == 1) 
			return 1;
		else return (int) (getSn1(n-1) + Math.pow(-1, n+1)*n);
	}
	//cau2
	public static int getSn2Help(int n) {
		if(n == 1)
			return 1;
		else return n * getSn2Help(n-1);
	}
	public static int getSn2(int n) {
		if(n == 1)
			return 1;
		return getSn2Help(n) + getSn2(n-1);
	}
	//cau3
	public static int getSn3(int n) {
		if(n == 1)
			return 1;
		else return (int) (Math.pow(n, 2) + getSn3(n-1));
	}
	//cau4
	public static int getSn4Help(int n) {
		if (n == 0) {
			return 1;
		}
		return getSn4Help(n - 1) * (n * 2);
	}
	public static double getSn4(int n) {
		if (n == 0) {
			return 1;
		}
		return getSn4(n - 1) + (double) 1 / getSn4Help(n);
	}
	public static void main(String[] args) {
		//cau1
		System.out.print("ket qua cau1: ");
		int n1 = 12;
		System.out.println(getSn1(n1));
		System.out.println();
		
		//cau2
		System.out.print("ket qua cau2: ");
		int n2 = 5;
		System.out.println(getSn2(n2));
		System.out.println();
		
		//cau3
		System.out.print("ket qua cau3: ");
		int n3 = 2;
		System.out.println(getSn3(n3));
		System.out.println();
		
		//cau4
		System.out.print("ket qua cau4: ");
		int n4 = 2;
		System.out.println(getSn4(n4));
	}
}
