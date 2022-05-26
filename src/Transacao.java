import java.util.Scanner;

public abstract class Transacao {

    protected Conta origem;
    protected Conta destino;
    protected double valor;
    protected static double limite;

    protected Transacao() {
    }

    protected void setOrigem(Conta origem) {
        this.origem = origem;
    }

    protected void setDestino(Conta destino) {
        this.destino = destino;
    }

    protected void setValor(double valor) {
        this.valor = valor;
    }

    public static void selecionar() {
        Scanner scan = new Scanner(System.in);
        int opcao;
        Transacao transacao;

        System.out.print("\n=== SELECIONAR TRANSAÇÃO ===\n" +
                             "1 - Saque\n2 - Depósito\n3 - Transferência\n4 - Voltar\nOpção: ");
        opcao = scan.nextInt();

        switch (opcao) {
            case 1:
                transacao = new Saque();
                System.out.println("\n=== REALIZAR SAQUE ===\n");
                transacao.realizar();
                break;
            case 2:
                transacao = new Deposito();
                System.out.println("\n=== REALIZAR DEPÓSITO ===\n");
                transacao.realizar();
                break;
            case 3:
                transacao = new Transferencia();
                System.out.println("\n=== REALIZAR TRANSFERÊNCIA ===\n");
                transacao.realizar();
                break;
            case 4:
                System.out.println("Voltando ao Menu Inicial...");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    private static void verificarValor(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido.");
            MenuInicial.exibir();
        } if (valor > limite) {
            System.out.println("Limite ultrapassado.");
            MenuInicial.exibir();
        }
    }

    protected static Double definirValor() {
        Scanner scan = new Scanner(System.in);
        double valor;
        while(true)
            try {
                System.out.print("Valor: R$ ");
                valor = Double.parseDouble(scan.next().replace(",","."));
                verificarValor(valor);
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido.");
            }
    }

    protected void realizar() {
    }
}