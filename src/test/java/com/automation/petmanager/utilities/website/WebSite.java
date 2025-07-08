package com.automation.petmanager.utilities.website;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;

public class WebSite {
    @Steps(shared = true)
    PageObject petManager;

    @Step("Ingresar a la página web")
    public void navigateTo(String url) {
        petManager.setDefaultBaseUrl(url);
        petManager.open();
    }

}
