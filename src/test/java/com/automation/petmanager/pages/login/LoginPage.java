package com.automation.petmanager.pages.login;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {
    @FindBy(css = "input[placeholder='Nombre']")
    protected WebElementFacade txtUsername;

    @FindBy(css = "input[placeholder='Contraseña']")
    protected WebElementFacade txtPassword;

    @FindBy(css = "button[type='submit']")
    protected WebElementFacade btnLogin;

    @FindBy(xpath = "//button[text()='Explorar ahora']")
    protected WebElementFacade btnMenu;
}
