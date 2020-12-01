package app;

public class Conta {

    private int agencia;
    private double saldo;

    public Conta(int agencia) {
        this.agencia = agencia;
        this.saldo = 0;
    }

    public void depositarDinheiro(double valor) {
        this.saldo += valor;
    }

    public void debitarDinheiro(double valor) {
        this.saldo -= valor;
    }

    public void transferirDinheiro(Conta contaDestino, double valor) {
        this.debitarDinheiro(valor);
        contaDestino.depositarDinheiro(valor);
    }

    public int getAgencia() {
        return this.agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
