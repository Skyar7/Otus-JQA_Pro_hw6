import com.google.inject.Inject;
import extensions.AndroidExtension;
import modules.GuicePagesModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.GreetingPage;
import pages.SettingsPage;

@ExtendWith(AndroidExtension.class)
public class SettingsTest {

  @Inject
  GreetingPage greetingPage = new GuicePagesModule().getWelcomePage();

  @Inject
  SettingsPage settingsPage = new GuicePagesModule().getSettingsPage();

  @Test
  @DisplayName("Вывод полей в настройках")
  public void settingsChecking() {
    greetingPage.greetingPass()
            .selectStatsPage()
            .clickSettings();

    settingsPage.checkFields();
  }
}