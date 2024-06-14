import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDrop extends BaseTest{
    @Test
    public void DragDropTest () {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement dot1 = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement dot2 = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
        dragAndDropGesture(dot1, dot2);
        String dragResultText = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(dragResultText, "Dropped!");
    }
}
