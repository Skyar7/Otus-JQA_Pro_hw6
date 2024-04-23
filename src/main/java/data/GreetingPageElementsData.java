package data;

public enum GreetingPageElementsData {
  first("Next", "Chat to improve your English"),
  second("Next", "Learn new words and grammar"),
  third("Skip >", "7 days FREE");

  private String button;
  private String title;

  GreetingPageElementsData(String button, String title) {
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