import java.util.ArrayList;
import java.util.Scanner;  

public class Main {

    public static void main(String[] args) {
        Float nro1 = 0.45f;
        Float nro2 = 3.5f;
        Float[] entrada = encabezado();

        Float distancia = entrada[0];
        Float velocidad = entrada[1];

        Fuzzyficador fuzzy =  new Fuzzyficador();
        ArrayList<ReglasInferencia> inferencias = fuzzy.fuzzyficar(distancia, velocidad);
        
        Defuzzyficador defuzzy =  new Defuzzyficador();
        Float resultadoVoltaje = defuzzy.metodoCAD(inferencias);
        System.out.println("---------------------------------------------------------------");
        System.out.println("|                         RESULTADO                           |");
        System.out.println("---------------------------------------------------------------");
        System.out.println("El voltaje a aplicar cuando e = " + entrada[0] + " mts. y 'e = " + entrada[1] + " m/s, es de V = " + resultadoVoltaje + " voltios.");
        System.out.println();
    }

    /**
     * Funcion estatica para leer los valores float y dar formato de encabezado del programa
     */
    public static Float[] encabezado() {
        Scanner lect = new Scanner(System.in);
        Float[] datos = new Float[2];
        Boolean esValido = false;
        System.out.println( "---------------------------------------------------------------");
        System.out.println( "|                           PROBLEMA                          |");
        System.out.println( "---------------------------------------------------------------");
        System.out.println( "| \"Ball and Beam Plant\", sistema de control fuzzy con metodo  |" +
                            "\n| de Mamdani (para inferencia) y promedio central             |" + 
                            "\n| (para defuzzyficacion)                                      |");
        System.out.println("---------------------------------------------------------------");

        System.out.println("---------------------------------------------------------------");
        System.out.println("|                        DATOS ENTRADA                        |");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Primero, defina el valor de la distancia...");
        while(!esValido) {
            System.out.println("Ingrese distancia e (entre -0,5 y +0,5): ");
            try {
                datos[0] = lect.nextFloat();
                if(datos[0] <= 0.5f && datos[0] >= -0.5f) esValido = true;
                else System.out.println("Valor invalido! (debe estar entre -0,5 y +0,5)");
            } catch(Exception e) {
                lect.next();
                System.out.println("Valor invalido!");
            }
        }


        esValido = false;
        System.out.println("Ahora, defina el valor de la velocidad...");
        while(!esValido) {
            System.out.println("Ingrese velocidad 'e (entre -4,0 y +4,0): ");
            try{
                datos[1] = lect.nextFloat();
                if(datos[1] <= 4.0f && datos[1] >= -4.0f) esValido = true;
                else System.out.println("Valor invalido! (debe estar entre -4,0 y +4,0)");
            } catch (Exception e) {
                lect.next();
                System.out.println("Valor invalido!");
            }
        }

        return datos;
    }
}