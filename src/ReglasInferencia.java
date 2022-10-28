
public class ReglasInferencia {
    Integer nroRegla = null;
    String conjuntoDistancia = null;
    Float pertenenciaDistancia = null;
    String conjuntoVelocidad = null;
    Float pertenenciaVelocidad = null;
    String conjuntoVoltaje = null;
    Float pertenenciaVoltaje = null;

    ReglasInferencia(Integer nroRegla, String conjuntoDistancia, Float pertenenciaDistancia, String conjuntoVelocidad, Float pertenenciaVelocidad, String conjuntoVoltaje, Float pertenenciaVoltaje) {
        this.nroRegla = nroRegla;
        this.conjuntoDistancia = conjuntoDistancia;
        this.pertenenciaDistancia = pertenenciaDistancia;
        this.conjuntoVelocidad = conjuntoVelocidad;
        this.pertenenciaVelocidad = pertenenciaVelocidad;
        this.conjuntoVoltaje = conjuntoVoltaje;
        this.pertenenciaVoltaje = pertenenciaVoltaje;
    }
}