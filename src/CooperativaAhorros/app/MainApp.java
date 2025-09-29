package CooperativaAhorros.app;

import CooperativaAhorros.model.*;


import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        // Crear la cooperativa
        Cooperativa coop = new Cooperativa("CoopRKC");

        Random random = new Random();

        // ===============================
        // 1) Registrar 20 socios con cuentas y nombres reales
        // ===============================
        String[] nombres = {
                "Ana Torres", "Carlos López", "María Gómez", "Juan Rodríguez",
                "Laura Martínez", "Pedro Sánchez", "Sofía Ramírez", "Andrés Pérez",
                "Valentina Morales", "Felipe Castro", "Camila Herrera", "Julián Vargas",
                "Isabella Ríos", "Santiago Jiménez", "Gabriela Mendoza", "Mateo Duarte",
                "Daniela Fernández", "Esteban Silva", "Natalia Cárdenas", "Ricardo Ortega"
        };

        for (int i = 0; i < nombres.length; i++) {
            String id = String.format("%03d", i + 1);
            Socio socio = new Socio(id, nombres[i]);

            // abrir una cuenta de ahorro con saldo inicial aleatorio
            double saldoInicial = 100000 + random.nextInt(900000); // entre 100k y 1M
            CuentaAhorros cuenta = new CuentaAhorros("CTA" + (i + 1), saldoInicial, 0.05);

            socio.agregarCuenta(cuenta);
            coop.registrarSocio(socio);
        }

        // ===============================
        // 2) Operaciones de depósito y retiro en una cuenta
        // ===============================
        Socio socioEjemplo = coop.getSocios().get(0);
        CuentaAhorros cuentaEjemplo = (CuentaAhorros) socioEjemplo.getCuentas().get(0);

        cuentaEjemplo.depositar(50000);
        try {
            cuentaEjemplo.retirar(20000);
            cuentaEjemplo.retirar(2000000); // provoca error
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }

        // ===============================
        // 3) Aplicar interés a todas las cuentas
        // ===============================
        coop.getSocios().forEach(s ->
                s.getCuentas().forEach(c -> {
                    if (c instanceof CuentaAhorros ca) {
                        ca.aplicarInteres();
                    }
                })
        );

        // ===============================
        // 4) Programación funcional
        // ===============================

        // a) Listar nombres de todos los socios
        System.out.println("\n👥 Lista de socios:");
        coop.getSocios().stream()
                .map(Socio::getNombre)
                .forEach(System.out::println);

        // b) Filtrar cuentas con saldo mayor a $500000
        System.out.println("\n💰 Cuentas con saldo > 500000:");
        coop.getSocios().stream()
                .flatMap(s -> s.getCuentas().stream())
                .filter(c -> c.getSaldo() > 500000)
                .forEach(c -> System.out.println(c.getNumeroCuenta() + " | Saldo: " + c.getSaldo()));

        // c) Calcular el total de dinero en la cooperativa usando reduce()
        double totalFondos = coop.getSocios().stream()
                .flatMap(s -> s.getCuentas().stream())
                .map(Cuenta::getSaldo)
                .reduce(0.0, Double::sum);

        System.out.println("\n💲 Total de dinero en la cooperativa: " + totalFondos);
    }
}

