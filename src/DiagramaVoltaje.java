import java.util.*;
import java.util.ArrayList;

public class DiagramaVoltaje {
    ArrayList<ConjuntoVoltaje> listaConjuntos = null;

    /**
     * Constructor
     */
    DiagramaVoltaje() {
        listaConjuntos = new ArrayList<ConjuntoVoltaje>();        
        listaConjuntos.add(new ConjuntoVoltaje("NL", -10.0f));
        listaConjuntos.add(new ConjuntoVoltaje("NS", -5.0f));
        listaConjuntos.add(new ConjuntoVoltaje("Z", 0.0f));
        listaConjuntos.add(new ConjuntoVoltaje("PS", 5.0f));
        listaConjuntos.add(new ConjuntoVoltaje("PL", 10.0f));
    }

    /**
     * Retorna el valor del conjunto con el nombre "name"
     */
    public Float hallarValue(String name) {
        for (int i = 0; i < listaConjuntos.size(); i++) {
            ConjuntoVoltaje conj = listaConjuntos.get(i);
            if ( conj.name == name ) {
               return conj.value;
            }
        }
        return -15.0f;
    }

}