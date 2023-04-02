package com.sofkau.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaInicial extends PageObject {

    public static final Target BOTON_MI_CUENTA = Target.the("Boton ir a mi cuenta")
            .located(By.cssSelector(".vtex-menu-2-x-styledLinkIcon.vtex-menu-2-x-styledLinkIcon--header-link.mh2"));

    public static final Target CAMPO_BUSQUEDA = Target.the("Campo busqueda")
            .located(By.cssSelector("input[placeholder='Buscar en exito.com']"));

    public static final Target BOTON_BUSQUEDA = Target.the("Boton Busqueda")
            .located(By.cssSelector(".vtex-store-components-3-x-searchBarIcon.vtex-store-components-3-x-searchBarIcon--search.flex.items-center.pointer.bn.bg-transparent.outline-0.pv0.pl0.pr3"));

    public static final Target BOTON_UBICACION = Target.the("Sellecionar ubicacion")
            .located(By.cssSelector(".exito-geolocation-3-x-addressResult"));

    public static final Target BOTON_CARRITO = Target.the("Carrito de compras")
            .located(By.cssSelector(".exito-header-3-x-minicartContainer"));

}
