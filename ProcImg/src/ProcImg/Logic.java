package ProcImg;

public class Logic {
    public Imagem nao(Imagem a){
        int alt = a.getAltura();
        int larg = a.getLargura();
        int tom;
        Imagem out = new Imagem(alt,larg,Imagem.GRAY);
        for(int y = 0; y < alt; y++){
            for(int x = 0; x < larg; x++){
                tom = a.getPixel(y,x,0);
                if(tom < 255){
                    out.setPixel(y,x,255,0,0);
                }
                else{
                    out.setPixel(y,x,0,0,0);
                }
            }
        }
        return out;
    }

    public Imagem and(Imagem a, Imagem b){
        int alt = a.getAltura();
        int larg = a.getLargura();
        int tomA,tomB;
        Imagem out = new Imagem(alt,larg,Imagem.GRAY);
        for(int y = 0; y < alt; y++) {
            for (int x = 0; x < larg; x++) {
                tomA = a.getPixel(y,x,0);
                tomB = b.getPixel(y,x,0);
                if(tomA == 255 && tomB == 255){
                    out.setPixel(y,x,255,0,0);
                }
                else{
                    out.setPixel(y,x,0,0,0);
                }
            }
        }
        return out;
    }

    public Imagem or(Imagem a, Imagem b){
        int alt = a.getAltura();
        int larg = a.getLargura();
        int tomA,tomB;
        Imagem out = new Imagem(alt,larg,Imagem.GRAY);
        for(int y = 0; y < alt; y++) {
            for (int x = 0; x < larg; x++) {
                tomA = a.getPixel(y,x,0);
                tomB = b.getPixel(y,x,0);
                if(tomA == 255 || tomB == 255){
                    out.setPixel(y,x,255,0,0);
                }
                else{
                    out.setPixel(y,x,0,0,0);
                }
            }
        }
        return out;
    }

    public Imagem xor (Imagem a, Imagem b){
        int alt = a.getAltura();
        int larg = a.getLargura();
        int tomA,tomB;
        Imagem out = new Imagem(alt,larg,Imagem.GRAY);
        for(int y = 0; y < alt; y++) {
            for (int x = 0; x < larg; x++) {
                tomA = a.getPixel(y,x,0);
                tomB = b.getPixel(y,x,0);
                if(tomA != tomB){
                    out.setPixel(y,x,255,0,0);
                }
                else{
                    out.setPixel(y,x,0,0,0);
                }
            }
        }
        return out;
    }

    public Imagem sub (Imagem a, Imagem b){
        int alt = a.getAltura();
        int larg = a.getLargura();
        int tomA,tomB;
        Imagem out = new Imagem(alt,larg,Imagem.GRAY);
        for(int y = 0; y < alt; y++) {
            for (int x = 0; x < larg; x++) {
                tomA = a.getPixel(y,x,0);
                tomB = b.getPixel(y,x,0);
                if(tomA == 255 && tomB == 0){
                    out.setPixel(y,x,255,0,0);
                }
                else{
                    out.setPixel(y,x,0,0,0);
                }
            }
        }
        return out;
    }
}
