package pl.kurs.task2.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.ZoneId;

public class YearKeyExtractor implements FileReportKeyExtractor<Integer> {
    @Override
    public Integer extractKey(File file) {
        int year;
        try {
            BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            LocalDate localDate = LocalDate.ofInstant(attributes.creationTime().toInstant(), ZoneId.systemDefault());
            year = localDate.getYear();
        } catch (IOException e) {
            System.err.println("Błąd podczas czytania pliku " + file.getName());
            return null;
        }
        return year;
    }
}
