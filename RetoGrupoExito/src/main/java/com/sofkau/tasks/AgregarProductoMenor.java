package com.sofkau.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.sofkau.ui.PaginaInicial.BOTON_MI_CUENTA;
import static com.sofkau.ui.PaginaInicial.CAMPO_BUSQUEDA;
import static com.sofkau.ui.PaginaProductoFiltrado.DESPLEGABLE_ORDER_BY;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class AgregarProductoMenor implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DESPLEGABLE_ORDER_BY, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(DESPLEGABLE_ORDER_BY)
        );
    }
    public static AgregarProductoMenor agregarProductoMenor(){
        return new AgregarProductoMenor();
    }
}
