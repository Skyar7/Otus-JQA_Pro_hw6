package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import components.ChatWindowComponent;
import components.MainMenuComponent;

public class GuiceComponentsModule extends AbstractModule {

  @Provides
  @Singleton
  public ChatWindowComponent getChatWindowComponent() {
    return new ChatWindowComponent();
  }

  @Provides
  @Singleton
  public MainMenuComponent getMainMenuComponent() {
    return new MainMenuComponent();
  }
}