class ListaDuplamenteEncadeadaCartas {
    NoCarta cabeca;
    NoCarta cauda;

    void adicionar(String carta) {
        NoCarta novoNo = new NoCarta(carta);
        if (cabeca == null) {
            cabeca = cauda = novoNo;
        } else {
            cauda.proximo = novoNo;
            novoNo.anterior = cauda;
            cauda = novoNo;
        }
    }

    void remover(String carta) {
        NoCarta atual = cabeca;
        while (atual != null && !atual.carta.equals(carta)) {
            atual = atual.proximo;
        }
        if (atual != null) {
            if (atual.anterior != null) {
                atual.anterior.proximo = atual.proximo;
            } else {
                cabeca = atual.proximo;
            }
            if (atual.proximo != null) {
                atual.proximo.anterior = atual.anterior;
            } else {
                cauda = atual.anterior;
            }
        }
    }

    void reorganizar(String carta, int novaPosicao) {
        remover(carta);
        NoCarta novoNo = new NoCarta(carta);
        if (novaPosicao == 0) {
            novoNo.proximo = cabeca;
            if (cabeca != null) {
                cabeca.anterior = novoNo;
            }
            cabeca = novoNo;
            if (cauda == null) {
                cauda = novoNo;
            }
        } else {
            NoCarta atual = cabeca;
            for (int i = 0; i < novaPosicao - 1 && atual != null; i++) {
                atual = atual.proximo;
            }
            if (atual != null) {
                novoNo.proximo = atual.proximo;
                novoNo.anterior = atual;
                if (atual.proximo != null) {
                    atual.proximo.anterior = novoNo;
                }
                atual.proximo = novoNo;
                if (novoNo.proximo == null) {
                    cauda = novoNo;
                }
            }
        }
    }

    void imprimirMao() {
        NoCarta atual = cabeca;
        while (atual != null) {
            System.out.print(atual.carta + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}