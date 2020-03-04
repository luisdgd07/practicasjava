
package asignacion1;

/**
 *
 * @author Gonzalez Duerto
 */
public interface Entregable {
    
    void entregar(boolean prestado);
    void devolver(int i);
    boolean isEntregado(int i);
}
