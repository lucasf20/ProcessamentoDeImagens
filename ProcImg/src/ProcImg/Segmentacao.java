package ProcImg;

public class Segmentacao {

    private static int max(int[] v){
        int m = v[0];
        int p = 0;
        for(int i = 0; i < v.length; i++){
            if(m < v[i]){
                m = v[i];
                p = i;
            }
        }
        return p;
    }

    public static Imagem crescimentoDeRegiao(Imagem a, int limiar){
        Imagem rst = new Imagem(a.getAltura(),a.getLargura(),Imagem.GRAY);
        int[] linhas = new int[a.getAltura()];
        int[] colunas = new int[a.getLargura()];
        int mX, mY, color;
        for(int y = 0; y < a.getAltura(); y++) {
            for (int x = 0; x < a.getLargura(); x++) {
                colunas[x] += a.getPixel(y,x,0);
                linhas[y] += a.getPixel(y,x,0);
            }
        }
        mX = max(linhas);
        mY = max(colunas);
        color = a.getPixel(mY,mX,0);
        rst.setPixel(mY,mX,color,0,0);
        for(int y = mY; y < a.getAltura(); y++) {
            for (int x = mX; x < a.getLargura(); x++) {
                if((y-1 >= 0 )){
                    if((x-1)>=0){
                        if(Math.abs(a.getPixel(y-1,x-1,0)  - a.getPixel(y,x,0)) <= limiar){
                            rst.setPixel(y-1,x-1,a.getPixel(y-1,x-1,0),0,0);
                        }
                    }
                    if((x+1)< a.getLargura()){
                        if(Math.abs(a.getPixel(y-1,x+1,0)  - a.getPixel(y,x,0)) <= limiar){
                            rst.setPixel(y-1,x+1,a.getPixel(y-1,x+1,0),0,0);
                        }
                    }
                    if(Math.abs(a.getPixel(y-1,x,0)  - a.getPixel(y,x,0)) <= limiar){
                        rst.setPixel(y-1,x,a.getPixel(y-1,x,0),0,0);
                    }
                }
                if((y+1 < a.getAltura() )){
                    if((x-1)>=0){
                        if(Math.abs(a.getPixel(y-1,x-1,0)  - a.getPixel(y,x,0)) <= limiar){
                            rst.setPixel(y-1,x-1,a.getPixel(y-1,x-1,0),0,0);
                        }
                    }
                    if((x+1)< a.getLargura()){
                        if(Math.abs(a.getPixel(y-1,x+1,0)  - a.getPixel(y,x,0)) <= limiar){
                            rst.setPixel(y-1,x+1,a.getPixel(y-1,x+1,0),0,0);
                        }
                    }
                    if(Math.abs(a.getPixel(y-1,x,0)  - a.getPixel(y,x,0)) <= limiar){
                        rst.setPixel(y-1,x,a.getPixel(y-1,x,0),0,0);
                    }
                }
                if(x + 1 < a.getLargura() && y + 1 < a.getAltura()){
                    if(Math.abs(a.getPixel(y+1,x+1,0) - a.getPixel(y,x,0)) <= limiar){
                     rst.setPixel(y+1,x+1,a.getPixel(y+1,x+1,0),0,0);
                    }
                }
                if(x - 1 < a.getLargura() && y - 1 >=0){
                    if(Math.abs(a.getPixel(y-1,x-1,0) - a.getPixel(y,x,0)) <= limiar){
                        rst.setPixel(y-1,x-1,a.getPixel(y-1,x-1,0),0,0);
                    }
                }
            }
        }
        return rst;
    }
}
