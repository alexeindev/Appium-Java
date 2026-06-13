# Appium Java — Mobile Automation Practice

A practice project for Android mobile test automation using **Appium** with Java and TestNG. Tests run against two real APKs (`ApiDemos-debug` and `General-Store`) on an Android emulator, and cover a range of native gestures and UI interactions.

## Test Scenarios

| Class | What it tests |
|---|---|
| `AppiumBasicsTest` | Navigating preferences, enabling Wi-Fi, asserting dialog title, entering text |
| `LongPress` | Long-pressing a list item and asserting a context menu appears |
| `SwipeGesture` | Swiping through a photo gallery |
| `ScrollDown` | Scrolling via `UiScrollable` and via JavaScript gesture events |
| `DragDrop` | Dragging a dot onto a target and asserting "Dropped!" result |

## Gestures Covered

All gesture helpers live in `BaseTest` and are reused across test classes:

- **Long press** — `mobile: longClickGesture` via `JavascriptExecutor`
- **Swipe** — `mobile: swipeGesture` with direction and percent
- **Drag & drop** — `mobile: dragGesture` targeting element center coordinates
- **Scroll** — `UiScrollable` (UIAutomator2) and `mobile: scrollGesture` (JS loop)

## Tech Stack

| Tool | Version | Role |
|---|---|---|
| Appium Java Client | 9.2.3 | Android driver & gestures |
| TestNG | 7.9.0 | Test runner & assertions |
| UIAutomator2 | — | Android automation engine |
| Java | 11 | Language |
| Maven | — | Build & dependency management |

## Project Structure

```
Appium-Java/
├── src/test/
│   ├── java/
│   │   ├── BaseTest.java          # Driver setup, teardown & shared gesture methods
│   │   ├── AppiumBasicsTest.java  # UI interaction basics
│   │   ├── LongPress.java         # Long press gesture
│   │   ├── SwipeGesture.java      # Swipe gesture
│   │   ├── ScrollDown.java        # Scroll gestures (two approaches)
│   │   └── DragDrop.java          # Drag and drop gesture
│   └── Utils/
│       ├── ApiDemos-debug.apk     # Primary test app
│       └── General-Store.apk      # Secondary test app
└── pom.xml
```

## Prerequisites

- JDK 11+
- Maven
- Node.js + Appium installed globally (`npm install -g appium`)
- Android SDK + `ANDROID_HOME` environment variable set
- Android emulator running (configured as **Pixel 6 Pro API 33** in `BaseTest`)
- UIAutomator2 driver installed (`appium driver install uiautomator2`)

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/alexeindev/Appium-Java.git
   cd Appium-Java
   ```

2. Update the paths in `BaseTest.java` to match your local environment:
   ```java
   // Appium server path
   new File("YOUR_PATH/appium/build/lib/main.js")
   // APK path
   options.setApp("YOUR_PATH/src/test/Utils/ApiDemos-debug.apk");
   ```

3. Start your Android emulator, then run the tests:
   ```bash
   mvn test
   ```

## Example Test

```java
@Test
public void DragDropTest() {
    driver.findElement(AppiumBy.accessibilityId("Views")).click();
    driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
    WebElement dot1 = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
    WebElement dot2 = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
    dragAndDropGesture(dot1, dot2);
    Assert.assertEquals(
        driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText(),
        "Dropped!"
    );
}
```

## Purpose

Practice project for learning Android mobile test automation with Appium — covering element locator strategies (`accessibilityId`, `xpath`, `className`, `id`), native gesture execution, and TestNG-based test structure.

---

> Built with ☕ Java · Appium · TestNG · UIAutomator2
