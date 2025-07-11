package com.automation.petmanager.definitions.login;

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

    private final Actor actor = Actor.named("Usuario");

    @Given("navego al módulo de inicio de sesión")
    public void userNavigateToLogin () {
        actor.can(BrowseTheWeb.with(driver));
        actor.attemptsTo(NavigateToLoginTask.page());
    }

    @When("ingreso credenciales correctas")
    public void inputValidCredentials () {
        actor.attemptsTo(InputFieldLoginTask.withCredentials("Usuario1","Contrasena1*"),
                UserModuleViewTask.now());
    }

    @Then("logro entrar al módulo correspondiente a mi rol")
    public void viewMenu () {
      actor.should(seeThat(LoginResult.wasSuccesful()));
    }

    @When("ingreso una de las credenciales incorrectas")
    public void inputInvalidPassword () {
        actor.attemptsTo(InputFieldLoginTask.withCredentials("Usuario1", "ContrasenaFake1*"));
    }

    @Then("observo un mensaje de error de autenticación")
    public void viewLoginError () {
        actor.should(seeThat(ErrorMessageResult.forInvalidCredentials(), equalTo(true)));
    }

    @When("dejo los campos vacios")
    public void inputEmptyCredentials () {
        actor.attemptsTo(InputFieldLoginTask.withEmptyCredentials());
    }

    @Then("observo un mensaje de error de campos obligatorios")
    public void viewFieldValidation () {
        actor.should(seeThat(ErrorMessageResult.forEmptyCredentials(), equalTo(true)));
    }
}
