package Lab8;

import java.io.IOException;

public class TestTextAnalyzer {
	public static void main(String[] args) throws IOException {
		TextAnalyzer ta = new TextAnalyzer();
		
		System.out.print("displayWords: ");
		ta.displayWords();
		
		System.out.println();
		System.out.println("mostFrequentWord: " + ta.mostFrequentWord());
		
		System.out.println();
		System.out.println("displayText: ");
		ta.displayText();
	}
}
