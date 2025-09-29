package CooperativaAhorros.model;


public class CuentaAhorros extends Cuenta {
    private double interes; // porcentaje, ej: 0.05 = 5%

    public CuentaAhorros(String numeroCuenta, double saldo, double interes) {
        super(numeroCuenta, saldo);
        this.interes = interes;
    }

    @Override
    public void retirar(double monto) {
        if (monto > saldo) {
            throw new IllegalArgumentException("Fondos insuficientes en la cuenta.");
        }
        saldo -= monto;
        transacciones.add(new TransaccionSimple("Retiro", monto));
    }

    public void aplicarInteres() {
        double ganancia = saldo * interes;
        saldo += ganancia;
        transacciones.add(new TransaccionSimple("Interés aplicado", ganancia));
    }

    public double getInteres() {
        return interes;
    }
}



