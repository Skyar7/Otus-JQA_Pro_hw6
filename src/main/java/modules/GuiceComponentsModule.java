package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import components.ChatComponent;
import components.MenuComponent;

public class GuiceComponentsModule extends AbstractModule {

  @Provides
  @Singleton
  public ChatComponent getChatWindowComponent() {
    return new ChatComponent();
  }

  @Provides
  @Singleton
  public MenuComponent getMainMenuComponent() {
    return new MenuComponent();
  }
}