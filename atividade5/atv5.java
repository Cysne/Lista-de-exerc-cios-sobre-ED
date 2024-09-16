//5. Implemente um jogo simples de cartas onde a mão do jogador é representada por
//uma lista duplamente encadeada. Permita que o jogador adicione, remova, e reorganize
//as cartas na mão.

import java.util.Scanner;

public class atv5 {
    public static void main(String[] args) {
        ListaDuplamenteEncadeadaCartas mao = new ListaDuplamenteEncadeadaCartas();
        Scanner scanner = new Scanner(System.in);
        String comando;

        while (true) {
            System.out.println("Digite um comando (adicionar, remover, reorganizar, imprimir, sair):");
            comando = scanner.nextLine();

            if (comando.equals("sair")) {
                break;
            } else if (comando.equals("adicionar")) {
                System.out.println("Digite a carta para adicionar:");
                String carta = scanner.nextLine();
                mao.adicionar(carta);
            } else if (comando.equals("remover")) {
                System.out.println("Digite a carta para remover:");
                String carta = scanner.nextLine();
                mao.remover(carta);
            } else if (comando.equals("reorganizar")) {
                System.out.println("Digite a carta para reorganizar:");
                String carta = scanner.nextLine();
                System.out.println("Digite a nova posição (0 para início):");
                int posicao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha
                mao.reorganizar(carta, posicao);
            } else if (comando.equals("imprimir")) {
                mao.imprimirMao();
            } else {
                System.out.println("Comando desconhecido.");
            }
        }

        scanner.close();
    }
}