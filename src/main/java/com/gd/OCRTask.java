package com.gd;

import java.nio.file.Path;
import java.util.concurrent.Callable;

public class OCRTask extends Callable<PPIResult> {

    private Integer pageNumber;
    private Path fileName;

    public OCRTask(Integer pageNumber, Path fileName) {
        this.pageNumber = pageNumber;
        this.fileName = fileName;
    }

    @Override
    public PPIResult call() throws Exception {
        return null;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public Path getFileName() {
        return fileName;
    }
}
