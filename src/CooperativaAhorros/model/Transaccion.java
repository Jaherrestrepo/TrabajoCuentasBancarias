
// el paquete donde se encuentra la interfaz.
package CooperativaAhorros.model;



// Define un contrato que cualquier clase puede implementar
// No tiene implementación de métodos, solo la firma (nombre, parámetros y tipo de retorno).
public interface Transaccion {

    // Declaración de un método abstracto que debe ser implementado por cualquier clase que implemente Transaccion
    void ejecutar();
    double getMonto();
    // Método abstracto que devuelve el tipo de transacción (“Depósito”, “Retiro”, etc.)
    String getTipo();
}


