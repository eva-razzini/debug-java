package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String inputFilePath;
	
	/**
	 * 
	 * @param inputFilePath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String inputFilePath) {
		this.inputFilePath = inputFilePath;
	}
	
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (inputFilePath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(inputFilePath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				System.err.println("Error reading symptoms from file: " + inputFilePath);
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
