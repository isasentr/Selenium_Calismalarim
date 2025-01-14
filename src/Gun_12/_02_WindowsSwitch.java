package Gun_12;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class _02_WindowsSwitch extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://www.selenium.dev/");

        String anasayfaWindowId=driver.getWindowHandle(); // bulunduğun sayfanın win id si

        List<WebElement> linkler = driver.findElements(By.cssSelector("a[target='_blank']"));
        for (WebElement link : linkler) {
            if (!link.getAttribute("href").contains("mailto"))
                link.click();
        }

        Set<String> windowsIdler=driver.getWindowHandles();  //açık olan  bütün sayfanın win id si vardır.
        for ( String id: windowsIdler) {
            if(id.equals(anasayfaWindowId))
                continue; //ana sayfa değilse

            driver.switchTo().window(id); //diğer sayfaya (windows geçiş yaptık
            System.out.println(id+"-Title = " + driver.getTitle());
        }

        Bekle(3);
        BekleKapat();
    }
}
