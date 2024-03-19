package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * The AnalyticsCounter class provides methods for counting the occurrences of symptoms
 * and writing the results to an output file.
 */
public class AnalyticsCounter {
	 /**
     * Counts the occurrences of each symptom in the given list.
     *
     * @param symptoms A list of symptoms.
     * @return A map containing each unique symptom as key and its occurrence count as value.
     */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCounts = new TreeMap<>();

        for (String symptom : symptoms) {
            symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
        }

        return symptomCounts;
    }
    /**
     * The main entry point of the application.
     *
     * @throws Exception If an error occurs while reading or writing symptom data.
     */
	public static void main(String args[]) throws Exception {
		// Input and output file paths
		String inputFilePath = "./Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt";
        String outputFilePath = "./Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/result.out";
        
        try {
			// Read symptoms from the input file
			ISymptomReader symptomReader = new ReadSymptomDataFromFile(inputFilePath);
			List<String> symptoms = symptomReader.GetSymptoms();

			// Count occurrences of each symptom
			AnalyticsCounter analyticsCounter = new AnalyticsCounter();
            Map<String, Integer> symptomCounts = analyticsCounter.countSymptoms(symptoms);

			// Write symptom counts to the output file
			ISymptomWriter symptomWriter = new WriteSymptomDataToFile(outputFilePath);
			symptomWriter.writeSymptoms(symptomCounts);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
