import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {
        //Starting appium server
        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\aleji\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        //Starting android driver and capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 6 Pro API 33");
        options.setApp("C:\\Users\\aleji\\IdeaProjects\\AppiumBasics\\src\\test\\Utils\\ApiDemos-debug.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void longPressGesture(WebElement element, int duration) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration", duration
        ));
    }
    public void swipeGesture(WebElement element, String direction) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement)element).getId());
        params.put("direction", direction);
        params.put("percent", "1.0");
        js.executeScript("mobile: swipeGesture", params);
    }

    public static Point getCenterOfElement(WebElement element) {
        Point elementLocation = element.getLocation();
        Dimension elementSize = element.getSize();
        return new Point(elementLocation.x + elementSize.width/2, elementLocation.y + elementSize.height/2);
    }
    public void dragAndDropGesture(WebElement sourceElement, WebElement targetElement) {
        Point centerOfTarget = getCenterOfElement(targetElement);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement)sourceElement).getId());
        params.put("endX", centerOfTarget.x);
        params.put("endY", centerOfTarget.y);
        js.executeScript("mobile: dragGesture", params);
    }
    public void scrollIntoText(String elementText) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"\"))"));
    }

    @AfterClass
    public void EndSession() {
        driver.quit();
        service.stop();
    }
}
