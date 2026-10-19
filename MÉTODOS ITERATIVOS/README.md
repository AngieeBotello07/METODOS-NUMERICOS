# Práctica de Programación Modular en Java: Métodos Iterativos

Este repositorio aloja el desarrollo de la práctica correspondiente a la asignatura de **Métodos Numéricos**, bajo la supervisión del docente **Víctor Hugo Vásquez Herrera**, en el **Instituto Tecnológico Superior de Xalapa**.

## 👥 Datos del Curso e Institución
* **Institución:** Instituto Tecnológico Superior de Xalapa (ITSX)
* **Materia:** Métodos Numéricos
* **Docente:** Víctor Hugo Vásquez Herrera
* **Correo del Docente:** victor.vasquez@itsx.edu.mx
* **Entorno de Desarrollo:** Java v11+ (u otra versión compatible)
* **Arquitectura de Software:** Modular de Tres Componentes
* ISC SABATINO 3° "B"

## 📌 Descripción del Proyecto
El objetivo del proyecto es implementar, analizar y comparar la convergencia de dos de los algoritmos iterativos fundamentales de la resolución de sistemas de ecuaciones lineales de la forma \(Ax = b\):
1. **Método de Jacobi:** Utiliza un vector auxiliar para almacenar los nuevos valores calculados, los cuales son asignados de manera simultánea al final de cada iteración completa.
2. **Método de Gauss-Seidel:** Emplea la actualización inmediata de variables dentro del mismo ciclo iterativo para acelerar el proceso de convergencia.

Ambos métodos computan el criterio de parada mediante la **Norma Infinito** (\(\Vert{}X^{(k)} - X^{(k-1)}\Vert{}_\infty\)), deteniendo el ciclo al alcanzar una tolerancia estricta de \(\epsilon = 0.0001\) o un límite de 100 iteraciones.

## 📂 Estructura de Clases (Enfoque Modular)
El código fuente está estrictamente empaquetado bajo `package metodosnum;`, distribuyendo las tareas de la siguiente manera:
* `Sistema.java`: Módulo de definición que encapsula la matriz de coeficientes \(A\), el vector independiente \(b\), la aproximación inicial \(X^{(0)}\) y la tolerancia.
* `MetodosIterativos.java`: Módulo de cálculo matemático que implementa la lógica secuencial de los métodos de Jacobi y Gauss-Seidel, además del cálculo de la norma del error.
* `Main.java`: Módulo ejecutor central encargado de desplegar el sistema en consola e iniciar secuencialmente ambas rutinas de resolución.

## 🚀 Instrucciones de Compilación y Ejecución
Si deseas compilar y ejecutar el proyecto desde una terminal de comandos, sigue estas instrucciones estándar:

# 1. Navegar hasta la carpeta raíz del proyecto (donde se encuentra la carpeta 'src')
cd tu-repositorio/src

# 2. Compilar todas las clases dentro del paquete
javac metodosnum/*.java

# 3. Ejecutar la clase principal
java metodosnum.Main
______________________________________________________________________________________

**RESULTADOS DE LA PRÁCTICA**


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

