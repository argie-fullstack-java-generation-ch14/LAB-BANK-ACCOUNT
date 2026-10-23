
package cuentaBancaria;

public class CuentaEmpresarial extends CuentaBancaria {

    private String nombreEmpresa;
    private String RUT;
    private double comisionRetiro = 2000;

    public CuentaEmpresarial(
            String numeroCuenta,
            String titular,
            double saldoInicial,
            String nombreEmpresa,
            String RUT) {

        super(numeroCuenta, titular, saldoInicial, 1.5);

        if (saldoInicial < 100000) {
            throw new IllegalArgumentException(
                    "La cuenta empresarial necesita un saldo mínimo de $100000."
            );
        }

        this.nombreEmpresa = nombreEmpresa;
        this.RUT = RUT;
    }

    @Override
    public double depositar(double monto) {

        if (monto <= 0) {
            System.out.println("El depósito debe ser mayor que cero.");
            return getSaldo();
        }

        ajustarSaldo(monto);

        System.out.println("Depósito exitoso.");
        System.out.println("Nuevo saldo: $" +
                String.format("%.2f", getSaldo()));

        return getSaldo();
    }

    @Override
    public double retirar(double monto) {

        if (monto <= 0) {
            System.out.println("El retiro debe ser mayor que cero.");

        } else if (monto + comisionRetiro <= getSaldo()) {

            ajustarSaldo(-monto);
            ajustarSaldo(-comisionRetiro);

            System.out.println("Retiro exitoso.");
            System.out.println("Comisión por retiro: $" +
                    String.format("%.2f", comisionRetiro));
            System.out.println("Nuevo saldo: $" +
                    String.format("%.2f", getSaldo()));

        } else {
            System.out.println(
                    "Error: el saldo no alcanza para el retiro y la comisión."
            );
        }

        return getSaldo();
    }

    @Override
    public double aplicarInteres(double tasa) {

        if (tasa < 0) {
            System.out.println(
                    "La tasa de interés no puede ser negativa."
            );
            return getSaldo();
        }

        double interes = getSaldo() * tasa / 100;
        ajustarSaldo(interes);

        System.out.println("Interés aplicado: $" +
                String.format("%.2f", interes));
        System.out.println("Nuevo saldo: $" +
                String.format("%.2f", getSaldo()));

        return getSaldo();
    }

    @Override
    public void mostrarInfo() {

        super.mostrarInfo();

        System.out.println("Nombre de la empresa: " + nombreEmpresa);
        System.out.println("RUT: " + RUT);
        System.out.println("Comisión por retiro: $" +
                String.format("%.2f", comisionRetiro));
    }
}
