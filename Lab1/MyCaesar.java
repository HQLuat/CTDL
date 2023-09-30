package Lab1;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 
											'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
											'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;
	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}
	//EncryptChar
	public char encryptChar(char c) {
		int x = 0;
		for (int i = 0; i < ALPHABET.length; i++) {
			if(c == ALPHABET[i]) {
				x = i;
			}
		}
		char result = ALPHABET[(x + n) % 26];
		return result;
		
	}
	//Encrypt
	public String encrypt(String input) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == ' ') {
				result += " ";
			}else {
				result += encryptChar(input.charAt(i));
			}
		}
		return result;
	}
	public char decryptChar(char c) {
		int x = 0;
		char result = ' ';
		for (int i = 0; i < ALPHABET.length; i++) {
			if(c == ALPHABET[i]) {
				x = i;
			}
		}
		if(x - n < 0) {
			result = ALPHABET[26 - (-1*(x - n)) % 26];
		}else {
			result = ALPHABET[(x - n) % 26];
		}
		return result;
	}
	public String decrypt(String input) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == ' ') {
				result += " ";
			}else {
				result += decryptChar(input.charAt(i));
			}
		}
		return result;
	}
	public static void main(String[] args) {
		MyCaesar char1 = new MyCaesar(2);
		String str1 = "ABC";
		
		//Testing for encryptChar method
		System.out.print("encryptChar: ");
		System.out.println(char1.encryptChar('Z'));
		
		//Testing for decryptChar method
		System.out.print("decryptChar: ");
		System.out.println(char1.decryptChar(char1.encryptChar('Z')));
		System.out.println();
		
		//Testing for encrypt method
		System.out.print("encrypt: ");
		System.out.println(char1.encrypt(str1));
		
		//Testing for decrypt method
		System.out.print("decrypt: ");
		System.out.println(char1.decrypt(char1.encrypt(str1)));
	}
}
