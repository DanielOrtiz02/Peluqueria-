package peluqueria;

public class PilaCliente {

    private Nodo cima;

    public PilaCliente() {
        cima = null;
    }

    
    public void agregarCliente(String cliente, String servicio) {
        Nodo nuevo = new Nodo(cliente, servicio);

        nuevo.siguiente = cima;
        cima = nuevo;

        System.out.println("Cliente agregado a la pila.");
    }

    
    public void atenderUltimoCliente() {
        if (cima == null) {
            System.out.println("La pila está vacía.");
            return;
        }

        System.out.println("Cliente atendido: "
                + cima.dato + " - "
                + cima.detalle);

        cima = cima.siguiente;
    }

    public void mostrarPila() {

        if (cima == null) {
            System.out.println("La pila está vacía.");
            return;
        }

        Nodo actual = cima;

        System.out.println("\n--- PILA DE CLIENTES ---");

        while (actual != null) {
            System.out.println("Cliente: "
                    + actual.dato
                    + " | Servicio: "
                    + actual.detalle);

            actual = actual.siguiente;
        }
    }

    public boolean estaVacia() {
        return cima == null;
    }
}
