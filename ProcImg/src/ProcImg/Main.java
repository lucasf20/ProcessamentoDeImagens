package ProcImg;

public class Main {
    public static void main (String [] args){
        //new Janela();
        Imagem lena = new Imagem("lena.jpeg");
        lena.mostrar();
        Dithering.aperiodicoPorDispersao(lena,128).mostrar();
    }
}
