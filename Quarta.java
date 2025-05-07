import java.util.Scanner;
import java.util.Stack;

public class Quarta {
    public static boolean expressaoValida(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (char c : expressao.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                pilha.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pilha.isEmpty()) return false;

                char topo = pilha.pop();

                if ((c == ')' && topo != '(') ||
                    (c == ']' && topo != '[') ||
                    (c == '}' && topo != '{')) {
                    return false;
                }
            }
        }

        return pilha.isEmpty(); // deve estar vazia se tudo foi fechado corretamente
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a expressão matemática: ");
        String expressao = scanner.nextLine();

        if (expressaoValida(expressao)) {
            System.out.println("Expressão válida! Todos os símbolos estão balanceados.");
        } else {
            System.out.println("Expressão inválida! Há símbolos não balanceados.");
        }

        scanner.close();
    }
}
