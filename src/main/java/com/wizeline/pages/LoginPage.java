package com.wizeline.pages;

import com.wizeline.utils.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

  private By usernameField = By.id("user-name");
  private By passwordField = By.id("password");
  private By loginButton = By.id("login-button");
  private By errorMessage = By.cssSelector("h3[data-test='error']");

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  // Navega a la página de login
  public void openLoginPage() {
    System.out.println("Abriendo la URL: " + Config.BASE_URL);
    navigateTo(Config.BASE_URL);
  }

  // Inicia sesión con un nombre de usuario y una contraseña
  public void login(String username, String password) {
    writeText(usernameField, username);
    writeText(passwordField, password);
    click(loginButton);
  }

  // Verifica que la página de login esté visible
  public boolean isLoginPageDisplayed() {
    return driver.getTitle().contains("Swag Labs");
  }

  // Obtiene el mensaje de error
  public String getErrorMessage() {
    WebElement errorElement = driver.findElement(errorMessage);
    return errorElement.getText().trim();
  }
}
