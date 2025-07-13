package BancoSimulador;
import BancoSimulador.servicios.Banco;
import BancoSimulador.models.Usuario;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Banco banco = new Banco(); // creamos el banco
        Scanner scanner = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {
            System.out.println("\n------ MENÚ BANCO ------ ");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesion");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce aqui un nombre de usuario");
                    String nombreUsuario = scanner.nextLine();

                    System.out.println("Introduce aqui una contraseña");
                    String password = scanner.nextLine();

                    System.out.println("Introduce aqui un numero de cuenta");
                    String numeroCuenta = scanner.nextLine();

                    boolean registrado = banco.registrarUsuario(nombreUsuario, password, numeroCuenta);
                    if (registrado) {
                        System.out.println("Usuario registrado correctamente.");
                    } else {
                        System.out.println("El usuario ya existe. Elija otro nombre de usuario.");
                    }
                    // aqui se mete el registro
                    break;
            
                case 2:
                    System.err.println("Ingrese su nombre de usuario:");
                    String usuarioLogin = scanner.nextLine();

                    System.out.println("Ingrese su contraseña:");
                    String passwordLogin = scanner.nextLine();

                    Usuario loggedUser = banco.login(usuarioLogin, passwordLogin);

                    if (loggedUser != null) {
                        System.out.println("Bienvenido " + loggedUser.getNombreUsuario()); ///////mas o menos aqui me he quedado para la siguiente vez que entr

                        boolean loggedIn = true;
                        while (loggedIn) {
                            System.out.println();
                    } else {
                        System.err.println("Usuario o contraseña incorrectos.");
                    }

                // aqui el login
                    break;

                case 3:
                    // aqui el login
                    salir = true;
                    System.out.println("¡Gracias por usar el banco!");
                    break;

                default: 
                System.err.println("Opcion no valida");

            }
        }
    }
}