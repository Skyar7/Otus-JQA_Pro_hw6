package providers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidWebDriverProvider implements WebDriverProvider {


  @Nonnull
  @Override
  public WebDriver createDriver(@Nonnull Capabilities capabilities) {

    UiAutomator2Options options = new UiAutomator2Options();
    options.merge(capabilities);

    options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);

    options.setDeviceName(System.getProperty("device.name"));
    options.setPlatformName(System.getProperty("platform.name"));
    options.setPlatformVersion(System.getProperty("platform.version"));
    options.setApp("/Andy.apk");

    try {
      return new AndroidDriver(new URL(Configuration.remote), options);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }
}
