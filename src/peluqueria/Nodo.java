
package peluqueria;


public class Nodo {
    
    String dato;
    String detalle;

    String peluquero;
    String hora;

    int prioridad;
    Nodo siguiente;
    
    public Nodo(String dato, String detalle) {
        this.dato = dato;
        this.detalle = detalle;
        this.siguiente = null;
    }
    public Nodo (String dato, String detalle, String peluquero, String hora){
        this.dato = dato;
        this.detalle = detalle;
        this.peluquero = peluquero;
        this.hora = hora;
        this.siguiente = null;
    }
      public Nodo(String dato,
                String detalle,
                int prioridad) {

        this.dato = dato;
        this.detalle = detalle;
        this.prioridad = prioridad;
        this.siguiente = null;
    }
}
    
