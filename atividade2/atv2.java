
//2. Crie uma aplicação que simule o histórico de navegação de um navegador utilizando
//uma lista simplesmente encadeada. Implemente funcionalidades para adicionar novas
//URLs e remover URLs antigas quando a lista atingir um certo tamanho.

import java.util.Scanner;

class URL {
    String url;
    URL next;

    URL(String url) {
        this.url = url;
        this.next = null;
    }
}

class BrowserHistory {
    private URL head;
    private int size;
    private int maxSize;

    BrowserHistory(int maxSize) {
        this.head = null;
        this.size = 0;
        this.maxSize = maxSize;
    }

    public void addURL(String url) {
        URL newURL = new URL(url);
        newURL.next = head;
        head = newURL;
        size++;
        if (size > maxSize) {
            removeOldestURL();
        }
    }

    private void removeOldestURL() {
        if (head == null)
            return;
        URL current = head;
        while (current.next != null && current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        size--;
    }

    public void printHistory() {
        URL current = head;
        while (current != null) {
            System.out.println(current.url);
            current = current.next;
        }
    }
}

public class atv2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BrowserHistory history = new BrowserHistory(5); // Defina o tamanho máximo do histórico

        while (true) {
            System.out.println("1. Adicionar URL");
            System.out.println("2. Mostrar Histórico");
            System.out.println("3. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (choice) {
                case 1:
                    System.out.println("Digite a URL:");
                    String url = scanner.nextLine();
                    history.addURL(url);
                    break;
                case 2:
                    history.printHistory();
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