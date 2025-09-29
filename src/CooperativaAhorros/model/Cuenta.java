package CooperativaAhorros.model;

import java.util.ArrayList;
import java.util.List;

// abstract indica que Cuenta define comportamiento/contrato común pero no puede instanciarse
public abstract class Cuenta {
    protected String numeroCuenta;
    protected double saldo;
    protected List<Transaccion> transacciones;

    public Cuenta(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.transacciones = new ArrayList<>();
    }
//getter: patrón clásico de encapsulación (aunque aquí devuelve referencia directa).
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

    // contrato que obliga a cada subclase a implementar la lógica de retiro (p. ej. chequeo de sobregiro, cobro de comisión). Aquí hay polimorfismo: distintas cuentas pueden retirar con reglas distintas.
    public abstract void retirar(double monto);

    // polimorfismo: sobrescribe toString() para depuración/representación
    @Override
    public String toString() {
        return numeroCuenta + " | Saldo: " + saldo;
    }
}
