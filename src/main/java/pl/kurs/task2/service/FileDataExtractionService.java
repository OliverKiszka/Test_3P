package pl.kurs.task2.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileDataExtractionService {
    public static List<File> findAllFiles(File dir) throws IOException {

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
                filesList.addAll(findAllFiles(file));
            } else {
                filesList.add(file);
            }
        }
        return filesList;
    }

    public static <T> void generateReport(List<File> fileList, FileReportKeyExtractor<T> keyExtractor) {
        Map<T, Integer> reportMap = new HashMap<>();
        for (File file : fileList) {
            T key = keyExtractor.extractKey(file);
            if (key != null) {
                reportMap.put(key, reportMap.getOrDefault(key, 0) + 1);
            }
        }

        for (Map.Entry<T, Integer> entry : reportMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
