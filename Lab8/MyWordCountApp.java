package Lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();
	
	public MyWordCountApp() throws FileNotFoundException {
		loadData();
	}
	// Load data from fileName into the above map (containing <word, its occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));

		while (input.hasNext()) {
			String word = input.next();
			if(map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			}else {
				map.put(word, 1);
			}
		}
		System.out.println(map);
	}

	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countDistinct() {
		int result = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			Integer val = entry.getValue();
			if(val == 1) {
				result++;
			}
		}
		return result;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			if(val == 1)
				result.put(key, val);
		}
		System.out.println(result);
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		Map<String, Integer> result = new TreeMap<String, Integer>(new Comparator<String>() {
			public int compare(String str1, String str2) {
				return str1.compareToIgnoreCase(str2);
			}
		});
		result.putAll(map);
		System.out.println(result);
	}
}
