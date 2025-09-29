package CooperativaAhorros.model;



public class Retiro implements Transaccion {
    private Cuenta cuenta;
    private double monto;

    public Retiro(Cuenta cuenta, double monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }

    @Override
    public void ejecutar() {
        try {
            cuenta.retirar(monto);
            System.out.println("💸 Retiro realizado: " + monto);
        } catch (Exception e) {
            System.out.println("⚠️ Error en el retiro: " + e.getMessage());
        }
    }

    @Override
    public double getMonto() {
        return monto;
    }

    @Override
    public String getTipo() {
        return "Retiro";
    }
}
