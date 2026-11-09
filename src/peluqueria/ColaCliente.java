package peluqueria;

public class ColaCliente {

    private Nodo frente;
    private Nodo fin;

    public ColaClientes() {
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

    // Sacamos al cliente de la cola ya que este va a ser atendido 
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

    public boolean estaVacia() {
        return frente == null;
    }
}
