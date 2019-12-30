package com.java.writer;

import java.io.PrintWriter;
import java.util.logging.Logger;

public class WordWriterFromUser {

	private static final Logger log = Logger.getLogger(WordWriterFromUser.class.getName());

	public static void main(String[] args) throws Exception {
		String text = "Hey there, how is it going?";
		System.out.println("Printing to file: " + text);
		try (PrintWriter out = new PrintWriter("message.txt")) {
			out.println(text);
		}
	}
}