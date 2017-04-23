package com.asif.fun;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

/**
 * Created by mhussaa on 3/12/17.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("I am loaded..");

        /**
        HttpResponse<String> response = Unirest.get("https://www.nseindia.com/content/historical/EQUITIES/2016/JAN/cm08JAN2016bhav.csv.zip")
                            .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11")

        // .queryString("h_filetype", "eqbhav")
                   // .queryString("date", "08-01-2008")
                   // .queryString("section", "EQ")
                    .asString();


        System.out.println(response.getBody());

        Unirest.shutdown();

         open /Applications/Google\ Chrome.app --args --enable-speech-input


         */

        // String[] cmd = {"/usr/bin/open", "-a", "Chrome.app", "/Users/michaelcook/Desktop/Playout"};

        String cmd = "/usr/bin/open -a Terminal /path/to/the/executable";
        Runtime.getRuntime().exec(cmd);

        //Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome http://goo.gl/EsomR0"});


        System.out.println("Downloaded all the links");
    }
}
