package cuentaBancaria;

public class CuentaCorriente extends CuentaBancaria{
    private double limiteSobregiro = 50000;
    private double porcentajeComisionSobregiro = 5.0;


    public CuentaCorriente(String numeroCuenta, String titular, double saldo, double limiteSobregiro, double porcentajeComisionSobregiro) {
        super(numeroCuenta, titular, saldo, 0.0 );
        this.limiteSobregiro = limiteSobregiro;
        this.porcentajeComisionSobregiro = porcentajeComisionSobregiro;
    }

    public CuentaCorriente(String numeroCuenta, String titular, double saldo){
        this(numeroCuenta, titular, saldo,50000, 5.0 );
    }

    @Override
    public double depositar(double monto){
        if (monto <= 0){
            actualizaSaldo(this.getSaldo() + monto);
        }
        return getSaldo();
    }

    @Override
    public double retirar(double monto){
        if(monto <= 0){
            System.out.println("El monto a retirar debe ser mayor a cero");
            return getSaldo();
        }
        double saldoDisponible = getSaldo()+limiteSobregiro;

        if(monto <= saldoDisponible){
            double nuevoSaldo = getSaldo() - monto;

            if (nuevoSaldo < 0){
                double montoSobregirado = nuevoSaldo * -1;
                double comision = montoSobregirado * (porcentajeComisionSobregiro / 100.);
                nuevoSaldo = nuevoSaldo -comision;
                System.out.println("comisión por sobregiro aplicada : $" + comision);

            }
            System.out.println("Retiro exitoso");
            System.out.println("Nuevo saldo: "+ nuevoSaldo);

        }else {
            System.out.println("Saldo insuficiente");
        }
        return getSaldo();

    }

    @Override
    public double aplicarInteres(double monto){
        return getTasaInteres();
    }

    @Override
    public void mostrarInfo(){
        System.out.println("Numero Cuenta: " + this.getNumeroCuenta());
        System.out.println("Titular: " + this.getTitular());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Tasa Interes: 0.0");
        System.out.println("Limite de Sobregiro: " + this.limiteSobregiro);
    }


}


