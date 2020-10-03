import javax.swing.JOptionPane;
public class Login {
    String Login[] = new String[10];
    String Senha[] = new String[10];
    String Agencia[] = new String[10];
    

    public String Cadastro(String log, String senh, String Agn){
        Boolean j = true;
        for(int i = 0; j = false; i++){
            Login[i] = log;
            Senha[i] = senh;
            Agencia[i] = Agn;
            j = true;
        }
        JOptionPane.showMessageDialog(null, "VOCÊ FOI CADASTRADO");
        return "";
    }

    public String Logar(String log, String senh, String Agn){
        Boolean valor = true;
        while (valor = true){
            // Aqui é a parte que eu não
            if (){
                return JOptionPane.showInputDialog(null, "O login foi um sucesso!!");
                valor = true;
            }else{
                return JOptionPane.showInputDialog(null, "O login não foi um sucesso!! Tente novamente!!");
                continue;
            }
        }
        
        
    }
}
