package com.automation.petmanager.tasks.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateToLoginTask implements Task {

    private final String url;

    public NavigateToLoginTask(String url) {
        this.url = url;
    }

    public static NavigateToLoginTask page() {
        return new NavigateToLoginTask("http://localhost:3000/login");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }
}
