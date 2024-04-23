package components;

import com.google.inject.Inject;
import data.MenuSectionsData;
import pages.AbsBasePage;
import pages.ChatPage;
import pages.ExercisePage;
import pages.StatsPage;

public class MainMenuComponent extends AbsBasePage {

  @Inject
  ChatPage chatPage;

  @Inject
  ExercisePage exercisePage;

  @Inject
  StatsPage statsPage;

  public MainMenuComponent mainMenuItemVisible(MenuSectionsData menuSections) {
    isPresent(menuSections.getName());
    return this;
  }

  public AbsBasePage select(MenuSectionsData menuSections) {
    click(menuSections.getName());

    switch (menuSections) {
      case CHAT:
        return chatPage;
      case EXERCISE:
        return exercisePage;
      case STATS:
        return statsPage;
      default:
        throw new RuntimeException(String.format("Unsupported Menu Item - %s", menuSections.getName()));
    }
  }
}