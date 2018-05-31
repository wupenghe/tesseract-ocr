package com.hwp.ocr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ocr {
    protected transient final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String recognizeText(String fileName) throws Exception {
        //使用processbulid方法
        List<String> command = new ArrayList<>();
        command.add("tesseract");
        command.add(MessageFormat.format("/{0}.png", fileName));
        command.add("output");
        ProcessBuilder pb = new ProcessBuilder();
        pb.directory(new File("/app/"));
        pb.command(command);
        pb.redirectErrorStream(true);
        Process process = pb.start();
        //使用runtime方法
        // Process process = Runtime.getRuntime()
        // .exec(MessageFormat.format("tesseract /{0}.png output", fileName));
        process.waitFor();
        
        File file = new File("/app/output.txt");
        StringBuffer sb = new StringBuffer();
        FileInputStream fis = new FileInputStream(file);
        InputStream is = fis;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        while (null != (line = br.readLine())) {
            sb.append(line);
        }
        br.close();
        return sb.toString().trim();
    }
}
