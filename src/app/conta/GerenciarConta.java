package app.conta;

import app.cliente.Cliente;
import app.cliente.GerenciarCliente;

public class GerenciarConta {
    public static boolean transferirEntreClientes(Cliente clienteLogado, double transferirValor, int agenciaDestino) {
        boolean transferidoSucesso = false;

        for (Cliente cliente : GerenciarCliente.listaClientes) {
            boolean confirmaAgencia = cliente.getConta().getAgencia() == agenciaDestino;

            if (confirmaAgencia) {
                Conta contaDestino = cliente.getConta();

                // convertendo o tipo da conta e transferindo o dinheiro para a conta de destino
                try {
                    ContaTipo2 contaClienteLogadoTransfeir = (ContaTipo2) clienteLogado.getConta();
                    contaClienteLogadoTransfeir.transferirDinheiro(contaDestino, transferirValor);
                    transferidoSucesso = true;
                } catch (Exception e) {
                    transferidoSucesso = false;
                }

            }
        }

        return transferidoSucesso;
    }
}
