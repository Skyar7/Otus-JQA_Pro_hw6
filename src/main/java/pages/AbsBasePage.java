package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbsBasePage<T> {

  @Step("Открытие страницы")
  protected T open() {
    Selenide.open();
    return (T)this;
  }

  public T isPresent(String text) {
    $(String.format("[text='%s']", text)).should(Condition.visible);
    System.out.println("Доступен элемент с текстом: " + text);
    return (T) this;
  }

  public T isPresentAll(String...args) {
    Stream.of(args).map(el -> isPresent(el)).collect(Collectors.toList());
    return (T) this;
  }

  public Boolean ifPresent(String text) {
    return $(String.format("[text='%s']", text)).has(Condition.visible);
  }

  public T click(String text) {
    $(String.format("[text='%s']", text)).should(Condition.visible).click();
    System.out.println("Клик по " + text);
    return (T) this;
  }
}