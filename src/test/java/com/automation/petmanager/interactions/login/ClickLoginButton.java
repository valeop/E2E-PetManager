package com.automation.petmanager.interactions.login;

import com.automation.petmanager.userinterfaces.login.LoginUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

public class ClickLoginButton implements Interaction {

    public static ClickLoginButton now() {
        return new ClickLoginButton();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LoginUserInterface.LOGIN_BTN));
    }
}
