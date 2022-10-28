import java.util.*;
import java.util.ArrayList;

public class DiagramaVelocidad {
    ArrayList<Conjunto> listaConjuntos = null;

    /**
     * Constructor
     */
    DiagramaVelocidad() {
        
        ConjuntoTriangular velocidad_NS = new ConjuntoTriangular("NS", -4.0f, -2.0f, 0.0f);
        ConjuntoTriangular velocidad_Z = new ConjuntoTriangular("Z", -2.0f, -0.0f, 2.0f);
        ConjuntoTriangular velocidad_PS = new ConjuntoTriangular("PS", 0.0f, 2.0f, 4.0f);
        ConjuntoTrapezoidal velocidad_NL = new ConjuntoTrapezoidal("NL", -Float.MAX_VALUE, -5.0f, -4.0f, -2.0f);
        ConjuntoTrapezoidal velocidad_PL = new ConjuntoTrapezoidal("PL", 2.0f, 4.0f, 5.0f, Float.MAX_VALUE);
        listaConjuntos = new ArrayList<Conjunto>();        
        listaConjuntos.add(velocidad_NS);
        listaConjuntos.add(velocidad_Z);
        listaConjuntos.add(velocidad_PS);
        listaConjuntos.add(velocidad_NL);
        listaConjuntos.add(velocidad_PL);
    }

    /**
     * Halla los dos intervalos a los que pertenece el punto
     * "position" y su grado de pertenencia. 
     * Se retorna en una lista de ArrayList<IntervaloPertenencia>
     */
    public ArrayList<IntervaloPertenencia> hallarPertenencia(Float position) {
        Integer count = 0;
        ArrayList<IntervaloPertenencia> lista = new ArrayList<IntervaloPertenencia>();
        for (int i = 0; i < listaConjuntos.size(); i++) {
            Conjunto conj = listaConjuntos.get(i);
            if ( conj.obtenerA() <= position && position <= conj.obtenerB() ) {
                lista.add(new IntervaloPertenencia( conj.obtenerName(), conj.calcularMembership(position)));
            }
        }
        return lista;
    }

}