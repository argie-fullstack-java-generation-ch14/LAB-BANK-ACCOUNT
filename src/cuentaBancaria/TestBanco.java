package cuentaBancaria;
public class TestBanco {
    public static void main(String[] args) {
        System.out.println("Creación de Cuentas");

        CuentaAhorro cuentaAna = new CuentaAhorro("AH001", "Ana Perez", 50000, "2024-01-15");
        CuentaCorriente cuentaLuis = new CuentaCorriente("CC001", "Luis Gomez", 20000);
        CuentaEmpresarial cuentaTech = new CuentaEmpresarial("EM001", "Tech Solutions", 200000, "Tech Solutions", "123456789-0");
        CuentaAhorro cuentaMaria = new CuentaAhorro("AH002", "Maria Lopez", 15000, "2024-02-01");

        System.out.println("Información inicial: ");

        cuentaAna.mostrarInfo();
        System.out.println();

        cuentaLuis.mostrarInfo();
        System.out.println();

        cuentaTech.mostrarInfo();
        System.out.println();

        cuentaMaria.mostrarInfo();

        System.out.println("Operaciones");

        System.out.println("Deposito Ana Perez");
        cuentaAna.depositar(10000);

        System.out.println("Retiro Luis Gomez");
        cuentaLuis.retirar(25000);

        System.out.println("Retiro Tech Solutions");
        cuentaTech.retirar(10000);

        System.out.println("Retiro de Maria Lopez");
        cuentaMaria.retirar(20000);

        System.out.println("Aplicación de interes");

        cuentaAna.aplicarInteres(2.5);
        cuentaLuis.aplicarInteres(0.0);
        cuentaTech.aplicarInteres(1.5);
        cuentaMaria.aplicarInteres(2.5);

        System.out.println("Estado final");

        cuentaAna.mostrarInfo();
        System.out.println();

        cuentaLuis.mostrarInfo();
        System.out.println();

        cuentaTech.mostrarInfo();
        System.out.println();

        cuentaMaria.mostrarInfo();

        System.out.println("Resumen");

        int totalCuentas = 4;
        double saldoTotal = cuentaAna.getSaldo() + cuentaLuis.getSaldo() + cuentaTech.getSaldo() + cuentaMaria.getSaldo();
        double promedioSaldo = saldoTotal / totalCuentas;
        CuentaBancaria cuentaMayor = cuentaAna;

        if (cuentaLuis.getSaldo() > cuentaMayor.getSaldo()){
            cuentaMayor = cuentaLuis;
        }

        if (cuentaTech.getSaldo() > cuentaMayor.getSaldo()){
            cuentaMayor = cuentaTech;
        }

        if (cuentaMaria.getSaldo() > cuentaMayor.getSaldo()){
            cuentaMayor = cuentaMaria;
        }

        System.out.println("Total de cuentas: " + totalCuentas);
        System.out.println("Saldo total: $" + String.format("%.2f", saldoTotal));
        System.out.println("Promedio de saldo: $" + String.format("%.2f", promedioSaldo));

        System.out.println("Cuenta con mayor saldo:");
        System.out.println("Numero de cuenta: " + cuentaMayor.getNumeroCuenta());
        System.out.println("Titular: " + cuentaMayor.getTitular());
        System.out.println("Saldo: $" + String.format("%.2f", cuentaMayor.getSaldo()));
    }
}