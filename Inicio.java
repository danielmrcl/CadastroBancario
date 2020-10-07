import javax.swing.JOptionPane;

public class Inicio {
    public static void main(String[] args) {

        // Instanciando uma conta
        Conta conta1 = new Conta();

        int menuEntrada = 0;

        do {
            menuEntrada = Integer.parseInt(
                JOptionPane.showInputDialog(
                "OLÁ, BEM-VINDO(A) AO NOSSO SISTEMA BANCÁRIO!!\n" +
                "Escolha um das opções abaixo: \n" +
                "1 - Login \n" +
                "2 - Registrar \n" +
                "3 - Listar Cadastros\n" +
                "0 - Sair"
                )
            );

            switch(menuEntrada){
                case 1: // Login
                    conta1.statusLogado = false;

                    JOptionPane.showMessageDialog(null, "Já que escolheu logar, vamos lá.");

                    String log1 = JOptionPane.showInputDialog(null, "Login: ");
                    String senh1 = JOptionPane.showInputDialog(null, "Senha: ");

                    conta1.Logar(log1, senh1);

                    // quebra a operação se o login não foi ralizado com sucesso
                    if (!conta1.statusLogado) {
                        break;
                    }

                    System.out.println(conta1.posicaoLogin); // DEBUG

                    // Escolhendo uma operação do menu
                    int menuPrincipal = 0;

                    do {
                    // Desenhando o menu principal
                    menuPrincipal = Integer.parseInt(
                        JOptionPane.showInputDialog(
                        "Escolha uma das Opções:\n" +
                        "1 - Consultar Saldo;\n" +
                        "2 - Depositar\n" +
                        "3 - Debitar\n" +
                        "4 - Transferir\n" +
                        "0 - Voltar"
                        )
                    );

                    switch (menuPrincipal) {
                        case 1: // Operação 1 - Consultar saldo

                            JOptionPane.showMessageDialog(null,
                                "Seu saldo atual é de R$" + conta1.consultarSaldo(conta1.posicaoLogin)
                            );

                            break;
                        case 2: // Operação 2 - Depositar

                            double depositoValor = Double.parseDouble(
                                JOptionPane.showInputDialog("Digite o valor a ser depositado na conta:")
                            );

                            conta1.depositarDinheiro(depositoValor, conta1.posicaoLogin);

                            JOptionPane.showMessageDialog(null,
                                "R$" + depositoValor + " depositado na conta " + conta1.agencia[conta1.posicaoLogin] + "!"
                            );

                            break;
                        case 3: // Operação 3 - Debitar

                            double debitarValor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser debitado da conta:"));

                            if (debitarValor > conta1.consultarSaldo(conta1.posicaoLogin)) {
                                JOptionPane.showMessageDialog(null, "Este valor excede o saldo da conta, tente outro.");
                            }
                            else {
                                conta1.debitarDinheiro(debitarValor, conta1.posicaoLogin);
                            }

                            JOptionPane.showMessageDialog(null,
                                "R$" + debitarValor + " debitado da conta " + conta1.agencia[conta1.posicaoLogin] + "!"
                            );

                            break;
                        case 4: // Operação 4 - Transferência

                            int agn = Integer.parseInt(
                                JOptionPane.showInputDialog("Por favor, me informe a AGÊNCIA para qual você vai transferir o dinheiro: ")
                            );
                            double transferirValor = Double.parseDouble(
                                JOptionPane.showInputDialog("Agora, informe o valor a ser transferido: ")
                            );

                            if (transferirValor > conta1.consultarSaldo(conta1.posicaoLogin)) {
                                JOptionPane.showMessageDialog(null, "Este valor excede o saldo da conta, tente outro");
                                break;
                            }

                            conta1.transferencia(agn, conta1.posicaoLogin, transferirValor);

                            break;
                        case 0: // Operação 0 - Voltar

                            JOptionPane.showMessageDialog(null, "Voltando...");

                            break;
                        default: // Operação não encontrada

                            JOptionPane.showMessageDialog(null, "Operação Inválida, tente outra.");

                            break;
                        }
                    } while (menuPrincipal != 0);

                    break;
                case 2: // Registrar
                    JOptionPane.showMessageDialog(null, "Já que escolheu ser cadastrado, vamos lá.");

                    String log2 = JOptionPane.showInputDialog(null, "Login (letras e números): ");
                    String senh2 = JOptionPane.showInputDialog(null, "Senha (letras e números): ");
                    int agn2 = Integer.parseInt(
                        JOptionPane.showInputDialog(null, "Agência (apenas números): ")
                    );

                    conta1.Cadastro(log2, senh2, agn2);

                    break;
                case 3: // Listar Cadastros
                    String cadastros = "↓ login / agencia ↓\n";

                    for (int i = 0; i < conta1.login.length; i++) {
                        // pular se o login for vazio
                        if (conta1.login[i] == null) {
                            continue;
                        }

                        cadastros = cadastros + "  " + conta1.login[i] + " / " + conta1.agencia[i] + "\n";
                    }

                    JOptionPane.showMessageDialog(null, cadastros);

                    break;
                case 0: // Sair
                    JOptionPane.showMessageDialog(null, "Saindo...");

                    break;
                default: // Operação não encontrada

                    JOptionPane.showMessageDialog(null, "Operação Inválida, tente outra.");

                    break;
            }
        } while (menuEntrada != 0);
    }
}
