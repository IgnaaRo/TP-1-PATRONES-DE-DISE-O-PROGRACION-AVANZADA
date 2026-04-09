
## Patrones de Diseño de Software

### Patrón de Creación: Multiton
Definición

El patrón Multiton es una variante del patrón Singleton que permite gestionar múltiples instancias de una clase, identificadas mediante claves únicas. A diferencia del Singleton, que restringe la creación a una única instancia, el Multiton administra un conjunto limitado de instancias controladas.

Implementación

La implementación se basa en el uso de una estructura de datos, generalmente un mapa, que asocia claves con instancias. Cuando se solicita una instancia, el sistema verifica si ya existe una asociada a la clave proporcionada; en caso contrario, la crea y la almacena para futuras referencias.

Ventajas
Permite controlar múltiples instancias de manera eficiente.
Evita la creación redundante de objetos.
Facilita la organización de recursos según diferentes categorías.
Desventajas
Presenta mayor complejidad que el patrón Singleton.
Puede generar un mayor acoplamiento en el sistema.
Aplicaciones

Este patrón resulta útil en sistemas que requieren manejar distintas configuraciones, como conexiones a bases de datos por región o instancias diferenciadas de servicios.

Patrón Estructural: Bridge
Definición

El patrón Bridge tiene como objetivo separar una abstracción de su implementación, permitiendo que ambas puedan evolucionar de forma independiente. Esto evita la proliferación de clases cuando existen múltiples combinaciones posibles entre abstracciones e implementaciones.

Implementación

Se estructura en dos jerarquías principales:

La abstracción, que define la interfaz de alto nivel.
La implementación, que contiene la lógica concreta.

Ambas se relacionan mediante composición en lugar de herencia, lo que permite mayor flexibilidad en el diseño.

Ventajas
Reduce la cantidad de clases necesarias.
Permite modificar la implementación sin afectar la abstracción.
Aumenta la flexibilidad del sistema.
Desventajas
Incrementa la complejidad inicial del diseño.
Puede resultar innecesario en aplicaciones de pequeña escala.
Aplicaciones

Se aplica en sistemas donde existen múltiples variantes de implementación, como plataformas de pago, dispositivos electrónicos o interfaces desacopladas de su lógica interna.

Patrón de Comportamiento: Mediator
Definición

El patrón Mediator centraliza la comunicación entre múltiples objetos, evitando que estos interactúen directamente entre sí. De esta forma, se reduce el acoplamiento entre componentes y se mejora la organización del sistema.

Implementación

Se introduce un objeto mediador encargado de gestionar la interacción entre los distintos componentes. Los objetos envían sus mensajes al mediador, quien se encarga de distribuirlos de manera adecuada.

Ventajas
Disminuye el acoplamiento entre clases.
Mejora la mantenibilidad del sistema.
Centraliza la lógica de comunicación.
Desventajas
El mediador puede volverse complejo con el tiempo.
Existe el riesgo de que se convierta en un componente excesivamente centralizado.
Aplicaciones

Se utiliza en sistemas de mensajería, plataformas de soporte técnico, interfaces gráficas y entornos donde múltiples componentes deben interactuar entre sí.

