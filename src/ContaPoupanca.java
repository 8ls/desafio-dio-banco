public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        this.tipo = "Poupança";
    }

    @Override
    public void imprimirSaldo() {
        System.out.println("\n=== Saldo Conta Poupança ===\n");
        super.imprimirInformacoes();
    }

    public static void abrirNova() {
        Conta nova = new ContaPoupanca(Cliente.selecionar());
        System.out.println("\nOperação concluída.\n\n=== Nova Conta Poupança ===");
        nova.imprimirInformacoes();
    }
}