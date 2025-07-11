@Suite @Create

  Feature: EP18-HU01 - Registro de usuarios con distintos niveles de permisos

    Como administrador del sistema
    quiero poder registrar usuarios con distintos niveles de permisos
    para asegurar que solo los usuarios autenticados accedan al módulo de promociones

  Background:
    Given navego al módulo de registro de usuarios

    @ValidAdminCreate
    Scenario: EP18-HU01-01 Registro exitoso de un administrador
      When ingreso la información correcta del nuevo administrador
      Then observo un mensaje de administrador creado

    @ValidUserCreate
    Scenario: EP18-HU01-02 Registro exitoso de un usuario
      When ingreso la información correcta del nuevo usuario
      Then observo un mensaje de usuario creado

    @UserDuplicatedFailure
    Scenario: EP18-HU01-03 Registro fallido con nombre de usuario ya existente
      When ingreso la información del usuario existente
      Then observo un mensaje de error de usuario existente

    @EmptyFieldsCreate
    Scenario: EP18-HU01-04 Registro fallido por campos vacíos
      When dejo los campos vacíos para el nuevo usuario
      Then observo un mensaje de error por campos obligatorio