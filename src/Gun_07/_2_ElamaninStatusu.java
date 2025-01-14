package Gun_07;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _2_ElamaninStatusu extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");


        WebElement sali = driver.findElement(By.id("gwt-debug-cwCheckBox-Tuesday-input"));

        System.out.println(sali.isDisplayed()); // görünüyor mu
        System.out.println(sali.isEnabled()); // aktif mi
        System.out.println(sali.isSelected()); // seçili mu
        Bekle(2);
        sali.click();
        Bekle(2);
        System.out.println(sali.isSelected());

        BekleKapat();

    }
}
