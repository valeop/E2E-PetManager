package com.automation.petmanager.steps.login;

import com.automation.petmanager.pages.login.LoginPage;
import net.serenitybdd.annotations.Step;

public class LoginStep extends LoginPage {

    @Step("Ingresar usuario")
    public void inputUsername(String username) {
        txtUsername.sendKeys(username);
    }

    @Step("Ingresar contrasena")
    public void inputPassword(String password) {
        txtPassword.sendKeys(password);
    }

    @Step("Click en el botón para iniciar sesión")
    public void clickLogin() {
        btnLogin.click();
    }

    @Step("Click en el botón para ir al menu")
    public void clickMenu() {
        btnMenu.click();
    }
}
