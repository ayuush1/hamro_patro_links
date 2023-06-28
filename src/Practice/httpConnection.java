package Practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class httpConnection {



        public static void checkLink(String newUrl, String link, exceloutput excelOutput) {
            try {
                URL baseUrl = new URL(newUrl);
                URL concatenatedURL = new URL(baseUrl, link);

                System.out.println(concatenatedURL);

                HttpURLConnection connection = (HttpURLConnection) concatenatedURL.openConnection();
                connection.setRequestMethod("HEAD");
                int responseCode = connection.getResponseCode();

                if (responseCode >= 400) {
                    System.out.println("Broken link with response status of " + responseCode);
                    excelOutput.addLink(concatenatedURL.toString(), responseCode, "The link is broken with the status code of " + responseCode);
                } else {
                    System.out.println("The system is working with status code of " + responseCode);
                    excelOutput.addLink(concatenatedURL.toString(), responseCode, "The link is working with the status code of " + responseCode);
                }
            } catch (IOException e) {
                System.out.println("The system has an error: " + e);
            }
        }
    }


