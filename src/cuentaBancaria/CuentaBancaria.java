package cuentaBancaria;

public class CuentaBancaria {
  private String numeroCuenta;
  private String titular;
  private double saldo;
  private double tasaInteres;

  public CuentaBancaria(String numeroCuenta, String titular, double saldo, double tasaInteres) {
    this.numeroCuenta = numeroCuenta;
    this.titular = titular;
    this.saldo = saldo;
    this.tasaInteres = tasaInteres;
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
}
