import java.util.Scanner;

public abstract class Conta{

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected String tipo;
    private int agencia;
    private int numero;
    protected double saldo;
    private Cliente cliente;
    Banco banco;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;

        Banco.contas.add(this);
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    private static void verificar(int numeroConta) {
        if ((numeroConta > Banco.contas.size()) || (numeroConta <= 0)) {
            System.out.println("Conta inexistente.");
            MenuInicial.exibir();
        }
    }

    public static Conta selecionar() {
        Scanner scan = new Scanner(System.in);
        int numeroConta;
        while(true)
            try {
                System.out.print("Número da Conta: ");
                numeroConta = Integer.parseInt(scan.next());
                verificar(numeroConta);
                return (Banco.contas.get(numeroConta - 1));
            } catch (NumberFormatException e) {
                System.out.println("Número inválido.");
            }
    }

    protected static void abrirNova() {
    }

    protected void imprimirSaldo() {
    }

    protected void imprimirInformacoes() {
        System.out.printf("Agência: %04d\n", this.agencia);
        System.out.printf("Número da conta: %07d\n", this.numero);
        System.out.printf("Tipo: %s\n", this.tipo);
        System.out.printf("Saldo: R$ %.2f\n", this.saldo);
        System.out.printf("Cliente: %s %s\n", this.cliente.getPrenome(), this.cliente.getSobrenome());
        System.out.printf("ID do Titular: %s\n", this.cliente.getId());
    }
}