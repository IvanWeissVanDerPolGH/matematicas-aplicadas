import java.util.ArrayList;

public class Fuzzyficador {
     /**
     * La matriz de reglas tiene como conjuntos columnas las velocidades
     * y como conjuntos filas las distancias.
     */
    public String[][] matrizReglas = { {"NL", "NL", "NL", "NS", "Z"},
                            {"NL", "NL", "NS", "Z", "PS"},
                            {"NL", "NS", "Z", "PS", "PL"},
                            {"NS", "Z", "PS", "PL", "PL"},
                            {"Z", "PS", "PL", "PL", "PL"}
                        };
    public String[] ordenConjuntos = {"NL", "NS", "Z", "PS", "PL"};

    public ArrayList<ReglasInferencia> fuzzyficar(Float distancia, Float velocidad) {
        DiagramaDistancia dist = new DiagramaDistancia();
        DiagramaVelocidad vel = new DiagramaVelocidad();

        ArrayList<IntervaloPertenencia> respuestaDistancia = dist.hallarPertenencia(distancia);
        ArrayList<IntervaloPertenencia> respuestaVelocidad = vel.hallarPertenencia(velocidad);

        System.out.println("---------------------------------------------------------------");
        System.out.println("|                      PARA LA DISTANCIA                      |");
        System.out.println("---------------------------------------------------------------");        
        imprimirLista(respuestaDistancia);

        System.out.println("---------------------------------------------------------------");
        System.out.println("|                      PARA LA VELOCIDAD                      |");
        System.out.println("---------------------------------------------------------------");
        imprimirLista(respuestaVelocidad);

        ArrayList<ReglasInferencia> inferencias = analizarReglas(respuestaDistancia, respuestaVelocidad);
        imprimirListaReglas(inferencias);

        return inferencias;
    }

    /**
     * Indica las reglas que se aplican
     * Retorna una matriz 2*Cant. de Reglas, donde la primera columna es el conjunto de Distancia
     * y la segunda columna es el conjunto de Velocidad.
     */
    public ArrayList<ReglasInferencia> analizarReglas( ArrayList<IntervaloPertenencia> listaDistancia, ArrayList<IntervaloPertenencia> listaVelocidad) {
        ArrayList<ReglasInferencia> lista = new ArrayList<ReglasInferencia>();
        for(int i = 0; i < listaDistancia.size(); i++) {
            for (int j = 0; j < listaVelocidad.size(); j++) {
                // Hallamos las posiciones de fila y columna
                String nombreDist = (listaDistancia.get(i)).name;
                String nombreVel = (listaVelocidad.get(j)).name;
                Integer posDistancia = hallarPosicion(nombreDist);
                Integer posVelocidad = hallarPosicion(nombreVel);
                Float pertDistancia = (listaDistancia.get(i)).membership;
                Float pertVelocidad = (listaVelocidad.get(j)).membership;
                Integer nroRegla = (posDistancia*5) + posVelocidad + 1;
                lista.add(new ReglasInferencia(nroRegla, nombreDist, pertDistancia, nombreVel, pertVelocidad, matrizReglas[posDistancia][posVelocidad], operarAND(pertDistancia, pertVelocidad)));
            }
        }
        return lista;
    }


    /**
     * Imprime las listas de IntervaloPertenencia ()
     */
    public static void imprimirLista(ArrayList<IntervaloPertenencia> lista) {
        
        for(int i = 0; i < lista.size(); i++) {
            IntervaloPertenencia aux = lista.get(i);
            System.out.println("Conjunto: " + aux.name + "\tPertenencia: " + aux.membership);
        }
        System.out.println();
    
    }

    /**
     * Retorna la posicion en el array de orden del nombre dado.
     */
    private int hallarPosicion(String nombre) {
        for (int i = 0; i < ordenConjuntos.length; i++) {
            if (ordenConjuntos[i] == nombre) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Funcion MIN para la operacion de AND de las reglas de inferencia
     */
    private Float operarAND(Float a, Float b) {
        return Math.min(a,b);
    }

    /**
     * Imprimir el resultado de las inferencias que se utilizaron para el calculo
     */
    private void imprimirListaReglas(ArrayList<ReglasInferencia> lista) {
        int count = 0;
        System.out.println("---------------------------------------------------------------");
        System.out.println("|                       REGLAS ACTIVADAS                      |");
        System.out.println("---------------------------------------------------------------");
        for(int i = 0; i < lista.size(); i++) {
            ReglasInferencia aux = lista.get(i);
            System.out.println("Regla Nro. " + aux.nroRegla  + " : " + "Si e es " + aux.conjuntoDistancia + " y 'e es " + aux.conjuntoVelocidad + ", entonces v es " + aux.conjuntoVoltaje);
            System.out.println("Pertenencia al conjunto " + aux.conjuntoVoltaje + ": " + aux.pertenenciaDistancia + " (t) " + aux.pertenenciaVelocidad + " = " + aux.pertenenciaVoltaje);
            System.out.println();
        }
    }

}