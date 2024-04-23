package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import pages.*;

public class GuicePagesModule extends AbstractModule {

  @Provides
  @Singleton
  public GreetingPage getWelcomePage() {
    return new GreetingPage();
  }

  @Provides
  @Singleton
  public ChatPage getChatPage() {
    return new ChatPage();
  }

  @Provides
  @Singleton
  public ExercisePage getExercisePage() {
    return new ExercisePage();
  }

  @Provides
  @Singleton
  public StatsPage getStatsPage() {
    return new StatsPage();
  }

  @Provides
  @Singleton
  public SettingsPage getSettingsPage() {
    return new SettingsPage();
  }
}