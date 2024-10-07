package pl.kurs.task2.service;

import java.io.File;

public interface FileReportKeyExtractor<T> {
    T extractKey(File file);
}
