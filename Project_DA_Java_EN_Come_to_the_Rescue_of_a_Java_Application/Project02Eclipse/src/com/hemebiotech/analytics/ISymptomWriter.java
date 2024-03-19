package com.hemebiotech.analytics;

import java.util.Map;
/**
 * The ISymptomWriter interface defines a contract for classes that write symptom data to a source.
 */
public interface ISymptomWriter {
    /**
     * Writes the given symptoms and their occurrences to a source.
     *
     * @param symptoms A map containing symptoms as keys and their occurrences as values.
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
