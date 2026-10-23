# TIFC2DEV-JAVA-MJ3 LAB — BankAccount

## 👥 Integrantes

* **Sara Cardona**
* **Yuliana Quintero**
* **Luisa Fernanda Sepúlveda**
* **Argie Rincón**

---

## 🎯 Objetivo

Aplicar los conceptos de Programación Orientada a Objetos vistos en las sesiones anteriores:
* Encapsulación
* Herencia
* Polimorfismo
* Uso de `super()`
* Sobreescritura de métodos (`@Override`)
* Manejo de objetos de forma individual (sin colecciones ni arreglos)

---

## 🏦 Descripción del Proyecto

Sistema de gestión de cuentas bancarias para una entidad financiera que ofrece tres tipos de productos: **Cuenta de Ahorro**, **Cuenta Corriente** y **Cuenta Empresarial**. Cada tipo de cuenta implementa reglas de negocio específicas.

> **Importante:** El sistema debe manejar las cuentas de forma individual, sin utilizar arreglos ni listas. Cada cuenta será una variable independiente en el programa principal (`TestBanco.java`).

---

## 📐 Requerimientos de las Clases

### 1. Clase Base Abstracta: `CuentaBancaria`

* **Atributos privados:**
  * `numeroCuenta`: `String`
  * `titular`: `String`
  * `saldo`: `double`
  * `tasaInteres`: `double`

* **Constructor:**
  * Recibe `numeroCuenta`, `titular`, `saldoInicial` y `tasaInteres`.
  * Valida que el saldo inicial y la tasa de interés no sean negativos.

* **Métodos:**
  * Getters para todos los atributos (sin setters).
  * `depositar(double monto)`: Agrega dinero validando que el monto sea positivo. Muestra mensaje con monto depositado y nuevo saldo.
  * `retirar(double monto)`: Método abstracto (`abstract`).
  * `aplicarInteres()`: Aplica la tasa de interés al saldo actual y muestra el interés generado.
  * `mostrarInfo()`: Muestra toda la información de la cuenta.

---

### 2. Clase Hija: `CuentaAhorro`
Extiende de `CuentaBancaria`.

* **Reglas de negocio:**
  * **Retiro:** No se puede retirar más del saldo disponible.
  * **Interés:** Tasa fija del 2.5% anual.
  * **Comisión:** Sin comisión por retiro.
  * **Saldo mínimo de apertura:** $10,000. Si el saldo inicial es menor, el constructor debe mostrar un mensaje de error o lanzar excepción.
* **Atributo adicional:**
  * `fechaApertura`: `String`
* **Constructor:** Recibe `numeroCuenta`, `titular`, `saldoInicial` y `fechaApertura`. La tasa de interés es fija.
* **Métodos:**
  * `retirar(double monto)`: Valida saldo suficiente, realiza el retiro y muestra mensajes descriptivos.
  * `mostrarInfo()`: Incluye la fecha de apertura.

---

### 3. Clase Hija: `CuentaCorriente`
Extiende de `CuentaBancaria`.

* **Reglas de negocio:**
  * **Retiro:** Permite retirar hasta $50,000 por encima del saldo (sobregiro).
  * **Interés:** 0.0% (no genera intereses).
  * **Comisión por sobregiro:** Si el saldo queda en negativo, se cobra una comisión del 5% sobre el monto sobregirado.
* **Atributos adicionales:**
  * `limiteSobregiro`: `double` (defecto: $50,000)
  * `porcentajeComisionSobregiro`: `double` (defecto: 5.0%)
* **Constructores:**
  * Principal: recibe `numeroCuenta`, `titular`, `saldoInicial`, `limiteSobregiro` y `porcentajeComisionSobregiro`.
  * Secundario: recibe `numeroCuenta`, `titular`, `saldoInicial` (usa valores por defecto para límite y comisión).
* **Métodos:**
  * `retirar(double monto)`: Valida que no supere `saldo + limiteSobregiro`. Si el saldo pasa a negativo, calcula y aplica la comisión.
  * `mostrarInfo()`: Incluye el límite de sobregiro.

---

### 4. Clase Hija: `CuentaEmpresarial`
Extiende de `CuentaBancaria`.

* **Reglas de negocio:**
  * **Retiro:** Retiros hasta el saldo disponible. Se cobra una comisión fija de $2,000 por cada retiro.
  * **Interés:** Tasa fija del 1.5% anual.
  * **Saldo mínimo de apertura:** $100,000.
* **Atributos adicionales:**
  * `nombreEmpresa`: `String`
  * `RUT`: `String`
  * `comisionRetiro`: `double` (defecto: $2,000)
* **Constructor:** Recibe `numeroCuenta`, `titular`, `saldoInicial`, `nombreEmpresa` y `RUT`.
* **Métodos:**
  * `retirar(double monto)`: Verifica que `monto + comisionRetiro <= saldo`. Descuenta el monto y la comisión.
  * `mostrarInfo()`: Incluye el nombre de la empresa y el RUT.

---

## 🧪 Escenario de Prueba (`TestBanco.java`)

El método `main` debe ejecutar secuencialmente las siguientes etapas:

1. **Paso 1: Crear las cuentas**
   * `CuentaAhorro`: Ana Pérez (`AH001`, Saldo: $50,000, Fecha: `2024-01-15`)
   * `CuentaCorriente`: Luis Gómez (`CC001`, Saldo: $20,000)
   * `CuentaEmpresarial`: Tech Solutions (`EM001`, Saldo: $200,000, RUT: `123456789-0`)
   * `CuentaAhorro`: María López (`AH002`, Saldo: $15,000, Fecha: `2024-02-01`)

2. **Paso 2: Mostrar información inicial**
   * Invocar `mostrarInfo()` en cada cuenta.

3. **Paso 3: Realizar operaciones**
   * Ana Pérez deposita $10,000.
   * Luis Gómez retira $25,000 (activa sobregiro y comisión).
   * Tech Solutions retira $10,000 (aplica comisión por retiro).
   * María López intenta retirar $20,000 (operación rechazada por saldo insuficiente).

4. **Paso 4: Aplicar intereses**
   * Invocar `aplicarInteres()` en todas las cuentas.

5. **Paso 5: Mostrar estado final**
   * Mostrar información completa actualizada con `mostrarInfo()`.

6. **Paso 6: Generar resumen**
   * Total de cuentas (4)
   * Saldo total acumulado
   * Promedio de saldo por cuenta
   * Cuenta con mayor saldo (Número, Titular y Saldo)

---

## 📦 Entregables del Proyecto

1. `CuentaBancaria.java` *(Clase Abstracta)*
2. `CuentaAhorro.java`
3. `CuentaCorriente.java`
4. `CuentaEmpresarial.java`
5. `TestBanco.java` *(Clase de prueba con el `main`)*
6. Captura de pantalla con la ejecución completa en consola.
