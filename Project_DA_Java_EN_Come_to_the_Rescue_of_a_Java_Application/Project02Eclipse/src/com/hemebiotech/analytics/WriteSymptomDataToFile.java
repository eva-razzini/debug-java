package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
/**
 * Writes symptom data to a file.
 */
public class WriteSymptomDataToFile implements ISymptomWriter{
    
    private final String outputPath;
    /**
     * Constructs a new WriteSymptomDataToFile object with the specified output file path.
     *
     * @param outputPath The path to the file where symptom data will be written.
     */
    public WriteSymptomDataToFile(String outputPath) {
        this.outputPath = outputPath;
    }
    /**
     * Writes the given symptoms and their occurrences to the output file.
     *
     * @param symptoms A map containing symptoms as keys and their occurrences as values.
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms){
        try (FileWriter writer = new FileWriter(outputPath)) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing symptoms to file: " + outputPath);
            e.printStackTrace();
        }
    }
}