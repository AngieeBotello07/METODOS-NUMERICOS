package Ecuaciones_lineales;

public class Lanzador_GaussJordan {
    public static void main(String[] args) {
        // 1. Cargamos la Matriz Aumentada Original
        double[][] matriz = DefMatriz.defmatriz();

        // 2. Ejecutamos el Método completo de Gauss-Jordan
        GaussJordan.resolverGaussJordan(matriz);

        // 3. PASO 3: Lectura Directa de Resultados (matriz[i][n]) sin Sustitución Regresiva
        int n = matriz.length;
        System.out.println("Soluciones del Sistema (vía Gauss-Jordan):");
        for (int i = 0; i < n; i++) {
            System.out.println("x" + (i + 1) + " = " + matriz[i][n]);
        }
    }
}
