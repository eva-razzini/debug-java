package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads symptom data from a file.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String inputFilePath;
	
    /**
     * Constructs a new ReadSymptomDataFromFile object with the specified input file path.
     *
     * @param inputFilePath The path to the file containing symptom strings, one per line.
     */
	public ReadSymptomDataFromFile (String inputFilePath) {
		this.inputFilePath = inputFilePath;
	}
	 /**
     * Reads symptoms from the input file and returns them as a list.
     *
     * @return A list of symptoms read from the input file.
     */
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
