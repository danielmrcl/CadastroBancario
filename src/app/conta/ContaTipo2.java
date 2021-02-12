package app.conta;

public class ContaTipo2 extends Conta {
    public ContaTipo2(int agencia) {
        super(agencia);
    }

    public void transferirDinheiro(Conta contaDestino, double valor) {
        this.saldo -= valor;
        contaDestino.depositarDinheiro(valor);
    }
}
