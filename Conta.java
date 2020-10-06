import javax.swing.JOptionPane;

// package contabancaria;

public class Conta {
    public Login login = new Login();
    Login login2 = new Login();

    public double consultarSaldo() {
        return this.login2.saldo[i];
    }

    public void depositarDinheiro(double valor) {
        this.login2.saldo[i] += valor;
    }

    public void debitarDinheiro(double valor) {
        this.login2.saldo[i] -= valor;
    }
    public void transferencia(String Agn, Double Din){
        for(int i = 0; i < login.agencia.length; i++){
            if(login.agencia[i] == Agn){
                this.login2.saldo[i] += Din;
            }else{
                JOptionPane.showMessageDialog(null, "Deu falha");
            }
        } 
        

    }
}
