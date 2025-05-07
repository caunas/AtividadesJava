import java.util.*;

public class Setima {
    private static final int MAX_DOWNLOADS_EM_ANDAMENTO = 3;

    public static void main(String[] args) {
        Queue<String> filaEmAndamento = new LinkedList<>();
        List<String> listaEspera = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opções:");
            System.out.println("1. Solicitar novo download");
            System.out.println("2. Concluir um download");
            System.out.println("3. Ver downloads em andamento");
            System.out.println("4. Ver lista de espera");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Nome do arquivo: ");
                    String arquivo = scanner.nextLine();
                    if (filaEmAndamento.size() < MAX_DOWNLOADS_EM_ANDAMENTO) {
                        filaEmAndamento.add(arquivo);
                        System.out.println("Download iniciado: " + arquivo);
                    } else {
                        listaEspera.add(arquivo);
                        System.out.println("Download adicionado à lista de espera: " + arquivo);
                    }
                    break;

                case "2":
                    if (filaEmAndamento.isEmpty()) {
                        System.out.println("Nenhum download em andamento.");
                    } else {
                        String concluido = filaEmAndamento.poll();
                        System.out.println("Download concluído: " + concluido);

                        if (!listaEspera.isEmpty()) {
                            String proximo = listaEspera.remove(0);
                            filaEmAndamento.add(proximo);
                            System.out.println("Iniciando novo download: " + proximo);
                        }
                    }
                    break;

                case "3":
                    if (filaEmAndamento.isEmpty()) {
                        System.out.println("Nenhum download em andamento.");
                    } else {
                        System.out.println("Downloads em andamento:");
                        for (String f : filaEmAndamento) {
                            System.out.println(" - " + f);
                        }
                    }
                    break;

                case "4":
                    if (listaEspera.isEmpty()) {
                        System.out.println("Nenhum arquivo na lista de espera.");
                    } else {
                        System.out.println("Lista de espera:");
                        for (String f : listaEspera) {
                            System.out.println(" - " + f);
                        }
                    }
                    break;

                case "5":
                    System.out.println("Encerrando gerenciador.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
