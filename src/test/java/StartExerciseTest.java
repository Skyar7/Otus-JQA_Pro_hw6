import com.google.inject.Inject;
import extensions.AndroidExtension;
import modules.GuicePagesModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.GreetingPage;

@ExtendWith(AndroidExtension.class)
public class StartExerciseTest {

  @Inject
  GreetingPage greetingPage = new GuicePagesModule().getWelcomePage();

  @Test
  @DisplayName("Проверка старта Упражнений")
  public void exercisePageChecking() {
    greetingPage.greetingPass()
            .selectExercisePage()
            .isPresent("Learn 5 new words today")
            .clickStart()
            .sendMessage("Lets GO");
  }
}