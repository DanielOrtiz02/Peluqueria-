package peluqueria;

public class ColaCliente {

    private Nodo frente;
    private Nodo fin;

    public ColaClientes() {
        frente = null;
        fin = null;
    }

    // Encolar
    public void agregarCliente(String cliente, String servicio) {

        Nodo nuevo = new Nodo(cliente, servicio);

        if (frente == null) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }

        System.out.println("Cliente agregado a la cola.");
    }

    // Desencolar
    public void atenderCliente() {

        if (frente == null) {
            System.out.println("No hay clientes en espera.");
            return;
        }

        System.out.println("Cliente atendido: "
                + frente.dato
                + " - "
                + frente.detalle);

        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }
    }

    public void mostrarCola() {

        if (frente == null) {
            System.out.println("No hay clientes en espera.");
            return;
        }

        Nodo actual = frente;

        System.out.println("\n--- COLA DE CLIENTES ---");

        while (actual != null) {

            System.out.println("Cliente: "
                    + actual.dato
                    + " | Servicio: "
                    + actual.detalle);

            actual = actual.siguiente;
        }
    }

    public boolean estaVacia() {
        return frente == null;
    }
}
