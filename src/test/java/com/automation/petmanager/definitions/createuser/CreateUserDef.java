package com.automation.petmanager.definitions.createuser;

import com.automation.petmanager.questions.createuser.CreateUserResult;
import com.automation.petmanager.questions.createuser.ErrorMessageCreateResult;
import com.automation.petmanager.tasks.createuser.InputFieldCreateUserTask;
import com.automation.petmanager.tasks.createuser.NavigateToCreateUserTask;
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

public class CreateUserDef {

    @Managed(uniqueSession = true)
    public WebDriver driver;

    private final Actor actor = Actor.named("Usuario");

    @Given("navego al módulo de registro de usuarios")
    public void userNavigateToCreateUser() {
        actor.can(BrowseTheWeb.with(driver));
        actor.attemptsTo(NavigateToLoginTask.page());
        actor.attemptsTo(InputFieldLoginTask.withCredentials("Usuario1", "Contrasena1*"));
        actor.attemptsTo(UserModuleViewTask.now());
        actor.attemptsTo(NavigateToCreateUserTask.now());
    }

    @When("ingreso la información correcta del nuevo administrador")
    public void inputValidAdminInformation() {
        actor.attemptsTo(InputFieldCreateUserTask.withAdminCredentials("AdminNuevo1", "Contrasena1*", "ADMIN"));
    }

    @Then("observo un mensaje de administrador creado")
    public void viewAdminCreatedMessage() {
        actor.should(seeThat(CreateUserResult.wasSuccessful(), equalTo(true)));
    }

    @When("ingreso la información correcta del nuevo usuario")
    public void inputValidUserInformation() {
        actor.attemptsTo(InputFieldCreateUserTask.withUserCredentials("UsuarioNuevo1", "Contrasena1*", "USUARIO"));
    }

    @Then("observo un mensaje de usuario creado")
    public void viewUserCreatedMessage() {
        actor.should(seeThat(CreateUserResult.wasSuccessful(), equalTo(true)));
    }

    @When("ingreso la información del usuario existente")
    public void inputExistingUserInformation() {
        actor.attemptsTo(InputFieldCreateUserTask.withUserCredentials("Usuario4", "Contrasena4*", "USUARIO"));
    }

    @Then("observo un mensaje de error de usuario existente")
    public void viewUserExistsError() {
        actor.should(seeThat(ErrorMessageCreateResult.forDuplicateUser(), equalTo(true)));
    }
}
