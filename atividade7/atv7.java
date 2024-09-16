//filas
//7. Implemente um sistema de gerenciamento de impressões onde os trabalhos de
//impressão são enfileirados e processados na ordem em que chegam. Use uma fila para
//armazenar os trabalhos de impressão.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class atv7 {
    public static void main(String[] args) {
        Queue<String> filaImpressao = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Adicionar Trabalho de Impressão");
            System.out.println("2. Processar Próximo Trabalho de Impressão");
            System.out.println("3. Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome do trabalho de impressão:");
                    String trabalho = scanner.nextLine();
                    filaImpressao.add(trabalho);
                    System.out.println("Trabalho de impressão " + trabalho + " adicionado à fila.");
                    break;
                case 2:
                    if (filaImpressao.isEmpty()) {
                        System.out.println("Nenhum trabalho de impressão na fila.");
                    } else {
                        String proximoTrabalho = filaImpressao.poll();
                        System.out.println("Processando trabalho de impressão " + proximoTrabalho);
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