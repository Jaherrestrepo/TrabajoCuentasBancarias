package CooperativaAhorros.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Cuenta {
    protected String numeroCuenta;
    protected double saldo;
    protected List<Transaccion> transacciones;

    public Cuenta(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.transacciones = new ArrayList<>();
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void depositar(double monto) {
        saldo += monto;
        transacciones.add(new TransaccionSimple("Depósito", monto));
    }

    // Método abstracto que se implementa en las subclases
    public abstract void retirar(double monto);

    @Override
    public String toString() {
        return numeroCuenta + " | Saldo: " + saldo;
    }
}
