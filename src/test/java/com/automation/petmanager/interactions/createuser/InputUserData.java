package com.automation.petmanager.interactions.createuser;

import com.automation.petmanager.userinterfaces.createuser.CreateUserUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InputUserData implements Interaction {

    private final String username;
    private final String email;
    private final String password;
    private final String role;

    public InputUserData(String username, String email, String password, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public static InputUserData with(String username, String email, String password, String role) {
        return new InputUserData(username, email, password, role);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (username != null && !username.isEmpty()) {
            actor.attemptsTo(Enter.theValue(username).into(CreateUserUserInterface.USERNAME_TXT));
        }
        if (email != null && !email.isEmpty()) {
            actor.attemptsTo(Enter.theValue(email).into(CreateUserUserInterface.EMAIL_TXT));
        }
        if (password != null && !password.isEmpty()) {
            actor.attemptsTo(Enter.theValue(password).into(CreateUserUserInterface.PASSWORD_TXT));
        }
        if (role != null && !role.isEmpty()) {
            actor.attemptsTo(
                Click.on(CreateUserUserInterface.ROLE_SELECT),
                Click.on(Target.the("opción de rol").located(By.xpath("//option[contains(text(), '" + role + "')]")))
            );
        }
    }
}
