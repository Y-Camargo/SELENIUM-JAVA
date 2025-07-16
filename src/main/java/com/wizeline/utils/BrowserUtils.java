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
        // Crear directorio si no existe
        String directory = "screenshots/";
        File folder = new File(directory);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Añadir timestamp para evitar sobrescribir
        String timestamp = java.time.LocalDateTime.now()
                .toString()
                .replace(":", "-")
                .replace(".", "-");

        String fullFileName = directory + fileName + "_" + timestamp + ".png";

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get(fullFileName));

        System.out.println("Screenshot saved at: " + fullFileName);
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
