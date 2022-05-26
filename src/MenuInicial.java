import java.util.Scanner;

public class MenuInicial {
    static Banco banco = new Banco();

    public static void exibir() {

        Scanner scan = new Scanner(System.in);
        int opcao;

        System.out.println("\n  Banco " + banco.getNome());
        System.out.print("\n==== MENU INICIAL ====\n1 - Abrir Conta\n2 - Consultar Saldo\n3 - Realizar transação\n4 - Listar contas\n5 - Listar Clientes\n6 - Sair\nOpção: ");
        opcao = scan.nextInt();

        switch (opcao) {
            case 1:
                int opcao2;
                System.out.print("\n=== ABRIR CONTA ===\n1 - Conta Corrente\n2 - Conta Poupança \nOpção: ");
                opcao2 = scan.nextInt();
                switch (opcao2) {
                    case 1:
                        ContaCorrente.abrirNova();
                        exibir();
                    case 2:
                        ContaPoupanca.abrirNova();
                        exibir();
                    default:
                        System.out.println("Opção inválida.");
                        exibir();
                }
            case 2:
                System.out.println("\n=== CONSULTAR SALDO ===");
                Conta.selecionar().imprimirSaldo();
                exibir();
            case 3:
                Transacao.selecionar();
                exibir();
            case 4:
                System.out.println("\n  Banco " + banco.getNome());
                Banco.imprimirListaContas();
                exibir();
            case 5:
                System.out.println("\n        Banco " + banco.getNome());
                Banco.imprimirListaClientes();
                exibir();
            case 6:
                System.out.println("Encerrando...");
                System.exit(0);
            default:
                System.out.println("Opção inválida.");
                exibir();
        }
    }
}