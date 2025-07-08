package com.automation.petmanager.steps.validation;

import com.automation.petmanager.pages.validations.ValidationPage;
import net.serenitybdd.annotations.Step;

public class ValidationStep extends ValidationPage {

    @Step("Validar visualización de módulo de administrador")
    public Boolean titleAdminVisible () {
        return titleAdmin.isDisplayed();
    }

    @Step("Validar visualización del mensaje de error para credenciales inválidas")
    public Boolean errorMessageVisible() {
        return errorLoginMessage.isDisplayed();
    }

    @Step("Validar visualización de mensaje de error para campos vacíos")
    public Boolean fieldValidationMessageVisible () {
        return fieldValidation.isDisplayed();
    }
}
