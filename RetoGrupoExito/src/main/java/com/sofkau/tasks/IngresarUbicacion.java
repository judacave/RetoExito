package com.sofkau.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static com.sofkau.ui.ModalCompraYRecoge.*;
import static com.sofkau.ui.PaginaInicial.BOTON_UBICACION;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class IngresarUbicacion implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Click.on(CAMPO_CIUDAD),
                Hit.the(Keys.ENTER).into(CAMPO_CIUDAD),
                Click.on(CAMPO_TIENDA),
                Hit.the(Keys.ENTER).into(CAMPO_TIENDA),
                Click.on(BOTON_CONFIRMAR)
        );

    }
    public static IngresarUbicacion ingresarUbicacion(){
        return new IngresarUbicacion();
    }
}
