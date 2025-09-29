package CooperativaAhorros.model;

// La clase Deposito implementa la interfaz Transaccion.
public class Deposito implements Transaccion {

// Encapsulamiento: Los atributos son private, lo que significa que solo la clase Deposito puede acceder directamente a ellos.
    private Cuenta cuenta;
    private double monto;

    public Deposito(Cuenta cuenta, double monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }

    // polimorfismo: cualquier Transaccion puede ejecutar su lógica específica
    @Override
    public void ejecutar() {
        cuenta.depositar(monto);
        System.out.println("✅ Depósito realizado: " + monto);
    }

    @Override
    public double getMonto() {
        return monto;
    }

    @Override
    public String getTipo() {
        return "Depósito";
    }
}
