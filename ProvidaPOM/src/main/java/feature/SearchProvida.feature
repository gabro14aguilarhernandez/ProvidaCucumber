@tag
Feature: Search Provida
  I searched for a Provida policy

  @tag1
  Scenario: Search Provida
    Given I enter the chrome browser
    And Enter the page Provida with valid credentials
    When I enter to Generales
    And Selec to Consultador
    And Enter the policy number
    And Click on Buscar
    Then Click on link policy number
    And Valid section Informacion General
    And Valid section Datos de contacto
    And Valid section Coberturas
    And Valid section Beneficiarios
    And Valid section Servicios
    And Valid section Agentes
    And Logout
 
   @tag2
  Scenario: Search Provida
    Given I enter the chrome browser
    And Enter the page Provida with valid credentials
    When I enter to Generales
    And Selec to Consultador
    And Enter the policy number
    And Click on Buscar
    Then Click on link policy number
    And Valid section Informacion General
    And Valid section Datos de contacto
    And Valid section Coberturas
    And Valid section Beneficiarios
    And Valid section Servicios
    And Valid section Agentes
    And Logout
   @tag3
  Scenario: Search Provida
    Given I enter the chrome browser
    And Enter the page Provida with valid credentials
    When I enter to Generales
    And Selec to Consultador
    And Enter the policy number
    And Click on Buscar
    Then Click on link policy number
    And Valid section Informacion General
    And Valid section Datos de contacto
    And Valid section Coberturas
    And Valid section Beneficiarios
    And Valid section Servicios
    And Valid section Agentes
    And Logout
    