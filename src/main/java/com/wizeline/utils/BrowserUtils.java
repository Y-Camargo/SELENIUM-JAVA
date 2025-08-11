package com.wizeline.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

  private static final Logger LOG = Logger.getLogger(BrowserUtils.class.getName());

  public static void waitForVisibility(WebDriver driver, By locator, int timeoutInSeconds) {
    new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
        .until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public static void scrollToElement(WebDriver driver, WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
  }

  public static void scrollDown(WebDriver driver) {
    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
  }

  public static void takeScreenshot(WebDriver driver, String fileName) {
    String directory = "screenshots/";
    File folder = new File(directory);
    if (!folder.exists() && !folder.mkdirs()) {
      LOG.warning("No se pudo crear el directorio de screenshots: " + directory);
      return;
    }

    String timestamp = java.time.LocalDateTime.now().toString().replace(":", "-").replace(".", "-");
    String fullFileName = directory + fileName + "_" + timestamp + ".png";

    try {
      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      Files.copy(screenshot.toPath(), Paths.get(fullFileName));
      LOG.info("Screenshot guardado en: " + fullFileName);
    } catch (IOException e) {
      LOG.log(Level.SEVERE, "No se pudo guardar el screenshot: " + fullFileName, e);
    }
  }

  public static void switchToNewTab(WebDriver driver) {
    for (String window : driver.getWindowHandles()) {
      driver.switchTo().window(window);
    }
  }

  public static void acceptAlert(WebDriver driver) {
    try {
      driver.switchTo().alert().accept();
    } catch (NoAlertPresentException e) {
      LOG.fine("No hay alerta para aceptar");
    }
  }

  public static void maximizeWindow(WebDriver driver) {
    driver.manage().window().maximize();
  }

  public static void refreshPage(WebDriver driver) {
    driver.navigate().refresh();
  }
}
