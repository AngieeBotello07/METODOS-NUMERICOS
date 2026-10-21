package TrapecioCompuesto; // [ACOTACIÓN] Unificado al mismo paquete operativo

/**
 * Clase Principal encargada de procesar las ejecuciones y el análisis numérico comparativo.
 */
public class Main {
    public static void main(String[] args) {
        // [ACOTACIÓN] Parámetros iniciales del problema de integración
        double limiteInferior = 0.0;        // Límite 'a'
        double limiteSuperior = 2.0;        // Límite 'b'
        double toleranciaObjetivo = 0.0001; // Tolerancia épsilon (0.0001)

        System.out.println("=========================================================");
        System.out.println("INSTITUTO TECNOLÓGICO SUPERIOR DE XALAPA");
        System.out.println("MÉTODOS NUMÉRICOS - ISC - TAREA 1 UNIDAD 4");
        System.out.println("Docente: Víctor Hugo Vásquez Herrera");
        System.out.println("=========================================================");
        System.out.println("Evaluando f(x) = x^2 en el intervalo [" + limiteInferior + ", " + limiteSuperior + "]");
        System.out.println("Tolerancia Objetivo: " + toleranciaObjetivo);
        System.out.println("=========================================================");

        // [ACOTACIÓN] Ejecución del primer método: Trapecio Compuesto
        double resultadoTrapecio = TrapecioCompuesto.integrarConTolerancia(limiteInferior, limiteSuperior, toleranciaObjetivo);

        // [ACOTACIÓN] Ejecución del segundo método: Simpson 1/3 Compuesto
        double resultadoSimpson = SimpsonCompuesto.integrarConTolerancia(limiteInferior, limiteSuperior, toleranciaObjetivo);

        System.out.println("=========================================================");
        System.out.println("ANALISIS DE RESULTADOS FINALES:");
        System.out.println("-> Aproximación Trapecio: " + resultadoTrapecio);
        System.out.println("-> Aproximación Simpson : " + resultadoSimpson);
        System.out.println("=========================================================");
    }
}
