

public class ConjuntoTrapezoidal  implements Conjunto {
    String name = null;
    Float a = null;
    Float m = null;
    Float n = null;
    Float b = null;

    /**
     * Constructor
     */
    ConjuntoTrapezoidal(String name, Float a, Float m, Float n, Float b) {
        this.name = name;
        this.a = a;
        this.m = m;
        this.n = n;
        this.b = b;
    }

    /**
     * Calcular el valor de pertenencia de una posicion dada
     */
    public Float calcularMembership(Float position) {
        if ( a <= position && position < m) return (position - a)/(m - a);
        else if ( m <= position && position < n ) return 1.0f;
        else if ( n <= position && position <= b ) return (b - position)/(b - n);
        else return 0.0f;
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