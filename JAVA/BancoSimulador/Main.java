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
            System.out.println("0. Ingresar dinero");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesion");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 0:
                    System.out.println("Cantidad a ingresar: ");
                    double cantidad = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar el buffer
                    try {
                        if cantidad <= 0 {
                            System.err.println("La cantidad debe ser mayor que cero.");
                        } else {
                            System.out.println("Ingrese su nombre de usuario:");    
                            String nombreUsuarioIngreso = scanner.nextLine();
                            Usuario usuarioIngreso = banco.buscarUsuario(nombreUsuarioIngreso);
                            if (usuarioIngreso != null) {
                                usuarioIngreso.ingresar(cantidad);
                                usuarioIngreso.registrarMovimiento("Ingreso: +" + cantidad + "€");
                                System.out.println("Ingreso realizado con éxito. Saldo actual: " + usuarioIngreso.getSaldo() + "€");
                            } else {
                                System.err.println("Usuario no encontrado. Por favor, registrese primero.");
                        }
                    }

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
                            System.out.println("------ MENÚ USUARIO ------ ");
                            System.out.println("1. Ver saldo");
                            System.out.println("2. Ver movimientos");
                            System.out.println("3. Hacer transferencia");
                            System.out.println("4. Cerrar sesión");
                            System.out.print("Elige una opción: ");

                            int opcionUsuario = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer
                            switch (opcionUsuario) {
                                case 1:
                                    System.out.println("Saldo actual: " + loggedUser.getSaldo() + "€");// Ver saldo
                                    break;
                                case 2:
                                    System.out.println("Movimientos:");
                                    for (String mov : loggedUser.getMovimientos()) {
                                        System.out.println("- " + mov);// Ver movimientos
                                }
                                    if (loggedUser.getMovimientos().isEmpty()) {
                                        System.out.println("No hay movimientos registrados.");
                                    }
                                break;
                                case 3:
                                    System.out.println("Ingrese el nombre del usuario destino:");
                                    String destinatario = scanner.nextLine();

                                    System.out.println("Ingrese la cantidad a transferir:");
                                    double cantidad = scanner.nextDouble();
                                    scanner.nextLine(); // Limpiar el buffer
                                    // Hacer transferencia
                                    boolean transferido = banco.transferir(loggedUser, destinatario, cantidad);
                                    if (transferido) {
                                        System.out.println("Transferencia realizada con éxito.");
                                    } else {
                                        System.err.println("Error al realizar la transferencia. Verifique el usuario destino y el saldo disponible.");
                                    }
                                    break;
                                case 4:
                                    loggedIn = false;
                                    System.out.println("Sesión cerrada.");
                                    break;
                                default:
                                    System.err.println("Opción no válida.");
                                    break;
                            }
                        }
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