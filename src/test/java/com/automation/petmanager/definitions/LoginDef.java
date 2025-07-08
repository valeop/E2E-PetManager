package com.automation.petmanager.definitions;

import com.automation.petmanager.steps.login.LoginStep;
import com.automation.petmanager.steps.validation.ValidationStep;
import com.automation.petmanager.utilities.website.WebSite;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

public class LoginDef {

    @Steps(shared = true)
    WebSite url;

    @Steps(shared = true)
    LoginStep login;

    @Steps(shared = true)
    ValidationStep validation;

    @Given("navego al módulo de inicio de sesión")
    public void userNavigateTo () {
        url.navigateTo("http://localhost:3000/login");
    }

    @When("ingreso credenciales correctas")
    public void inputValidCredentials () {
        login.inputUsername("Usuario1");
        login.inputPassword("Contrasena1*");
        login.clickLogin();
        login.clickMenu();
    }

    @Then("logro entrar al módulo correspondiente a mi rol")
    public void viewMenu () {
        Assert.assertTrue(validation.titleAdminVisible());
    }


    @When("ingreso el nombre de usuario")
    public void inputValidUser () {
        login.inputUsername("Usuario2");
    }

    @And("ingreso la contrasena incorrecta")
    public void inputInvalidPassword () {
        login.inputPassword("ContrasenaFake1*");
        login.clickLogin();
    }

    @Then("observo un mensaje de error de autenticación")
    public void viewLoginError () {
        Assert.assertTrue(validation.errorMessageVisible());
    }

    @When("dejo los campos vacios")
    public void inputEmptyCredentials () {
        login.inputUsername(null);
        login.inputPassword(null);
        login.clickLogin();
    }

    @Then("observo un mensaje de error de campos obligatorios")
    public void viewFieldValidation () {
        Assert.assertTrue(validation.fieldValidationMessageVisible());
    }
}
