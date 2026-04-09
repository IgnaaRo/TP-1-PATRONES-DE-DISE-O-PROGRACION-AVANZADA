# INFORME ACADÉMICO

## Patrones de Diseño de Software

---

### 1. Introducción

En el desarrollo de software, los patrones de diseño constituyen soluciones probadas a problemas comunes que se presentan durante la construcción de sistemas. Estos patrones permiten mejorar la organización del código, facilitar su mantenimiento y aumentar la escalabilidad de las aplicaciones.

El presente trabajo tiene como objetivo analizar e implementar tres patrones de diseño, uno por cada categoría principal: creación, estructura y comportamiento. A diferencia de los patrones más tradicionales, se han seleccionado variantes menos comunes con el fin de ampliar la comprensión sobre distintas alternativas de diseño.

---

### 2. Objetivos

#### 2.1 Objetivo General

Comprender e implementar distintos tipos de patrones de diseño utilizando el lenguaje Java en el entorno de desarrollo Apache NetBeans.

#### 2.2 Objetivos Específicos

* Analizar el funcionamiento de patrones de diseño poco utilizados.
* Implementar ejemplos prácticos de cada patrón.
* Evaluar ventajas y desventajas de cada solución.
* Comprender su aplicación en sistemas reales.

---

### 3. Desarrollo

#### 3.1 Patrón de Creación: Multiton

##### Definición

El patrón Multiton es una variación del patrón Singleton que permite gestionar múltiples instancias de una clase, identificadas mediante claves únicas.



```java
import java.util.HashMap;
import java.util.Map;

class GestorUsuarios {
    private static Map<String, GestorUsuarios> instancias = new HashMap<>();
    private String tipo;

    private GestorUsuarios(String tipo) {
        this.tipo = tipo;
    }

    public static GestorUsuarios obtenerInstancia(String tipo) {
        if (!instancias.containsKey(tipo)) {
            instancias.put(tipo, new GestorUsuarios(tipo));
        }
        return instancias.get(tipo);
    }

    public void mostrarTipo() {
        System.out.println("Tipo de usuario: " + tipo);
    }
}
```

##### Ventajas

* Permite controlar múltiples instancias de forma eficiente.
* Evita la duplicación innecesaria de objetos.

##### Desventajas

* Incrementa la complejidad respecto al Singleton.

---

#### 3.2 Patrón Estructural: Bridge

##### Definición

El patrón Bridge separa la abstracción de su implementación.


```java
interface MetodoPago {
    void procesarPago(double monto);
}

class PagoTarjeta implements MetodoPago {
    public void procesarPago(double monto) {
        System.out.println("Pago con tarjeta: $" + monto);
    }
}

class PagoEfectivo implements MetodoPago {
    public void procesarPago(double monto) {
        System.out.println("Pago en efectivo: $" + monto);
    }
}

abstract class Compra {
    protected MetodoPago metodo;

    public Compra(MetodoPago metodo) {
        this.metodo = metodo;
    }

    public abstract void realizarPago(double monto);
}

class CompraOnline extends Compra {
    public CompraOnline(MetodoPago metodo) {
        super(metodo);
    }

    public void realizarPago(double monto) {
        metodo.procesarPago(monto);
    }
}
```

##### Ventajas

* Permite cambiar implementaciones fácilmente.
* Reduce combinaciones de clases.

##### Desventajas

* Mayor complejidad inicial.

---

#### 3.3 Patrón de Comportamiento: Mediator

##### Definición

El patrón Mediator centraliza la comunicación entre objetos.


```java
import java.util.ArrayList;
import java.util.List;

class SistemaSoporte {
    private List<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public void enviarMensaje(String mensaje, Empleado emisor) {
        for (Empleado e : empleados) {
            if (e != emisor) {
                e.recibirMensaje(mensaje);
            }
        }
    }
}

class Empleado {
    private String nombre;
    private SistemaSoporte sistema;

    public Empleado(String nombre, SistemaSoporte sistema) {
        this.nombre = nombre;
        this.sistema = sistema;
    }

    public void enviar(String mensaje) {
        sistema.enviarMensaje(nombre + " dice: " + mensaje, this);
    }

    public void recibirMensaje(String mensaje) {
        System.out.println(nombre + " recibe -> " + mensaje);
    }
}
```

##### Ventajas

* Reduce el acoplamiento.
* Centraliza la comunicación.

##### Desventajas

* Puede volverse complejo.

---

### 4. Conclusión

Los patrones de diseño representan herramientas fundamentales para el desarrollo de software de calidad. A través de este trabajo, se logró implementar y analizar tres patrones menos convencionales: Multiton, Bridge y Mediator.

Cada uno de ellos aporta soluciones específicas a problemas particulares, permitiendo mejorar la organización, flexibilidad y mantenibilidad del código. Si bien algunos de estos patrones pueden introducir complejidad adicional, su correcta aplicación resulta clave en sistemas de mayor escala.

El conocimiento de estos patrones permite a los desarrolladores tomar decisiones más informadas y diseñar sistemas más robustos y adaptables.


