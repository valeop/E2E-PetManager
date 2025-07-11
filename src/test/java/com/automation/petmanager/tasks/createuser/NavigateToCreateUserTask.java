package com.automation.petmanager.tasks.createuser;

import com.automation.petmanager.interactions.createuser.ClickCreateUserButton;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class NavigateToCreateUserTask implements Task {

    public static NavigateToCreateUserTask now() {
        return new NavigateToCreateUserTask();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ClickCreateUserButton.now());
    }
}
