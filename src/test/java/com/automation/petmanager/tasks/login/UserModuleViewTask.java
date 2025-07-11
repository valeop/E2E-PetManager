package com.automation.petmanager.tasks.login;

import com.automation.petmanager.userinterfaces.login.LoginUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class UserModuleViewTask implements Task {

    public static UserModuleViewTask now() {
        return new UserModuleViewTask();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LoginUserInterface.MENU_BTN));
    }
}
