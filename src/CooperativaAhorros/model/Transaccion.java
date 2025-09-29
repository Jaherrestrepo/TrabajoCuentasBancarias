package CooperativaAhorros.model;




public interface Transaccion {
    void ejecutar();
    double getMonto();
    String getTipo();
}


