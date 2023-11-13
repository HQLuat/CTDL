package Lab8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class TextAnalyzer {
	public static final String fileName = "data/short.txt";
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	public TextAnalyzer() throws IOException {
		load(fileName);
	}

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		int index = 1;
		while (true) {
			line = reader.readLine();

			if (line == null)
				break;
			StringTokenizer tokens = new StringTokenizer(line, " ");

			while (tokens.hasMoreTokens()) {
				String tmp = tokens.nextToken();
				if (!tokens.hasMoreTokens()) {
					add(tmp, -index);
				} else {
					add(tmp, index);
				}
				index++;
			}
		}
		reader.close();
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		ArrayList<Integer> list = new ArrayList<>();
		if (!map.containsKey(word)) {
			list.add(position);
		} else {
			list = map.get(word);
			list.add(position);
		}
		map.put(word, list);
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		Map<String, ArrayList<Integer>> result = new TreeMap<String, ArrayList<Integer>>(new Comparator<String>() {
			public int compare(String str1, String str2) {
				return str1.compareToIgnoreCase(str2);
			}
		});
		result.putAll(map);
		System.out.println(result);
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		int wordsTotal = 0;
		for (ArrayList<Integer> list : map.values()) {
			wordsTotal += list.size();
		}
		
		int index = 1;
		while(true) {
			for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
				String word = entry.getKey();
				ArrayList<Integer> val = entry.getValue();
				if(val.contains(index)) {
					System.out.print(word + " ");
					index++;
				}
				if(val.contains(-index)) {
					System.out.println(word);
					index++;
				}
			}
			if(index == wordsTotal) {
				break;
			}
		}
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		int max = 0;
		for (ArrayList<Integer> list : map.values()) {
			if (list.size() > max)
				max = list.size();
		}
		
		String result = "";
		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			String word = entry.getKey();
			ArrayList<Integer> list = entry.getValue();
			if (list.size() == max)
				result += word + " ";
		}
		return result;
	}
}
