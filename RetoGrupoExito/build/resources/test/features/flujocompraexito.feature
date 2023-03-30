Feature: Compra de productos en Almacen Exito
  yo como usuario de la pagina exito
  quiero empezar a comprar productos

  Scenario: Compra de el producto mas barato
    Given Given que estoy en la pagina de exito
    When he iniciado sesion con mis credenciales
    And he agregado el producto que quiero comprar
    Then se muestra el modulo para finalizar la compra
