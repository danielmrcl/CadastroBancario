package app.conta;

public class ContaTipo1 extends Conta {
    public ContaTipo1(int agencia) {
        super(agencia);
    }

    public void debitarDinheiro(double valor) {
        this.saldo -= valor;
    }
}
