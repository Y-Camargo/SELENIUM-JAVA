package com.wizeline.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class BrowserUtils {

    // Espera explícita genérica
    public static void waitForVisibility(WebDriver driver, By locator, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Scroll hacia un elemento
    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Scroll hacia abajo
    public static void scrollDown(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    // Captura de screenshot
    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), Paths.get("screenshots/" + fileName + ".png"));
        } catch (Exception e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }

    // Cambiar a nueva pestaña
    public static void switchToNewTab(WebDriver driver) {
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
        }
    }

    // Aceptar alerta
    public static void acceptAlert(WebDriver driver) {
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert to accept");
        }
    }

    // Maximizar ventana
    public static void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    // Refrescar página
    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }
}
