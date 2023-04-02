package com.sofkau.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.sofkau.ui.PaginaCarrito.BOTON_IR_A_PAGAR;
import static com.sofkau.ui.PaginaInicial.BOTON_CARRITO;
import static com.sofkau.ui.PaginaProductoFiltrado.*;
import static com.sofkau.ui.PaginaProductoFiltrado.BOTON_AGREGAR_MENOR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class FinalizarCompra implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_CARRITO),
                Click.on(BOTON_IR_A_PAGAR)
        );
    }
    public static FinalizarCompra finalizarCompra(){
        return new FinalizarCompra();
    }

}
