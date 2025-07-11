package com.automation.petmanager.userinterfaces.validations;


import net.serenitybdd.screenplay.targets.Target;

public class ValidationCreateUserInterface {

    public static final Target SUCCESS_CREATE_MESSAGE = Target.the("mensaje de usuario creado")
            .locatedBy("//h1[text()='¡La cuenta ha sido creada con éxito!']");

    public static final Target ERROR_USER_EXISTS_MESSAGE = Target.the("mensaje de error por usuario duplicado")
            .locatedBy("//p[text()='Error al crear usuario, inténtelo de nuevo. El Usuario ya existe']");

}
