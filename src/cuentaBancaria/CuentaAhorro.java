package cuentaBancaria;

public class CuentaAhorro extends CuentaBancaria {

    private static final double tasaInteres = 0.025 ;
    private static final double capitalInicialRequerido = 10000;
    private String fechaApertura;

    public CuentaAhorro(String numeroCuenta, String titular, double saldo, String fechaApertura) {

        super(numeroCuenta, titular, saldo, tasaInteres);

        this.fechaApertura = fechaApertura;
    }

    @Override
    public double depositar(double monto) {
        return 0;
    }

    @Override
    public double retirar(double monto) {
        if (monto > getSaldo() || getSaldo() == 0){
            System.out.println("Saldo insuficiente");
            return 0;
        }
            System.out.println("Saldo realizado");
            return getSaldo() - monto;
    }

    @Override
    public double aplicarInteres(double tasa) {
        return 0;
    }
}
