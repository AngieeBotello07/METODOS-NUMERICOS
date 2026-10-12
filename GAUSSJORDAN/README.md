# Resolución de Sistemas de Ecuaciones Lineales mediante Gauss-Jordan

Este proyecto implementa el algoritmo de **Gauss-Jordan en Java** utilizando un enfoque de programación modular y el principio de reutilización de software. El sistema transforma una matriz aumentada en una matriz identidad mediante el paso de referencias directas en la memoria RAM, permitiendo obtener el vector de soluciones de manera directa sin necesidad de una fase de sustitución regresiva.

---

## 1. Estructura Modular del Proyecto

El sistema se divide en componentes independientes con responsabilidades únicas que optimizan el rendimiento al eliminar copias innecesarias en memoria:

*   **`Gauss.java`**: Repositorio de la práctica anterior. Proporciona el método estático de eliminación gaussiana simple empleado para realizar la triangulación superior inicial de la matriz.
*   **`GaussJordan.java`**: Módulo central de la práctica. Reutiliza el método de triangulación de `Gauss.java`, normaliza los pivotes de la diagonal principal para convertirlos en la unidad (1) y ejecuta el barrido superior eliminando los coeficientes restantes para generar la matriz identidad.
*   **`DefMatriz.java`**: Componente dedicado exclusivamente a la capa de datos. Define y expone de forma estática la matriz aumentada \([A \mid b]\) que será procesada.
*   **`Lanzador_GaussJordan.java`**: Punto de entrada principal (`main`). Coordina la carga de la matriz, invoca el solver numérico y presenta el vector final de soluciones por consola.

---

## 2. Guía de Compilación y Ejecución

Para compilar e interactuar con el programa desde una terminal empleando el Java Development Kit (JDK), siga detalladamente la siguiente secuencia estándar:

1. **Abrir la terminal** y situarse en el directorio raíz del proyecto (donde reside la carpeta del paquete `Ecuaciones_lineales`).
2. **Compilar el paquete completo** con el compilador nativo de Java:
   ```bash
   javac Ecuaciones_lineales/*.java
   ```
3. **Lanzar la ejecución** de la clase principal coordinadora:
   ```bash
   java Ecuaciones_lineales.Lanzador_GaussJordan
   ```

---

## 3. Ejemplo de Prueba y Salida por Consola

### Matriz Aumentada Original \([A \mid b]\) Procesada:
```text
[  3.0  -0.1  -0.2 |   7.85 ]
[  0.1   7.0  -0.3 | -19.30 ]
[  0.3  -0.2  10.0 |  71.40 ]
```

### Salida Plana Extraída de la Consola:
```text
Soluciones del Sistema (vía Gauss-Jordan):
x1 = 3.0
x2 = -2.5
x3 = 7.0
```

x1 = 3.0
x2 = -2.5
x3 = 7.0
x3 = 7.0

