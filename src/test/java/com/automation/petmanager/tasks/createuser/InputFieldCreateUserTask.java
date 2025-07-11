package com.automation.petmanager.tasks.createuser;

import com.automation.petmanager.interactions.createuser.ClickRoleSelector;
import com.automation.petmanager.interactions.createuser.InputUserData;
import com.automation.petmanager.userinterfaces.createuser.CreateUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class InputFieldCreateUserTask implements Task {
    private final String username;
    private final String password;
    private final String role;

    public InputFieldCreateUserTask(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public static InputFieldCreateUserTask withAdminCredentials(String username, String password, String role) {
        return new InputFieldCreateUserTask(username, password, role);
    }

    public static InputFieldCreateUserTask withUserCredentials(String username, String password, String role) {
        return new InputFieldCreateUserTask(username, password, role);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                InputUserData.with(username, password),
                ClickRoleSelector.with(role),
                Click.on(CreateUserInterface.CREATE_ACCOUNT_BTN)
        );
    }
}
