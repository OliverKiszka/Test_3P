package pl.kurs.task1.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;


public class FileMetadataService {

    public static List<File> findJavaFiles(File dir) throws IOException {

        if (!dir.isDirectory()) {
            throw new IOException("Podana ścieżka nie wskazuje na folder" + dir.getAbsolutePath());
        }
        List<File> filesList = new ArrayList<>();
        File[] files = dir.listFiles();
        if (files == null) {
            throw new IOException("Nie ma dostępu do tego folderu");
        }
        for (File file : files) {
            if (file.isDirectory()) {
                filesList.addAll(findJavaFiles(file));
            } else if (file.getName().endsWith(".java")) {
                filesList.add(file);
            }
        }
        return filesList;
    }

    public static void printWeekDaysOfJavaFilesCreation(List<File> filesList) {
        int[] weekDaysCounters = new int[7];

        for (File file : filesList) {
            DayOfWeek dayOfWeek = getDayOfWeekFromFile(file);
            if (dayOfWeek != null) {
                weekDaysCounters[dayOfWeek.getValue() - 1]++;
            }
        }
        DayOfWeek[] dayOfWeekNames = DayOfWeek.values();
        for (int i = 0; i < dayOfWeekNames.length; i++) {
            System.out.println(dayOfWeekNames[i] + " -> " + weekDaysCounters[i]);
        }
    }

    private static DayOfWeek getDayOfWeekFromFile(File file) {
        DayOfWeek day = null;
        try {
            BasicFileAttributes attributes = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);
            LocalDate localDate = LocalDate.ofInstant(attributes.creationTime().toInstant(), ZoneId.systemDefault());
            day = localDate.getDayOfWeek();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return day;
    }
}
