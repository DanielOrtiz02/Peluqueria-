
package peluqueria;


public class Nodo {
    
    String dato;
    String detalle;
    int prioridad;
    Nodo siguiente;
    
    public Nodo(String dato, String detalle) {
        this.dato = dato;
        this.detalle = detalle;
        this.siguiente = null;
    }
    public Nodo (String dato, String detalle, int prioridad){
        this.dato = dato;
        this.detalle = detalle;
        this.prioridad = prioridad;
        this.siguiente = null;
    }
    
}
