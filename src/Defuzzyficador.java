import java.util.ArrayList;

public class Defuzzyficador {

    public Float defuzzyficar(ArrayList<ReglasInferencia> inferencias) {

        Float voltaje = metodoCAD(inferencias);

        return voltaje;

    } 

    /**
     * Implementa el metodo de defuzzyfucacion center average defuzzyfication
     */
    public Float metodoCAD( ArrayList<ReglasInferencia> listaReglas) {
        DiagramaVoltaje voltaje = new DiagramaVoltaje();
        Float resultado = 0.0f;
        Float num = 0.0f;
        Float den = 0.0f;
        for(int i = 0; i < listaReglas.size(); i++) {
            String conjuntoVoltaje = (listaReglas.get(i)).conjuntoVoltaje;
            Float aux1 = (listaReglas.get(i)).pertenenciaVoltaje;
            Float aux2 = voltaje.hallarValue(conjuntoVoltaje);

            num += aux1*aux2;
            den += aux1;
        }

        return num/den;
    }

}