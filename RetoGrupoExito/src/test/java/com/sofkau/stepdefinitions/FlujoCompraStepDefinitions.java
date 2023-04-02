package com.sofkau.stepdefinitions;

import com.sofkau.setup.Configuracion;

import com.sofkau.tasks.AbrirPaginaInicial;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.util.List;

import static com.sofkau.questions.MensajeFinalizarCompra.mensajeFinalizarCompra;
import static com.sofkau.tasks.AgregarProductoMenor.agregarProductoMenor;
import static com.sofkau.tasks.FinalizarCompra.finalizarCompra;
import static com.sofkau.tasks.IngresarUbicacion.ingresarUbicacion;
import static com.sofkau.tasks.IniciarSesion.iniciarSesion;
import static com.sofkau.tasks.NavegarAMiCuenta.navegarAMiCuenta;
import static com.sofkau.tasks.RealizarBusqueda.realizarBusqueda;
import static com.sofkau.util.LoadCredentials.getCredentials;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class FlujoCompraStepDefinitions extends Configuracion {
    private List<String> credentials = getCredentials();
    public static Logger LOGGER = Logger.getLogger(FlujoCompraStepDefinitions.class);

    public FlujoCompraStepDefinitions() throws IOException {
    }

    @Given("Given que estoy en la pagina de exito")
    public void givenQueEstoyEnLaPaginaDeExito() {
        try {
            configurarNavegador();
            LOGGER.info("Inicio de la Automatizacion");
            theActorInTheSpotlight().wasAbleTo(
                    new AbrirPaginaInicial(),
                    navegarAMiCuenta()
            );
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }

    }

    @When("he iniciado sesion con mis credenciales")
    public void heIniciadoSesionConMisCredenciales() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    iniciarSesion()
                            .conElUsuario(credentials.get(0))
                            .yConLaContrasenna(credentials.get(1))
            );
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }

    @When("he agregado el producto que quiero comprar")
    public void heAgregadoElProductoQueQuieroComprar() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    realizarBusqueda().yConElProducto("Lentejas"),
                    ingresarUbicacion(),
                    agregarProductoMenor(),
                    finalizarCompra()
            );
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }

    }

    @Then("se muestra el modulo para finalizar la compra")
    public void seMuestraElModuloParaFinalizarLaCompra() {
        try {
            theActorInTheSpotlight().should(
                    seeThat(mensajeFinalizarCompra(), equalTo("Finalizar la compra"))
            );

        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }finally {
            quitarDriver();
        }

    }
}
