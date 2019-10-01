package ProcImg;

public class Basicas {
    public int[] histograma (Imagem a, int matriz){
        int alt = a.getAltura();
        int larg = a.getLargura();
        int[] rst = new int[256];
        for(int y = 0; y < alt; y++){
            for(int x = 0; x < larg; x++){
                rst[a.getPixel(y,x,matriz)]++;
            }
        }
        return rst;
    }

    public int[] histograma_acumulado(Imagem a, int matriz){
        int[] hist = histograma(a,matriz);
        int[] rst = new int[256];
        rst[0] = hist[0];
        for(int i = 1; i < 256; i++){
            rst[i] = rst[i-1] + hist[i];
        }
        return rst;
    }

    public Imagem equalizacao(Imagem a){
        int alt = a.getAltura();
        int larg = a.getLargura();
        double[] pixel = new double[256];
        int[] histAc = histograma_acumulado(a,0);
        int y;
        Imagem rst = new Imagem(alt,larg,Imagem.GRAY);
        for(y = 0; y < 255; y++){
            pixel[y] = (histAc[y]*255)/(alt*larg);
        }
        for(y = 0; y < alt; y++){
            for(int x = 0; x < larg; x++){
                rst.setPixel(y,x,(int)pixel[a.getPixel(y,x,0)],0,0);
            }
        }
        return rst;
    }

    private int mediaMatriz(int[][] matriz, int raio){
        int rst = 0;
        int tam = (raio*2 + 1)*(raio*2 + 1);
        for(int l = -raio; l <= raio; l++){
            for(int c = -raio; c <= raio; c++){
                rst += matriz[l+raio][c+raio];
            }
        }
        rst = rst/tam;
        return rst;
    }

    public Imagem filtroDaMedia(Imagem a, int raio){
        int alt = a.getAltura();
        int larg = a.getLargura();
        int[][] mat = new int[raio*2 + 1][raio*2 + 1];
        Imagem rst = new Imagem(alt,larg,Imagem.GRAY);
        for(int y = raio; y < alt - raio; y++){
            for(int x = raio; x < larg - raio; x++){
                for (int l = -raio; l <= raio; l++) {
                    for (int c = -raio; c <= (raio); c++) {
                        mat[l + raio][c + raio] = a.getPixel(y - l, x - c, 0);
                    }
                }
                rst.setPixel(y,x,mediaMatriz(mat,raio),0,0);
            }
        }
        return rst;
    }

    private int medianaMatriz(int[][] matriz, int raio){
        int rst,lmin,cmin,x,tam;
        tam = (raio*2 + 1)*(raio*2 + 1);
        int[] aux = new int[tam];
        lmin = 0;
        cmin = 0;
        for(x = 0; x < (tam); x++) {
            aux[x] = 256;
            for (int l = -raio; l <= raio; l++) {
                for (int c = -raio; c <= (raio); c++) {
                    if (matriz[l + raio][c + raio] < aux[x]) {
                        aux[x] = matriz[l + raio][c + raio];
                        lmin = l + raio;
                        cmin = c + raio;
                    }
                }
            }
            matriz[lmin][cmin] = 257;
        }
        rst = aux[tam/2];
        return rst;
    }

    public Imagem filtroDaMediana(Imagem a, int raio){
        int alt = a.getAltura();
        int larg = a.getLargura();
        int[][] mat = new int[raio*2 + 1][raio*2 + 1];
        Imagem rst = new Imagem(alt ,larg ,Imagem.GRAY);
        for(int y = raio; y < alt - raio; y++){
            for(int x = raio ; x < larg - raio; x++){
               for(int l = -raio; l <= raio; l++){
                   for(int c = -raio; c <= raio; c++){
                       mat[l + raio][c + raio] = a.getPixel(y - l, x - c, 0);
                   }
               }
               rst.setPixel(y,x,medianaMatriz(mat,raio),0,0);
            }
        }
        return rst;
    }

    private int operador(int[][]g,int[][]mat){
        int rst = 0;
        for(int l = 0; l<3; l++){
            for(int c = 0; c<3; c++){
                rst += g[l][c]*mat[l][c];
            }
        }
        return rst;
    }

    private int operador(double[][]g,int[][]mat){
        int rst = 0;
        for(int l = 0; l<3; l++){
            for(int c = 0; c<3; c++){
                rst += g[l][c]*mat[l][c];
            }
        }
        return rst;
    }

    public Imagem sobel (Imagem a){
        int[][] gx = {{-1,0,1},{-2,0,2},{-1,0,1}};
        int[][] gy = {{-1,-2,-1},{0,0,0},{1,2,1}};
        int[][] mat = new int[3][3];
        int alt = a.getAltura();
        int larg = a.getLargura();
        int gya, gxa;
        Imagem rst = new Imagem(alt,larg,Imagem.GRAY);
        for(int y = 1; y < alt - 1; y++){
            for(int x = 1; x < larg - 1; x++){
                for(int l = -1; l <= 1; l++){
                    for(int c = -1; c <= 1; c++){
                        mat[l+1][c+1] = a.getPixel(y - l,x - c,0);
                    }
                }
                gya = operador(gy,mat);
                gxa = operador(gx,mat);
                rst.setPixel(y,x,(int) Math.sqrt(Math.pow(gya,2)+Math.pow(gxa,2)),0,0);
            }
        }
        return rst;
    }

    public Imagem prewitt (Imagem a){
        int[][] gx = {{-1,-1,-1},{0,0,0},{1,1,1}};
        int[][] gy = {{-1,0,1},{-1,0,1},{-1,0,1}};
        int[][] mat = new int[3][3];
        int alt = a.getAltura();
        int larg = a.getLargura();
        int gya, gxa;
        Imagem rst = new Imagem(alt,larg,Imagem.GRAY);
        for(int y = 1; y < alt - 1; y++){
            for(int x = 1; x < larg - 1; x++){
                for(int l = -1; l <= 1; l++){
                    for(int c = -1; c <= 1; c++){
                        mat[l+1][c+1] = a.getPixel(y - l,x - c,0);
                    }
                }
                gya = operador(gy,mat);
                gxa = operador(gx,mat);
                rst.setPixel(y,x,(int) Math.sqrt(Math.pow(gya,2)+Math.pow(gxa,2)),0,0);
            }
        }
        return rst;
    }

    public Imagem isotropico (Imagem a){
        double raiz2 = Math.sqrt(2);
        double[][] gx = {{-1,0,1},{-raiz2,0,raiz2},{-1,0,1}};
        double[][] gy = {{-1,-raiz2,-1},{0,0,0},{1,raiz2,1}};
        int[][] mat = new int[3][3];
        int alt = a.getAltura();
        int larg = a.getLargura();
        int gya, gxa;
        Imagem rst = new Imagem(alt,larg,Imagem.GRAY);
        for(int y = 1; y < alt - 1; y++){
            for(int x = 1; x < larg - 1; x++){
                for(int l = -1; l <= 1; l++){
                    for(int c = -1; c <= 1; c++){
                        mat[l+1][c+1] = a.getPixel(y - l,x - c,0);
                    }
                }
                gya = operador(gy,mat);
                gxa = operador(gx,mat);
                rst.setPixel(y,x,(int) Math.sqrt(Math.pow(gya,2)+Math.pow(gxa,2)),0,0);
            }
        }
        return rst;
    }

    public Imagem laplace (Imagem a){
        int[][] gx = {{0,-1,0},{-1,4,-1},{0,-1,0}};
        int[][] gy = {{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};
        int[][] mat = new int[3][3];
        int alt = a.getAltura();
        int larg = a.getLargura();
        int gya, gxa;
        Imagem rst = new Imagem(alt,larg,Imagem.GRAY);
        for(int y = 1; y < alt - 1; y++){
            for(int x = 1; x < larg - 1; x++){
                for(int l = -1; l <= 1; l++){
                    for(int c = -1; c <= 1; c++){
                        mat[l+1][c+1] = a.getPixel(y - l,x - c,0);
                    }
                }
                gya = operador(gy,mat);
                gxa = operador(gx,mat);
                rst.setPixel(y,x,(int) Math.sqrt(Math.pow(gya,2)+Math.pow(gxa,2)),0,0);
            }
        }
        return rst;
    }

    public Imagem roberts(Imagem a){
        int[][] gy = {{0,1},{-1,0}};
        int[][] gx = {{1,0},{0,-1}};
        int[][] mat = new int[2][2];
        int alt = a.getAltura();
        int larg = a.getLargura();
        int gya, gxa;
        Imagem rst = new Imagem(alt,larg,Imagem.GRAY);
        for(int y = 1; y < alt - 1; y++){
            for(int x = 1; x < larg - 1; x++){
                for(int l = 0; l <= 1; l++){
                    for(int c = 0; c <= 1; c++){
                        mat[l][c] = a.getPixel(y - l,x - c,0);
                    }
                }
                gya = operador2(gy,mat);
                gxa = operador2(gx,mat);
                rst.setPixel(y,x,(int) Math.sqrt(Math.pow(gya,2)+Math.pow(gxa,2)),0,0);
            }
        }
        return rst;
    }

    private int operador2(int[][]g,int[][]mat){
        int rst = 0;
        for(int l = 0; l<2; l++){
            for(int c = 0; c<2; c++){
                rst += g[l][c]*mat[l][c];
            }
        }
        return rst;
    }

    public Imagem quantizacao(Imagem a, int qntCores){
        int alt =  a.getAltura();
        int larg = a.getLargura();
        int cor;
        Imagem rst = new Imagem(alt,larg,Imagem.GRAY);
        for(int y = 0; y < alt; y++){
            for(int x = 0; x < larg; x++){
                cor = a.getPixel(y,x,0);
                rst.setPixel(y,x,colorInterval(cor,qntCores),0,0);
            }
        }
        return rst;
    }

    private int colorInterval (int cor, int qntcor){
        int[] intervalosIniciais = new int[qntcor];
        int[] intervalosFinais = new int [qntcor];
        int rst = 0;
        int r = 256/(qntcor);
        intervalosIniciais[0] = 0;
        intervalosFinais[qntcor - 1] = 255;
        for(int i = 1; i < qntcor; i++) {
            intervalosIniciais[i] = intervalosIniciais[i - 1] + r;
            intervalosFinais[i - 1] = intervalosIniciais[i] - 1;
        }
        for(int i = 0; i < qntcor; i++){
            if(intervalosIniciais[i] <= cor && intervalosFinais[i] >= cor){
                 if(i < qntcor/2 ){
                     rst = intervalosIniciais[i];
                 }
                 else{
                     if(i == qntcor/2){
                         rst = (intervalosFinais[i]+intervalosFinais[i])/2;
                     }
                     else{
                         rst = intervalosFinais[i];
                     }
                 }
            }
        }
        return rst;
    }
}
