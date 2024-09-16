//Filas
//6. Crie um simulador de fila de atendimento em um banco. Utilize uma fila para gerenciar
//os clientes que aguardam atendimento e implemente a lógica para chamar o próximo
//cliente.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class atv6 {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Chamar Próximo Cliente");
            System.out.println("3. Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome do cliente:");
                    String cliente = scanner.nextLine();
                    fila.add(cliente);
                    System.out.println("Cliente " + cliente + " adicionado à fila.");
                    break;
                case 2:
                    if (fila.isEmpty()) {
                        System.out.println("Nenhum cliente na fila.");
                    } else {
                        String proximoCliente = fila.poll();
                        System.out.println("Chamando cliente " + proximoCliente);
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