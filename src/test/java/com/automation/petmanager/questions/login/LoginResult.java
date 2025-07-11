package com.automation.petmanager.questions.login;

import com.automation.petmanager.userinterfaces.validations.ValidationUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class LoginResult implements Question<Boolean> {

    public static LoginResult wasSuccesful() {
        return new LoginResult();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(ValidationUserInterface.ADMIN_TITLE).answeredBy(actor);
    }
}
