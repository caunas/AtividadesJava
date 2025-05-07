import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Segunda {
    private Map<String, Integer> itens;

    public ListaDeCompras() {
        itens = new HashMap<>();
    }

    public void adicionarItem(String nome, int quantidade) {
        if (itens.containsKey(nome)) {
            itens.put(nome, itens.get(nome) + quantidade);
            System.out.println("Quantidade de '" + nome + "' atualizada para " + itens.get(nome) + ".");
        } else {
            itens.put(nome, quantidade);
            System.out.println("Item '" + nome + "' adicionado com quantidade " + quantidade + ".");
        }
    }

    public void removerItem(String nome) {
        if (itens.containsKey(nome)) {
            itens.remove(nome);
            System.out.println("Item '" + nome + "' removido da lista.");
        } else {
            System.out.println("Item '" + nome + "' não encontrado na lista.");
        }
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("A lista de compras está vazia.");
        } else {
            System.out.println("Lista de Compras:");
            for (Map.Entry<String, Integer> entrada : itens.entrySet()) {
                System.out.println(" - " + entrada.getKey() + ": " + entrada.getValue());
            }
        }
    }

    public static void main(String[] args) {
        ListaDeCompras lista = new ListaDeCompras();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar item");
            System.out.println("2. Remover item");
            System.out.println("3. Listar itens");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Nome do item: ");
                    String nomeAdd = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int qtd;
                    try {
                        qtd = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Quantidade inválida.");
                        break;
                    }
                    lista.adicionarItem(nomeAdd, qtd);
                    break;

                case "2":
                    System.out.print("Nome do item a remover: ");
                    String nomeRemover = scanner.nextLine();
                    lista.removerItem(nomeRemover);
                    break;

                case "3":
                    lista.listarItens();
                    break;

                case "4":
                    System.out.println("Encerrando programa.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
