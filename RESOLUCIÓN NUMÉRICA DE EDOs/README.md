# Resolución Numérica de Ecuaciones Diferenciales Ordinarias (EDOs)

**Actividad – Unidad 6**  
**Institución:** Instituto Tecnológico Superior de Xalapa (ITSX)  
**Carrera:** Ingeniería en Sistemas Computacionales  
**Docente:** Víctor Hugo Vásquez Herrera  

### Integrantes del Equipo
* María Fátima Sánchez Landa
* María de los Ángeles Rocha Botello
* Óscar Lozada Vargas

---

## Descripción del Proyecto

Este proyecto implementa de forma modular en Java los algoritmos numéricos del **Método de Euler** y el **Método de Runge-Kutta de 4º orden (RK4)** para la resolución de Ecuaciones Diferenciales Ordinarias (EDOs) de primer orden con condición inicial (Problema de Valor Inicial). El código aplica criterios de paro formales (\(N\)), experimentación variando el tamaño de paso (\(h\)) y comparación contra soluciones analíticas exactas.

### Estructura del Código
* **`MetodoEuler.java`**: Aproxima numéricamente la solución de una EDO de primer orden con condición inicial en un intervalo determinado, de forma modular y controlada.
* **`MetodoRungeKutta.java`**: Aproxima con alta precisión (orden de convergencia \(O(h^4)\)) la solución de una EDO de primer orden en un intervalo definido.

---

## Requerimientos del Entorno

* **Lenguaje:** Java SE 8 o superior (JDK 17 recomendado).
* **IDE Sugerido:** NetBeans, Eclipse, IntelliJ IDEA o Visual Studio Code.

---

## Instrucciones de Ejecución

1. **Clonar el repositorio:**
   ```bash
  GITHUB DEL EQUIPO
   git clone https://github.com/mfsl010906-hash/Resolucion-Numerica-De-EDOs.git
   cd Resolucion-Numerica-De-EDOs

   GITHUB DE MARÍA DE LOS ANGELES ROCHA BOTELLO
https://github.com/AngieeBotello07/METODOS-NUMERICOS/tree/main/RESOLUCI%C3%93N%20NUM%C3%89RICA%20DE%20EDOs
   ```

2. **Compilar los archivos fuente:**
   ```bash
   javac -d bin *.java
   ```

3. **Ejecutar cada método:**
   * Para ejecutar el Método de Euler:
     ```bash
     java -cp bin MetodoEuler
     ```
   * Para ejecutar el Método de Runge-Kutta (RK4):
     ```bash
     java -cp bin MetodoRungeKutta
     ```

---

## Resultados y Salida de Consola

### 1. Método de Euler (\(h = 0.1\))

```text
n       x_n         y_n (Euler)
0       0.0000      1.0000
1       0.1000      0.4000
2       0.2000      0.1800
3       0.3000      0.1120

Process finished with exit code 0
```

### 2. Método de Runge-Kutta de 4º Orden (\(h = 0.1\))

```text
n       x_n         y_n (RK4)
0       0.0000      1.0000
1       0.1000      0.5577
2       0.2000      0.3297
3       0.3000      0.2195

Process finished with exit code 0
```

---

## Conclusión

El **Método de Euler** resulta útil desde el punto de vista didáctico por su simplicidad conceptual y bajo costo computacional por paso. Sin embargo, en aplicaciones reales de ingeniería donde se exige alta exactitud y eficiencia, el **Método de Runge-Kutta de cuarto orden (RK4)** es la alternativa estándar y más confiable, ya que ofrece resultados altamente precisos incluso con mallas gruesas y pocas iteraciones.
