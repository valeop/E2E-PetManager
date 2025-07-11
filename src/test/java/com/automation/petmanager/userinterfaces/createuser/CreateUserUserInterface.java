package com.automation.petmanager.userinterfaces.createuser;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateUserUserInterface {

    public static final Target USERNAME_TXT = Target.the("campo nombre de usuario")
            .locatedBy("//input[@placeholder='Nombre de usuario' or @name='username' or @id='username']")
            .or(By.cssSelector("input[type='text']:first-of-type"));

    public static final Target EMAIL_TXT = Target.the("campo email")
            .locatedBy("//input[@type='email' or @placeholder*='email' or @placeholder*='Email']")
            .or(By.cssSelector("input[type='email']"));

    public static final Target PASSWORD_TXT = Target.the("campo contraseña")
            .locatedBy("//input[@type='password' or @placeholder*='contraseña' or @placeholder*='password']")
            .or(By.cssSelector("input[type='password']"));

    public static final Target ROLE_SELECT = Target.the("selector de rol")
            .locatedBy("//select[@name='role' or @name='rol' or contains(@class, 'role')]")
            .or(By.cssSelector("select"));

    public static final Target CREATE_USER_BTN = Target.the("botón crear usuario")
            .locatedBy("//button[@type='submit' or contains(text(), 'Crear') or contains(text(), 'Registrar')]")
            .or(By.cssSelector("button[type='submit']"));

    public static final Target CANCEL_BTN = Target.the("botón cancelar")
            .locatedBy("//button[contains(text(), 'Cancelar') or contains(text(), 'Cancel')]");
}
