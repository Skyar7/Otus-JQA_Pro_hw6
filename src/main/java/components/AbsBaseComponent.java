package components;

import static com.codeborne.selenide.Selenide.$;

import annotations.Component;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbsBaseComponent<T> {

  {
    getComponentEntity().shouldBe(Condition.visible);
  }

  public SelenideElement getComponentEntity() {
    Class clazz = this.getClass();

    if (clazz.isAnnotationPresent(Component.class)) {
      Component component = (Component) clazz.getAnnotation(Component.class);
      By by = locatorAnalyzer(component.value());

      assert by !=null: "Search strategy not supported";

      return $(by);
    }

    return null;
  }

  private By locatorAnalyzer(String value) {
    Pattern pattern = Pattern.compile("(\\w+):(\\w+)");
    Matcher matcher = pattern.matcher(value);

    if(matcher.find()) {
      switch (matcher.group(1)) {
        case "id":
          return By.id(matcher.group(2));
      }
    }

    return null;
  }
}