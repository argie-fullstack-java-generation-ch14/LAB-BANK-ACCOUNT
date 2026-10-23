package cuentaBancaria;

public abstract class CuentaBancaria {
  private String numeroCuenta;
  private String titular;
  private double saldo = 0;
  private double tasaInteres = 0;

  public CuentaBancaria(String numeroCuenta, String titular, double saldo, double tasaInteres) {

    this.numeroCuenta = numeroCuenta;
    this.titular = titular;
    if (saldo >= 0) {
      this.saldo = saldo;
    } else {
      System.out.println("Cuenta inicial en 0");
    }
    if (tasaInteres >= 0) {
      this.tasaInteres = tasaInteres;
    }
  }

  public String getNumeroCuenta() {
    return numeroCuenta;
  }

  public String getTitular() {
    return titular;
  }

  public double getSaldo() {
    return saldo;
  }

  public double getTasaInteres() {
    return tasaInteres;
  }

  public abstract double depositar(double monto);

  public abstract double retirar(double monto);

  public abstract double aplicarInteres(double tasa);

  protected void actualizaSaldo(double saldo) {
    this.saldo = saldo;
  }

  public void mostrarInfo() {
    System.out.println("Numero Cuenta: " + this.numeroCuenta);
    System.out.println("Titular: " + this.titular);
    System.out.println("Saldo: " + this.saldo);
    System.out.println("Tasa Interes: " + this.tasaInteres);
  }
}
