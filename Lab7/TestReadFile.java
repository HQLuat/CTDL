package Lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class TestReadFile {
	public static void main(String[] args) throws FileNotFoundException {
		// Scanner input = new Scanner(new File("data/hamlet.txt"));
		Scanner input = new Scanner(new File("src/data/fit.txt"));

		while (input.hasNext()) {
			String word = input.next();
			System.out.print(word + " ");
		}
		System.out.println();
		
		MyWordCount mwc = new MyWordCount();
		
		//Testing for getWordCounts method
		System.out.println("getWordCounts: " + mwc.getWordCounts());
		
		//Tesing for getUniqueWords method
		System.out.println("getUniqueWords: " + mwc.getUniqueWords());
		
		//Testing for getDistinctWords method
		System.out.println("getDistinctWords: " + mwc.getDistinctWords());
		
		//Testing for exportWordCounts method
		System.out.println("exportWordCounts: " + mwc.exportWordCounts());
		
		//Testing for exportWordCountsOrderByOccurence method
		System.out.println("exportWordCountsOrderByOccurence: " + mwc.exportWordCountsOrderByOccurence());
		
		//Testing for filterWords method
		System.out.println("filterWords: " + mwc.filterWords("hoc"));
	}
}