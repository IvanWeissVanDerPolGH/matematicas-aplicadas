import java.util.*;
import java.util.ArrayList;

public class DiagramaDistancia {
    ArrayList<Conjunto> listaConjuntos = null;

    /**
     * Constructor
     */
    DiagramaDistancia() {
        
        ConjuntoTriangular distancia_NS = new ConjuntoTriangular("NS", -0.5f, -0.25f, 0.0f);
        ConjuntoTriangular distancia_Z = new ConjuntoTriangular("Z", -0.25f, -0.0f, 0.25f);
        ConjuntoTriangular distancia_PS = new ConjuntoTriangular("PS", -0.0f, -0.25f, 0.5f);
        ConjuntoTrapezoidal distancia_NL = new ConjuntoTrapezoidal("NL", -Float.MAX_VALUE, -0.75f, -0.5f, -0.25f);
        ConjuntoTrapezoidal distancia_PL = new ConjuntoTrapezoidal("PL", 0.25f, 0.5f, 0.75f, Float.MAX_VALUE);
        listaConjuntos = new ArrayList<Conjunto>();        
        listaConjuntos.add(distancia_NS);
        listaConjuntos.add(distancia_Z);
        listaConjuntos.add(distancia_PS);
        listaConjuntos.add(distancia_NL);
        listaConjuntos.add(distancia_PL);
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