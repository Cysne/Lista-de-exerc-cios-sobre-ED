// 4.Implemente um editor de texto simples onde as operações de desfazer (undo) e
//refazer (redo) são gerenciadas por uma lista duplamente encadeada.

import java.util.Scanner;

class NoTexto {
    String texto;
    NoTexto anterior;
    NoTexto proximo;

    NoTexto(String texto) {
        this.texto = texto;
    }
}

class EditorTexto {
    private NoTexto atual;
    private NoTexto inicio;
    private NoTexto fim;

    public EditorTexto() {
        this.atual = new NoTexto("");
        this.inicio = this.atual;
        this.fim = this.atual;
    }

    public void escrever(String novoTexto) {
        NoTexto novoNo = new NoTexto(novoTexto);
        novoNo.anterior = atual;
        atual.proximo = novoNo;
        atual = novoNo;
        fim = atual;
    }

    public void desfazer() {
        if (atual.anterior != null) {
            atual = atual.anterior;
        } else {
            System.out.println("Nada para desfazer.");
        }
    }

    public void refazer() {
        if (atual.proximo != null) {
            atual = atual.proximo;
        } else {
            System.out.println("Nada para refazer.");
        }
    }

    public void exibirTexto() {
        System.out.println("Texto atual: " + atual.texto);
    }
}

public class Atv4 {
    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto();
        Scanner scanner = new Scanner(System.in);
        String comando;

        while (true) {
            System.out.println("Digite um comando (escrever, desfazer, refazer, exibir, sair):");
            comando = scanner.nextLine();

            if (comando.equals("sair")) {
                break;
            } else if (comando.equals("escrever")) {
                System.out.println("Digite o texto:");
                String texto = scanner.nextLine();
                editor.escrever(texto);
            } else if (comando.equals("desfazer")) {
                editor.desfazer();
            } else if (comando.equals("refazer")) {
                editor.refazer();
            } else if (comando.equals("exibir")) {
                editor.exibirTexto();
            } else {
                System.out.println("Comando desconhecido.");
            }
        }

        scanner.close();
    }
}