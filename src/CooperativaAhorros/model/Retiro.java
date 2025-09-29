
// define el paquete donde se encuentra la clase. Sirve para organizar el código y controlar visibilidad entre módulos.
package CooperativaAhorros.model;


// La clase Retiro implementa la interfaz Transaccion
public class Retiro implements Transaccion {

    // (encapsulamiento): no accesibles desde fuera de la clase, protegiendo el estado interno.
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
