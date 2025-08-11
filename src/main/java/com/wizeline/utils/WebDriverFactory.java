package com.wizeline.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class WebDriverFactory {

  private WebDriverFactory() {} // utility class

  private static WebDriver driver;

  // Método para obtener la instancia del WebDriver
  public static WebDriver getDriver() {
    if (driver == null) {
      WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();
      driver = new ChromeDriver(options);
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    return driver;
  }

  // Método para cerrar la instancia de WebDriver (importante para liberar recursos)
  public static void quitDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}
