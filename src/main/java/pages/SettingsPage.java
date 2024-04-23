package pages;

public class SettingsPage extends AbsBasePage<SettingsPage> {

  public SettingsPage checkFields() {
    isPresentAll("Translations", "Feedback / help us improve", "Contact developer", "Terms of use");
    return this;
  }
}