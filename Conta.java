import javax.swing.JOptionPane;

public class Conta {

    public String login[] = new String[10];
    private String senha[] = new String[10];
    public int agencia[] = new int[10];
    private double saldo[] = new double[10];

    public boolean statusLogado = false;
    public int posicaoLogin;

    public void Cadastro(String log1, String senh1, int agn1) {
        boolean statusCadastrado = false;

        // o seguinte loop percorre cada elemento do array e:

        for (int i = 0; i < login.length; i++) {
            // fecha se o login ou agencia já existir
            if (log1.equalsIgnoreCase(login[i]) || agn1 == agencia[i]) {
                break;
            }

            // adiciona os dados log, senh e agn no primeiro elemento vazio que encontrar
            if (login[i] == null && senha[i] == null) {
                login[i] = log1;
                senha[i] = senh1;
                agencia[i] = agn1;
                saldo[i] = 0;
                statusCadastrado = true;

                break;
            }
        }

        if (statusCadastrado) {
            JOptionPane.showMessageDialog(null, "VOCÊ FOI CADASTRADO");
        }
        else {
            JOptionPane.showMessageDialog(null, "O CADASTRO NÃO FOI REALIZADO, verifique se o usuario ou a agencia já existem");
        }
    }

    public void Logar(String log2, String senh2){
        boolean confereUsuario = false;
        boolean confereSenha = false;

        for (int i = 0; i < login.length; i++) {
            // pular se o espaço do array estiver vazio
            if (login[i] == null) { continue; }

            // conferindo o usuario e a senha
            confereUsuario = log2.equalsIgnoreCase(login[i]);
            confereSenha = senh2.equals(senha[i]);

            // o usuario e a senha conferem
            if (confereUsuario && confereSenha) {
                statusLogado = true;
                posicaoLogin = i;

                JOptionPane.showMessageDialog(null,
                    "LOGADO COM SUCESSO NA CONTA:"+
                    "\nLogin: " + login[i] +
                    "\nAgencia: " + agencia[i]
                );

                break;
            }
            // a senha não confere
            else if (confereUsuario && !confereSenha) {
                JOptionPane.showMessageDialog(null, "Senha incorreta!");
            }
        }

        // falha no login
        if (!statusLogado) {
            JOptionPane.showMessageDialog(null, "O login não foi realizado! Verifique se sua conta esta cadastrada!");
        }
    }

    public double consultarSaldo(int login) {
        return saldo[login];
    }

    public void depositarDinheiro(double valor, int login) {
        this.saldo[login] += valor;
    }

    public void debitarDinheiro(double valor, int login) {
        this.saldo[login] -= valor;
    }

    public void transferencia(int agenciaDestino, int posicaoLogin, double valor) {
        boolean agenciaEncontrada = false;

        // encontra a agencia correspodente
        for(int i = 0; i < agencia.length; i++) {
            if (agencia[i] == agenciaDestino) {
                agenciaEncontrada = true;

                // debita o valor do remetente e deposita no destinatario
                this.saldo[posicaoLogin] -= valor;
                this.saldo[i] += valor;

                JOptionPane.showMessageDialog(null,
                    "Foi transferida a quantida de R$" + valor + "!"
                );

                break;
            }
        }

        if (!agenciaEncontrada) {
            JOptionPane.showMessageDialog(null, "Este numero e agencia não existe!");
        }
    }

}
