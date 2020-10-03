// package contabancaria;

import javax.swing.JOptionPane;

public class Inicio {
    public static void main(String[] args) {
        // Instanciando uma conta
        Conta conta1 = new Conta();

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
                    "0 - Sair"
                )
            );

            switch (menuPrincipal) {
                case 0: // Operação 0 - Sair

                    JOptionPane.showMessageDialog(null, "Saindo...");

                    break;
                case 1: // Operação 1 - Consultar saldo

                    JOptionPane.showMessageDialog(null, "Seu saldo atual é de R$" + conta1.consultarSaldo());

                    break;
                case 2: // Operação 2 - Depositar

                    double depositoValor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser depositado na conta:"));

                    conta1.depositarDinheiro(depositoValor);

                    break;
                case 3: // Operação 3 - debitarDinheiro

                    double debitarValor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser debitado da conta:"));

                    if (debitarValor > conta1.consultarSaldo()) {
                        JOptionPane.showMessageDialog(null, "Este valor não pode ser debitado, tente outro.");
                    }
                    else {
                        conta1.debitarDinheiro(debitarValor);
                    }

                    break;
                default: // Operação não encontrada

                    JOptionPane.showMessageDialog(null, "Operação Inválida, tente outra.");

                    break;
            }
        } while (menuPrincipal != 0);
    }
}