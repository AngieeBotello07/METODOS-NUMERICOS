MÉTODOS NUMÉRICOS
Reporte de Práctica: Métodos Iterativos en Java

Docente: Víctor Hugo Vásquez Herrera
Instituto Tecnológico Superior de Xalapa
ISC SABATINO 3° "B"

========================================================================
1. INTRODUCCIÓN
========================================================================
La resolución de sistemas de ecuaciones lineales (SEL) de grandes dimensiones representa uno de los desafíos operacionales más significativos dentro de la ingeniería y las ciencias exactas. A diferencia de los métodos directos tradicionales como la eliminación gaussiana o la regla de Cramer, los cuales sufren un alto costo computacional y acumulación de errores de redondeo en matrices gigantes, los métodos iterativos ofrecen una alternativa altamente eficiente.

Este reporte documenta el diseño, la codificación modular y la evaluación analítica de los dos métodos iterativos estacionarios por excelencia: Jacobi y Gauss-Seidel. A través de una arquitectura limpia en lenguaje Java, se examina el comportamiento computacional de ambos algoritmos al resolver un sistema acoplado de tres ecuaciones lineales de manera aproximada. El proceso se rige bajo una métrica estricta de parada basada en la Norma Infinito de la diferencia entre vectores sucesivos, permitiendo contrastar matemáticamente la velocidad de convergencia de ambos esquemas.

========================================================================
2. ARQUITECTURA MODULAR DE CLASES
========================================================================
Para garantizar un código limpio, mantenible y escalable, la arquitectura se fraccionó en tres componentes con una única responsabilidad bien demarcada:

Módulo 1: Definición del Sistema (Clase Sistema)
Es el repositorio de datos estáticos del problema. Almacena de forma centralizada y pública los coeficientes inmutables de la matriz A, las constantes del vector b, el estado inicial de aproximación X(0) y el valor de tolerancia asignado de 0.0001.

Módulo 2: Métodos Iterativos (Clase MetodosIterativos)
Este módulo aloja la lógica algorítmica principal. Incorpora el método privado 'calcularError' que busca la máxima diferencia absoluta entre componentes consecutivas. El método 'resolverJacobi' evalúa las fórmulas empleando copias estables del vector anterior, mientras que 'resolverGaussSeidel' sobreescribe el mismo vector sobre la marcha para alimentar las ecuaciones subsecuentes con los datos más nuevos del propio ciclo.

Módulo 3: Ejecución (Clase Main)
Actúa como la interfaz de arranque del programa. Muestra de forma descriptiva los datos de entrada del sistema lineal y realiza las invocaciones ordenadas a las rutinas matemáticas para desplegar el comportamiento de los algoritmos paso a paso en la consola.

========================================================================
3. FRAGMENTOS CLAVE DEL CÓDIGO EXPLICATIVO
========================================================================
A continuación, se destacan los bloques de código nucleares donde se evidencia la diferencia de control operacional entre ambos métodos computacionales:

[Cálculo del Criterio de Parada mediante Norma Infinito]
private static double calcularError(double[] actual, double[] anterior) {
    double maxError = 0;
    for (int i = 0; i < actual.length; i++) {
        double diff = Math.abs(actual[i] - anterior[i]);
        if (diff > maxError) { maxError = diff; }
    }
    return maxError;
}

[Diferencia en el Uso de Vectores: Jacobi vs Gauss-Seidel]
En Jacobi, para calcular 'xActual[i]' se lee exclusivamente de 'xAnterior[j]', lo que preserva el estado global de la iteración pasada intacto:
suma += A[i][j] * xAnterior[j];

En Gauss-Seidel, el cálculo de las componentes utiliza de forma inmediata los valores recién actualizados en el ciclo actual dentro del mismo vector 'xActual[j]':
suma += A[i][j] * xActual[j];

========================================================================
4. TABLA COMPARATIVA DE CONVERGENCIA (RESULTADOS DE CONSOLA)
========================================================================
Al ejecutar de forma secuencial las clases, el comportamiento matemático de los vectores de aproximación y sus respectivos errores residuales evoluciona bajo la siguiente bitácora:

--- TRAZA DEL MÉTODO DE JACOBI ---
Iter |     x      |     y      |     z      |   Error
1    |  1.400000  |  1.500000  |  1.600000  |  1.600000
2    |  0.780000  |  0.750000  |  0.720000  |  0.880000
3    |  1.106000  |  1.125000  |  1.144000  |  0.424000
4    |  0.946200  |  0.937500  |  0.928800  |  0.215200
5    |  1.026740  |  1.031250  |  1.035760  |  0.106960
...  |  ...       |  ...       |  ...       |  ...
14   |  0.999948  |  0.999939  |  0.999930  |  0.000209
15   |  1.000026  |  1.000031  |  1.000035  |  0.000105
16   |  0.999987  |  0.999985  |  0.999983  |  0.000052
-> Jacobi convergió con éxito en exactamente 16 iteraciones.

--- TRAZA DEL MÉTODO DE GAUSS-SEIDEL ---
Iter |     x      |     y      |     z      |   Error
1    |  1.400000  |  1.150000  |  0.860000  |  1.400000
2    |  0.998000  |  1.035500  |  0.986200  |  0.402000
3    |  0.995660  |  1.004535  |  0.999054  |  0.030965
4    |  0.999282  |  1.000416  |  0.999977  |  0.004119
5    |  0.999921  |  1.000025  |  1.000006  |  0.000639
6    |  0.999994  |  1.000000  |  1.000001  |  0.000072
-> Gauss-Seidel convergió con éxito en exactamente 6 iteraciones.

========================================================================
5. CONCLUSIÓN TÉCNICA COMPARATIVA
========================================================================
El análisis experimental de la solución del sistema propuesto ($x \approx 1.0$, $y \approx 1.0$, $z \approx 1.0$) bajo una tolerancia común de $0.0001$ arroja conclusiones de alto valor conceptual para los métodos analíticos:

El Método de Gauss-Seidel demostró una velocidad de convergencia drásticamente superior en comparación con el Método de Jacobi, completando el proceso en tan solo 6 iteraciones frente a las 16 requeridas por este último. Esto representa una reducción del 62.5% en la carga de ciclos lógicos del programa. 

La razón matemática de este comportamiento radica directamente en la naturaleza de actualización de los vectores. Mientras que Jacobi congela los valores de las incógnitas hasta que todo el bloque de ecuaciones es procesado (utilizando datos desactualizados durante la iteración), Gauss-Seidel retroalimenta el sistema de inmediato. Es decir, el valor calculado para 'x' en la primera línea se utiliza inmediatamente ese mismo instante para calcular 'y' en la segunda, y ambos se aprovechan al segundo siguiente para hallar 'z'. 

Dado que el sistema de ecuaciones posee una matriz de coeficientes A que cumple plenamente con la condición de ser estrictamente dominante por diagonal ($|5| > |1|+|1|$; $|4| > |1|+|1|$; $|5| > |1|+|2|$), se garantiza teóricamente la convergencia de ambos métodos. No obstante, la arquitectura de Gauss-Seidel aprovecha de manera óptima la proximidad a la solución en cada subpaso, consolidándose como un enfoque algorítmico preferible en términos de rendimiento computacional.
