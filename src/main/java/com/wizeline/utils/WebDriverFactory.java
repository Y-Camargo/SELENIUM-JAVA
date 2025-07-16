package com.wizeline.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    private static WebDriver driver;

    // Método para obtener la instancia del WebDriver
    public static WebDriver getDriver() {
        if (driver == null) {
            // Configurar WebDriverManager para obtener la última versión del driver
            WebDriverManager.chromedriver().setup();

            // Configuración de opciones adicionales (como iniciar en modo headless, etc.)
            ChromeOptions options = new ChromeOptions();
            // Opcional: opciones para ejecutar en headless (sin interfaz gráfica)
            // options.addArguments("--headless");

            // Crear un nuevo ChromeDriver con opciones configuradas
            driver = new ChromeDriver(options);

            // Configuración de tiempos de espera
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        return driver;
    }

    // Método para cerrar la instancia de WebDriver (importante para liberar recursos)
    public static void quitDriver() {
        if (driver != null) {
            driver.quit(); // Cierra el navegador
            driver = null; // Libera la referencia
        }
    }
}
