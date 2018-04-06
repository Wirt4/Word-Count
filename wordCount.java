/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */


import acm.program.*;
import acm.util.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class wordCount extends ConsoleProgram {
	String file = "gettysburgAddress";
	String filepath = file+".txt";
	public void run() {
		int lines =0;
		int words =0;
		int chars =0;
		ArrayList<String> doc = makeArray(file);
		for(int i=0; i<doc.size();i++) {
			String docLine = doc.get(i);
			for(int j=0; j<docLine.length();j++) {
				if(Character.isLetterOrDigit(docLine.charAt(j))==true) {
					chars++;
				}
				if(j!=0 && Character.isLetterOrDigit(docLine.charAt(j))==false && Character.isLetterOrDigit(docLine.charAt(j-1))==true) {
					words++;
				}
			}
			lines ++;
		}
		println("file: "+file);
		println("");
		println("lines = "+lines);
		println("words = "+words);
		println("characters = "+chars);
	} 
	private ArrayList<String> makeArray(String fileName) {
		ArrayList<String> lex = new ArrayList<String>();
		String line="";
		try{
			BufferedReader rd =new BufferedReader(new FileReader(filepath));
			while (true) {
			line=rd.readLine();
			if(line==null) {
				break;
			}
			lex.add(line);
		}
		rd.close();
		}catch(IOException ex) {
			lex.add("YOUTHREWANEXEPTION");
		}
	return lex;
	}
}
