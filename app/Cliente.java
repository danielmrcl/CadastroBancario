package app;

public class Cliente {
    private Conta conta;
    private String login;
    private String senha;

    public Cliente(Conta conta, String login, String senha) {
        this.setConta(conta);;
        this.setLogin(login);;
        this.setSenha(senha);;
    }

    public Conta getConta() {
        return this.conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
