package pages;

import com.google.inject.Inject;
import components.ChatComponent;
import components.MenuComponent;
import data.MenuSectionsData;
import modules.GuiceComponentsModule;
import modules.GuicePagesModule;

public class ChatPage extends AbsBasePage<ChatPage> {

  @Inject
  MenuComponent menuComponent = new GuiceComponentsModule().getMainMenuComponent();

  @Inject
  ChatComponent chatComponent = new GuiceComponentsModule().getChatWindowComponent();

  @Inject
  ExercisePage exercisePage = new GuicePagesModule().getExercisePage();

  @Inject
  StatsPage statsPage = new GuicePagesModule().getStatsPage();

  public ChatPage sendMessage(String text) {
    chatComponent.sendMessage(text);
    return this;
  }

  public ChatPage checkChatbotResponse(String statement) {
    chatComponent.checkChatbotResponse(statement);
    return this;
  }

  public ExercisePage selectExercisePage() {
    menuComponent.select(MenuSectionsData.EXERCISE);
    return exercisePage;
  }

  public StatsPage selectStatsPage() {
    menuComponent.select(MenuSectionsData.STATS);
    return statsPage;
  }
}