import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
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


        //Wifi Settings
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title']")).click();
    }
}