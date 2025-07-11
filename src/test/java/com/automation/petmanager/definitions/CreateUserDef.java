package com.automation.petmanager.definitions;

import com.automation.petmanager.questions.createuser.CreateUserResult;
import com.automation.petmanager.questions.createuser.ErrorMessageCreateResult;
import com.automation.petmanager.tasks.createuser.InputFieldCreateUserTask;
import com.automation.petmanager.tasks.createuser.NavigateToCreateUserTask;
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

    private final Actor administrador = Actor.named("Administrador");

    @Given("navego al módulo de registro de usuarios")
    public void userNavigateToCreateUser() {
        administrador.can(BrowseTheWeb.with(driver));
        administrador.attemptsTo(NavigateToCreateUserTask.page());
    }

    @When("ingreso la información correcta del nuevo administrador")
    public void inputValidAdminInformation() {
        administrador.attemptsTo(InputFieldCreateUserTask.withAdminCredentials("AdminTest", "admin@test.com", "AdminPass123", "ADMIN"));
    }

    @Then("observo un mensaje de administrador creado")
    public void viewAdminCreatedMessage() {
        administrador.should(seeThat(CreateUserResult.wasSuccessful(), equalTo(true)));
    }

    @When("ingreso la información correcta del nuevo usuario")
    public void inputValidUserInformation() {
        administrador.attemptsTo(InputFieldCreateUserTask.withUserCredentials("UserTest", "user@test.com", "UserPass123", "USER"));
    }

    @Then("observo un mensaje de usuario creado")
    public void viewUserCreatedMessage() {
        administrador.should(seeThat(CreateUserResult.wasSuccessful(), equalTo(true)));
    }

    @When("ingreso la información del usuario existente")
    public void inputExistingUserInformation() {
        administrador.attemptsTo(InputFieldCreateUserTask.withUserCredentials("admin", "admin@existing.com", "ExistingPass123", "USER"));
    }

    @Then("observo un mensaje de error de usuario existente")
    public void viewUserExistsError() {
        administrador.should(seeThat(ErrorMessageCreateResult.forDuplicateUser(), equalTo(true)));
    }

    @When("dejo los campos vacíos para el nuevo usuario")
    public void inputEmptyUserFields() {
        administrador.attemptsTo(InputFieldCreateUserTask.withEmptyCredentials());
    }

    @Then("observo un mensaje de error por campos obligatorio")
    public void viewEmptyFieldsError() {
        administrador.should(seeThat(ErrorMessageCreateResult.forEmptyFields(), equalTo(true)));
    }
}
