public class Deposito extends Transacao{

    private static final double LIMITE_PADRAO = Double.POSITIVE_INFINITY;

    public Deposito() {
        limite = LIMITE_PADRAO;
    }

    public void realizar() {
        this.setDestino(Conta.selecionar());
        this.setValor(Transacao.definirValor());
        destino.saldo += valor;
        System.out.println("Depósito realizado com sucesso.");
    }
}
