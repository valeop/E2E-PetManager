package com.automation.petmanager.interactions.createuser;

import com.automation.petmanager.userinterfaces.createuser.CreateUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;

public class InputUserData implements Interaction {

    private final String username;
    private final String password;

    public InputUserData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static InputUserData with(String username, String password) {
        return new InputUserData(username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (username != null && !username.isEmpty()) {
            actor.attemptsTo(Enter.theValue(username).into(CreateUserInterface.USERNAME_TXT));
        }
        if (password != null && !password.isEmpty()) {
            actor.attemptsTo(Enter.theValue(password).into(CreateUserInterface.PASSWORD_TXT));
        }
    }
}
