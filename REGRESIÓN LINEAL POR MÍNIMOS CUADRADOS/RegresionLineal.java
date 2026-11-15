package Ajuste_de_Funciones;

/**
 * Clase que implementa el calculo de Regresion Lineal Simple
 * utilizando el metodo de Minimos Cuadrados, incluyendo Pearson y R2.
 **/
public class RegresionLineal {

    /**
     * Calcula la regresion y retorna los coeficientes {beta0, beta1, r, r2}.
     *
     * @param x Arreglo con los valores independientes.
     * @param y Arreglo con los valores dependientes.
     * @return Arreglo double[] con los indicadores estadisticos.
     */
    public static double[] calcularMinimosCuadrados(double[] x, double[] y) {
        if (x.length != y.length || x.length == 0) {
            System.out.println("Error: Los arreglos deben tener el mismo tamano y no estar vacios.");
            return new double[]{0.0, 0.0, 0.0, 0.0};
        }

        int n = x.length;
        double sumX = 0, sumY = 0, sumX2 = 0, sumY2 = 0, sumXY = 0;

        // Acumulamos las sumatorias necesarias
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumX2 += x[i] * x[i];
            sumY2 += y[i] * y[i];
            sumXY += x[i] * y[i];
        }

        // Formulas oficiales de Minimos Cuadrados
        double beta1 = (n * sumXY - sumX * sumY) / (n * sumX2 - (sumX * sumX));
        double beta0 = (sumY - beta1 * sumX) / n;

        // ========================================================
        // IMPLEMENTACION DEL CALCULO DE PEARSON (r) Y R2
        // ========================================================
        double numeradorR = (n * sumXY) - (sumX * sumY);
        double denominadorR = Math.sqrt(((n * sumX2) - (sumX * sumX)) * ((n * sumY2) - (sumY * sumY)));

        double pearsonR = (denominadorR != 0) ? (numeradorR / denominadorR) : 0.0;
        double r2 = pearsonR * pearsonR;

        System.out.println("--- RESULTADOS DE MINIMOS CUADRADOS Y CORRELACION ---");
        System.out.printf("Sumatorias: n=%d, X=%.1f, Y=%.1f, X2=%.1f, Y2=%.1f, XY=%.1f%n",
                n, sumX, sumY, sumX2, sumY2, sumXY);
        System.out.printf("Pendiente (beta1): %.4f%n", beta1);
        System.out.printf("Ordenada al origen (beta0): %.4f%n", beta0);
        System.out.printf("Modelo obtenido: Y = %.4f + %.4fX%n", beta0, beta1);
        System.out.printf("Coeficiente de Pearson (r): %.4f%n", pearsonR);
        System.out.printf("Coeficiente de Determinacion (r2): %.4f%n", r2);

        return new double[]{beta0, beta1, pearsonR, r2};
    }

    /**
     * Realiza una estimacion/prediccion evaluando el modelo con un valor de X.
     */
    public static double predecir(double beta0, double beta1, double xValor) {
        return beta0 + beta1 * xValor;
    }

    // Método main de prueba para ejecutar directamente la clase
    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4, 5, 6, 7};
        double[] y = {0.5, 2.5, 2.0, 4.0, 3.5, 6.0, 5.5};

        double[] resultados = calcularMinimosCuadrados(x, y);
        double xPrueba = 8.0;
        double yEstimada = predecir(resultados[0], resultados[1], xPrueba);

        System.out.printf("Prediccion para X = %.1f -> Y = %.4f%n", xPrueba, yEstimada);
    }
}
