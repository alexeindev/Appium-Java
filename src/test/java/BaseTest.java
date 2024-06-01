import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {
        //Starting appium server
        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\aleji\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("172.26.80.1").usingPort(4723).build();
        service.start();

        //Starting android driver and capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 6 Pro AI 33");
        options.setApp("C:\\Users\\aleji\\IdeaProjects\\AppiumBasics\\src\\test\\Utils\\ApiDemos-debug.apk");
        driver = new AndroidDriver(new URL("http://172.26.80.1:4723"), options);

    }

    @AfterClass
    public void EndSession() {
        driver.quit();
        service.stop();
    }
}
