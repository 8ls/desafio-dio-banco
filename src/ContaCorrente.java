public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        this.tipo = "Corrente";
    }

    @Override
    public void imprimirSaldo() {
        System.out.println("\n=== Saldo Conta Corrente ===\n");
        super.imprimirInformacoes();
    }

    public static void abrirNova() {
        Conta nova = new ContaCorrente(Cliente.selecionar());
        System.out.println("\nOperação concluída.\n\n=== Nova Conta Corrente ===");
        nova.imprimirInformacoes();
    }
}