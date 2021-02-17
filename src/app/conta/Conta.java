package app.conta;

public abstract class Conta {
    private int agencia;
    protected double saldo;

    public Conta(int agencia) {
        this.agencia = agencia;
        this.saldo = 0;
    }

    public void depositarDinheiro(double valor) {
        this.saldo += valor;
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
