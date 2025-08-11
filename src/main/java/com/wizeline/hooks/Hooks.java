package com.wizeline.hooks;

import com.wizeline.utils.BrowserUtils;
import com.wizeline.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

  private static final Logger LOG = Logger.getLogger(Hooks.class.getName());

  @Before
  public void setUp() {
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
  }

  @After
  public void tearDown(Scenario scenario) {
    WebDriver driver = null;
    try {
      driver = DriverManager.getDriver();
      if (scenario.isFailed() && driver != null) {
        String screenshotName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
        BrowserUtils.takeScreenshot(driver, screenshotName);
      }
    } catch (RuntimeException e) {
      LOG.log(Level.SEVERE, "Error en tearDown", e);
      throw e;
    } finally {
      if (driver != null) {
        driver.quit();
      }
      // Si tu DriverManager no tiene removeDriver(), omite esta línea
      // DriverManager.removeDriver();
    }
  }
}
