import java.util.*;

public class Oitava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> historico = new ArrayList<>();
        Stack<String> pilhaVoltar = new Stack<>();
        Stack<String> pilhaAvancar = new Stack<>();
        String paginaAtual = null;

        while (true) {
            System.out.println("Opções:");
            System.out.println("1. Visitar nova página");
            System.out.println("2. Voltar (Ctrl + ←)");
            System.out.println("3. Avançar (Ctrl + →)");
            System.out.println("4. Ver histórico completo");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Digite a URL da nova página: ");
                    String novaPagina = scanner.nextLine();

                    if (paginaAtual != null) {
                        pilhaVoltar.push(paginaAtual);
                    }

                    paginaAtual = novaPagina;
                    historico.add(paginaAtual);
                    pilhaAvancar.clear();

                    System.out.println("Você está agora em: " + paginaAtual);
                    break;

                case "2":
                    if (pilhaVoltar.isEmpty()) {
                        System.out.println("Não há páginas anteriores.");
                    } else {
                        pilhaAvancar.push(paginaAtual);
                        paginaAtual = pilhaVoltar.pop();
                        System.out.println("Você voltou para: " + paginaAtual);
                    }
                    break;

                case "3":
                    if (pilhaAvancar.isEmpty()) {
                        System.out.println("Não há páginas...");
                    } else {
                        pilhaVoltar.push(paginaAtual);
                        paginaAtual = pilhaAvancar.pop();
                        System.out.println("Você avançou para: " + paginaAtual);
                    }
                    break;

                case "4":
                    if (historico.isEmpty()) {
                        System.out.println("Histórico vazio.");
                    } else {
                        System.out.println("Histórico de páginas visitadas:");
                        for (String pagina : historico) {
                            System.out.println(" - " + pagina);
                        }
                    }
                    break;

                case "5":
                    System.out.println("Encerrando navegador.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
