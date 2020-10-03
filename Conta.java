// package contabancaria;

public class Conta {
    private double saldo_conta = 0.0;

    public double consultarSaldo() {
        return this.saldo_conta;
    }

    public void depositarDinheiro(double valor) {
        this.saldo_conta += valor;
    }

    public void debitarDinheiro(double valor) {
        this.saldo_conta -= valor;
    }
    public void transferencia(){
        
    }
}
