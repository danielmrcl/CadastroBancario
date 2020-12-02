package app.cliente;

import app.conta.*;

public class Cliente {
    private Conta conta;
    private String login;
    private String senha;
    private int tipoConta;

    public Cliente(String login, String senha, Conta conta, int tipoConta) {
        this.setLogin(login);
        this.setSenha(senha);
        this.setTipoConta(tipoConta);
        this.setConta(conta);
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

    public int getTipoConta() {
        return this.tipoConta;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }
}
