package com.wizeline.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.wizeline.utils.DriverManager;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp() {
        try {
            // Usa WebDriverManager para configurar automáticamente el driver
            WebDriverManager.chromedriver().setup();
            
            // Elimina opciones problemáticas de Chrome
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*"); 
            
            // Configura el driver
            WebDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            // Asigna el WebDriver a DriverManager
            DriverManager.setDriver(driver);
            
            // Verifica si el WebDriver está inicializado correctamente
            if (DriverManager.getDriver() == null) {
                throw new IllegalStateException("El WebDriver no se ha inicializado correctamente.");
            }
        } catch (Exception e) {
            System.out.println("Error al iniciar el WebDriver: " + e.getMessage());
            e.printStackTrace();
        }
    }
@After
public void tearDown() {
        try {
            WebDriver driver = DriverManager.getDriver();
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar el WebDriver: " + e.getMessage());
            e.printStackTrace();
        }
    }
}   

