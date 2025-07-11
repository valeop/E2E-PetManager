package com.automation.petmanager.definitions;

import com.automation.petmanager.questions.login.ErrorMessageResult;
import com.automation.petmanager.questions.login.LoginResult;
import com.automation.petmanager.tasks.login.InputFieldLoginTask;
import com.automation.petmanager.tasks.login.NavigateToLoginTask;
import com.automation.petmanager.tasks.login.UserModuleViewTask;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class LoginDef {

    @Managed(uniqueSession = true)
    public WebDriver driver;

    private final Actor usuario = Actor.named("Usuario");

    @Given("navego al módulo de inicio de sesión")
    public void userNavigateTo () {
        usuario.can(BrowseTheWeb.with(driver));
        usuario.attemptsTo(NavigateToLoginTask.page());
    }

    @When("ingreso credenciales correctas")
    public void inputValidCredentials () {
        usuario.attemptsTo(InputFieldLoginTask.withCredentials("Usuario1","Contrasena1*"),
                UserModuleViewTask.now());
    }

    @Then("logro entrar al módulo correspondiente a mi rol")
    public void viewMenu () {
      usuario.should(seeThat(LoginResult.wasSuccesful()));
    }

    @When("ingreso una de las credenciales incorrectas")
    public void inputInvalidPassword () {
        usuario.attemptsTo(InputFieldLoginTask.withCredentials("Usuario1", "ContrasenaFake1*"));
    }

    @Then("observo un mensaje de error de autenticación")
    public void viewLoginError () {
        usuario.should(seeThat(ErrorMessageResult.forInvalidCredentials(), equalTo(true)));
    }

    @When("dejo los campos vacios")
    public void inputEmptyCredentials () {
        usuario.attemptsTo(InputFieldLoginTask.withEmptyCredentials());
    }

    @Then("observo un mensaje de error de campos obligatorios")
    public void viewFieldValidation () {
        usuario.should(seeThat(ErrorMessageResult.forEmptyCredentials(), equalTo(true)));
    }
}
