package org.example.UnitTest;

import org.example.Models.AutorModel;
import org.example.Entities.Autor;

import java.util.ArrayList;
import java.util.Scanner;


public class UnitTestAutor {



    public static ArrayList<Autor> resultados;
    private AutorModel autorModel;
    private Scanner scanner;

    public UnitTestAutor() {
        autorModel = new AutorModel();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Bienvenido a la interfaz de gestión de Autores.");

        boolean continuar = true;
        do {
            mostrarMenu();
            int opcion = obtenerOpcion();
            switch (opcion) {
                case 1:
                    buscarAutor();
                    break;
                case 2:
                    agregarAutor();
                    break;
                case 3:
                    actualizarAutor();
                    break;
                case 4:
                    eliminarAutor();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (continuar);

        System.out.println("Gracias por usar la interfaz de gestión de Autores. ¡Hasta luego!");
    }

    private void mostrarMenu() {
        System.out.println("\nPor favor, seleccione una opción:");
        System.out.println("1. Buscar autor");
        System.out.println("2. Agregar nuevo autor");
        System.out.println("3. Actualizar autor existente");
        System.out.println("4. Eliminar autor");
        System.out.println("5. Salir");
    }

    private int obtenerOpcion() {
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    private void buscarAutor() {
        scanner.nextLine(); // Consumir la nueva línea después de leer el número
        System.out.print("Ingrese la cadena de búsqueda: ");
        String searchString = scanner.nextLine();
        resultados = autorModel.get(searchString);
        mostrarResultados(resultados);
    }

    private void agregarAutor() {
        scanner.nextLine(); // Consumir la nueva línea después de leer el número
        System.out.println("Ingrese los detalles del nuevo autor:");
        System.out.print("ID: ");
        String auId = scanner.nextLine();
        System.out.print("Apellido: ");
        String auLname = scanner.nextLine();
        System.out.print("Nombre: ");
        String auFname = scanner.nextLine();
        System.out.print("Teléfono: ");
        String phone = scanner.nextLine();
        System.out.print("Dirección: ");
        String address = scanner.nextLine();
        System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("State: ");
        String state = scanner.nextLine();
        System.out.print("Zip: ");
        String zip = scanner.nextLine();
        System.out.print("Contract: ");
        int contract = scanner.nextInt();



        Autor nuevoAutor = new Autor(auId,auLname,auFname,phone,address,city,state,zip,contract);
        boolean exito = autorModel.post(nuevoAutor);
        if (exito) {
            System.out.println("Autor agregado exitosamente.");
        } else {
            System.out.println("Error al agregar el autor.");
        }
    }

    private void actualizarAutor() {
        scanner.nextLine(); // Consumir la nueva línea después de leer el número
        System.out.println("Ingrese el ID del autor que desea actualizar:");
        String findId=scanner.nextLine();
        ArrayList<Autor> autores = autorModel.get(findId);
        Autor autor=autores.get(0);
        System.out.println("Ingrese el campo que desea actualizar (au_lname, au_fname, phone, address, city, state, zip, contract):");
        String campo = scanner.nextLine();
        System.out.println("Ingrese el nuevo valor:");
        String valor = scanner.nextLine();

        boolean exito = autorModel.put(autor, campo, valor);
        if (exito) {
            System.out.println("Autor actualizado exitosamente.");
        } else {
            System.out.println("Error al actualizar el autor.");
        }
    }

    private void eliminarAutor() {
        scanner.nextLine(); // Consumir la nueva línea después de leer el número
        System.out.println("Ingrese el ID del autor que desea eliminar:");
        String auId = scanner.nextLine();

        boolean exito = autorModel.delete(auId);
        if (exito) {
            System.out.println("Autor eliminado exitosamente.");
        } else {
            System.out.println("Error al eliminar el autor.");
        }
    }

    private void mostrarResultados(ArrayList<Autor> resultados) {
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron resultados para la búsqueda especificada.");
        } else {
            System.out.println("Resultados de la búsqueda:");
            for (Autor autor : resultados) {
                System.out.println(autor);
            }
        }
    }
}



