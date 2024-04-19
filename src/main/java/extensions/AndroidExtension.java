package extensions;

import com.codeborne.selenide.Configuration;
import com.google.inject.Guice;
import modules.GuiceComponentsModule;
import modules.GuicePagesModule;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import providers.AndroidWebDriverProvider;


public class AndroidExtension implements BeforeAllCallback {

  @Override
  public void beforeAll(ExtensionContext extensionContext) {

    Guice.createInjector(new GuicePagesModule(), new GuiceComponentsModule());

    Configuration.browserSize = null;
    Configuration.remote = System.getProperty("remote.url");
    Configuration.browser = AndroidWebDriverProvider.class.getName();
  }
}
