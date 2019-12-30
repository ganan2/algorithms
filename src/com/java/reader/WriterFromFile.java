package com.java.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeMap;
import java.util.logging.Logger;

public class WriterFromFile {
	
	private static final Logger log = Logger.getLogger(WriterFromFile.class.getName());
	
	public static void main(String[] args) throws Exception {
		WordCountUtils utils = new WordCountUtils();
		BufferedReader bufferedReader = null;
		bufferedReader = new BufferedReader(new FileReader(args[0]));
		TreeMap<String, Integer> map = utils.getWordCountMap(bufferedReader);
		log.info(map.toString());
	}
}