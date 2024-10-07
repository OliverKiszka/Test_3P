package pl.kurs.task2.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

public class MonthKeyExtractor implements FileReportKeyExtractor<Month> {
    @Override
    public Month extractKey(File file) {
        Month month;
        try {
            BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            LocalDate localDate = LocalDate.ofInstant(attributes.creationTime().toInstant(), ZoneId.systemDefault());
            month = localDate.getMonth();
        } catch (IOException e) {
            System.err.println("Błąd podczas czytania danych pliku " + file.getName());
            return null;
        }
        return month;
    }
}
