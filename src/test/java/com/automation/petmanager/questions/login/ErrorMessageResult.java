package com.automation.petmanager.questions.login;

import com.automation.petmanager.userinterfaces.validations.ValidationUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class ErrorMessageResult implements Question<Boolean> {

    public static ErrorMessageResult forInvalidCredentials() {
        return new ErrorMessageResult();
    }

    public static ErrorMessageResult forEmptyCredentials() {
        return new ErrorMessageResult();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(ValidationUserInterface.ERROR_LOGIN_MESSAGE).answeredBy(actor) ||
                Visibility.of(ValidationUserInterface.FIELD_VALIDATION_MESSAGE).answeredBy(actor);
    }
}
