//
//package Practice;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.io.IOException;
//import java.util.List;
//import java.io.FileOutputStream;
//
//
//public class Dayone {
//
//    public static void main(String[] args) throws IOException {
//
//        //Initiate the web driver
//        WebDriver driver=new ChromeDriver();
//
//        String newUrl = "https://www.hamropatro.com/";
//
//        //select the url to be done operation in
//        driver.get(newUrl);
//
//
//        //List the elements denoted by the xpath
//        List<WebElement> anchorTags = driver.findElements(By.xpath("//a"));
//
//        // Create a new workbook and sheet
//        Workbook workbook = new XSSFWorkbook();
//
//        //create sheet inside of the workbook
//        Sheet sheet = workbook.createSheet("Links");
//
//        //select the row to be started from
//        int rowNumber = 0;
//
//
//
//        //Looping through the elements to perform operation
//        for (WebElement anchor : anchorTags) {
//
//            //get the href attribute
//            String link = anchor.getAttribute("href");
//
//            if (link != null && !link.isEmpty() && !link.startsWith("javascript:") && link.contains("https://www.hamropatro.com/") && !link.contains("/date") && !link.contains("/calendar")) {
//
//
//                //Converting the srirng into url
//                URL baseUrl = new URL(newUrl);
//
//                //concatenate two url... to do that base url should be in url format other should be in string
//                URL concatenatedURL = new URL(baseUrl, link);
//
//                System.out.println(concatenatedURL);
//
//                //Create the http connection
//                HttpURLConnection connection;
//
//
//                try {
//                    //open connection
//                    connection = (HttpURLConnection) concatenatedURL.openConnection();
//
//                    //Return the header
//                    connection.setRequestMethod("HEAD");
//
//                    //Get response code
//                    int responseCode = connection.getResponseCode();
//
//                    //create row and cell
//                    Row row = sheet.createRow(rowNumber++);
//                    Cell urlCell = row.createCell(0);
//                    Cell statusCell = row.createCell(1);
//                    Cell description = row.createCell(2);
//
//
//                    //set value
//                    urlCell.setCellValue(concatenatedURL.toString());
//                    statusCell.setCellValue(responseCode);
//
//                    if (responseCode >= 400) {
//                        System.out.println("broken link with response status of " + responseCode);
//                        description.setCellValue("the link is broken with the status code of " + responseCode);
//
//                    } else {
//                        System.out.println("the system is working with status code of " + responseCode);
//                        description.setCellValue("the link is working with the status code of " + responseCode);
//
//                    }
//
//                } catch (IOException e) {
//                    System.out.println("the system has error" + e);
//                }
//
//                // Save the workbook
//                FileOutputStream outputFile = new FileOutputStream("C:\\Users\\LENOVO\\Desktop\\hamro_patro\\Report of hamro patro link  working.xlsx");
//                workbook.write(outputFile);
//                outputFile.close();
//            }
//            else{
//                System.out.println("the URL is empty or is having javascript as a protocol");
//            }
//
//        }
//
//        driver.quit();
//    }
//}
//
//
//
//
