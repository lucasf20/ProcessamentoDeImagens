package ProcImg;

public class Stretching {

    private int abateTeto(double valor, double max, double min){
        return (int)(((valor - min)*255)/(max-min));
    }

    public Imagem linear (Imagem img, double a, double b){
        int alt = img.getAltura();
        int larg = img.getLargura();
        int l;
        Imagem rst = new Imagem(alt,larg,Imagem.GRAY);
        for(int y = 0; y < alt; y++){
            for(int x = 0; x < larg; x++){
                l = img.getPixel(y,x,0);
                l = abateTeto(a*l+b,65280,0);
                rst.setPixel(y,x,l,0,0);
            }
        }
        return rst;
    }

    public Imagem raizQuadrada (Imagem img, double a){
        int alt = img.getAltura();
        int larg = img.getLargura();
        int l;
        Imagem rst = new Imagem(alt,larg,Imagem.GRAY);
        for(int y = 0; y < alt; y++){
            for(int x = 0; x < larg; x++){
                l = img.getPixel(y,x,0);
                l = abateTeto(a*Math.sqrt(l),255*Math.sqrt(255),0);
                rst.setPixel(y,x,l,0,0);
            }
        }
        return rst;
    }

    public Imagem quadrado (Imagem img, double a){
        int alt = img.getAltura();
        int larg = img.getLargura();
        int l;
        Imagem rst = new Imagem(alt,larg,Imagem.GRAY);
        for(int y = 0; y < alt; y++){
            for(int x = 0; x < larg; x++){
                l = img.getPixel(y,x,0);
                l = abateTeto(a*Math.pow(l,2),Math.pow(255,3),0);
                rst.setPixel(y,x,l,0,0);
            }
        }
        return rst;
    }

    public Imagem logaritmico (Imagem img, double a){
        int alt = img.getAltura();
        int larg = img.getLargura();
        int l;
        Imagem rst = new Imagem(alt,larg,Imagem.GRAY);
        for(int y = 0; y < alt; y++){
            for(int x = 0; x < larg; x++){
                l = img.getPixel(y,x,0);
                l = abateTeto(a*Math.log(l+1),255*Math.log(256),0);
                rst.setPixel(y,x,l,0,0);
            }
        }
        return rst;
    }

    public Imagem negativo (Imagem img, double a, double b){
        int alt = img.getAltura();
        int larg = img.getLargura();
        int l;
        Imagem rst = new Imagem(alt,larg,Imagem.GRAY);
        for(int y = 0; y < alt; y++){
            for(int x = 0; x < larg; x++){
                l = img.getPixel(y,x,0);
                l = abateTeto(-a*l+b,255,-65025);
                rst.setPixel(y,x,l,0,0);
            }
        }
        return rst;
    }
}
