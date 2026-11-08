# Práctica: Interpolación de Lagrange vs. Diferencias Divididas de Newton

**Asignatura:** Métodos Numéricos (SCC-1017)  
**Docente:** Víctor Hugo Vásquez Herrera  
**Institución:** Instituto Tecnológico Superior de Xalapa  
**Carrera:** Ingeniería en Sistemas Computacionales  

---

## 📝 Descripción del Proyecto
Este proyecto contiene la implementación en el lenguaje Java de dos de los algoritmos de interpolación polinomial más utilizados en el análisis numérico:
1. **Método de Diferencias Divididas de Newton** (Módulo completo para cálculo y despliegue de matrices de coeficientes).
2. **Método de Interpolación de Lagrange** (Módulo completado analíticamente en su productoria base $L_i(x)$).

Ambas clases permiten aproximar el valor de una función desconocida en un punto intermedio `xEval` basándose en un conjunto finito de nodos estructurados en arreglos unidimensionales.

## 🛠️ Requisitos del Entorno
* **Java SDK:** Versión 17 o superior recomendado (Compatible con OpenJDK 26).
* **IDE Sugerido:** IntelliJ IDEA (Comunidad o Ultimate), Eclipse o NetBeans.
* **Gestor de Compilación:** Proyecto Java nativo / estándar.

## 🚀 Instrucciones de Ejecución
1. Clone el repositorio en su máquina local:
   ```bash
   git clone https://github.com
   ```
2. Abra el proyecto desde su IDE preferido.
3. Localice la clase `Main.java` dentro del paquete correspondientemente configurado (`interpolacion`).
4. Ejecute el método `main`. El programa utilizará de forma automática los nodos de prueba preconfigurados:
   * $X = [1.0, 2.0, 4.0]$
   * $Y = [2.0, 3.0, 10.0]$
   * Punto de evaluación: $x = 3.0$

## 📊 Ejemplo de Salida en Consola
Al ejecutarse de manera correcta, el sistema mostrará en terminal el siguiente formato impreso:
* La tabla estructurada de diferencias divididas.
* Los coeficientes calculados de la diagonal superior ($a_k$).
* El valor de estimación final aproximado por ambos métodos en el punto de evaluación.
