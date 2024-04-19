import com.google.inject.Inject;
import components.ChatWindowComponent;
import extensions.AndroidExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.ChatPage;
import pages.MainPage;
import providers.AndroidWebDriverProvider;

@ExtendWith(AndroidExtension.class)
public class MainWidget_Test {

  @Inject
  private MainPage mainPage;

  @Inject
  private ChatWindowComponent chatWindowComponent;

  @Test
  public void navigationMainPageWidget() {

//    mainPage = new MainPage();
    mainPage.open()
            .clickNextButton()
            .clickChatButton();

    chatWindowComponent.getComponentEntity().click();
  }
}
