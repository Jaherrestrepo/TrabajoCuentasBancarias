package CooperativaAhorros.model;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cooperativa {
    private String nombre;
    private List<Socio> socios;

    public Cooperativa(String nombre) {
        this.nombre = nombre;
        this.socios = new ArrayList<>();
    }

    // Método para registrar un nuevo socio
    public void registrarSocio(Socio socio) {
        socios.add(socio);
        System.out.println("✅ Socio registrado: " + socio.getNombre());
    }

    // Método clásico para listar socios
    public void listarSocios() {
        System.out.println("📋 Lista de socios en " + nombre + ":");
        socios.forEach(socio -> System.out.println("- " + socio.getId() + " | " + socio.getNombre()));
    }

    // ============================================
    // 🚀 Programación funcional con streams
    // ============================================

    // 1) Listar socios registrados con stream()
    public void listarSociosStream() {
        System.out.println("📋 Lista de socios (con stream):");
        socios.stream()
                .map(s -> s.getId() + " | " + s.getNombre())
                .forEach(System.out::println);
    }

    // 2) Filtrar cuentas con saldo mayor a un valor específico
    public List<Cuenta> filtrarCuentasPorSaldo(double minimo) {
        return socios.stream()
                .flatMap(s -> s.getCuentas().stream()) // juntar todas las cuentas de todos los socios
                .filter(c -> c.getSaldo() > minimo)    // condición de saldo
                .collect(Collectors.toList());
    }

    // 3) Obtener la suma total de saldos de la cooperativa
    public double obtenerSaldoTotal() {
        return socios.stream()
                .flatMap(s -> s.getCuentas().stream())
                .mapToDouble(Cuenta::getSaldo)
                .sum();
    }

    public List<Socio> getSocios() {
        return socios;
    }
}
