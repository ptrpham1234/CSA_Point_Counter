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
        
        String token = "EAAR621eun4IBALJqUrPXbEICcyckxKwN809dJpN5YlP1cN2lNxedDYbYNANpOW9c4IkEVcwB45cSNJbPTREGLQRZAm6FlgE1FykZCVIz6zdWyaqIrlZANoN9Op59M6OxdCjqEuXnrPW02D2Xi7YWjrye8k97GbSV5YnWaC7bZAXTQuSBs88zbZCoAicGSKRONZBEkJ9gsaZCwnv7JvZCXaaWjJQghBgB5YMZD";

        URL url = new URL("https://graph.facebook.com/v12.0/1095482641223244?fields=feed&access_token=" + token);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
            for (String line; (line = reader.readLine()) != null;) {
                System.out.println(line + "\n");
            }
        }
    }
}