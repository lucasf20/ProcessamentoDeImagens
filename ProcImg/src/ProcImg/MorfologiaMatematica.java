package ProcImg;

public class MorfologiaMatematica {

    private static Imagem imagemDoMesmoTamanho(Imagem a){
        int alt = a.getAltura();
        int larg = a.getLargura();
        return new Imagem(alt,larg, Imagem.GRAY);
    }
    public static Imagem erosao(Imagem a){
        Imagem rst = imagemDoMesmoTamanho(a);

        return rst;
    }
}
