package extensions;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Guice;
import modules.GuiceComponentsModule;
import modules.GuicePagesModule;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import providers.AndroidWebDriverProvider;

public class AndroidExtension implements BeforeAllCallback, AfterAllCallback {

  @Override
  public void beforeAll(ExtensionContext extensionContext) {

    Guice.createInjector(new GuicePagesModule(), new GuiceComponentsModule());
    Configuration.browserSize = null;
    Configuration.browser = AndroidWebDriverProvider.class.getName();
    Configuration.timeout = 200000L;
    Configuration.remoteReadTimeout = 200000L;
    Configuration.reportsFolder = "allure-results";
  }

  @Override
  public void afterAll(ExtensionContext extensionContext) {
    allureEnvironmentWriter(
            ImmutableMap.<String, String>builder()
                    .put("DEVICE_NAME", System.getProperty("device.name"))
                    .put("PLATFORM_NAME", System.getProperty("platform.name"))
                    .put("REMOTE_URL", System.getProperty("remote.url"))
                    .build(), System.getProperty("user.dir")
                    + "/allure-results/");

    Selenide.closeWebDriver();
  }
}