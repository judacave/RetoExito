package com.sofkau.stepdefinitions;

import com.sofkau.setup.Configuracion;

import com.sofkau.tasks.AbrirPaginaInicial;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.log4j.Logger;

;
import java.io.IOException;
import java.util.List;

import static com.sofkau.tasks.AgregarProductoMenor.agregarProductoMenor;
import static com.sofkau.tasks.IngresarUbicacion.ingresarUbicacion;
import static com.sofkau.tasks.IniciarSesion.iniciarSesion;
import static com.sofkau.tasks.NavegarAMiCuenta.navegarAMiCuenta;
import static com.sofkau.tasks.RealizarBusqueda.realizarBusqueda;
import static com.sofkau.util.LoadCredentials.getCredentials;
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
                    navegarAMiCuenta(),
                    iniciarSesion()
                        .conElUsuario(credentials.get(0))
                        .yConLaContrasenna(credentials.get(1))
            );
        }catch (Exception e){
            quitarDriver();
            LOGGER.warn(e.getMessage());
        }

    }

    @When("he iniciado sesion con mis credenciales")
    public void heIniciadoSesionConMisCredenciales() {

    }

    @When("he agregado el producto que quiero comprar")
    public void heAgregadoElProductoQueQuieroComprar() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    ingresarUbicacion(),
                    realizarBusqueda().yConElProducto("Lentejas")
            );
            Thread.sleep(4000);
            theActorInTheSpotlight().attemptsTo(
                    agregarProductoMenor()
            );
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }

    }

    @Then("se muestra el modulo para finalizar la compra")
    public void seMuestraElModuloParaFinalizarLaCompra() {
        try {
            Thread.sleep(5000);
            quitarDriver();
        }catch (Exception e){
            e.getMessage();
        }

    }
}
