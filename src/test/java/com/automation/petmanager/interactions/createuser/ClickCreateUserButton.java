package com.automation.petmanager.interactions.createuser;

import com.automation.petmanager.userinterfaces.createuser.CreateUserUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

public class ClickCreateUserButton implements Interaction {

    public static ClickCreateUserButton now() {
        return new ClickCreateUserButton();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CreateUserUserInterface.CREATE_USER_BTN));
    }
}
