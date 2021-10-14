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
 * 
 * The methods/functions are categorized by order of completion stage. The meaning of the stages are defined below:
 * 
 * Stage 0: Not completed main functionality and still in development. Expect error or unintended outputs or return
 *          values. Needs further improvements.
 *         
 * Stage 1: Completed the main functionality of the method but have not done any debugging. Little to no error catching.
 *          
 * Stage 2: Debugging done for the most part but have not done extensive debugging. Bugs solved include but not limited:
 *              * invalid, too many, or too little inputs
 *              * empty files
 *              * logic errors
 *              * compile errors
 *              * runtime errors
 *          Expect little to no exception handling
 *          
 * Stage 3: Debugging for the listed problems above are done and exception handling is completed
 * 
 * Stage 4: Final stage and most completed stage. No more errors were found and all exception handling and bugs found
 *          in testing are resolved. At this point further improvements include optimization.
 *              
 *****************************************************************************************************************/
/*****************************************************************************************************************
 * File:                Main.java
 * Author:              Peter Pham (pxp180041)
 * Date Started:        09/06/2021
 *
 * Description:
 *
 *****************************************************************************************************************/
package com.company;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        
        String line,
               token = findToken();
        
        String[] splitLine = getMessage(token);
        
        int listStart = findMessageStart(splitLine);

        System.out.println(splitLine[listStart]);
        
        

    }

    /*****************************************************************************************************************
     * Functions:           findToken
     * Author:              Peter Pham (pxp180041)
     * Date Started:        10/14/2021
     * Status:              Stage 1
     *
     * Description:
     * Function used to verify the username and password of the user. Returns a true for correct identification or
     * a false if credentials are incorrect.
     *
     * Parameters:
     *      username        I/P         string      The username that the user has inputted.
     *      password        O/P         string      The password that the user has inputted.
     *****************************************************************************************************************/
    private static String findToken() throws FileNotFoundException {
        
        String token = null;

        Scanner tokenFile = new Scanner(new File("token.txt"));

        if (!tokenFile.hasNext()) {
            System.out.println("Token not available.");;}
        else { token = tokenFile.next();}

        tokenFile.close();
        
        return token;
    }

    /*****************************************************************************************************************
     * Functions:           findToken
     * Author:              Peter Pham (pxp180041)
     * Date Started:        10/14/2021
     * Status:              Stage 1
     *
     * Description:
     * Function used to verify the username and password of the user. Returns a true for correct identification or
     * a false if credentials are incorrect.
     *
     * Parameters:
     *      token           I/P         string      stores the value of the token and 
     *      password        O/P         string      The password that the user has inputted.
     *****************************************************************************************************************/
    private static String[] getMessage(String token) throws IOException {

        String groupID = "1095482641223244",
               line;
        
        String []splitLine = new String[0];

        FileWriter file = new FileWriter("graphGrab.txt");

        URL url = new URL("https://graph.facebook.com/v12.0/" + groupID + "?fields=feed&access_token=" + token);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
            for (; (line = reader.readLine()) != null;) {
                System.out.println(line);
                file.write(line);
                splitLine = line.split("\\t|,|;|\\.|\\?|!|-|:|@|\\[|\\]|\\(|\\)|\\{|\\}|_|\\*|/|\\\\n|\"");
            }
        }
        catch (IOException e) {
            System.out.println("Can't access website. Make sure the token is correct.");
        }

        file.close();
        
        return splitLine;
    }

    /*****************************************************************************************************************
     * Functions:           findToken
     * Author:              Peter Pham (pxp180041)
     * Date Started:        10/14/2021
     * Status:              Stage 1
     *
     * Description:
     * Function used to verify the username and password of the user. Returns a true for correct identification or
     * a false if credentials are incorrect.
     *
     * Parameters:
     *      username        I/P         string      The username that the user has inputted.
     *      password        O/P         string      The password that the user has inputted.
     *      
     * TODO: exception catching for array out of bounds
     *****************************************************************************************************************/
    private static int findMessageStart(String[] splitLine) {
        
        int listStart;
        try {
            for (listStart = 0; splitLine[listStart].compareToIgnoreCase("heads") != 0 && splitLine[listStart].compareToIgnoreCase("kids") != 0 && splitLine[listStart].compareToIgnoreCase("head") != 0 && splitLine[listStart].compareToIgnoreCase("kid") != 0; listStart++) {

            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
        
        return listStart;
    }
    
}