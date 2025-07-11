package com.automation.petmanager.questions.createuser;

import com.automation.petmanager.userinterfaces.validations.ValidationCreateUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class CreateUserResult implements Question<Boolean> {

    public static CreateUserResult wasSuccessful() {
        return new CreateUserResult();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(ValidationCreateUserInterface.SUCCESS_CREATE_MESSAGE).answeredBy(actor);
    }
}
