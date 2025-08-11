package com.wizeline.utils;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

  private DriverManager() {} // utility class

  private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  public static WebDriver getDriver() {
    if (driver.get() == null) {
      throw new IllegalStateException("El WebDriver no ha sido inicializado.");
    }
    return driver.get();
  }

  public static void setDriver(WebDriver webDriver) {
    driver.set(webDriver);
  }

  public static void quitDriver() {
    if (driver.get() != null) {
      driver.get().quit();
      driver.remove();
    }
  }
}
