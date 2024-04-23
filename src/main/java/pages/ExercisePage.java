package pages;

import com.google.inject.Inject;
import components.MenuComponent;
import data.MenuSectionsData;
import modules.GuiceComponentsModule;

public class ExercisePage extends AbsBasePage<ExercisePage> {

  @Inject
  MenuComponent menuComponent = new GuiceComponentsModule().getMainMenuComponent();

  @Inject
  ExercisePage exercisePage;

  public ChatPage clickStart() {
    menuComponent.menuItemVisible(MenuSectionsData.EXERCISE);
    click("Start");
    return new ChatPage();
  }
}