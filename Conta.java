// package contabancaria;
import javax.swing.JOptionPane;

public class Conta {
    public Login login = new Login();
    public int j;
    public String verificalogin(String log1){
        int i = 0;
        while (true){
            if (log1 == login.login[i]){
                j = i;
                return Integer.toString(j);
            }
            i += 1;
            continue;
        }
    }
    public int consultarSaldo(int a){
        return this.login.saldo[a];
    }
    public void depositarDinheiro(double valor, int a) {
        this.login.saldo[a] += valor;
    }
    public void debitarDinheiro(double valor, int a) {
        this.login.saldo[a] -= valor;
    }
    public void transferencia(String Agn, Double Din){
        for(int i = 0; i < login.agencia.length; i++){
            if(login.agencia[i] == Agn){
                this.login.saldo[i] += Din;
                JOptionPane.showMessageDialog(null, "O dinheiro foi transferido!");
            }else{
                JOptionPane.showMessageDialog(null, "Deu falha");
            }
        } 
    } 
}
