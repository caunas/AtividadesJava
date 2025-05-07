import java.util.LinList;
import java.util.Queue;
import java.util.Scanner;

class Quinta {
    String nome;
    String sintomas;

    public Paciente(String nome, String sintomas) {
        this.nome = nome;
        this.sintomas = sintomas;
    }

    @Override
    public String toString() {
        return nome + " - " + sintomas;
    }
}

public class FilaDePacientes {
    public static void main(String[] args) {
        Queue<Paciente> fila = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Chamar próximo paciente");
            System.out.println("3. Listar pacientes aguardando");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Nome do paciente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Sintomas: ");
                    String sintomas = scanner.nextLine();
                    fila.add(new Paciente(nome, sintomas));
                    System.out.println("Paciente registrado.");
                    break;

                case "2":
                    if (fila.isEmpty()) {
                        System.out.println("Nenhum paciente na fila.");
                    } else {
                        Paciente proximo = fila.poll(); // remove e retorna o primeiro
                        System.out.println("Chamando: " + proximo);
                    }
                    break;

                case "3":
                    if (fila.isEmpty()) {
                        System.out.println("Nenhum paciente aguardando.");
                    } else {
                        System.out.println("Pacientes aguardando:");
                        for (Paciente p : fila) {
                            System.out.println(" - " + p);
                        }
                    }
                    break;

                case "4":
                    System.out.println("Encerrando o sistema.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
