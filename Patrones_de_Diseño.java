import java.util.*;

// 1. PATRÓN CREACIÓN - MULTITON

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


// 2. PATRÓN ESTRUCTURAL - BRIDGE

interface MetodoPago {
    void procesarPago(double monto);
}

class PagoTarjeta implements MetodoPago {
    public void procesarPago(double monto) {
        System.out.println("Procesando pago con tarjeta: $" + monto);
    }
}

class PagoEfectivo implements MetodoPago {
    public void procesarPago(double monto) {
        System.out.println("Procesando pago en efectivo: $" + monto);
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


// 3. PATRÓN DE COMPORTAMIENTO - MEDIATOR

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


// MAIN (PRUEBAS)

public class Patrones_de_Diseño {
    public static void main(String[] args) {

        System.out.println(" PRUEBA MULTITON ");
        GestorUsuarios admin1 = GestorUsuarios.obtenerInstancia("ADMIN");
        GestorUsuarios user1 = GestorUsuarios.obtenerInstancia("CLIENTE");
        GestorUsuarios admin2 = GestorUsuarios.obtenerInstancia("ADMIN");

        admin1.mostrarTipo();
        user1.mostrarTipo();

        System.out.println("¿ADMIN es la misma instancia? " + (admin1 == admin2));


        System.out.println("\n PRUEBA BRIDGE ");
        MetodoPago pago1 = new PagoTarjeta();
        Compra compra1 = new CompraOnline(pago1);
        compra1.realizarPago(15000);

        MetodoPago pago2 = new PagoEfectivo();
        Compra compra2 = new CompraOnline(pago2);
        compra2.realizarPago(8000);


        System.out.println("\n PRUEBA MEDIATOR ");
        SistemaSoporte sistema = new SistemaSoporte();

        Empleado e1 = new Empleado("Carlos", sistema);
        Empleado e2 = new Empleado("Lucia", sistema);
        Empleado e3 = new Empleado("Mateo", sistema);

        sistema.agregarEmpleado(e1);
        sistema.agregarEmpleado(e2);
        sistema.agregarEmpleado(e3);

        e1.enviar("Necesito ayuda con un cliente");
    }
}