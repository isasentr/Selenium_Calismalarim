package Gun_07;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _07_ActionContextClick extends BaseStaticDriver {

    public static void main(String[] args) {
        driver.get("https://demoqa.com/buttons");

        WebElement element= driver.findElement(By.id("rightClickBtn"));
        Bekle(2);

        Actions aksiyonlar=new Actions(driver);

        Action aksiyon=aksiyonlar.moveToElement(element).contextClick().build();

        aksiyon.perform();

        Bekle(6);
        BekleKapat();
    }
}
