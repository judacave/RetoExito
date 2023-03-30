package com.sofkau.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaProductoFiltrado extends PageObject {

    public static final Target DESPLEGABLE_ORDER_BY = Target.the("Boton iniciar con email y clave")
            .located(By.cssSelector(".vtex-search-result-3-x-orderByText.c-muted-2"));
}
