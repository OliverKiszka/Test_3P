package pl.kurs.task2.service;

import java.io.File;

public class ExtensionKeyExtractor implements FileReportKeyExtractor<String> {
    private static final String NO_EXTENSION = "BRAK ROZSZERZENIA";

    @Override
    public String extractKey(File file) {
        String fileName = file.getName();
        int idx = fileName.lastIndexOf(".");

        if (idx > 0 && idx < fileName.length() - 1) {
            return fileName.substring(idx + 1).toLowerCase();
        } else {
            return NO_EXTENSION;
        }
    }
}
