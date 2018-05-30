package com.hwp.ocr;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        Ocr ocr = new Ocr();
        try {
            ocr.recognizeText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
