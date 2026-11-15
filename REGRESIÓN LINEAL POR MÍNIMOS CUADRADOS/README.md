# Implementación de Regresión Lineal por Mínimos Cuadrados en Java

Práctica correspondiente a la **Unidad 5: Ajuste de Funciones** de la asignatura **SCC-1017 Métodos Numéricos**.

---

## Información Académica

* **Institución:** Instituto Tecnológico Superior de Xalapa (ITSX)
* **Carrera:** Ingeniería en Sistemas Computacionales (ISC)
* **Asignatura:** SCC-1017 Métodos Numéricos
* **Docente:** Víctor Hugo Vásquez Herrera (`victor.vasquez@itsx.edu.mx`)
* **Alumna:** María de los Angeles Rocha Botello
* **Semestre y Grupo:** 3° Semestre — Grupo "B"
* **Ubicación:** Xalapa, Veracruz, México

---

## Descripción del Proyecto

Este repositorio contiene la implementación completa en **Java** de la clase `RegresionLineal` dentro del paquete `Ajuste_de_Funciones`. El programa calcula la recta de mejor ajuste mediante el **Método de Mínimos Cuadrados**, además de obtener el **Coeficiente de Correlación de Pearson ($r$)**, el **Coeficiente de Determinación ($r^2$)** y realizar estimaciones para nuevos valores de $X$.

---

## Estructura del Repositorio

```text
RegresionLineal/
├── src/
│   └── Ajuste_de_Funciones/
│       └── RegresionLineal.java
└── README.md
```

---

## Requisitos Previos

* **Java Development Kit (JDK):** Versión 8 o superior instalado y configurado en las variables de entorno (`PATH`).
* **Git:** Para clonar el repositorio localmente.

---

## Instrucciones de Clonación, Compilación y Ejecución

### 1. Clonar el repositorio
Abre una terminal y ejecuta el siguiente comando:

```bash
git clone https://github.com/AngieeBotello07/METODOS-NUMERICOS/tree/main/REGRESI%C3%93N%20LINEAL%20POR%20M%C3%8DNIMOS%20CUADRADOS
cd RegresionLineal
```

### 2. Compilar el código fuente
Desde la carpeta raíz del proyecto (o dentro de `src`), compila la clase respetando su paquete:

```bash
javac -d bin src/Ajuste_de_Funciones/RegresionLineal.java
```

### 3. Ejecutar el programa
Ejecuta la clase compilada indicando el nombre completo del paquete:

```bash
java -cp bin Ajuste_de_Funciones.RegresionLineal
```

---

## Ejemplo de Salida en Consola

Al ejecutar el programa con los datos de prueba integrados en el método `main`, se obtiene la siguiente salida:

```text
--- RESULTADOS DE MINIMOS CUADRADOS Y CORRELACION ---
Sumatorias: n=7, X=28.0, Y=24.0, X2=140.0, Y2=105.0, XY=119.5
Pendiente (beta1): 0.8393
Ordenada al origen (beta0): 0.0714
Modelo obtenido: Y = 0.0714 + 0.8393X
Coeficiente de Pearson (r): 0.9318
Coeficiente de Determinacion (r2): 0.8683
Prediccion para X = 8.0 -> Y = 6.7857
```

