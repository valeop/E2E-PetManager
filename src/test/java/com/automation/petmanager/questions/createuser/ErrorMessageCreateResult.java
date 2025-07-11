package com.automation.petmanager.questions.createuser;

import com.automation.petmanager.userinterfaces.validations.ValidationUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class ErrorMessageCreateResult implements Question<Boolean> {

    public static ErrorMessageCreateResult forDuplicateUser() {
        return new ErrorMessageCreateResult();
    }

    public static ErrorMessageCreateResult forEmptyFields() {
        return new ErrorMessageCreateResult();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(ValidationUserInterface.ERROR_USER_EXISTS_MESSAGE).answeredBy(actor) ||
                Visibility.of(ValidationUserInterface.ERROR_EMPTY_FIELDS_MESSAGE).answeredBy(actor);
    }
}
