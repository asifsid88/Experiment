package com.asif.fun.htmlparser;

import com.asif.fun.htmlparser.parser.HTMLParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by mhussaa on 4/21/17.
 */
public class ParserMain {
    public static void main(String[] args) throws Exception {
        System.out.println("This is the start of the application");

        FileReader fileReader = new FileReader(new File("/Users/mhussaa/Asif/Experiment/src/main/java/com/asif/fun/htmlparser/sample1.txt"));

        BufferedReader br = new BufferedReader(fileReader);

        String html;

        while((html = br.readLine()) != null) {
            System.out.println(html);
            System.out.println("--- Parser Output");

            HTMLParser parser = new HTMLParser();
            parser.parse(0, html, 0);
            System.out.println("-----------------");
        }

        System.out.println("Terminated.. !!");
    }
}
