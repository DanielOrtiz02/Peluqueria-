
package peluqueria;


public class Nodo {
    
    String dato;
    String detalle;

    String peluquero;
    String hora;

    int indicePeluquero;
    int indiceHora;

    
    Nodo siguiente;
    
    public Nodo(String dato, String detalle) {
        this.dato = dato;
        this.detalle = detalle;
        this.siguiente = null;
    }
    public Nodo (String dato, String detalle, String peluquero, String hora, int indicePeluquero, int indiceHora){
        this.dato = dato;
        this.detalle = detalle;
        
        this.peluquero = peluquero;
        this.hora = hora;

        this.indicePeluquero = indicePeluquero;
        this.indiceHora = indiceHora;
        
        this.siguiente = null;
    }
     
    }

    
