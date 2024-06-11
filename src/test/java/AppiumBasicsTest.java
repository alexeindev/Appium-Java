import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumBasicsTest extends BaseTest {
    @Test
    public void WifiSettingsName() {
        //Activate Wifi
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        //Using Xpath
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        //Using id
        driver.findElement(By.id("android:id/checkbox")).click();

        //Wi-fi Settings
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title']")).click();

        //Wi-fi Password
        driver.findElements(AppiumBy.className("android.widget.RelativeLayout")).get(1).click();
            //Assert that the title is correct
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("WifiPass");

        //Click on OK using ClassName
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
    }
}