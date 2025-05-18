
package com.mycompany.p1activ3cevallosbryan;
import java.util.Scanner;

public class P1Activ3CevallosBryan {
    public static void main(String[] args) {
        GestorInventario gestor = new GestorInventario();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENU DE INVENTARIO =====");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Guardar en CSV");
            System.out.println("4. Guardar en JSON");
            System.out.println("5. Leer desde CSV (cargar al sistema)");
            System.out.println("6. Ver contenido del CSV");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> gestor.agregarItem();
                case 2 -> gestor.mostrarInventario();
                case 3 -> gestor.guardarEnCSV("inventario.csv");
                case 4 -> gestor.guardarEnJSON("inventario.json");
                case 5 -> gestor.leerDesdeCSV("inventario.csv");
                case 6 -> gestor.verContenidoCSV("inventario.csv");
                case 7 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opcion invalida. Intente nuevamente.");
            }
        } while (opcion != 7);

        sc.close();
    }
}