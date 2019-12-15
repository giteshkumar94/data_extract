package com.example.demo.opencvtest;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.photo.Photo;

public class Denoising {
    static {
     //   nu.pattern.OpenCV.loadLibrary();
        nu.pattern.OpenCV.loadShared();
        System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to OpenCV " + Core.VERSION);
        Mat src = Imgcodecs.imread("C:\\Users\\KiNG\\Pictures\\noised.jpg", Imgcodecs.CV_IMWRITE_PAM_FORMAT_BLACKANDWHITE);
        Mat dest = src.clone();
      //  Photo.fastNlMeansDenoising(src,dest,10,10,7,21);
        Photo.fastNlMeansDenoising(src,dest,(float)5, 7,21);

        Imgcodecs.imwrite("C:\\Users\\KiNG\\Pictures\\noised_denoised3.jpg", dest);
        System.out.println("Done2");
    }
    
    
    /*
     <dependency>
            <groupId>org.openpnp</groupId>
            <artifactId>opencv</artifactId>
            <version>3.4.2-1</version>
        </dependency>
    
    */
    
    // https://docs.opencv.org/java/3.0.0/
    // https://opencv-python-tutroals.readthedocs.io/en/latest/py_tutorials/py_photo/py_non_local_means/py_non_local_means.html
}
