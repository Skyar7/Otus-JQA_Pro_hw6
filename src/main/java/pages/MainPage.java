package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.google.inject.Inject;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends AbsBasePage<MainPage> {

  @Inject
  private ChatPage chatPage;

  private SelenideElement nextButton = $("[text='next']");

  public MainPage clickNextButton() {
    nextButton.should(Condition.visible).click();

    return this;
  }

  public MainPage nextButtonShouldBeVisible() {
    Assertions.assertTrue(nextButton.has(Condition.visible), "nextButton visible Error");

    return this;
  }

  public ChatPage clickChatButton() {
    $("[text='chat']").shouldBe(Condition.visible).click();

    return chatPage;
  }
}
