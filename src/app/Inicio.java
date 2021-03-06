package app;

import javax.swing.JOptionPane;

import app.cliente.Cliente;
import app.conta.ContaTipo1;
import app.cliente.GerenciarCliente;
import app.conta.GerenciarConta;

public class Inicio {
    public static void main(String[] args) {

        int menuEntrada = 0;

        do {
            try {
                menuEntrada = Integer.parseInt(JOptionPane.showInputDialog(
                    "OLÁ, BEM-VINDO(A) AO NOSSO SISTEMA BANCÁRIO!!\n" +
                    "\n" +
                    "Escolha um das opções abaixo: \n" +
                    "1 - Login \n" +
                    "2 - Registrar \n" +
                    "3 - Listar Cadastros\n" +
                    "0 - Sair"
                ));
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada Inválida, selecionando 0 - Sair.");
            }

            switch (menuEntrada) {
                case 1: // Login

                    JOptionPane.showMessageDialog(null, "Logando...");
                    String login = JOptionPane.showInputDialog(null, "Login (letras e números): ");
                    String senha = JOptionPane.showInputDialog(null, "Senha (letras e números): ");

                    // verificando o login e guardando a posição
                    Cliente clienteLogado = GerenciarCliente.logarCliente(login, senha);

                    if (clienteLogado != null) {
                        JOptionPane.showMessageDialog(null, "Logado com sucesso no login " + clienteLogado.getLogin());
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Ocorreu uma falha no login. Verifique se o login existe e se a senha esta correta");
                        break;
                    }

                    // desenhando o menu de conta
                    int menuConta = 0;

                    do {
                        try {
                            menuConta = Integer.parseInt(JOptionPane.showInputDialog(
                                "Agencia: " + clienteLogado.getConta().getAgencia() + "\n" +
                                "Tipo conta: " + clienteLogado.getTipoConta() + "\n" +
                                "Login: " + clienteLogado.getLogin() + "\n" +
                                "Saldo: " + clienteLogado.getConta().getSaldo() + "\n" +
                                "\n" +
                                "Escolha uma das Opções:\n" +
                                "1 - Depositar\n" +
                                "2 - Debitar\n" +
                                "3 - Transferir\n" +
                                "0 - Voltar"
                            ));
                        }
                        catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null,
                                "Entrada Inválida, selecionando 0 - Voltar."
                            );
                        }

                        switch (menuConta) {
                            case 1: // Depositar

                                double depositoValor = 0;
                                // valor à ser depositado
                                try {
                                    depositoValor = Double.parseDouble(
                                        JOptionPane.showInputDialog("Digite o valor a ser depositado na conta:")
                                    );
                                }
                                catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null,
                                        "Entrada Inválida, o valor para depósito precisa ser um número."
                                    );
                                }

                                // verificando se o valor é menor que o limite mínimo
                                if (depositoValor < 1.00) {
                                    JOptionPane.showMessageDialog(null,
                                        "O limite mínimo para depósito é R$1."
                                    );
                                    break;
                                }

                                // depositando
                                clienteLogado.getConta().depositarDinheiro(depositoValor);

                                // mensagen de concluído
                                JOptionPane.showMessageDialog(null,
                                    "R$" + depositoValor + " depositado na conta " + clienteLogado.getConta().getAgencia() + "!"
                                );

                                break;
                            case 2: // Debitar

                                // verificando tipo de conta
                                if (clienteLogado.getTipoConta() == 2) {
                                    JOptionPane.showMessageDialog(null, "Você não pode debitar em uma conta tipo 2");
                                    break;
                                }

                                // valor a ser debitado
                                double debitarValor = 0;
                                try {
                                    debitarValor = Double.parseDouble(JOptionPane.showInputDialog(
                                        "Digite o valor a ser debitado da conta:"
                                    ));
                                }
                                catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null,
                                        "Entrada Inválida: O valor precisa ser numérico Voltando..."
                                    );
                                }

                                // verificando se o valor digitado excede o valor em conta
                                if (debitarValor > clienteLogado.getConta().getSaldo()) {
                                    JOptionPane.showMessageDialog(null, "Este valor excede o saldo da conta, tente outro.");
                                    break;
                                }

                                // converte a conta para o tipo 1 para realizar a operação de debito
                                ContaTipo1 contaClienteLogadoDebitar = (ContaTipo1) clienteLogado.getConta();
                                contaClienteLogadoDebitar.debitarDinheiro(debitarValor);

                                // mensagen de concluído
                                JOptionPane.showMessageDialog(null,
                                    "R$" + debitarValor + " debitado da conta " + clienteLogado.getConta().getAgencia() + "!"
                                );

                                break;
                            case 3: // Transferência

                                // verificando e convertendo o tipo da conta
                                if (clienteLogado.getTipoConta() == 1) {
                                    JOptionPane.showMessageDialog(null, "Você não pode realizar transferência de uma conta tipo 1");
                                    break;
                                }

                                int agenciaDestino = 0;
                                double transferirValor = 0;
                                try {
                                    // agencia para qual será transferido o dinheiro
                                    agenciaDestino = Integer.parseInt(JOptionPane.showInputDialog(
                                        "Por favor, me informe a AGÊNCIA para qual você vai transferir o dinheiro: "
                                    ));
                                    // valor à ser transferido
                                    transferirValor = Double.parseDouble(JOptionPane.showInputDialog(
                                        "Agora, informe o valor a ser transferido: "
                                    ));
                                }
                                catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null,
                                        "Entrada Inválida: O valor precisa ser numérico. Voltando..."
                                    );
                                }

                                // verificando o saldo da conta
                                if (transferirValor > clienteLogado.getConta().getSaldo()) {
                                    JOptionPane.showMessageDialog(null, "Este valor excede o saldo da conta, tente outro");
                                    break;
                                }

                                // variavel para validar a transferencia
                                boolean transferidoSucesso = GerenciarConta.transferirEntreClientes(clienteLogado, transferirValor, agenciaDestino);

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

                    String loginCadastro = JOptionPane.showInputDialog("Login (letras e números)");
                    String senhaCadastro = JOptionPane.showInputDialog("Senha (letras e números)");

                    // escolher o tipo de conta
                    int tipoConta = 0;
                    int agenciaCadastro;
                    try {
                        while (true) {
                            agenciaCadastro = Integer.parseInt(JOptionPane.showInputDialog("Agência (4 dígitos)"));
                            int tamanhoAgencia = String.valueOf(agenciaCadastro).length();

                            if (agenciaCadastro > 0 && tamanhoAgencia == 4) {
                                break;
                            }
                            else {
                                JOptionPane.showMessageDialog(null,
                                    "O número da agencia precisa ter 4 dígitos e ser maior que zero."
                                );
                            }
                        }

                        tipoConta = Integer.parseInt(JOptionPane.showInputDialog(
                            "Tipo de Conta:" + "\n" +
                            "1 - Conta Deposito e Saque" + "\n" +
                            "2 - Conta Deposito e Transferencia"
                        ));
                    }
                    catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Operação Inválida, tente outra.");
                        break;
                    }

                    boolean cadastradoSucesso = GerenciarCliente.cadastrarCliente(agenciaCadastro, loginCadastro, senhaCadastro, tipoConta);

                    // confirmação de cadastro
                    if (cadastradoSucesso) {
                        JOptionPane.showMessageDialog(null, "Usuario " + loginCadastro + " cadastrado com sucesso!!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Erro no cadastro, verifique se este login ou agencia ja existe");
                    }

                    break;
                case 3: // Listar Cadastros
                    String cadastros = "↓ login / agencia / tipo conta ↓\n";

                    for (Cliente cliente : GerenciarCliente.listaClientes) {
                        cadastros += cliente.getLogin() + "  /  ";
                        cadastros += cliente.getConta().getAgencia() + "  /  Tipo: ";
                        cadastros += cliente.getTipoConta() + "\n";
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
}
