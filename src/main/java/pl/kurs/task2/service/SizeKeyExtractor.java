package pl.kurs.task2.service;

import java.io.File;

public class SizeKeyExtractor implements FileReportKeyExtractor<String> {
    @Override
    public String extractKey(File file) {
        try {
            long size = file.length();
            if (size < 1024) {
                return "Mlutka waga (<1KB)";
            } else if (size < 1024 * 1024) {
                return "Srednia waga (1KB-1MB)";
            } else {
                return "Duża waga (>1MB)";
            }
        } catch (SecurityException e) {
            System.err.println("Brak dostępu do pliku: " + file.getName());
            return "";
        }

    }
}
