/*****************************************************************************************************************
 * Project:             CSA_Point_Counter
 * Author:              Peter Pham
 * Date Started:        09/28/2021
 * Compiler:            java
 * IDE:                 IntelliJ
 *
 * Description:
 * The aim of this program is to grab member's posts using Facebook API and count the number of people tagged in the
 * post and give the appropriate amount of points.
 *****************************************************************************************************************/
/*****************************************************************************************************************
 * File:                Main.java
 * Author:              Peter Pham (pxp180041)
 * Date Started:        09/06/2021
 *
 * Description:
 *
 * Changelog:
 * 
 *
 * TODO: found out the requirements so you can hard code the magic square
 *****************************************************************************************************************/
package com.company;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {
        
        FileWriter file = new FileWriter("graphGrab.txt");

        String token = "EAAR621eun4IBADZBZAzi10kktbgSHDEE4zkJS57wkdYxALZBNuQSLMdYXfiXNLPklbhg0nFP2H88unw8ZCXBq1lYhZBXLygb8nZCwnJOfZAfarTZCnJcBbZC5GtvbXtfM1EaDdEILVZAVbyh8scyz3R2cSWFdZBnyUvoeQbkfuXqUezLnaMFVzfuDQZC1rAK2mKtXi4P3g6ve5ubNmsULUqGgCxZAq283f5DHy7QZD",
               groupID = "1095482641223244";

        URL url = new URL("https://graph.facebook.com/v12.0/" + groupID + "?fields=feed&access_token=" + token);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
            for (String line; (line = reader.readLine()) != null;) {
                System.out.println(line);
                System.out.println();
                file.write(line);
            }
        }
        
        file.close();
    }
}