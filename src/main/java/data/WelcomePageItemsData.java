package data;

public enum WelcomePageItemsData {
  first("Next", "Chat to improve your English"),
  second("Next", "Learn new words and grammar"),
  third("Skip >", "7 days FREE");

  private String button;
  private String title;

  WelcomePageItemsData(String button, String title) {
    this.button = button;
    this.title = title;
  }

  public String getButton() {
    return button;
  }

  public String getPageTitle() {
    return title;
  }
}