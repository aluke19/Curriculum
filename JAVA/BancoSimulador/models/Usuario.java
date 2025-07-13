package BancoSimulador.models;

import java.util.ArrayList;
import java.util.List; 


public class Usuario {
    private String nombreUsuario;
    private String password;
    private String numeroCuenta;
    private double saldo;
    private List<String> movimientos;

    public Usuario(String nombreUsuario, String password, String numeroCuenta){
    this.nombreUsuario = nombreUsuario;
    this.password = password;
    this.numeroCuenta = numeroCuenta;
    this.saldo = 0.0;
    this.movimientos = new ArrayList<>();
    }



        //ponemos los getters para poder ver los valores sin dar acceso a modificarlos

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<String> getMovimientos() {
        return movimientos;
    }

    //ingresar dinero y retirar dinero

    public void ingresar(double cantidad) {
        saldo += cantidad;
        movimientos.add("Ingreso: +" + cantidad + "€");
    }

    public boolean retirar(double cantidad) {
        if (cantidad > saldo) {
            return false; //No hay suficiente dinero
        }
        saldo -= cantidad;
        movimientos.add("Retiro: -" + cantidad + "€");
        return true;
        
    }

    public void registrarMovimiento(String movimiento) {
        movimientos.add(movimiento);
    }

}

