package com.automation.petmanager.tasks.createuser;

import com.automation.petmanager.interactions.createuser.ClickCreateUserButton;
import com.automation.petmanager.interactions.createuser.InputUserData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class InputFieldCreateUserTask implements Task {
    private final String username;
    private final String email;
    private final String password;
    private final String role;

    public InputFieldCreateUserTask(String username, String email, String password, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public static InputFieldCreateUserTask withAdminCredentials(String username, String email, String password, String role) {
        return new InputFieldCreateUserTask(username, email, password, role);
    }

    public static InputFieldCreateUserTask withUserCredentials(String username, String email, String password, String role) {
        return new InputFieldCreateUserTask(username, email, password, role);
    }

    public static InputFieldCreateUserTask withEmptyCredentials() {
        return new InputFieldCreateUserTask(null, null, null, null);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            InputUserData.with(username, email, password, role),
            ClickCreateUserButton.now()
        );
    }
}
