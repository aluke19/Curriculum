package MiniGestor;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorUsuarios {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        int option;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Mostrar usuarios");
            System.out.println("3. Eliminar usuario");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // limpiar salto de linea

            switch (option) {
                case 1:
                    addUser();
                    break;
                case 2:
                    showUsers();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (option != 0);
    }

    public void addUser() {
        System.out.println("Introduce el nombre del usuario: ");
        String nombre = scanner.nextLine();

        System.out.println("Introduce el email del usuario: ");
        String email = scanner.nextLine();

        Usuario nuevo = new Usuario(nombre, email);
        usuarios.add(nuevo);

        System.out.println("Usuario añadido correctamente.");
        
    }

    public void showUsers() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("\n📋 Lista de usuarios:");
            for (int i = 0; i < usuarios.size(); i++) {
                Usuario u = usuarios.get(i);
                System.out.println((i + 1) + ". " + u.getNombre() + " - " + u.getEmail());
            }
        }
    }

    public void deleteUser() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios para eliminar.");
            return;
        }

        showUsers(); //Enseña lo usuarios primero

        System.out.println("Introduce el numero de usuario para eliminar: ");
        scanner.nextLine(); //Limpia el salto de linea

        if (indice < 1 || idice > usuarios.size()) {
            System.out.println("Número invalido.");
        } else {
            Usuario eliminado = usuarios.remove(indice -1); //quitamos el usuario
            System.out.println("Usuario eliminado: " + eliminado.getNombre);
        }


    }
}
