1. Estructura Modular del Proyecto
// El sistema ha sido estructurado bajo los principios de programación modular y la reutilización de software. Los componentes se dividen en clases independientes con responsabilidades únicas que se comunican mediante paso de referencias en la memoria RAM, eliminando copias innecesarias y optimizando el rendimiento:
•	GaussJordan.java: Módulo central que extiende la práctica anterior. Reutiliza el método de triangulación superior, normaliza los pivotes de la diagonal principal para transformarlos en la unidad (1) y ejecuta el barrido superior eliminando los coeficientes restantes para generar la matriz identidad.
•	DefMatriz.java: Componente dedicado exclusivamente a la capa de datos. Define y expone de forma estática la matriz aumentada [A | b] que será procesada por los componentes numéricos.
•	Lanzador_GaussJordan.java: Punto de entrada principal (método main). Coordina la orquestación del programa encargándose de la carga de la matriz, la invocación del solver numérico y la presentación directa del vector final de soluciones por consola.
•	Gauss.java: Repositorio de la práctica previa. Proporciona el método estático de eliminación gaussiana simple empleado en el primer paso de triangulación de la matriz.

2. Guía de Compilación y Ejecución
// Para compilar e interactuar con el desarrollo modular desde una interfaz de comandos limpia empleando el Java Development Kit (JDK), siga detalladamente la siguiente secuencia estándar:
Paso 1: Situar la terminal en el directorio raíz del proyecto (donde reside el paquete Ecuaciones_lineales).
Paso 2: Compilar el paquete completo con el compilador nativo:
   > javac Ecuaciones_lineales/*.java
Paso 3: Lanzar la ejecución de la clase principal coordinadora:
   > java Ecuaciones_lineales.Lanzador_GaussJordan

3. Caso de Prueba y Resultados
// Se detalla el comportamiento del algoritmo aplicando los coeficientes numéricos cargados de manera predeterminada en el código fuente.
Matriz Aumentada Original [A | b]:
Fila	Coeficiente x1	Coeficiente x2	Coeficiente x3	Vector Términos (b)
Fila 1	3.0	-0.1	-0.2	7.85
Fila 2	0.1	7.0	-0.3	-19.3
Fila 3	0.3	-0.2	10.0	71.4
Salida Plana de la Consola (Output Extraído Directamente):
Soluciones del Sistema (vía Gauss-Jordan):
x1 = 3.0
x2 = -2.5
x3 = 7.0
x3 = 7.0

