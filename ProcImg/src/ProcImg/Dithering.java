package ProcImg;

import java.awt.*;

public class Dithering {

    private static Imagem imagemDoMesmoTamanho(Imagem a){
        int alt = a.getAltura();
        int larg = a.getLargura();
        return new Imagem(alt,larg, Imagem.GRAY);
    }

    public static Imagem limiarSimples(Imagem a, int limiar){
        Imagem rst = imagemDoMesmoTamanho(a);
        for(int y = 0; y < a.getAltura(); y++){
            for(int x = 0; x < a.getLargura(); x++){
                if(a.getPixel(y,x,0) <= limiar){
                    rst.setPixel(y,x,0,0,0);
                }
                else{
                    rst.setPixel(y,x,255,0,0);
                }
            }
        }
        return rst;
    }

    public static Imagem modulacaoAleatoria(Imagem a, int limiar){
        Imagem rst = imagemDoMesmoTamanho(a);
        for(int y = 0; y < a.getAltura(); y++) {
            for (int x = 0; x < a.getLargura(); x++) {
                if(a.getPixel(y,x,0) + Math.random()*31 <= limiar){
                    rst.setPixel(y,x,0,0,0);
                }
                else{
                    rst.setPixel(y,x,255,0,0);
                }
            }
        }
        return rst;
    }

    private static int[][] quantizador(Imagem a, int nivel){
        int[][] matrizQuantizada = new int[a.getLargura()][a.getAltura()];
        int interval = 256/nivel;
        for(int y = 0; y < a.getAltura(); y++){
            for(int x = 0; x < a.getLargura(); x++ ){
                matrizQuantizada[x][y] = (a.getPixel(y,x,0)/interval);
            }
        }
        return matrizQuantizada;
    }

    private static int[][] ajuste(int[][] imgQuantizada, int nivelQuantizacao){
        for(int i = 0; i < imgQuantizada.length; i++){
            for(int j = 0; j<imgQuantizada[i].length;j++){
                imgQuantizada[i][j] *= (256/nivelQuantizacao);
            }
        }
        return imgQuantizada;
    }

    private static int[][] matrizDeDithering(int n){
        int[][] D2 = {{0,2},{3,1}};
        int[][] D3 = {{0,6,8},{4,1,7},{5,3,2}};
        int[][] D4 = {{0,8,2,10},{12,4,14,6},{3,11,1,9},{15,7,13,5}};
        int[][] D = {};
        if(n == 2){
            D = D2;
        }else{
            if(n == 3){
                D = D3;
            }else{
                if(n == 4){
                    D = D4;
                }else{
                    System.out.println("Erro na matriz de Dithering\nEscolha um n entre 2, 3 ou 4!!");
                    System.exit(-1);
                }
            }
        }
        return D;
    }

    public static Imagem periodicoPorDispercao(Imagem a, int n){
        Imagem rst = imagemDoMesmoTamanho(a);
        int[][] imagemQuantizada = quantizador(a,n*n);
        int[][] D = matrizDeDithering(n);
        int i,j;
        for(int y = 0; y < a.getAltura(); y++){
            for(int x = 0; x < a.getLargura(); x++){
                i = x % n;
                j = y % n;
                if(imagemQuantizada[x][y] > D[i][j]){
                    rst.setPixel(y,x,255,0,0);
                }
                else{
                    rst.setPixel(y,x,0,0,0);
                }
            }
        }
        return rst;
    }

    private static int mediaDaImagem(Imagem a){
        int m = 0;
        for(int y = 0; y < a.getAltura(); y++){
            for(int x = 0; x < a.getLargura(); x++){
                m += a.getPixel(y,x,0);
            }
        }
        return m/(a.getLargura()*a.getAltura());
    }

    public static Imagem aperiodicoPorDispersao(Imagem a, int quantizacao){
        Imagem rst = imagemDoMesmoTamanho(a);
        int limiar = mediaDaImagem(a);
        int error;
        int[][] imagemQuantizada = ajuste(quantizador(a,quantizacao),quantizacao);
        for(int y = 0; y < a.getAltura() - 1; y++) {
            for (int x = 0; x < a.getLargura() - 1; x++) {
                if(imagemQuantizada[x][y]>limiar){
                    error = a.getPixel(y,x,0) - 255;
                    rst.setPixel(y,x,255,0,0);
                }else{
                    error = a.getPixel(y,x,0) - 0;
                    rst.setPixel(y,x,0,0,0);
                }
                imagemQuantizada[x+1][y] += (error*3)/8;
                rst.setPixel(y,x+1,imagemQuantizada[x+1][y],0,0);
                imagemQuantizada[x][y+1] += (error*3)/8;
                rst.setPixel(y+1,x,imagemQuantizada[x][y+1],0,0);
                imagemQuantizada[x+1][y+1] += (error*2)/8;
                rst.setPixel(y+1,x+1,imagemQuantizada[x+1][y+1],0,0);
            }
        }
        return rst;
    }

    public static Imagem periodicoPorAglomeracao(Imagem a,int n){
        int alt = a.getAltura();
        int larg = a.getLargura();
        Imagem rst = new Imagem(alt*n,larg*n,Imagem.GRAY);
        int[][] matriz = matrizDeDithering(n);
        int[][] imagemQuantizada = quantizador(a,(n*n)+1);
        for(int y = 0; y < alt;y++){
            for(int x = 0; x < larg;x++){
                for(int i = 0; i < n;i++){
                    for(int j = 0; j < n;j++){
                        rst.setPixel(n*y,n*x,(imagemQuantizada[x][y]>matriz[i][j])?255:0,0,0);
                    }
                }
            }
        }
        return rst;
    }
}
