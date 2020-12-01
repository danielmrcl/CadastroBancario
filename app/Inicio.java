package app;

import javax.swing.JOptionPane;

public class Inicio {

    // lista de clientes criada de modo global
    public static Cliente[] listaClientes = new Cliente[20];

    public static void main(String[] args) {

        int menuEntrada = 0;

        do {
            menuEntrada = Integer.parseInt(
                JOptionPane.showInputDialog(
                "OLÁ, BEM-VINDO(A) AO NOSSO SISTEMA BANCÁRIO!!\n" +
                "\n" +
                "Escolha um das opções abaixo: \n" +
                "1 - Login \n" +
                "2 - Registrar \n" +
                "3 - Listar Cadastros\n" +
                "0 - Sair"
                )
            );

            switch (menuEntrada) {
                case 1: // Login

                    JOptionPane.showMessageDialog(null, "Logando...");
                    String login1 = JOptionPane.showInputDialog(null, "Login (letras e números): ");
                    String senha1 = JOptionPane.showInputDialog(null, "Senha (letras e números): ");

                    // verificando o login e guardando a posição
                    int posicaoCliente = logarCliente(login1, senha1);

                    if (posicaoCliente >= 0) {
                        JOptionPane.showMessageDialog(null, "Logado com sucesso no login " + listaClientes[posicaoCliente].getLogin());
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Ocorreu uma falha no login. Verifique se o login existe e se a senha esta correta");
                        break;
                    }

                    Cliente clienteLogado = listaClientes[posicaoCliente];

                    // desenhando o menu de conta
                    int menuConta = 0;

                    do {
                        menuConta = Integer.parseInt(JOptionPane.showInputDialog(
                        "Agencia: " + clienteLogado.getConta().getAgencia() + "\n" +
                        "Login: " + clienteLogado.getLogin() + "\n" +
                        "Saldo: " + clienteLogado.getConta().getSaldo() + "\n" +
                        "\n" +
                        "Escolha uma das Opções:\n" +
                        "1 - Depositar\n" +
                        "2 - Debitar\n" +
                        "3 - Transferir\n" +
                        "0 - Voltar"
                        ));

                        switch (menuConta) {
                            case 1: // Depositar
                                
                                // valor à ser depositado
                                double depositoValor = Double.parseDouble(
                                    JOptionPane.showInputDialog("Digite o valor a ser depositado na conta:")
                                );

                                // verificando se o valor é menor que o limite mínimo
                                if (depositoValor < 1.00) {
                                    JOptionPane.showMessageDialog(null, "O limite mínimo para depósito é R$1.");
                                    break;
                                }

                                // depositando
                                clienteLogado.getConta().depositarDinheiro(depositoValor);

                                // mensagen de concluído
                                JOptionPane.showMessageDialog(
                                    null, "R$" + depositoValor + " depositado na conta " + clienteLogado.getConta().getAgencia() + "!"
                                );

                                break;
                            case 2: // Debitar
                                
                                // valor a ser debitado
                                double debitarValor = Double.parseDouble(JOptionPane.showInputDialog(
                                    "Digite o valor a ser debitado da conta:"
                                ));
                                
                                // verificando se o valor digitado excede o valor em conta
                                if (debitarValor > clienteLogado.getConta().getSaldo()) {
                                    JOptionPane.showMessageDialog(null, "Este valor excede o saldo da conta, tente outro.");
                                }
                                // debitando se não exceder
                                else {
                                    clienteLogado.getConta().debitarDinheiro(debitarValor);
                                }

                                // mensagen de concluído
                                JOptionPane.showMessageDialog(null,
                                    "R$" + debitarValor + " debitado da conta " + clienteLogado.getConta().getAgencia() + "!"
                                );

                                break;
                            case 3: // Transferência
                                
                                // agencia para qual será transferido o dinheiro
                                int agenciaDestino = Integer.parseInt(JOptionPane.showInputDialog(
                                    "Por favor, me informe a AGÊNCIA para qual você vai transferir o dinheiro: "
                                ));
                                // valor à ser transferido
                                double transferirValor = Double.parseDouble(JOptionPane.showInputDialog(
                                    "Agora, informe o valor a ser transferido: "
                                ));

                                // verificando o saldo da conta
                                if (transferirValor > clienteLogado.getConta().getSaldo()) {
                                    JOptionPane.showMessageDialog(null, "Este valor excede o saldo da conta, tente outro");
                                    break;
                                }

                                // variavel para validar a transferencia
                                boolean transferidoSucesso = false;

                                // varrendo a lista de contas
                                for (int i = 0; i < listaClientes.length; i++) {
                                    // pular se a posição for nula
                                    if (listaClientes[i] == null) { continue; }

                                    // confirmando a agencia e armazenando a conta de destino
                                    if (listaClientes[i].getConta().getAgencia() == agenciaDestino) {
                                        Conta contaDestino = listaClientes[i].getConta();
                                        transferidoSucesso = true;

                                        // transferindo o dinheiro para a conta de destino
                                        clienteLogado.getConta().transferirDinheiro(contaDestino, transferirValor);

                                        break;
                                    }
                                }
                                
                                // validando transferencia
                                if (transferidoSucesso) {
                                    JOptionPane.showMessageDialog(
                                        null, "Foi transferida a quantida de R$" + transferirValor + "!"
                                    );
                                }
                                else {
                                    JOptionPane.showMessageDialog(
                                        null, "Falha na transferencia, verifique a agencia " + agenciaDestino + " existe"
                                    );
                                }

                                break;
                            case 0: // Voltar
                                JOptionPane.showMessageDialog(null, "Voltando...");
                                break;
                            default: // Operação não encontrada
                                JOptionPane.showMessageDialog(null, "Operação Inválida, tente outra.");
                        }

                    } while (menuConta != 0);

                    break;
                case 2: // Cadastrar
                    
                    JOptionPane.showMessageDialog(null, "Cadastrando...");
                    String login2 = JOptionPane.showInputDialog(null, "Login (letras e números): ");
                    String senha2 = JOptionPane.showInputDialog(null, "Senha (letras e números): ");
                    int agencia2 = Integer.parseInt(
                        JOptionPane.showInputDialog(null, "Agência (apenas números): ")
                    );

                    boolean cadastradoSucesso = cadastrarCliente(agencia2, login2, senha2);

                    // confirmação de cadastro
                    if (cadastradoSucesso) {
                        JOptionPane.showMessageDialog(null, "Usuario " + login2 + " cadastrado com sucesso!!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Erro no cadastro, verifique se este login ou agencia ja existe");
                    }

                    break;
                case 3: // Listar Cadastros
                    String cadastros = "↓ login / agencia ↓\n";
                    
                    for (int i = 0; i < listaClientes.length; i++) {
                        // pular se o login for vazio
                        if (listaClientes[i] == null) {
                            continue;
                        }

                        cadastros = cadastros + "  " + listaClientes[i].getLogin() + " / " + listaClientes[i].getConta().getAgencia() + "\n";
                    }

                    JOptionPane.showMessageDialog(null, cadastros);

                    break;
                case 0: // Sair
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default: // Opção não encontrada
                    JOptionPane.showMessageDialog(null, "Operação Inválida, tente outra.");
            }
        } while (menuEntrada != 0);

    }

    // metodo para cadastrar novos clientes
    public static boolean cadastrarCliente(int agencia, String login, String senha) {
        // variavel de confirmação de cadastro
        boolean cadastradoSucesso = false;

        for (int i = 0; i < listaClientes.length; i++) {
            // pular se a posição for nula
            if (listaClientes[i] == null) { continue; }

            // verificar se esta agencia ou login já existe
            if (agencia == listaClientes[i].getConta().getAgencia() || login.equalsIgnoreCase(listaClientes[i].getLogin())) {
                return cadastradoSucesso;
            }
        }

        // criar uma nova conta para o cliente
        Conta conta = new Conta(agencia);
        
        // instanciar um cliente
        Cliente cliente = new Cliente(conta, login, senha);

        // adiciona o cliente na lista de clientes
        for (int i = 0; i < listaClientes.length; i++) {
            if (listaClientes[i] == null) {
                listaClientes[i] = cliente;
                cadastradoSucesso = true;
                break;
            }
        }

        return cadastradoSucesso;
    }

    // metodo para logar clientes existentes
    public static int logarCliente(String login, String senha) {
        // variavel de posição de login
        int posicao = -1;

        // percorre a lista de clientes verificando o login e senha de cada cliente
        for (int i = 0; i < listaClientes.length; i++) {
            // pular se o espaço do array estiver vazio
            if (listaClientes[i] == null) { continue; }

            // confirmação de usuario e senha
            boolean loginConfere = listaClientes[i].getLogin().equalsIgnoreCase(login);
            boolean senhaConfere = listaClientes[i].getSenha().equals(senha);

            // usuario e senha confirmado
            if (loginConfere && senhaConfere) {
                posicao = i;
                break;
            }
        }

        return posicao;

    }
}
