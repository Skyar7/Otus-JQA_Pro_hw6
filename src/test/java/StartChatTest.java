import com.google.inject.Inject;
import extensions.AndroidExtension;
import modules.GuicePagesModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.GreetingPage;

@ExtendWith(AndroidExtension.class)
public class StartChatTest {

  @Inject
  GreetingPage greetingPage = new GuicePagesModule().getWelcomePage();

  @Test
  @DisplayName("Проверка первого ответа от чат-бота")
  public void chatChecking() {
    greetingPage.greetingPass()
            .sendMessage("Hey!")
            .checkChatbotResponse("I will speak English now. I hope it’s okay, we learn English here after all");
  }
}