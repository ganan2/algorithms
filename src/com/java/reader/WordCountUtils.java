package com.java.reader;

import java.io.BufferedReader;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordCountUtils {
	
	private static final Logger log = Logger.getLogger(WordCountUtils.class.getName());
	
	public TreeMap<String, Integer> getWordCountMap(BufferedReader bufferedReader) throws Exception{
		String inputLine = null;
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		try {
			while ((inputLine = bufferedReader.readLine()) != null) {
				String[] words = inputLine.split("[ \n\t\r.,;:!?(){}]");
				for (int count = 0; count < words.length; count++) {
					String key = words[count].toLowerCase();
					if (key.length() > 0) {
						if (map.get(key) == null) {
							map.put(key, 1);
						} else {
							int value = map.get(key).intValue();
							value++;
							map.put(key, value);
						}
					}
				}
			}
		} catch (Exception error) {
			log.info("Invalid File");
			log.setLevel(Level.SEVERE);
		} finally {
			bufferedReader.close();
		}
		return map;
	}
}
