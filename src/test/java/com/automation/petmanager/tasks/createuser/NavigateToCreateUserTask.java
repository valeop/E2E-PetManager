package com.automation.petmanager.tasks.createuser;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateToCreateUserTask implements Task {

    private final String url;

    public NavigateToCreateUserTask(String url) {
        this.url = url;
    }

    public static NavigateToCreateUserTask page() {
        return new NavigateToCreateUserTask("http://localhost:3000/register");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }
}
