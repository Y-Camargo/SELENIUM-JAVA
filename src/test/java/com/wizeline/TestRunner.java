package com.wizeline;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",  // Ruta donde se encuentran los archivos .feature
        glue = {"com.wizeline.steps", "com.wizeline.hooks"},  // Paquetes con las definiciones de pasos y hooks
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/cucumber.json"}
)
public class TestRunner {
    // La clase de TestRunner se encarga de ejecutar los escenarios de Cucumber
}
