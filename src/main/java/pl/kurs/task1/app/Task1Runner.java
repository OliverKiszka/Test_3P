package pl.kurs.task1.app;

import pl.kurs.task1.service.FileMetadataService;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Task1Runner {
    public static void main(String[] args) throws IOException {
        //wynik moich plików .java
        /*
        MONDAY -> 46
        TUESDAY -> 32
        WEDNESDAY -> 147
        THURSDAY -> 796
        FRIDAY -> 28
        SATURDAY -> 75
        SUNDAY -> 49
        */
        String pathname = "C:\\Users\\ASRock\\IdeaProjects";

        List<File> myJavaFiles = FileMetadataService.findJavaFiles(new File(pathname));


        FileMetadataService.printWeekDaysOfJavaFilesCreation(myJavaFiles);

    }


}
