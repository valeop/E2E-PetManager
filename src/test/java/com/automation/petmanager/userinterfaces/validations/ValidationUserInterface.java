package com.automation.petmanager.userinterfaces.validations;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ValidationUserInterface {

    public static final Target ADMIN_TITLE = Target.the("título de admin")
            .located(By.xpath("//h1[@class='text-[24px] font-semibold']"));

    public static final Target ERROR_LOGIN_MESSAGE = Target.the("mensaje de error en login")
            .located(By.xpath("//div[text()='No se pudo iniciar sesión. Verifica tus credenciales e inténtalo nuevamente.']"));

    public static final Target FIELD_VALIDATION_MESSAGE = Target.the("mensaje de validación de campos")
            .located(By.xpath("//p[text()='Este campo es obligatorio']"));
}
