package com.wizeline.hooks;

import com.wizeline.utils.BrowserUtils;
import com.wizeline.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

  @Before
  public void setUp() {
    try {
      WebDriverManager.chromedriver().setup();

      ChromeOptions options = new ChromeOptions();
      options.addArguments("--remote-allow-origins=*");
      options.addArguments("--no-sandbox");
      options.addArguments("--disable-dev-shm-usage");
      options.addArguments("--disable-gpu");
      options.addArguments("--headless=new");
      options.addArguments("--user-data-dir=/tmp/chrome-user-data");

      WebDriver driver = new ChromeDriver(options);
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.manage().window().maximize();

      DriverManager.setDriver(driver);

      if (DriverManager.getDriver() == null) {
        throw new IllegalStateException("El WebDriver no se ha inicializado correctamente.");
      }
    } catch (Exception e) {
      System.out.println("Error al iniciar el WebDriver: " + e.getMessage());
      e.printStackTrace();
    }
  }

  @After
  public void tearDown(Scenario scenario) {
    try {
      WebDriver driver = DriverManager.getDriver();

      if (scenario.isFailed() && driver != null) {
        String screenshotName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
        BrowserUtils.takeScreenshot(driver, screenshotName);
      }

      if (driver != null) {
        driver.quit();
      }
    } catch (Exception e) {
      System.out.println("Error en tearDown: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
