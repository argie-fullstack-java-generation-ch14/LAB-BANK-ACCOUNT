
package cuentaBancaria;

public class CuentaAhorro extends CuentaBancaria {

    private String fechaApertura;

    private static final double tasaInteres = 2.5;
    private static final double capitalInicialRequerido = 10000;

    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, String fechaApertura){
        super(numeroCuenta, titular, saldoInicial, tasaInteres);
        if (saldoInicial < capitalInicialRequerido){
            throw new IllegalArgumentException("El saldo inicial debe ser mínimo de $10.000");
        }
        this.fechaApertura = fechaApertura;
    }

    @Override
    public double depositar(double monto){

        if (monto <= 0) {
            System.out.println("Error: el monto debe ser positivo.");
            return getSaldo();
        }
        ajustarSaldo(monto);
        System.out.println("Depósito exitoso: $" + String.format("%.2f", monto));
        System.out.println("Nuevo saldo: $" + String.format("%.2f", getSaldo()));
        return getSaldo();
    }

    @Override
    public double retirar(double monto){
        if (monto <= 0) {
            System.out.println("Error: el monto debe ser positivo.");
            return getSaldo();
        }
        if (monto > getSaldo()) {
            System.out.println("Error: saldo insuficiente.");
            return getSaldo();
        }
        ajustarSaldo(-monto);
        System.out.println("Retiro exitoso: $" + String.format("%.2f", monto));
        System.out.println("Nuevo saldo: $" + String.format("%.2f", getSaldo()));
        return getSaldo();
    }

    @Override
    public double aplicarInteres(double tasa) {
        double interes = getSaldo() * tasaInteres / 100;
        ajustarSaldo(interes);
        System.out.println("Interés generado: $" +
                String.format("%.2f", interes));
        System.out.println("Nuevo saldo: $" +
                String.format("%.2f", getSaldo()));
        return interes;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Fecha de apertura: " + fechaApertura);
    }
}
