package com.sofkau.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ModalCompraYRecoge extends PageObject {

    public static final Target CAMPO_CIUDAD = Target.the("Boton seleccionar ciudad")
            .located(By.xpath("//input[@aria-autocomplete='list']"));

    public static final Target CAMPO_TIENDA = Target.the("Boton seleccionar tienda")
            .located(By.xpath("(//input[@type='text' and @aria-autocomplete='list'])[2]"));
    public static final Target BOTON_CONFIRMAR = Target.the("Boton seleccionar tienda")
            .located(By.xpath("(//button[normalize-space()='Confirmar'])[1]"));

}
