package ProcImg;

public class MorfologiaMatematica {

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
}
