package ProcImg;

public class Ops {

    public Imagem soma(Imagem a, Imagem b){
        int alt = a.getAltura();
        int larg = a.getLargura();
        int som;
        Imagem out = new Imagem(alt, larg, Imagem.GRAY);
        for(int y = 0; y < alt; y++){
            for(int x = 0; x < larg; x++){
               som = a.getPixel(y,x,0) + b.getPixel(y,x,0);
               out.setPixel(y,x,fix_soma(0,255*2,som),0,0);
            }
        }
        return out;
    }

    private int fix_soma(int min, int max, int sum){
        return ((sum - min)*255)/(max-min);
    }

    public Imagem subtracao(Imagem a, Imagem b){
        int alt = a.getAltura();
        int larg = a.getLargura();
        int sub;
        Imagem out = new Imagem(alt, larg, Imagem.GRAY);
        for(int y = 0; y < alt; y++) {
            for (int x = 0; x < larg; x++) {
                sub = a.getPixel(y,x,0) - b.getPixel(y,x,0);
                if (sub <= 0)
                    sub = 0;
                out.setPixel(y,x,sub,0,0);
            }
        }
        return out;
    }

    public Imagem multiplicacao(Imagem a, Imagem b){
        int alt = a.getAltura();
        int larg = a.getLargura();
        int aux;
        Imagem out = new Imagem(alt, larg, Imagem.GRAY);
        for(int y = 0; y < alt; y++) {
            for (int x = 0; x < larg; x++) {
                aux = (a.getPixel(y,x,0)*b.getPixel(y,x,0))/255;
                out.setPixel(y,x,aux,0,0);
            }
        }
        return out;
    }

    public Imagem divisao (Imagem a, Imagem b){
        int alt = a.getAltura();
        int larg = a.getLargura();
        int aux, tomB;
        Imagem out = new Imagem(alt, larg, Imagem.GRAY);
        for(int y = 0; y < alt; y++) {
            for (int x = 0; x < larg; x++) {
                tomB = b.getPixel(y,x,0) ;
                if(tomB != 0)
                    aux = (a.getPixel(y,x,0)/tomB);
                else
                    aux = (a.getPixel(y,x,0)/1);
                out.setPixel(y,x,aux,0,0);
            }
        }
        return out;
    }

    public Imagem media(Imagem a, Imagem b){
        int alt = a.getAltura();
        int larg = a.getLargura();
        int aux;
        Imagem out = new Imagem(alt, larg, Imagem.GRAY);
        for(int y = 0; y < alt; y++) {
            for (int x = 0; x < larg; x++) {
                aux = a.getPixel(y,x,0) + b.getPixel(y,x,0);
                out.setPixel(y,x,aux/2,0,0);
            }
        }
        return out;
    }
}

