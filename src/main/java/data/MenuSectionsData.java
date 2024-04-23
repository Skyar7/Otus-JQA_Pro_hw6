package data;

public enum MenuSectionsData {
  CHAT("Chat"),
  EXERCISE("Exercise"),
  GRAMMAR("Grammar"),
  STATS("Stats");

  private String name;

  MenuSectionsData(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}