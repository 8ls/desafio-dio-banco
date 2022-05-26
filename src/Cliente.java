import java.util.Scanner;

public class Cliente {

    private String prenome;
    private String sobrenome;
    private String id;

    public String getPrenome() {
        return prenome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getId() {
        return id;
    }

    private static void verificar(String idCliente) {
        if(!Banco.clientes.containsKey(idCliente)) {
            System.out.println("Cliente não cadastrado.");
            Cliente.cadastrar();
        }
    }

    private static void cadastrar() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n=== CADASTRAR CLIENTE ===");

        Cliente novo = new Cliente();
        System.out.print("Prenome(s): ");
        novo.prenome = scan.next();
        System.out.print("Sobrenome(s): ");
        novo.sobrenome = scan.next();
        System.out.print("ID: ");
        novo.id = scan.next();
        System.out.print("Novo cliente cadastrado com sucesso.");

        Banco.clientes.put(novo.getId(), novo);
    }

    public static Cliente selecionar() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n=== SELECIONAR CLIENTE ===");
        System.out.print("ID: ");
        String idCliente = scan.next();
        verificar(idCliente);
        return (Banco.clientes.get(idCliente));
    }

    @Override
    public String toString() {
        return "Nome: " + prenome + " - Sobrenome: " + sobrenome + " - ID: " + id;
    }
}