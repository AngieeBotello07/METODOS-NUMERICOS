package TrapecioCompuesto;

/**
 * Clase que implementa el método de integración numérica de la Regla de Simpson 1/3 Compuesta.
 * Trabaja de forma coordinada con la clase TrapecioCompuesto para reutilizar la evaluación
 * de funciones y cálculo de parámetros básicos.
 */
public class SimpsonCompuesto {

    /**
     * Calcula la aproximación de la integral definida utilizando la Regla de Simpson 1/3 Compuesta.
     *
     * @param a Extremo inferior del intervalo de integración.
     * @param b Extremo superior del intervalo de integración.
     * @param n Número total de subintervalos (debe ser estrictamente un número par).
     * @return El valor aproximado de la integral definida en el intervalo dado.
     */
    private static double calcularSimpson(double a, double b, int n) {
        // [ACOTACIÓN] Se invoca el cálculo del tamaño de paso (h) de la clase base compartida
        TrapecioCompuesto.calcularH(a, b, n);

        // [ACOTACIÓN] Se extrae u obtiene el ancho de cada subintervalo h = (b - a) / n
        double h = (b - a) / n;

        // [ACOTACIÓN] Inicializadores para almacenar las sumas ponderadas internas
        double sumaImpares = 0.0; // Acumulador para nodos con índice k impar (peso 4)
        double sumaPares = 0.0;   // Acumulador para nodos con índice k par (peso 2)

        // [ACOTACIÓN] Bucle de evaluación numérica para los nodos interiores (desde k=1 hasta n-1)
        for (int k = 1; k < n; k++) {
            // Se determina el valor del punto x en la iteración k actual
            double xk = a + k * h;

            // [ACOTACIÓN: CONDICIÓN Y ACUMULACIÓN SOLICITADA]
            // Se verifica la paridad geométrica del índice del subintervalo actual
            if (k % 2 != 0) {
                // Si el índice k es IMPAR, el nodo corresponde al centro de una parábola de aproximación.
                // Estos puntos tienen un coeficiente multiplicador de 4 según la deducción del método.
                sumaImpares += TrapecioCompuesto.funcion(xk);
            } else {
                // Si el índice k es PAR, el nodo es un punto frontera donde convergen dos parábolas consecutivas.
                // Al ser compartido por ambas figuras, su coeficiente acumulado es de 2 (1 + 1).
                sumaPares += TrapecioCompuesto.funcion(xk);
            }
        }

        // [ACOTACIÓN] Suma total incorporando el primer elemento f(a), el último f(b) y las sumas internas ponderadas
        double sumaTotal = TrapecioCompuesto.funcion(a) + (4 * sumaImpares) + (2 * sumaPares) + TrapecioCompuesto.funcion(b);

        // [ACOTACIÓN] Retorno de la evaluación final multiplicada por el factor h / 3 propio del método
        return (h / 3) * sumaTotal;
    }

    /**
     * Algoritmo adaptativo que dobla de forma iterativa el número de subintervalos hasta que
     * la diferencia entre dos aproximaciones consecutivas sea menor o igual a la tolerancia provista.
     *
     * @param a Extremo inferior de integración.
     * @param b Extremo superior de integración.
     * @param tolerancia Error absoluto máximo permitido para detener la aproximación.
     * @return El valor de la integral calculado que cumple con el criterio de parada.
     */
    public static double integrarConTolerancia(double a, double b, double tolerancia) {
        int n = 2; // [ACOTACIÓN] Se arranca con el número mínimo de subintervalos válido para Simpson (par)

        // Se realiza la primera aproximación matemática
        double integralAnterior = calcularSimpson(a, b, n);
        double errorAbsoluto = 999.0; // Inicialización del error con un valor arbitrario elevado

        // [ACOTACIÓN] Bucle de control de convergencia algorítmica
        while (errorAbsoluto > tolerancia) {
            n *= 2; // [ACOTACIÓN] Se duplica el número de subintervalos preservando su propiedad de paridad (n par)

            // Se calcula el nuevo valor aproximado de la integral con el n actualizado
            double integralNueva = calcularSimpson(a, b, n);

            // [ACOTACIÓN] Cálculo de la magnitud del error absoluto de convergencia mutua
            errorAbsoluto = Math.abs(integralNueva - integralAnterior);

            // Actualización de la referencia anterior para la siguiente evaluación del bucle
            integralAnterior = integralNueva;
        }

        // Retorno de la aproximación final que satisfizo el límite de la tolerancia
        return integralAnterior;
    }
}
