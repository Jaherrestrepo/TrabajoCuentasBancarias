package CooperativaAhorros.model;

public class TransaccionSimple implements Transaccion {

    private String tipo;
    private double monto;

    public TransaccionSimple(String tipo, double monto) {
        this.tipo = tipo;
        this.monto = monto;
    }

    @Override
    public void ejecutar() {
        // No altera saldo; solo sirve como registro en el historial.
        // Puedes dejarlo vacío o imprimir algo:
        // System.out.println("Registro: " + tipo + " $" + monto);
    }

    @Override
    public double getMonto() {
        return monto;
    }

    @Override
    public String getTipo() {
        return tipo;
    }
}
