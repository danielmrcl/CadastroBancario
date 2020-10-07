// package contabancaria;
import javax.swing.JOptionPane;

public class Conta {
    public Login login = new Login();
    public int j;
    public String verificalogin(String log1){
        for(int i = 0; i < 10; i++){
            if (log1 == login.login[i]){
                j = i;
                return Integer.toString(j);
            }
        }
        return Integer.toString(j);
    }
    public int consultarSaldo(int a){
        return this.login.saldo[a];
    }
    public void depositarDinheiro(int valor, int a) {
        this.login.saldo[a] += valor;
    }
    public void debitarDinheiro(int valor, int a) {
        this.login.saldo[a] -= valor;
    }
    public void transferencia(String Agn, int Din){
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
