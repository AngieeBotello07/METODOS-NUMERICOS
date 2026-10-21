# Práctica: Implementación de Simpson 1/3 Compuesto y Análisis Comparativo

## Datos de Identificación Institucional
* **Instituto:** Instituto Tecnológico Superior de Xalapa (ITSX)
* **Carrera:** Ingeniería en Sistemas Computacionales (ISC)
* **Asignatura:** SCC-1017 Métodos Numéricos
* **Docente:** Víctor Hugo Vásquez Herrera
* **Correo Docente:** victor.vasquez@itsx.edu.mx
* **Unidad Académica:** Tarea 1 Unidad 4
* **Ubicación Ciudadana:** Xalapa, Ver.

---

## Descripción de la Práctica
Este proyecto implementa y contrasta la eficiencia de dos algoritmos fundamentales de integración numérica aplicados a la función de evaluación continua **\(f(x) = x^2\)** en el intervalo definido **\([0, 2]\)**:
1. **Regla del Trapecio Compuesto**
2. **Regla de Simpson 1/3 Compuesta**

Ambas clases operan de forma coordinada bajo un enfoque adaptativo iterativo, donde el número de subintervalos (\(n\)) se duplica de forma continua (\(n \times 2\)) en un bucle controlado hasta que la diferencia absoluta entre dos aproximaciones consecutivas satisface la tolerancia restrictiva impuesta (\(\le 0.0001\)).

---

## Instrucciones para Compilar y Ejecutar el Proyecto

### Ejecución Directa desde la Consola de Comandos
1. Sitúese en la carpeta raíz del proyecto (`src`).
2. Compile todas las clases pertenecientes al paquete unificado ejecutando el comando:
   ```bash
   javac TrapecioCompuesto/*.java
   ```
3. Ejecute el programa principal invocando el método `main`:
   ```bash
   java TrapecioCompuesto.Main
   ```

### Ejecución mediante Entorno de Desarrollo (IDE)
1. Abra la carpeta raíz en **IntelliJ IDEA**, **Eclipse** o **NetBeans**.
2. Asegúrese de que la estructura reconozca a la carpeta contenedora como el paquete `TrapecioCompuesto`.
3. Busque el archivo `Main.java`, dé clic derecho sobre él y seleccione la opción **Run 'Main.main()'**.

---

## Salida Real Obtenida en Consola

Al ejecutar el programa principal para evaluar la integral de \(f(x) = x^2\) de \(0\) a \(2\) con una tolerancia de \(0.0001\), se imprime el siguiente reporte de convergencia en la terminal:

```text
=========================================================
INSTITUTO TECNOLÓGICO SUPERIOR DE XALAPA
MÉTODOS NUMÉRICOS - ISC - TAREA 1 UNIDAD 4
Docente: Víctor Hugo Vásquez Herrera
=========================================================
Evaluando f(x) = x^2 en el intervalo [0.0, 2.0]
Tolerancia Objetivo: 0.0001
=========================================================
--- ITERACIONES (TRAPECIO COMPUESTO) ---
n = 2 | Integral = 2.75
n = 4 | Integral = 2.6875 | Error = 0.0625
n = 8 | Integral = 2.671875 | Error = 0.015625
n = 16 | Integral = 2.66796875 | Error = 0.00390625
n = 32 | Integral = 2.6669921875 | Error = 0.0009765625
n = 64 | Integral = 2.666748046875 | Error = 0.000244140625
n = 128 | Integral = 2.66668701171875 | Error = 6.103515625E-5

--- ITERACIONES (SIMPSON 1/3 COMPUESTO) ---
n = 2 | Integral = 2.6666666666666665
n = 4 | Integral = 2.6666666666666665 | Error = 0.0
=========================================================
ANALISIS DE RESULTADOS FINALES:
-> Aproximación Trapecio: 2.66668701171875
-> Aproximación Simpson : 2.6666666666666665
=========================================================
```

---

## Análisis Conceptual de Paridad y Coeficientes

### 1. ¿Por qué el número total de subintervalos ($n$) en Simpson debe ser estrictamente par?
Geométricamente, la Regla de Simpson 1/3 aproxima el área bajo la curva sustituyendo a la función original por una serie de **polinomios de segundo grado (parábolas)**. Mientras que un trapecio lineal requiere únicamente 2 puntos consecutivos para definirse ($x_i$ y $x_{i+1}$), una parábola matemática requiere **estrictamente de 3 puntos distribuidos espacialmente** para quedar completamente determinada en el plano: el límite izquierdo, un punto medio central y el límite derecho. 

Dado que cada parábola individual consume e integra exactamente un par de subintervalos continuos a la vez, cualquier composición global del método compuesto demandará múltiplos enteros de dos. Por lo tanto, es una restricción geométrica inquebrantable que el número total de subintervalos $n$ sea un **número par** ($n = 2, 4, 6, 8, \dots$).

### 2. ¿A qué se debe el patrón alternado de coeficientes $(1, 4, 2, 4, \dots, 2, 4, 1)$?
Este fenómeno se origina debido a la **superposición de fronteras** entre las parábolas consecutivas durante el proceso de sumatoria compuesta:
* Los puntos extremos absolutos ($f(a)$ y $f(b)$) no se comparten con ninguna otra figura, por lo que retienen su coeficiente base de **1**.
* Los puntos con índices **impares** ($x_1, x_3, x_5, \dots$) fungen exclusivamente como el **nodo central interno** de cada parábola individual. Por deducción matemática de la regla simple de Simpson, estos puntos se multiplican por **4**.
* Los puntos con índices **pares** ($x_2, x_4, x_6, \dots$) representan los **puntos frontera o de unión** donde termina una parábola y comienza inmediatamente la siguiente. Al ser evaluados y contabilizados dos veces (una vez como extremo derecho de la parábola anterior y otra como extremo izquierdo de la parábola posterior), sus coeficientes unitarios se consolidan algebraicamente sumando $1 + 1 = \mathbf{2}$.

Esta brillante reutilización de nodos es lo que le otorga a Simpson una velocidad de convergencia de cuarto orden $O(h^4)$, reduciendo drásticamente las iteraciones necesarias frente a la convergencia lineal $O(h^2)$ del Trapecio.
