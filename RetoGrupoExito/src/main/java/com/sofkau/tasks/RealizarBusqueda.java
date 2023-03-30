package com.sofkau.tasks;

import groovyjarjarasm.asm.commons.TableSwitchGenerator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.sofkau.ui.PaginaInicial.*;
import static com.sofkau.ui.PaginaInicioSesion.CAMPO_EMAIL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class RealizarBusqueda implements Task {
    private String producto;
    public RealizarBusqueda yConElProducto(String producto){
        this.producto=producto;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CAMPO_BUSQUEDA, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(CAMPO_BUSQUEDA),
                Enter.theValue(producto).into(CAMPO_BUSQUEDA),
                Click.on(BOTON_BUSQUEDA)
        );
    }
    public static RealizarBusqueda realizarBusqueda(){
        return new RealizarBusqueda();
    }
}
