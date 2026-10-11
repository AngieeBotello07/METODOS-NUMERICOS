package Ecuaciones_lineales;

public class GaussJordan {

    /**
     * Método que aplica el algoritmo de Gauss-Jordan reutilizando la Triangulación Previa.
     * @param matriz Matriz aumentada [A | b] que se modificará directamente en memoria RAM.
     */
    public static void resolverGaussJordan(double[][] matriz) {
        int n = matriz.length;

        // PASO 1: Reutilización inteligente (Invocamos el Método de la Práctica Anterior de Gauss)
        Gauss.eliminacionGaussiana(matriz);

        // PASO 2: Normalización y Barrido Superior (Recorremos de abajo hacia arriba)
        for (int i = n - 1; i >= 0; i--) {
            double pivote = matriz[i][i];

            // 2.a. Normalizar la Fila Actual para que el Pivote sea 1
            for (int k = i; k <= n; k++) {
                matriz[i][k] /= pivote;
            }

            // 2.b. Barrido Superior: Hacer ceros los Coeficientes por encima del Pivote
            for (int j = i - 1; j >= 0; j--) {
                double factor = matriz[j][i];
                for (int k = i; k <= n; k++) {
                    matriz[j][k] -= factor * matriz[i][k];
                }
            }
        }
    }
}

