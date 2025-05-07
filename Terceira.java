import java.util.Scanner;
import java.util.Stack;

public class Terceira {
    public static void main(String[] args) {
        Stack<String> pilha = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar item à pilha");
            System.out.println("2. Remover item da pilha");
            System.out.println("3. Sair");
            System.out.print("Opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Digite o item: ");
                    String item = scanner.nextLine();
                    pilha.push(item);
                    System.out.println("Item adicionado à pilha.");
                    break;

                case "2":
                    if (pilha.isEmpty()) {
                        System.out.println("A pilha está vazia...");
                    } else {
                        String removido = pilha.pop();
                        System.out.println("Item removido: " + removido);
                    }
                    break;

                case "3":
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
