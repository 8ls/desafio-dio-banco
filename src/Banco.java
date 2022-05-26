import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Banco {

    private static final String BANCO = "Desafio S.A.";

    private String nome;
    protected static List<Conta> contas;
    protected static Map<String,Cliente> clientes;
    Conta conta;

    public Banco() {
        this.nome = BANCO;
        contas = new LinkedList<>();
        clientes = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public static void imprimirListaContas() {
        System.out.println("=== Lista de Contas ===");
        for (Conta conta : contas) {
            System.out.println();
            conta.imprimirInformacoes();
        }
    }

    public static void imprimirListaClientes() {
        System.out.println("  =====  Lista de Clientes  =====  ");
        for (Cliente cliente : clientes.values()) {
            System.out.println("\n" + cliente.toString() + "\nContas associadas ao cliente:");
            for (Conta conta : contas) {
                if (conta.getCliente() == cliente) {
                    System.out.printf("Conta %s: %07d\n", conta.tipo, conta.getNumero());
                }
            }
        }
    }
}
