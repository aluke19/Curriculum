package BancoSimulador.servicios;

import java.util.ArrayList;
import java.util.List;
import BancoSimulador.models.Usuario;

public class Banco {
    private List<Usuario> usuarios;

    public Banco() {
        this.usuarios = new ArrayList<>();
    }

    
    public boolean registrarUsuario(String nombreUsuario, String password, String numeroCuenta){
        if (buscarUsuario(nombreUsuario) != null) {
            return false; //Ya existe el usuario
        }

        Usuario nuevo = new Usuario(nombreUsuario, password, numeroCuenta);
        usuarios.add(nuevo);
        return true;
    }

    public Usuario buscarUsuario(String nombreUsuario) {
        for (Usuario u : usuarios) {
            if (u.getNombreUsuario().equals(nombreUsuario)) {
                return u;
            }
        }
        return null;
    }

    public Usuario login(String nombreUsuario, String password) {
        for (Usuario u : usuarios) {
            if (u.getNombreUsuario().equals(nombreUsuario) && u.getPassword().equals(password)) {
                return u; //usuario correcto
            }
        }
        return null; // usuario o contraseña incorrecto
    }

    public boolean transferir(Usuario origen, String destinoNombre, double cantidad) {
        Usuario destino = buscarUsuario(destinoNombre);
        if (destino == null || origen.getSaldo() < cantidad) {
            return false;
        }

        origen.retirar(cantidad);
        destino.ingresar(cantidad);

        origen.registrarMovimiento("Transferencia a " + destinoNombre + ": -" + cantidad + "€");
        destino.registrarMovimiento("Transferencia de " + origen.getNombreUsuario() + ": +" + cantidad + "€");

        return true;
    }

}
