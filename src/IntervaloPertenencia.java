
/**
 * Representa el intervalo al que pertenece un punto y el grado de 
 * pertenencia que tiene en ese intervalo.
 */
public class IntervaloPertenencia {
    public String name = null;
    public Float membership = null;

    /**
     * Constructor
     */
    IntervaloPertenencia(String name, Float membership) {
        this.name = name;
        this.membership = membership;
    }
}