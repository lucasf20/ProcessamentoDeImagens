package ProcImg;

public class Main {
    public static void main (String [] args) {
        //new Janela();
        Imagem lena = new Imagem("lena.jpeg");
        Imagem parafuso = new Imagem("B.PNG");
        Imagem quadrado = new Imagem("A.PNG");
        Imagem fechamento = new Imagem("fechamento.png");
        int[][] ee = {{255, 255, 255,255,255}, {255, 255, 255,255,255}, {255, 255, 255,255,255},{255, 255, 255,255,255},{255, 255, 255,255,255}};
        lena.mostrar();
        MorfologiaMatematica.erosaoCinza(lena, ee, 2, 2).mostrar("Fechamento");
        MorfologiaMatematica.dilatacaoCinza(lena, ee, 2, 2).mostrar("Abertura");
        MorfologiaMatematica.smoothing(lena, ee, 2, 2).mostrar("Smoothing");
        MorfologiaMatematica.gradiente(lena, ee, 2, 2).mostrar("Gradiente");

    }
}
