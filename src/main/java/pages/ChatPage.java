package pages;

import com.google.inject.Inject;
import components.ChatWindowComponent;
import components.MainMenuComponent;
import data.MenuSectionsData;
import modules.GuiceComponentsModule;
import modules.GuicePagesModule;

public class ChatPage extends AbsBasePage<ChatPage> {

  @Inject
  MainMenuComponent mainMenuComponent = new GuiceComponentsModule().getMainMenuComponent();

  @Inject
  ChatWindowComponent chatWindowComponent = new GuiceComponentsModule().getChatWindowComponent();

  @Inject
  ExercisePage exercisePage = new GuicePagesModule().getExercisePage();

  @Inject
  StatsPage statsPage = new GuicePagesModule().getStatsPage();

  public ChatPage sendMessage(String text) {
    chatWindowComponent.sendMessage(text);
    return this;
  }

  public ChatPage checkChatbotResponse(String statement) {
    chatWindowComponent.checkChatbotResponse(statement);
    return this;
  }

  public ExercisePage selectExercisePage() {
    mainMenuComponent.select(MenuSectionsData.EXERCISE);
    return exercisePage;
  }

  public StatsPage selectStatsPage() {
    mainMenuComponent.select(MenuSectionsData.STATS);
    return statsPage;
  }
}