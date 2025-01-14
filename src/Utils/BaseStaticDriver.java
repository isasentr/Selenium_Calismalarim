package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;

import java.util.logging.Logger;
import java.time.Duration;

public class BaseStaticDriver {

    public static WebDriver driver;

    public static WebDriverWait wait;

 static{

     KalanOncekileriKapat();
     Logger logger = Logger.getLogger("");
     logger.setLevel(Level.SEVERE);


     // burada public static void yazlı idi, bu metodu kullanırken yazmadan direk kullanmak için public ve void sildik. En başta olduğu için bu şkeilde kullanabildik.
     System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");  // run daki ilk 3 satırı gizliyor.

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
      //  driver.manage().window().maximize(); //max
        driver.manage().deleteAllCookies();

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

//     Duration dr= Duration.ofSeconds(30);
     driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); //sadece ana sayfa yüklenirken eb başta
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //bütün webelement için geçerli
    }

    public static void BekleKapat() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    public static void Bekle(int saniye) {

        try {
            Thread.sleep(saniye * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void KalanOncekileriKapat() {

        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {

        }
    }
    }