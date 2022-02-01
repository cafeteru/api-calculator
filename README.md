# api-calculator

## Modo de uso

1. Instalar las dependencias del servidor

```shell
mvn clean compile install
```

2. Arrancar el servidor

```shell
mvn spring-boot:run
```

3. Acceder a [Swagger](http://localhost:8080/swagger-ui.html) para realizar las pruebas.

4. Ejemplos

[http://localhost:8080/suma?sumando1=1&sumando2=2](http://localhost:8080/suma?sumando1=1&sumando2=2)

[http://localhost:8080/suma?sumando1=1&sumando2=2.1](http://localhost:8080/suma?sumando1=1&sumando2=2.1)

[http://localhost:8080/resta?minuendo=1&sustraendo=2](http://localhost:8080/resta?minuendo=1&sustraendo=2)

[http://localhost:8080/resta?minuendo=1&sustraendo=2.1](http://localhost:8080/resta?minuendo=1&sustraendo=2.1)

## Decisiones tomadas

- Se ha usado el tipo `BigDecimal` para usar números en base decimal y no binarias para que sea más fiel a las
  calculadoras tradicionales
- Se ha añadido Swagger para simplificar las pruebas, pero no es obligatorio usarlo.
- Se han añadido test de integración para comprobar, aunque Spring ya lo hace, que cuando se envia un `String` en lugar
  de un número, el sistema devuelva un error.
- Se ha divido la aplicación en capas para separar la logica.
- Se ha añadido un log para facilitar su posterior mantenimiento.
- Se han usado interfaces para cumplir los principios `S.O.L.I.D.` dentro de lo posible,
  habría que revisar la entrada de los controladores para mejorar esto.
- Se ha implimentado el código usando `TDD`.
- También se añadido `JaCoCo` para comprobar la covertura de los tests.

## Como implementar nuevas operaciones

Tomando de ejemplo que quisieramos añadir una multiplicación, tendríamos que realizar los siguientes pasos, (vamos a hacer desde la capa más interna a la más externa):

1. Tendriamos que crear una nueva clase en `Model` que implementase `Operacion`
2. Creariamos un nuevo método en `CalculatorService` y su implementación que ejecutase la nueva clase creada en el caso anterior.
3. Creariamos un nuevo método en `CalculatorController` para que llame al nuevo método del servicio.
