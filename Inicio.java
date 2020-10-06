// package contabancaria;

import javax.swing.JOptionPane;

public class Inicio {
    public static void main(String[] args) {
        // Instanciando uma conta
        Conta conta1 = new Conta();
        Login login1 = new Login();

        int menuEntrada = 0;

        do {
            menuEntrada = Integer.parseInt(
                JOptionPane.showInputDialog(
                "OLÁ, BEM-VINDO(A) AO NOSSO SISTEMA BANCÁRIO!!\n" +
                "Escolha um das opções abaixo: \n" +
                "1 - Login \n" +
                "2 - Registrar \n" +
                "0 - Sair"

                )
                );


            switch(menuEntrada){
                case 1: // Login
                    String log1;
                    String senh1;

                    JOptionPane.showMessageDialog(null, "Já que escolheu logar, vamos lá.");

                    log1 = JOptionPane.showInputDialog(null, "Login: ");
                    senh1 = JOptionPane.showInputDialog(null, "Senha: ");

                    login1.Logar(log1, senh1);
                

                    // TODO: para gerenciar a conta precisa estar logado.

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
                    int a = Integer.parseInt(conta1.verificalogin(log1)); //Correção
                    switch (menuPrincipal) {
                        case 0: // Operação 0 - Voltar

                            JOptionPane.showMessageDialog(null, "Voltando...");

                            break;
                        case 1: // Operação 1 - Consultar saldo

                            JOptionPane.showMessageDialog(null, "Seu saldo atual é de R$" + conta1.consultarSaldo(a));

                            break;
                        case 2: // Operação 2 - Depositar

                            double depositoValor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser depositado na conta:"));

                            conta1.depositarDinheiro(depositoValor, a);

                            break;
                        case 3: // Operação 3 - debitarDinheiro

                            double debitarValor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser debitado da conta:"));

                            if (debitarValor > conta1.consultarSaldo(a)) {
                                JOptionPane.showMessageDialog(null, "Este valor não pode ser debitado, tente outro.");
                            }
                            else {
                                conta1.debitarDinheiro(debitarValor, a);
                            }

                            break;
                        case 4: // Operação 4 - Transferência
                            
                            String Agn = JOptionPane.showInputDialog("Por favor, me informe a agência para qual você vai transferir o dinheiro: ");
                            String Dins = JOptionPane.showInputDialog("Agora, informe o valor a ser transferido: ");
                            conta1.transferencia(Agn, Double.parseDouble(Dins));
                            break;     
                        default: // Operação não encontrada

                            JOptionPane.showMessageDialog(null, "Operação Inválida, tente outra.");

                            break;
                        }
                    } while (menuPrincipal != 0);

                    break;
                case 2: // Registrar
                    String log2;
                    String senh2;
                    String agn2;

                    JOptionPane.showMessageDialog(null, "Já que escolheu ser cadastrado, vamos lá.");

                    log2 = JOptionPane.showInputDialog(null, "Login: ");
                    senh2 = JOptionPane.showInputDialog(null, "Senha: ");
                    agn2 = JOptionPane.showInputDialog(null, "Agência: ");

                    login1.Cadastro(log2, senh2, agn2);

                    break;

                case 0: // Sair
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;

            }
        } while (menuEntrada != 0);
    }
}