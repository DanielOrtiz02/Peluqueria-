package peluqueria;

public class ListaClientes {

    Nodo cabeza;

    public void AgregarCliente(String cliente, String servicio) {
        Nodo nuevo = new Nodo(cliente, servicio);

        //Si la lista esta vacia,  el nodo new es la cabeeza
        if (cabeza == null) {
            cabeza = nuevo;

        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public void MostrarCliente() {
        if (cabeza == null) {
            System.out.println("No hay clietes en la base. ");
            return;
        }
        Nodo actual = cabeza;
        int i = 1;
        System.out.println(" Historial de clientes ");
        while (actual != null) {
            System.out.println(i + " Cliente: " + actual.siguiente + "Servicio: " + actual.detalle);
            actual = actual.siguiente;
            i++;
        }
    }

    public boolean BuscarCliente(String nombre) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato.equalsIgnoreCase(nombre)) {
                System.out.println(" Cliente encontrado: " + actual.dato + "Servicio " + actual.detalle);
                return true;
            }
            actual = actual.siguiente;
        }
        System.out.println("El clinete no se ha encontrado en el historial.");
        return false;
    }

    public void ElimiarCliente (String nombre) {
        if (cabeza == null) {
            System.out.println("La lista esta vacia ");
            return;
        }
        if (cabeza.dato.equalsIgnoreCase(nombre)) {
            cabeza = cabeza.siguiente;
            System.out.println("Regristo de " + nombre + "eliminado del historial. ");
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.dato.equalsIgnoreCase(nombre)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            System.out.println("Registro de " + nombre + "eliminado del historial.");
        } else {
            System.out.println("No se pued  eliminar ya que el cliente no se encontro.");
        }

    }
}
