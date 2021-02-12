package app.cliente;

import app.conta.Conta;
import app.conta.ContaTipo1;
import app.conta.ContaTipo2;

import java.util.LinkedList;
import java.util.List;

public class GerenciarCliente {
    public static List<Cliente> listaClientes = new LinkedList<>();

    public static boolean cadastrarCliente(int agencia, String login, String senha, int tipoConta) {
        // variavel de confirmação de cadastro
        boolean cadastradoSucesso = false;

        // verificar se esta agencia ou cpf já existe
        for (Cliente cliente : listaClientes) {
            boolean agenciaJaExiste = cliente.getConta().getAgencia() == agencia;
            boolean loginJaExiste = login.equalsIgnoreCase(cliente.getLogin());

            if (agenciaJaExiste || loginJaExiste) {
                return cadastradoSucesso;
            }
        }

        // criar uma conta tipo 1 ou tipo 2 conforme passado por parâmetro
        Conta conta;

        if (tipoConta == 1) {
            conta = new ContaTipo1(agencia);
        }
        else if (tipoConta == 2) {
            conta = new ContaTipo2(agencia);
        }
        else {
            return cadastradoSucesso = false;
        }

        // instanciar um cliente com a conta criada
        Cliente cliente = new Cliente(login, senha, conta, tipoConta);

        // adiciona o cliente na lista de clientes
        try {
            listaClientes.add(cliente);
            cadastradoSucesso = true;
        } catch (Exception e) {
            cadastradoSucesso = false;
        }

        return cadastradoSucesso;
    }

    public static Cliente logarCliente(String login, String senha) {
        // variavel de posição de login
        Cliente clienteLogado = null;

        // percorre a lista de clientes verificando o login e senha de cada cliente
        for (Cliente cliente : listaClientes) {
            boolean loginConfere = cliente.getLogin().equalsIgnoreCase(login);
            boolean senhaConfere = cliente.getSenha().equals(senha);

            if (loginConfere && senhaConfere) {
                clienteLogado = cliente;
            }
        }

        return clienteLogado;
    }
}
