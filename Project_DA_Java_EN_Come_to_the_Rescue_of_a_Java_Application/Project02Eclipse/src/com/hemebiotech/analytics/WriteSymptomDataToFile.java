package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{
    
    private final String outputPath;

    public WriteSymptomDataToFile(String outputPath) {
        this.outputPath = outputPath;
    }

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
