package components;

import annotations.Component;
import com.google.inject.Inject;
import data.MenuSectionsData;
import pages.AbsBasePage;
import pages.ChatPage;
import pages.ExercisePage;
import pages.StatsPage;

@Component("id:menu")
public class MenuComponent extends AbsBasePage<MenuComponent> {

  @Inject
  ChatPage chatPage;

  @Inject
  ExercisePage exercisePage;

  @Inject
  StatsPage statsPage;

  public MenuComponent menuItemVisible(MenuSectionsData menuSections) {
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