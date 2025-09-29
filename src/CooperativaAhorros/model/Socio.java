package CooperativaAhorros.model;

// importa colecciones de Java. List es la interfaz y ArrayList su implementación
import java.util.ArrayList;
import java.util.List;

public class Socio {

    // encapsulamiento protege los datos internos, no pueden ser modificados desde fuera de la clase.
    private String id;
    private String nombre;
    private List<Cuenta> cuentas;

    public Socio(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.cuentas = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    // 🚨 Validar que no se repitan los números de cuenta
    public void agregarCuenta(Cuenta cuenta) {
        boolean existe = cuentas.stream()
                .anyMatch(c -> c.getNumeroCuenta().equals(cuenta.getNumeroCuenta()));

        if (existe) {
            throw new IllegalArgumentException("El socio " + nombre +
                    " ya tiene una cuenta con número " + cuenta.getNumeroCuenta());
        } else {
            cuentas.add(cuenta);
            System.out.println("✅ Cuenta " + cuenta.getNumeroCuenta() +
                    " registrada al socio " + nombre);
        }
    }


    @Override
    public String toString() {
        return id + " | " + nombre;
    }
}
