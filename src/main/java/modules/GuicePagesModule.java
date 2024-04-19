package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import pages.ChatPage;
import pages.MainPage;

public class GuicePagesModule extends AbstractModule {

  @Provides
  @Singleton
  public MainPage getMainPage() {
    return new MainPage();
  }

  @Provides
  @Singleton
  public ChatPage getChatPage() {
    return new ChatPage();
  }
}