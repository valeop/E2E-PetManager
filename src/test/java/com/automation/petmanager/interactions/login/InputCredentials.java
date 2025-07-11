package com.automation.petmanager.interactions.login;

import com.automation.petmanager.userinterfaces.login.LoginUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;

public class InputCredentials implements Interaction {

    private final String username;
    private final String password;

    public InputCredentials (String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static InputCredentials with(String username, String password) {
        return new InputCredentials(username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (username != null && !username.isEmpty()) {
            actor.attemptsTo(Enter.theValue(username).into(LoginUserInterface.USERNAME_TXT));
        }
        if (password != null && !password.isEmpty()) {
            actor.attemptsTo(Enter.theValue(password).into(LoginUserInterface.PASSWORD_TXT));
        }
    }
}
