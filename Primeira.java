/**
 Um aplicativo de produtividade como o Todoist ou o Microsoft To Do precisa organizar as tarefas diárias de um usuário.
 As tarefas devem ser listadas na ordem em que foram adicionadas, mas o usuário pode editar, remover ou reordenar essas tarefas a qualquer momento.
 Implemente uma estrutura de lista para armazenar as tarefas.
 Permita adicionar uma nova tarefa no final, remover uma tarefa específica pelo nome, mover uma tarefa de uma posição para outra e exibir todas as tarefas na ordem atual.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
//import java.util.Collections;

public class Primeira{
    public static void ui(){
        System.out.println("Fazer menu aqui vai ser um inferno...");
        System.out.println("1 - Adicionar");
        System.out.println("2 - Mover");
        System.out.println("3 - Remover (por nome)");
        System.out.println("4 - Ver tarefas");
        System.out.println("5 - Sair");
        System.out.println("Selecione uma opção");
    }

    public static void adicionar(List lista, String tarefa){
        // adicionar tarefa
        lista.add(tarefa);
    }

    public static void mover(List lista, String tarefa, String idx){
        // mover tarefa
        //lista.remove(tarefa);
        //lista.add(idx, tarefa);
        char mode = idx.charAt(0);
        int qtd = Integer.parseInt(idx.substring(1)); //strToInt(idx.substring(1));
        if(lista.contains(tarefa)){
            int indice = lista.indexOf(tarefa);
            if(mode == '+'){
                lista.remove(tarefa);
                lista.add(indice + qtd, tarefa);
            } else if(mode == '-'){
                lista.remove(tarefa);
                lista.add(indice - qtd, tarefa);
            } else{
                System.out.println("FATAL EXCEPTION");
            }
        } else{
            System.out.println("Item não encontrado na lista...");
        }
    }

    public static void remover(List lista, String tarefa){
        //lista.remove(tarefa);
        if(lista.contains(tarefa)){
            lista.remove(tarefa);
            System.out.println(tarefa + " removido(a) da lista");
        } else{
            System.out.println("Tarefa não encontrada na lista...");
        }
    }

    public static void ver(List lista){
        // ver lista de tarefas
        System.out.println(lista);
    }

    public static void main(String[] args){
        List<String> to_do_list = new ArrayList<>();
        Scanner scanc = new Scanner(System.in);

        int op;
        String input_on_func;
        String idx;

        while(true){
            ui();

            op = scanc.nextInt();
            scanc.nextLine(); // bug fix

            switch(op){
                case 1:
                    System.out.println("Qual o item que deseja adicionar? ");
                    input_on_func = scanc.nextLine();

                    adicionar(to_do_list, input_on_func);
                    ver(to_do_list);

                    break;
                case 2:
                    System.out.println("Qual item deseja mover?");
                    input_on_func = scanc.nextLine();

                    System.out.println("Digite o código de movimento do item.");
                    System.out.println("Ex: +3; -1");
                    idx = scanc.nextLine();

                    mover(to_do_list, input_on_func, idx);

                    //ver(to_do_list);

                    break;
                case 3:
                    System.out.println("Qual item deseja remover?");
                    input_on_func = scanc.nextLine();

                    remover(to_do_list, input_on_func);

                    //ver(to_do_list);

                    break;
                case 4:
                    ver(to_do_list);

                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida! ");
                    break;
            }
        }
    }
}