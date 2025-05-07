import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sexta {
    String usuario;
    String nomeArquivo;

    public Documento(String usuario, String nomeArquivo) {
        this.usuario = usuario;
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public String toString() {
        return usuario + " - " + nomeArquivo;
    }
}

public class FilaDeImpressao {
    public static void main(String[] args) {
        Queue<Documento> fila = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar documento à fila");
            System.out.println("2. Imprimir próximo documento");
            System.out.println("3. Ver documentos na fila");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Nome do usuário: ");
                    St
