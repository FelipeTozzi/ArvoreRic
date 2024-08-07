public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        arvore.inserir(10);
        arvore.inserir(8);
        arvore.inserir(5);
        arvore.inserir(9);
        arvore.inserir(7);
        arvore.inserir(18);
        arvore.inserir(13);
        arvore.inserir(20);

        //  System.out.println("Pré-ordem: ");
       // arvore.preOrdem(arvore.getRaiz());
        System.out.println("Em ordem: ");
        arvore.emOrdem(arvore.getRaiz());
        //System.out.println("Pós ordem: ");
        //arvore.posOrdem(arvore.getRaiz());
        System.out.println("Pausa");

        arvore.deleta(10);

        System.out.println("Em ordem delet: ");
        arvore.emOrdem(arvore.getRaiz());



    }
}