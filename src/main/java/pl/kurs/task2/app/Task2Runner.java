package pl.kurs.task2.app;

import pl.kurs.task2.service.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Task2Runner {
    public static void main(String[] args) throws IOException {
        String pathname = "C:\\Users\\ASRock\\IdeaProjects";

        List<File> myFiles = FileDataExtractionService.findAllFiles(new File(pathname));

        System.out.println("------------------------");
        System.out.println("Raport miesiącowy:");
        FileDataExtractionService.generateReport(myFiles, new MonthKeyExtractor());
        System.out.println("------------------------");
        System.out.println("Raport rokowy:");
        FileDataExtractionService.generateReport(myFiles, new YearKeyExtractor());
        System.out.println("------------------------");
        System.out.println("Raport rozszerzeniowy:");
        FileDataExtractionService.generateReport(myFiles, new ExtensionKeyExtractor());
        System.out.println("------------------------");
        System.out.println("Raport wielkościowy plików:");
        FileDataExtractionService.generateReport(myFiles, new SizeKeyExtractor());
        System.out.println("------------------------");


        System.out.println("------------------------");
    }
}
