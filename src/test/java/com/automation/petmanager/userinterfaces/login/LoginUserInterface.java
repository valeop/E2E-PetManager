package com.automation.petmanager.userinterfaces.login;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUserInterface {

    public static final Target USERNAME_TXT = Target.the("nombre de usuario")
            .located(By.cssSelector("input[placeholder='Nombre']"));

    public static final Target PASSWORD_TXT = Target.the("contraseña de usuario")
            .located(By.cssSelector("input[placeholder='Contraseña']"));

    public static final Target LOGIN_BTN = Target.the("botón de login")
            .located(By.cssSelector("button[type='submit']"));

    public static final Target MENU_BTN = Target.the("botón de menu")
            .located(By.xpath("//button[text()='Explorar ahora']"));
}
