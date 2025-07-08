@Suite @Login
Feature: EP18-HU02 - Autenticación de usuarios con diversas credenciales
  Como usuario del sistema
  quiero iniciar sesión usando mis credenciales
  para acceder al módulo de promociones con mi nivel de permiso correspondiente

  Background:
    Given navego al módulo de inicio de sesión

    @ValidCredentialsLogin
    Scenario: EP18-HU02-01 Autenticación exitosa de usuario registrado
      When ingreso credenciales correctas
      Then logro entrar al módulo correspondiente a mi rol

    @InvalidCredentialsLogin
    Scenario: EP18-HU02-02 Autenticación fallida por credenciales incorrectas
      When ingreso el nombre de usuario
      And ingreso la contrasena incorrecta
      Then observo un mensaje de error de autenticación

    @EmptyFieldsLogin
    Scenario: EP18-HU02-03 Validacion de campos obligatorios
      When dejo los campos vacios
      Then observo un mensaje de error de campos obligatorios