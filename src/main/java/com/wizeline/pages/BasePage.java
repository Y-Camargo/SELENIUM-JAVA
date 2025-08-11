package com.wizeline.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

  protected WebDriver driver;
  protected WebDriverWait wait;

  // Constructor de la clase base
  public BasePage(WebDriver driver) {
    if (driver == null) {
      throw new IllegalArgumentException("Driver cannot be null");
    }
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  // Espera a que un elemento sea visible
  protected WebElement waitForElementVisible(By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  // Hace clic en un elemento
  protected void click(By locator) {
    waitForElementVisible(locator).click();
  }

  // Escribe texto en un campo de entrada
  protected void writeText(By locator, String text) {
    WebElement element = waitForElementVisible(locator);
    element.clear();
    element.sendKeys(text);
  }

  // Lee el texto visible de un elemento
  protected String readText(By locator) {
    return waitForElementVisible(locator).getText();
  }

  // Verifica si un elemento está presente
  protected boolean isElementDisplayed(By locator) {
    try {
      return waitForElementVisible(locator).isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }

  // Navega a una URL
  public void navigateTo(String url) {
    driver.get(url);
  }
}
