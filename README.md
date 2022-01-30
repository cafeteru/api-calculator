# api-calculator

## Modo de uso

1. Instalar las dependencias del servidor

```shell
mvn clean install
```

2. Arrancar el servidor

```shell
mvn spring-boot:run
```

3. Acceder a [Swagger](http://localhost:8080/swagger-ui.html) para realizar las pruebas.

## Decisiones tomadas

- Se ha usado el tipo `BigDecimal` para usar números en base decimal y no binarias para que sea más fiel a las
calculadoras tradicionales
- Se ha añadido Swagger para simplificar las pruebas, pero no es obligatorio usarlo.
- Se han añadido test de integración para comprobar, aunque Spring ya lo hace, que cuando se envia un `String` en lugar
de un número, el sistema devuelva un error.
- Se ha divido la aplicación en capas para separar la logica.
- Se ha añadido un log para facilitar su posterior mantenimiento.
- Se han usado interfaces para cumplir los principios S.O.L.I.D.
- Se ha implimentado el código usando TDD.
