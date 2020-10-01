package contabancaria;

public class ValidacaoUsuario 
{	
	public static void main(String[] args) {
		MovimentaDinheiro dinheiro = new MovimentaDinheiro();
		dinheiro.debitar();
		dinheiro.depositar();
	}
}
