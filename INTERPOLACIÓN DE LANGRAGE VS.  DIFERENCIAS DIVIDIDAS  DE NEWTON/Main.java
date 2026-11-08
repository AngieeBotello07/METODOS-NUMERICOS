package interpolacion;

public class Main {
    public static void main(String[] args) {
        // Puntos de ejemplo del ejercicio en clase: (1, 2), (2, 3), (4, 10)
        double[] x = {1.0, 2.0, 4.0};
        double[] y = {2.0, 3.0, 10.0};

        // Punto intermedio a interpolar
        double xEval = 3.0;

        // ==========================================
        // 1. EJECUCIÓN DEL MÉTODO DE NEWTON
        // ==========================================
        // Calcular tabla de diferencias divididas
        double[][] tablaDiferencias = InterpolacionNewton.calcularDiferenciasDivididas(x, y);

        // Imprimir la tabla
        InterpolacionNewton.imprimirTabla(x, tablaDiferencias);

        // Mostrar los coeficientes (Diagonal superior)
        System.out.println("\n--- COEFICIENTES DEL POLINOMIO DE NEWTON (a_k) ---");
        for (int k = 0; k < x.length; k++) {
            System.out.printf("a_%d = %.4f\n", k, tablaDiferencias[0][k]);
        }

        // Evaluar en x = 3.0 usando Newton
        double yNewton = InterpolacionNewton.evaluarPolinomio(x, tablaDiferencias, xEval);

        // ==========================================
        // 2. EJECUCIÓN DEL MÉTODO DE LAGRANGE
        // ==========================================
        // Evaluar en x = 3.0 usando Lagrange
        double yLagrange = InterpolacionLagrange.interpolacionLagrange(x, y, xEval);

        // ==========================================
        // 3. DESPLIEGUE COMPARATIVO DE RESULTADOS
        // ==========================================
        System.out.println("\n=====================================================");
        System.out.println("      RESULTADOS FINALES DE LA INTERPOLACIÓN         ");
        System.out.println("=====================================================");
        System.out.printf("MÉTODO DE NEWTON   -> El valor estimado en x = %.2f es P(%.2f) = %.4f\n", xEval, xEval, yNewton);
        System.out.printf("MÉTODO DE LAGRANGE -> El valor estimado en x = %.2f es P(%.2f) = %.4f\n", xEval, xEval, yLagrange);
        System.out.println("=====================================================");
    }
}
