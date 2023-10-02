package Lab2;

public class Task1_4 {
	public static void moveTower(int disk, char src, char desk, char spare) {
		if (disk == 1) {
			System.out.println(src + " --> " + spare);
		} else {
          moveTower(disk-1, src, spare, desk);
          moveTower(1, src, desk, spare);
          moveTower(disk-1, desk, src, spare);
         
		}
	}
	public static void main(String[] args) {
		// test moveTowerHN
		moveTower(3, 'A', 'B', 'C');
	}
}
