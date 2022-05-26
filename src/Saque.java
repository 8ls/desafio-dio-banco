import java.util.Scanner;

public class Saque extends Transacao{

    private static final double LIMITE_PADRAO = 2000;

    public Saque() {
        limite = LIMITE_PADRAO;
    }

    public void realizar() {
        Scanner scan = new Scanner(System.in);

        this.setOrigem(Conta.selecionar());
        this.setValor(Transacao.definirValor());
        if(origem.saldo >= valor) {
            origem.saldo -= valor;
            System.out.println("Saque realizado com sucesso.");
        }  else System.out.println("Saldo insuficiente.");
    }

}
