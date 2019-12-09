package com.gd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    private static final String IMAGE_FILE_LOCATION = "C:\\Users\\KiNG\\Documents\\work_ms\\Final\\4c\\java_test\\buildings";
    private static final String IMAGE_FILE_TYPE = ".png";
    private static final String IMAGE_FILE_NAME_SEPARATOR = "_";
    public static void main(String[] args) throws IOException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<OCRTask> ocrTasks = new ArrayList<>();
        List<Future<PPIResult>> ocrResultFutures = new ArrayList<>();

        Files.walk(Paths.get(IMAGE_FILE_LOCATION),1)
                .filter(Files::isRegularFile)
                .filter(path->path.getFileName().toString().endsWith(IMAGE_FILE_TYPE))
                .forEachOrdered(path-> {
                    ocrTasks.add(new OCRTask(getPageNumber(path.getFileName().toString()), path));
                        }
                );

        ocrResultFutures = executorService.invokeAll(ocrTasks);


            ocrResultFutures.stream().map(fut -> {
               try {
                    return fut.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
               return null;
            }).collect(Collectors.toList()).stream().sorted().forEachOrdered(WriteExcel);



    }


    private static int getPageNumber(String fileName) {
        return Integer.parseInt(fileName.substring(fileName.indexOf(IMAGE_FILE_NAME_SEPARATOR)+1, fileName.indexOf(IMAGE_FILE_TYPE)));
    }


}
