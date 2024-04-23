package pages;

import com.google.inject.Inject;
import components.MainMenuComponent;
import data.MenuSectionsData;
import modules.GuiceComponentsModule;

public class ExercisePage extends AbsBasePage<ExercisePage> {

  @Inject
  MainMenuComponent mainMenuComponent = new GuiceComponentsModule().getMainMenuComponent();

  @Inject
  ExercisePage exercisePage;

  public ChatPage clickStart() {
    mainMenuComponent.mainMenuItemVisible(MenuSectionsData.EXERCISE);
    click("Start");
    return new ChatPage();
  }
}