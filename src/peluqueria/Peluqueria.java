package peluqueria;

import java.util.Scanner;

public class Peluqueria {
    static Scanner sc = new Scanner(System.in);
    static String[] servicios = {
            "Corte básico",
            "Corte más barba",
            "Corte más cejas",
            "Corte, barba y cejas",
            "Cera",
            "Polvos de textura",
            "keratina",
            "Tintura",
            "keratina pelo largo",
            "Tintura pelo largo"
    };
    static int[] precios = {
            15000, // Corte básico
            20000, // Corte más barba
            20000, // Corte con cejas
            23000, // Corte, barba y cejas
            25000, // Cera
            20000, // Polvos de textura
            100000, // keratina
            120000, // Tintura
            150000, // keratina pelo largo
            180000 // Tintura pelo largo
    };
    static String[] peluqueros = { "Brayan", "Chirly", "Javi", "Kevin" };
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
            System.out.print(peluqueros[i] + "\t\t");

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

    public static void mostrarMenu(Scanner sc, ListaClientes historial,
            ColaCliente colaEspera, PilaCliente pilaDeshacer, ListaCircular rotacion) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ PELUQUERÍA ---");
            System.out.println("1. Ver Catálogo (Ordenado)");
            System.out.println("2. Ver Horarios de Peluqueros");
            System.out.println("3. Registrar Cliente / Venta");
            System.out.println("4. Atender Siguiente Cliente");
            System.out.println("5. Deshacer Último Registro");
            System.out.println("6. Ver Historial de Clientes");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");


            int opcion = -1; 
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
            }else {
                System.out.println("\n[!] Error: Debes ingresar un número válido (del 1 al 7). No letras ni símbolos.");            
                sc.next();
                continue;

            switch (opcion) {
                case 1:
                    ordenarServicios(servicios, precios);
                    mostrarCatalogo(servicios, precios);
                    break;
                case 2:
                    mostrarHorarios();
                    break;
                case 3:
                    System.out.print("Nombre del cliente: ");
                    String nombre = sc.nextLine();
                    System.out.println("1. Servicio (Requiere peluquero) | 2. Producto");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    if (!sc.hasNextInt()) {
                        System.out.println("[!] Entrada inválida. Cancelando registro.");
                        sc.next();
                        break;
                    }
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Escribe lo que desea: ");
                    String detalle = sc.nextLine();

                    if (tipo == 1) {
                        String pAsignado = rotacion.asignarSiguientePeluquero();
                        System.out.println("Asignado a: " + pAsignado);
                        colaEspera.agregarCliente(nombre, detalle);
                    } else {
                        System.out.println("Venta de producto registrada.");
                        historial.AgregarCliente(nombre, detalle);
                    }
                    break;
                case 4:
                    colaEspera.atenderCliente();
                    break;
                case 5:
                    pilaDeshacer.atenderUltimoCliente();
                    break;
                case 6:
                    historial.MostrarCliente();
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void main(String[] args) {

        ListaClientes historial = new ListaClientes();
        ColaCliente colaEspera = new ColaCliente();
        PilaCliente pilaDeshacer = new PilaCliente();
        ListaCircular rotacion = new ListaCircular();

        rotacion.agregarPeluquero("Brayan");
        rotacion.agregarPeluquero("Chirly");
        rotacion.agregarPeluquero("Javi");
        rotacion.agregarPeluquero("Kevin");
        mostrarMenu(sc, historial, colaEspera, pilaDeshacer, rotacion);
    }

}
