package com.automation.petmanager.tasks.login;

import com.automation.petmanager.interactions.login.ClickLoginButton;
import com.automation.petmanager.interactions.login.InputCredentials;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class InputFieldLoginTask implements Task {
    private final String username;
    private final String password;

    public InputFieldLoginTask(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static InputFieldLoginTask withCredentials(String username, String password) {
        return new InputFieldLoginTask(username, password);
    }

    public static InputFieldLoginTask withEmptyCredentials() {
        return new InputFieldLoginTask(null, null);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
          InputCredentials.with(username, password), ClickLoginButton.now()
        );
    }
}
