package ProcImg;

public class MorfologiaMatematica {

    static Logic logic = new Logic();

    private static Imagem imagemDoMesmoTamanho(Imagem a){
        int alt = a.getAltura();
        int larg = a.getLargura();
        Imagem rst = new Imagem(alt,larg, Imagem.GRAY);
        for(int y = 0; y < rst.getAltura(); y++){
            for(int x = 0; x < rst.getLargura();x++){
                rst.setPixel(y,x,a.getPixel(y,x,0),0,0);
            }
        }
        return rst;
    }

    public static Imagem erosao(Imagem a, int[][] ee, int linhaCentral, int colunaCentral){
        Imagem rst = imagemDoMesmoTamanho(a);
        boolean verify;
        int aux;
        for(int y = linhaCentral; y<a.getAltura() - linhaCentral;y++){
            for(int x = colunaCentral; x<a.getLargura() - colunaCentral; x++){
                verify = false;
                for(int i = 0; i < ee.length;i++){
                    for(int j = 0; j < ee[i].length; j++){
                        aux = a.getPixel(y - linhaCentral + i, x - colunaCentral + j,0);
                        if(ee[i][j] != 0){
                            if(aux != ee[i][j]){
                                verify = true;
                            }
                        }
                    }
                }
                if(verify){
                    rst.setPixel(y,x,0,0,0);
                }
            }
        }
        return rst;
    }

    public static Imagem dilatacao(Imagem a, int[][] ee, int linhaCentral, int colunaCentral){
        Imagem rst = imagemDoMesmoTamanho(a);
        int aux;
        for(int y = linhaCentral; y<a.getAltura() - linhaCentral;y++) {
            for (int x = colunaCentral; x < a.getLargura() - colunaCentral; x++) {
                aux = a.getPixel(y,x,0);
                if(aux == ee[linhaCentral][colunaCentral]){
                    for(int i = 0; i < ee.length; i++){
                        for(int j = 0; j <ee[i].length; j++){
                            if(ee[i][j] != 0){
                                rst.setPixel(y - linhaCentral + i, x - colunaCentral + j, ee[i][j],0,0);
                            }
                        }
                    }
                }
            }
        }
        return rst;
    }

    public static Imagem fechamento(Imagem a, int[][] ee, int linhaCentral, int colunaCentral){
        return erosao(dilatacao(a,ee,linhaCentral,colunaCentral),ee,linhaCentral,colunaCentral);
    }

    public static Imagem abertura(Imagem a, int[][] ee, int linhaCentral, int colunaCentral){
        return dilatacao(erosao(a,ee,linhaCentral,colunaCentral),ee,linhaCentral,colunaCentral);
    }

    public static Imagem bordaInterna(Imagem a, int[][] ee, int linhaCentral, int colunaCentral){
        Imagem rst = logic.sub(a,erosao(a,ee,linhaCentral,colunaCentral));
        return rst;
    }

    public static Imagem bordaExterna(Imagem a, int[][] ee, int linhaCentral, int colunaCentral){
        Imagem dilatada = dilatacao(a,ee,linhaCentral,colunaCentral);
        Imagem rst = logic.sub(dilatada,a);
        return rst;
    }

    public static Imagem acertoEerro(Imagem a, int[][] ee, int linhaCentral, int colunaCentral){
        Imagem i1 = erosao(a,ee,linhaCentral,colunaCentral);
        int [][] ee2 = new int[ee.length][ee[0].length];
        for(int i = 0; i < ee.length; i++){
            for(int j = 0; j<ee[i].length;j++){
                ee2[i][j] = (ee[i][j] == 0)?255:0;
            }
        }
        Imagem i2 = erosao(a,ee2,linhaCentral,colunaCentral);
        Imagem rst = logic.and(i1,i2);
        return rst;
    }

    private static int abateTeto(double valor, double max, double min){
        return (int)(((valor - min)*255)/(max-min));
    }

    private static int max(int[][]m){
        int c = m[0][0];
        for(int i = 0; i<m.length; i++){
            for (int j = 0; j < m[i].length; j++){
                if(c < m[i][j]){
                    c = m[i][j];
                }
            }
        }
        return c;
    }

    private static int min(int[][]m){
        int c = m[0][0];
        for(int i = 0; i<m.length; i++){
            for (int j = 0; j < m[i].length; j++){
                if(c > m[i][j]){
                    c = m[i][j];
                }
            }
        }
        return c;
    }

    public static Imagem dilatacaoCinza(Imagem a, int[][] ee, int linhaCentral, int colunaCentral){
       Imagem rst = imagemDoMesmoTamanho(a);
       int[][] aux = new int[ee.length][ee[0].length];
        for(int y = linhaCentral; y<a.getAltura() - linhaCentral;y++) {
            for (int x = colunaCentral; x < a.getLargura() - colunaCentral; x++) {
                for(int i = 0; i < ee.length; i++){
                    for(int j = 0; j <ee[i].length; j++){
                        aux[i][j] = ee[i][j] + a.getPixel(y - linhaCentral + i, x - colunaCentral + j, 0);
                    }
                }
                rst.setPixel(y,x,max(aux),0,0);
            }
        }
       return rst;
    }

    public static Imagem erosaoCinza(Imagem a, int[][] ee, int linhaCentral, int colunaCentral){
        Imagem rst = imagemDoMesmoTamanho(a);
        int[][] aux = new int[ee.length][ee[0].length];
        for(int y = linhaCentral; y<a.getAltura() - linhaCentral;y++) {
            for (int x = colunaCentral; x < a.getLargura() - colunaCentral; x++) {
                for(int i = 0; i < ee.length; i++){
                    for(int j = 0; j <ee[i].length; j++){
                        aux[i][j] = -ee[i][j] + a.getPixel(y - linhaCentral + i, x - colunaCentral + j, 0);
                    }
                }
                rst.setPixel(y,x,min(aux),0,0);
            }
        }
        return rst;
    }

    public static Imagem fechamentoCinza(Imagem a, int[][] ee, int linhaCentral, int colunaCentral){
        return erosaoCinza(dilatacaoCinza(a,ee,linhaCentral,colunaCentral),ee,linhaCentral,colunaCentral);
    }

    public static Imagem aberturaCinza(Imagem a, int[][] ee, int linhaCentral, int colunaCentral){
        return dilatacaoCinza(erosaoCinza(a,ee,linhaCentral,colunaCentral),ee,linhaCentral,colunaCentral);
    }

    public static Imagem smoothing(Imagem a, int[][] ee, int linhaCentral, int colunaCentral){
        return fechamentoCinza(aberturaCinza(a,ee,linhaCentral,colunaCentral),ee,linhaCentral,colunaCentral);
    }

    public static Imagem gradiente(Imagem a, int[][] ee, int linhaCentral, int colunaCentral){
        Ops operacao = new Ops();
        Imagem dilatada = dilatacaoCinza(a,ee,linhaCentral,colunaCentral);
        Imagem erodida = erosaoCinza(a,ee,linhaCentral,colunaCentral);
        return operacao.subtracao(dilatada,erodida);
    }
}
