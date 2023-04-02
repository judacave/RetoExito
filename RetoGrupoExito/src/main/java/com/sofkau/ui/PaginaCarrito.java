package com.sofkau.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaCarrito extends PageObject {

    public static final Target BOTON_IR_A_PAGAR = Target.the("Boton ir a pagar")
            .located(By.id("cart-to-orderform"));

    public static final Target MENSAJE_FINAL = Target.the("Mensaje Finalizar Compra")
            .located(By.xpath("(//h1[normalize-space()='Finalizar la compra'])[1]"));

}
