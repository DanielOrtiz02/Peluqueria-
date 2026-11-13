package peluqueria;

public class ColaCliente {

    private Nodo frente;
    private Nodo fin;

    public ColaCliente() {
        frente = null;
        fin = null;
    }

    // Agregamos un cliente a la cola 
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

    // sacamos el cliente de la cola al ser atendido 
    public String atenderCliente() {

    if (frente == null) {
        System.out.println("No hay clientes en espera.");
        return null; 
    }

    System.out.println("Cliente atendido: "
            + frente.dato
            + " - "
            + frente.detalle);

    // guarda el nombre antes de borrarlo de la cola
    String nombreCliente = frente.dato; 

    frente = frente.siguiente;

    if (frente == null) {
        fin = null;
    }
    
    // devolver nombre
    return nombreCliente; 
}
  //mostrar los clientes los cuales estan en la cola 
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
    public boolean eliminarCliente(String nombre) {
    Nodo anterior = null;
    Nodo actual = frente;

    while (actual != null && !actual.dato.equalsIgnoreCase(nombre)) {
        anterior = actual;
        actual = actual.siguiente;
    }

    if (actual == null) {
        return false; // No estaba en la cola, por ejemplo, si ya fue atendido.
    }

    if (anterior == null) {
        frente = actual.siguiente; // El cliente estaba al frente.
    } else {
        anterior.siguiente = actual.siguiente;
    }

    if (actual == fin) {
        fin = anterior; // El cliente estaba al final.
    }

    return true;
}
    public boolean estaVacia() {
        return frente == null;
    }
}
