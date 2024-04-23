package pages;

import com.google.inject.Inject;
import data.GreetingPageElementsData;
import modules.GuicePagesModule;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GreetingPage extends AbsBasePage<GreetingPage> {

  @Inject
  ChatPage chatPage = new GuicePagesModule().getChatPage();

  {
    super.open();
  }

  public ChatPage greetingPass() {
    Stream.of(GreetingPageElementsData.values())
            .map(items -> {
              ifPresent(items.getPageTitle());
              click(items.getButton());
              return this;
            })
            .collect(Collectors.toList());

    return chatPage;
  }
}