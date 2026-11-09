package peluqueria;

public class Peluqueria {
    static String[] servicios = {
            "Corte básico",
            "Corte más barba",
            "Corte más cejas",
            "Corte, barba y cejas",
            "Cera",
            "Polvos de textura",
            "Queratina",
            "Tintura",
            "Queratina pelo largo",
            "Tintura pelo largo"
    };
    static int[] precios = {
            15000, // Corte básico
            20000, // Corte más barba
            20000, // Corte con cejas
            23000, // Corte, barba y cejas
            25000, // Cera
            20000, // Polvos de textura
            100000, // Queratina
            120000, // Tintura
            150000, // Queratina pelo largo
            180000 // Tintura pelo largo
    };
    static String[] peluqueros = { "Peluquero-1", "Peluquero-2", "Peluquero-3", "Peluquero-4" };
    static String[] horas = { "8AM", "9AM", "10AM", "11AM", "12PM",
            "1PM", "2PM", "3PM", "4PM", "5PM", "6PM", "7PM" };

    static boolean[][] horarios = new boolean[4][12];

    public static void ordenarServicios(String[] servicios, int[] precios) {
        int n = precios.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (precios[j] > precios[j + 1]) {
                    // Intercambio de precios
                    int tempPrecio = precios[j];
                    precios[j] = precios[j + 1];
                    precios[j + 1] = tempPrecio;

                    // Intercambio del nombre de servicio para que corresponda al del precio
                    String tempServicio = servicios[j];
                    servicios[j] = servicios[j + 1];
                    servicios[j + 1] = tempServicio;
                }
            }
        }
    }

    public static void mostrarCatalogo(String[] servicios, int[] precios) {
        System.out.println("\n--- CATÁLOGO DE SERVICIOS ---");
        for (int i = 0; i < servicios.length; i++) {
            System.out.println((i + 1) + ". " + servicios[i] + " - $" + precios[i]);
        }
    }

    public static void mostrarHorarios() {
        System.out.println("\n   HORARIOS DISPONIBLES   ");
        System.out.print("Peluquero\t");
        for (String h : horas) {
            System.out.print(h + "\t");
        }
        System.out.println();

        for (int i = 0; i < peluqueros.length; i++) {
            System.out.print(peluqueros[i] + "\t");
            for (int j = 0; j < horas.length; j++) {
                if (horarios[i][j]) {
                    System.out.print("Ocupado\t"); 
                } else {
                    System.out.print("Libre\t"); 
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
    }

}
