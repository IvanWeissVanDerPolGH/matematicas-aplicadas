
public class ConjuntoTriangular  implements Conjunto {
    /**
     *  Representacion de una funcion de pertenencia triangular
     */
    String name = null;
    Float a = null;
    Float m = null;
    Float n = null;
    Float b = null;

    /**
     * Constructor
     */
    ConjuntoTriangular(String name, Float a, Float m, Float b) {
        this.name = name;
        this.a = a;
        this.m = m;
        this.b = b;
    }

    /***
     * Calcular el valor de pertenencia de una posicion dada
     */
    public Float calcularMembership(Float position) {
        if (a < position && position < m) return (position - a)/(m - a);
        else if (m <= position && position <= b) return (b-position)/(b-m);
        else return 0.0f; // Caso position <= a y position >= b
    }

    public Float obtenerA() {
        return a;
    }

    public Float obtenerB() {
        return b;
    }

    public String obtenerName() {
        return name;
    }
}
