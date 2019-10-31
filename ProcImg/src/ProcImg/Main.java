package ProcImg;

public class Main {
    public static void main (String [] args){
        //new Janela();
        Imagem lena = new Imagem("lena.jpeg");
        Imagem parafuso = new Imagem("B.PNG");
        int[][] ee = {{255,255,255,255,255},{255,255,255,255,255},{255,255,255,255,255}};
        parafuso.mostrar();
        MorfologiaMatematica.dilatacao(parafuso,ee,2,2).mostrar("Erosao");
    }
}
