public class Transferencia extends Transacao{

    private static final double LIMITE_PADRAO = 5000;

    public Transferencia() {
        limite = LIMITE_PADRAO;
    }

    public void realizar() {

        System.out.println("Selecionar conta de origem:");
        this.setOrigem(Conta.selecionar());
        System.out.println("Selecionar conta de destino:");
        this.setDestino(Conta.selecionar());
        if (origem==destino) {
            System.out.println("A conta de origem deve ser diferente da conta de destino.");
            MenuInicial.exibir();
        }
        this.setValor(Transacao.definirValor());
        if(origem.saldo >= valor) {
            origem.saldo -= valor;
            destino.saldo += valor;
            System.out.println("Transferência realizada com sucesso.");
        }  else System.out.println("Saldo insuficiente.");
    }
}
