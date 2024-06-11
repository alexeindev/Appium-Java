import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPress extends BaseTest{
    @Test
    public void LongPressGesture() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        WebElement peoplesNames = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"People Names\"]"));
        longPressGesture(peoplesNames, 2000);
        // Using Android ID
        WebElement menuElement = driver.findElement(By.id("android:id/title"));
        //Validate that the menu is showing
        Assert.assertTrue(menuElement.isDisplayed());
        Assert.assertEquals(menuElement.getText(), "Sample menu");
    }
}
