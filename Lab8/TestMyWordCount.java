package Lab8;

import java.io.FileNotFoundException;

public class TestMyWordCount {
	public static void main(String[] args) throws FileNotFoundException {
		MyWordCountApp mwc = new MyWordCountApp();
		
		System.out.println("countDistinct: " + mwc.countDistinct());
		
		System.out.print("printWordCounts: ");
		mwc.printWordCounts();
		
		System.out.print("printWordCountsAlphabet: ");
		mwc.printWordCountsAlphabet();
	}
}
