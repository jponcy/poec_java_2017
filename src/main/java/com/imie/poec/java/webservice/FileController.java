package com.imie.poec.java.webservice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {
    private static final String filePath = "/tmp/store_poec_java.txt";

    @RequestMapping("/read")
    public FileValue read() throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return new FileValue(Integer.parseInt(br.readLine())); // Only first line has data.
        } catch (IOException e) {
            return new FileValue(-42);
        }
    }

    @RequestMapping(path="/write", method = RequestMethod.POST)
    public String write(@RequestParam(defaultValue = "42") int value) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("" + value);
            return "Success";
        } catch (IOException e) {
            return "Fail";
        }
    }
}
