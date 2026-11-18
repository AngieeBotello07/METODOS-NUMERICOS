Resolucion-Nuemrica-De-EDOs
actividad unidad 6
instituto tecnologico superior de xalapa
ingeneria en sistemas computacionales
docente: Victor Hugo Vasquez Harrera
Integrantes de equipo:
Maria Fatima Sanchez Landa
Maria de Los Angeles Rocha Botello
Oscar Lozada Vargas
Requerimientos del Entorno
Lenguaje: Java SE 8 o superior (JDK 17 recomendado).
IDE Sugerido: NetBeans, Eclipse, IntelliJ IDEA o VS Code.
Descripción del Proyecto
Se implementa de forma modular en Java los algoritmos numéricos del Método de Euler y el Método de Runge-Kutta de 4º orden(RK4) para la resolución de Ecuaciones Diferenciales Ordinarias(EDOs), aplicando criterios de paro formales(N), experimentación variando el tamaño de paso (h) y comparación rigurosa contra soluciones analíticas exactas.

Clase MetodoEuler: Esta clase aproxima numéricamente la solución de una Ecuación Diferencial Ordinaria (EDO) de primer orden con condición inicial (Problema de Valor Inicial) en un intervalo determinado, de forma modular y controlada.
Clase MetodoRungeKutta: El objetivo de esta clase es aproximar con alta precisión (orden de convergencia O(h^4)) la solución de una Ecuación Diferencial Ordinaria (EDO) de primer orden con condición inicial en un intervalo definido.
Instrucciones de Ejecución
Clonar el repositorio:

git clone [https://github.com/mfsl010906-hash/Resolucion-Numerica-De-EDOs.git]
cd Resolucion-Numerica-De-EDOs


Compilar el código:

javac -d bin src/MetodoRungeKutta/*.java
Ejecutar la clase principal:

java -cp bin MetodoEuler.java
```bash
java -cp bin MetodoRungeKutta.java
Salida de Consola Metodo Euler
con h=0.1
n x_n y_n (Euler)
0 0.0000 1.0000
1 0.1000 0.4000
2 0.2000 0.1800
3 0.3000 0.1120
Process finished with exit code 0
Salida de Consola Metodo Runge-Kutta
con h=0.1
n x_n y_n (RK4)
0 0.0000 1.0000
1 0.1000 0.5577
2 0.2000 0.3297
3 0.3000 0.2195
Process finished with exit code 0
conclucion
El Método de Euler resulta útil desde el punto de vista didáctico por su simplicidad conceptual y bajo costo por paso, en aplicaciones reales de ingeniería donde se exige alta exactitud y eficiencia computacional, Runge-Kutta de cuarto orden es la alternativa estándar y más confiable, ya que ofrece resultados altamente precisos incluso con mallas gruesas y pocas iteraciones.
