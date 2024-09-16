//filas
//8. Implemente uma fila que simula a fila de processos prontos para execução em um
//sistema operacional. Permita que novos processos sejam adicionados e que o processo
//mais antigo seja removido para execução.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class atv8 {
    public static void main(String[] args) {
        Queue<String> filaProcessos = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Adicionar Processo");
            System.out.println("2. Executar Próximo Processo");
            System.out.println("3. Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome do processo:");
                    String processo = scanner.nextLine();
                    filaProcessos.add(processo);
                    System.out.println("Processo " + processo + " adicionado à fila.");
                    break;
                case 2:
                    if (filaProcessos.isEmpty()) {
                        System.out.println("Nenhum processo na fila.");
                    } else {
                        String proximoProcesso = filaProcessos.poll();
                        System.out.println("Executando processo " + proximoProcesso);
                    }
                    break;
                case 3:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}