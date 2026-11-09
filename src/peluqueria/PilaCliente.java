package peluqueria;

public class PilaCliente {

    private Nodo cima;

    public PilaCliente() {
        cima = null;
    }

    
    public void agregarCliente(String cliente, String servicio, String peluquero, String hora, int indicePeluquero, int indiceHora) {
        Nodo nuevo = new Nodo(cliente, servicio, peluquero, hora, indicePeluquero, indiceHora );

        nuevo.siguiente = cima;
        cima = nuevo;

        
    }

    
    public String atenderUltimoCliente() {
        if (cima == null) {
            System.out.println("La pila está vacía.");
            return null;
        }
        if(cima.indicePeluquero != -1 &&
       cima.indiceHora != -1){

        Peluqueria.horarios[cima.indicePeluquero]
                           [cima.indiceHora] = false;
       }                   

        System.out.println("registro eliminado: "
                + cima.dato + " - "
                + cima.detalle);

        String clienteEliminado = cima.dato;
        cima = cima.siguiente;
        return clienteEliminado;
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
