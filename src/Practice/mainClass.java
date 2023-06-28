package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.List;

public class mainClass {

        public static void main(String[] args) throws IOException {
            WebDriver driver = new ChromeDriver();
            String newUrl = "https://www.hamropatro.com/";
            driver.get(newUrl);

            List<WebElement> anchorTags = driver.findElements(By.xpath("//a"));
            exceloutput excelOutput = new exceloutput();

            for (WebElement anchor : anchorTags) {
                String link = anchor.getAttribute("href");

                if (link != null && !link.isEmpty() && !link.startsWith("javascript:") && link.contains("https://www.hamropatro.com/") && !link.contains("/date") && !link.contains("/calendar")) {
                    httpConnection.checkLink(newUrl, link, excelOutput);
                } else {
                    System.out.println("The URL is empty or has 'javascript' as a protocol");
                }
            }



            excelOutput.saveToFile("C:\\Users\\LENOVO\\Desktop\\hamro_patro\\Report of hamro patro link working.xlsx");

            driver.quit();

        }
    }




