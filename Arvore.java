public class Arvore {
    private No raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        No novoNo = new No(valor);        //cria um novo nó, ou seja um novo elemento
        if(this.raiz == null) {           //caso não tenha raiz o novo nó será a raiz
            this.raiz = novoNo;
        } else {                        //após a raiz ter sido definida
            No atual = this.raiz;       //variável de comparação, o código observa o elemento definido como atual //para decidir onde o elemento fica na arvore
            No pai = null;
            boolean esquerda = false;
            while(atual != null) {
                if(novoNo.getValor() < atual.getValor()) { //se o novo nó for menor que o elemento anterior ele é levado para a esquerda
                    pai = atual;         //o nó anterior vira o novo alvo de comparação
                    atual = atual.getEsq();
                    esquerda = true;
                } else {
                    pai = atual;
                    atual = atual.getDir();
                    esquerda = false;
                }
            }
            if(esquerda) {
                pai.setEsq(novoNo);
            } else {
                pai.setDir(novoNo);
            }
        }
    }

    public No getRaiz() {
        return this.raiz;
    }


    public void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getValor());
        preOrdem(no.getEsq());
        preOrdem(no.getDir());
    }

    public void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsq());
        System.out.println(no.getValor());
        emOrdem(no.getDir());
    }

    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsq());
        posOrdem(no.getDir());
        System.out.println(no.getValor());
    }

    //remoção
    public boolean deleta(int valor) {
        No atual = this.raiz;
        No anteriorAtual = null; //o valor anterior ao que está atualmente sendo observado, começa null já que a raiz não possui elementos anteriores

        while (atual != null) {   //a comparação continua até encontrar um valor null ou seja o fim da arvore
            if (atual.getValor() == valor) { //achou valor
                break;
            } else if (valor < atual.getValor()) { //caso o valor procurado é menor que o valor atual
                anteriorAtual = atual; //valor que foi analisado se torna o elemento anterior
                atual = atual.getEsq(); //começa a verificar elementos a esquerda (Menor)
            } else {
                anteriorAtual = atual;
                atual = atual.getDir(); //se não, verifica a direita (Maior)
            }
        }
        if (atual != null) { //verifica se o elemento existe

            if (atual.getDir() != null) { //Somente na direita ou 2 filhos

                No substituto = atual.getDir(); //nó que vai substituir o elemento
                No paiSusbstituto = atual; //nó anterior ao que foi selecionado como substituto
                while (substituto.getEsq() != null) { //procura o ultimo elemento a direita
                    paiSusbstituto = substituto;
                    substituto = substituto.getEsq();
                }

                if (paiSusbstituto != atual) {    //este código mantém o lado direito caso a raiz seja removida
                    paiSusbstituto.setEsq(substituto.getDir());
                    substituto.setDir(atual.getDir());
                }

                substituto.setEsq(atual.getEsq());
                if (anteriorAtual != null) { //verifica raiz
                    if (atual.getValor() < anteriorAtual.getValor()) {
                        anteriorAtual.setEsq(substituto);
                    } else {
                        anteriorAtual.setDir(substituto);
                    }
                }else{
                    this.raiz = substituto;
                }

                if (anteriorAtual != null) {
                    if (substituto.getValor() < paiSusbstituto.getValor()) { //se o elemento atual é menor que o anterior
                        paiSusbstituto.setEsq(null); //remove esquerda
                    } else {
                        paiSusbstituto.setDir(null); // senão remove direita
                    }
                } else { //se for a raiz
                    this.raiz = substituto;
                }
            } else if (atual.getEsq() != null) { //só na esquerda

                No substituto = atual.getEsq(); //nó que vai substituir o elemento
                No paiSusbstituto = atual; //nó anterior ao que foi selecionado como substituto
                while (substituto.getDir() != null) { //procura o ultimo elemento a direita
                    paiSusbstituto = substituto;
                    substituto = substituto.getDir();
                }
                if (anteriorAtual != null) { //se for a raiz
                    if (atual.getValor() < anteriorAtual.getValor()) {
                        anteriorAtual.setEsq(substituto);
                    } else {
                        anteriorAtual.setDir(substituto);
                    }
                }else{
                    this.raiz = substituto;
                }

                if (anteriorAtual != null) {
                    if (substituto.getValor() < paiSusbstituto.getValor()) { //se o elemento atual é menor que o anterior
                        paiSusbstituto.setEsq(null); //remove esquerda
                    } else {
                        paiSusbstituto.setDir(null); // senão remove direita
                    }
                } else { //se for a raiz
                    this.raiz = substituto;
                }
            } else { //folha
                if (anteriorAtual != null) {
                    if (atual.getValor() < anteriorAtual.getValor()) { //se o elemento atual é menor que o anterior
                        anteriorAtual.setEsq(null); //remove esquerda
                    } else {
                        anteriorAtual.setDir(null); // senão remove direita
                    }
                } else {
                    this.raiz = null;
                }
            }
            return true;
        } else {
            System.out.println("elemento não existe");
            return false;
        }
    }
}

