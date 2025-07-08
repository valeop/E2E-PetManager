package com.automation.petmanager.pages.validations;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ValidationPage extends PageObject {

    @FindBy(xpath = "//h1[@class='text-[24px] font-semibold']")
    protected WebElementFacade titleAdmin;

    @FindBy(xpath = "//div[text()='No se pudo iniciar sesión. Verifica tus credenciales e inténtalo nuevamente.']")
    protected WebElementFacade errorLoginMessage;

    @FindBy(xpath = "//p[text()='Este campo es obligatorio']")
    protected WebElementFacade fieldValidation;
}
