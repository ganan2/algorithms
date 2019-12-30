package com.java.reader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class WordReaderFromFile {

	private static final Logger log = Logger.getLogger(WordReaderFromFile.class.getName());

	public static void printLines(String cmd, InputStream ins) throws Exception {
		String line = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(ins));
		while ((line = in.readLine()) != null) {
			log.info(cmd + " " + line);
		}
	}

	public static void runProcess(String command) throws Exception {
		Process pro = Runtime.getRuntime().exec(command);
		WordReaderFromFile.printLines(command + " stdout:", pro.getInputStream());
		WordReaderFromFile.printLines(command + " stderr:", pro.getErrorStream());
		pro.waitFor();
		log.info(command + " exitValue() " + pro.exitValue());
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Compiling...");
		WordReaderFromFile.runProcess("javac com/java/reader/WriterFromFile.java");
		System.out.println("Performing word count reading the file...");
		WordReaderFromFile.runProcess("java -cp bin com/java/reader/WriterFromFile message.txt");
	}
}