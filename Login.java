import javax.swing.JOptionPane;

public class Login {
    public String login[] = new String[10];
    public String senha[] = new String[10];
    public String agencia[] = new String[10];
    public int saldo[] = new int[10];

    public void Cadastro(String log1, String senh1, String agn1) {
        boolean statusCadastrado = false;

        // o seguinte loop percorre cada elemento do array e:

        for (int i = 0; i < login.length; i++) {
            // fecha se o login ou agencia já existir
            if (log1.equalsIgnoreCase(login[i]) || agn1.equals(agencia[i])) { break; }

            // adiciona os dados log, senh e agn no primeiro elemento vazio que encontrar
            if (login[i] == null && senha[i] == null && agencia[i] == null) {
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
        boolean statusLogado = false;
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
}
