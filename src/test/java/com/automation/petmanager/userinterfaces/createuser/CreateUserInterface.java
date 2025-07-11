package com.automation.petmanager.userinterfaces.createuser;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateUserInterface {

    public static final Target CREATE_USER_BTN = Target.the("botón crear usuario")
            .located(By.xpath("//span[text()='Crear Usuario']"));

    public static final Target USERNAME_TXT = Target.the("campo nombre de usuario")
            .located(By.cssSelector("input[placeholder='Usuario']"));

    public static final Target PASSWORD_TXT = Target.the("campo contraseña")
            .located(By.cssSelector("input[placeholder='Contraseña']"));

    public static final Target ROLE_SELECTOR = Target.the("selector de rol")
            .located(By.xpath("//select[@class='border-1 border-[#E4E4E7] rounded-md p-2  focus:border-[#E4E4E7]  outline-none']"));

    public static final Target CREATE_ACCOUNT_BTN = Target.the("botón crear cuenta")
            .located(By.xpath("//button[text()='Crear cuenta']"));
}
