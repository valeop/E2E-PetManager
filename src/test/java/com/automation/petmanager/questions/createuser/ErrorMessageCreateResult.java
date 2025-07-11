package com.automation.petmanager.questions.createuser;

import com.automation.petmanager.userinterfaces.validations.ValidationCreateUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class ErrorMessageCreateResult implements Question<Boolean> {

    public static ErrorMessageCreateResult forDuplicateUser() {
        return new ErrorMessageCreateResult();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(ValidationCreateUserInterface.ERROR_USER_EXISTS_MESSAGE).answeredBy(actor);
    }
}
