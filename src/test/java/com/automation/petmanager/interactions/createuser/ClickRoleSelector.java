package com.automation.petmanager.interactions.createuser;

import com.automation.petmanager.userinterfaces.createuser.CreateUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class ClickRoleSelector implements Interaction {
    private final String role;

    public ClickRoleSelector(String role) {
        this.role = role;
    }

    public static ClickRoleSelector with(String role) {
        return new ClickRoleSelector(role);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (role != null) {
            actor.attemptsTo(
                    SelectFromOptions.byValue(role).from(CreateUserInterface.ROLE_SELECTOR));
        }
    }
}
