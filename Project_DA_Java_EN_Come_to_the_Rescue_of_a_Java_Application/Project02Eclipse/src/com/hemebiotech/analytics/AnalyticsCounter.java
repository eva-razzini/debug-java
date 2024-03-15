package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCounts = new TreeMap<>();

        for (String symptom : symptoms) {
            symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
        }

        return symptomCounts;
    }

	public static void main(String args[]) throws Exception {
		String inputFilePath = "./Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt";
        String outputFilePath = "./Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/result.out";
        
        try {
			ISymptomReader symptomReader = new ReadSymptomDataFromFile(inputFilePath);
			List<String> symptoms = symptomReader.GetSymptoms();

			AnalyticsCounter analyticsCounter = new AnalyticsCounter();
            Map<String, Integer> symptomCounts = analyticsCounter.countSymptoms(symptoms);

			ISymptomWriter symptomWriter = new WriteSymptomDataToFile(outputFilePath);
			symptomWriter.writeSymptoms(symptomCounts);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
