package com.hwp.ocr;


public class Test {
    public static void main(String[] args) {
        Ocr ocr = new Ocr();
        try {
            String s = ocr.recognizeText(args[0]);
            System.out.println("result:" + s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
