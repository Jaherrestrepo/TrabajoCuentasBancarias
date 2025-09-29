package CooperativaAhorros.service;


import CooperativaAhorros.model.Cuenta;
import CooperativaAhorros.model.Transaccion;

import java.util.List;
import java.util.stream.Collectors;

public class CuentaService {

    public void imprimirHistorial(Cuenta cuenta) {
        cuenta.getTransacciones().forEach(System.out::println);
    }

    public List<Transaccion> obtenerDepositos(Cuenta cuenta) {
        return cuenta.getTransacciones()
                .stream()
                .filter(t -> t.getTipo().equals("Depósito"))
                .collect(Collectors.toList());
    }

    public double calcularTotalRetiros(Cuenta cuenta) {
        return cuenta.getTransacciones()
                .stream()
                .filter(t -> t.getTipo().equals("Retiro"))
                .mapToDouble(Transaccion::getMonto)
                .sum();
    }
}

