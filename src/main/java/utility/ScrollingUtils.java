package utility;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import com.google.common.collect.ImmutableMap;

public class ScrollingUtils {

    public static void scrollDown(AndroidDriver driver) {

                int screenHeight = driver.manage().window().getSize().height;
                int screenWidth = driver.manage().window().getSize().width;

                // Define the scroll area
                int left = 0; // Left edge of the screen
                int top = (int) (screenHeight * 0.2); // Start from 20% of the screen height
                int width = screenWidth; // Full screen width
                int height = (int) (screenHeight * 0.6); // Use 60% of the screen height for scrolling

                // Perform the scroll gesture
                ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                        "left", left,
                        "top", top,
                        "width", width,
                        "height", height,
                        "direction", "down",
                        "percent", 0.80 // Scroll by 75% of the defined height
                ));
            }
}
