package peluqueria;

public class ListaCircular {
    private Nodo frente;
    private Nodo fin;
    private Nodo actual; 

    public void agregarPeluquero(String nombre) {
        Nodo nuevo = new Nodo(nombre, "Peluquero");
        if (frente == null) {
            frente = nuevo;
            fin = nuevo;
            nuevo.siguiente = frente; 
            actual = frente;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
            fin.siguiente = frente; //pasa del ultimo al primero
        }
    }

    public String asignarSiguientePeluquero() {
        if (frente == null) {
            return "No hay peluqueros registrados.";
        }
        String peluqueroAsignado = actual.dato;
        actual = actual.siguiente; // mover el turno al siguiente peluquero
        return peluqueroAsignado;
    }

    public void mostrarPeluqueros() {
        if (frente == null) return;
        Nodo temp = frente;
        System.out.println("\n--- PELUQUEROS EN ROTACIÓN ---");
        do {
            System.out.println("- " + temp.dato);
            temp = temp.siguiente;
        } while (temp != frente);
    }
}
