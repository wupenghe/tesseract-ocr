package com.hwp.ocr;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ocr {
    protected transient final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String LANG_OPTION = "-l";
    private final String EOL = System.getProperty("line.separator");

    public String recognizeText() throws Exception {
        Process process = Runtime.getRuntime().exec("tesseract /2.png output");
        InputStream fis = process.getInputStream();
        ByteArrayInputStream bais = (ByteArrayInputStream) fis;
        String str = bais.toString();
        return str;
        // File outputFile = new File("/", "output");
        // StringBuffer strB = new StringBuffer();
        //
        // List<String> cmd = new ArrayList<String>();
        // cmd.add("tesseract");
        // cmd.add("");
        // cmd.add(outputFile.getName());
        // cmd.add(LANG_OPTION);
        // cmd.add("eng");
        //
        // ProcessBuilder pb = new ProcessBuilder();
        // pb.directory(imageFile.getParentFile());
        //
        // cmd.set(1, "/2.png");
        // pb.command(cmd);
        // pb.redirectErrorStream(true);
        // Process process = pb.start();
        //
        // int w = process.waitFor();
        // logger.debug("Exit value = {}", w);
        //
        // if (w == 0) {
        // BufferedReader in = new BufferedReader(new InputStreamReader(
        // new FileInputStream(outputFile.getAbsolutePath() + ".txt"), "UTF-8"));
        //
        // String str;
        //
        // while ((str = in.readLine()) != null) {
        // strB.append(str).append(EOL);
        // }
        // in.close();
        // } else {
        // String msg;
        // switch (w) {
        // case 1:
        // msg = "Errors accessing files. There may be spaces in your image's filename.";
        // break;
        // case 29:
        // msg = "Cannot recognize the image or its selected region.";
        // break;
        // case 31:
        // msg = "Unsupported image format.";
        // break;
        // default:
        // msg = "Errors occurred.";
        // }
        // throw new RuntimeException(msg);
        // }
        //
        // new File(outputFile.getAbsolutePath() + ".txt").delete();
        // logger.info("图像识别结果:{}", strB);
        // return strB.toString();
    }
}
