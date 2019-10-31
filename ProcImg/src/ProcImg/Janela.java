package ProcImg;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame implements ActionListener {

    Imagem imgA = new Imagem("A.PNG");
    Imagem imgB = new Imagem("B.PNG");
    Imagem mao = new Imagem("mao.png");
    Imagem lena = new Imagem("lena.jpeg");

    Ops operacoes = new Ops();
    Logic logica = new Logic();
    Stretching st = new Stretching();
    Basicas bsc = new Basicas();

    JButton bt1 = new JButton("1 - Limiar Simples");
    JButton bt2 = new JButton("2 - Modulação Aleatória");
    JButton bt3 = new JButton("3 - Periódico Por Dispersão");
    JButton bt4 = new JButton("4 - Periódico Por Alglomeração");
    JButton bt5 = new JButton("5 - Aperiódico por Dispersão");

    JButton bt6 = new JButton("6 - Erosão Binária");
    JButton bt7 = new JButton("7 - Dilatação  Binária");
    JButton bt8 = new JButton("8 - Abertura Binária");
    JButton bt9 = new JButton("9 - Fechamento  Binário");
    JButton bt10 = new JButton("10 - Borda Interna");
    JButton bt11 = new JButton("11 - Borda Externa");
    JButton bt12 = new JButton("12 - Acerto e Erro");

    JButton bt13 = new JButton("13 - Erosão Não Binária");
    JButton bt14 = new JButton("14 - Dilatação Não Binária");
    JButton bt15 = new JButton("15 - Abertura Não Binária");
    JButton bt16 = new JButton("16 - Fechamento Não Binário");
    JButton bt17 = new JButton("17 - Smoothing");
    JButton bt18 = new JButton("18 - Gradiente");

    JButton bt19 = new JButton("19 - Cresciemento de Região");

//    JButton bt20 = new JButton("20 - Sobel");
//    JButton bt21 = new JButton("21 - Prewitt");
//    JButton bt22 = new JButton("22 - Isotrópico");
//    JButton bt23 = new JButton("23 - Laplace");
//    JButton bt24 = new JButton("24 - Roberts");
//    JButton bt25 = new JButton("25 - Passa Alta");

    int[][] ee1 = {{255,255,255},{255,255,255},{255,255,255}};
    int[][] ee2 = {{255, 255, 255,255,255,255},{255, 255, 255,255,255,255},{255, 255, 255,255,255,255},{255, 255, 255,255,255,255},{255, 255, 255,255,255,255},{255, 255, 255,255,255,255}};
    int[][] ee = {{255, 255, 255,255,255}, {255, 255, 255,255,255}, {255, 255, 255,255,255},{255, 255, 255,255,255},{255, 255, 255,255,255}};

    public Janela(){
        Font ft = new Font("Ubuntu", Font.BOLD,25);
        Font ft2 = new Font("Ubuntu", Font.BOLD,16);
        setLayout(new GridLayout(5,4));
        bt1.setFont(ft);
        bt2.setFont(ft);
        bt3.setFont(ft2);
        bt4.setFont(ft2);
        bt5.setFont(ft2);
        bt6.setFont(ft);
        bt7.setFont(ft);
        bt8.setFont(ft);
        bt9.setFont(ft);
        bt10.setFont(ft);
        bt11.setFont(ft);
        bt12.setFont(ft);
        bt13.setFont(ft2);
        bt14.setFont(ft2);
        bt15.setFont(ft2);
        bt16.setFont(ft2);
        bt17.setFont(ft);
        bt18.setFont(ft);
        bt19.setFont(ft2);
//        bt20.setFont(ft);
//        bt21.setFont(ft);
//        bt22.setFont(ft);
//        bt23.setFont(ft);
//        bt24.setFont(ft);
//        bt25.setFont(ft);

        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        bt5.addActionListener(this);
        bt6.addActionListener(this);
        bt7.addActionListener(this);
        bt8.addActionListener(this);
        bt9.addActionListener(this);
        bt10.addActionListener(this);
        bt11.addActionListener(this);
        bt12.addActionListener(this);
        bt13.addActionListener(this);
        bt14.addActionListener(this);
        bt15.addActionListener(this);
        bt16.addActionListener(this);
        bt17.addActionListener(this);
        bt18.addActionListener(this);
        bt19.addActionListener(this);
//        bt20.addActionListener(this);
//        bt21.addActionListener(this);
//        bt22.addActionListener(this);
//        bt23.addActionListener(this);
//        bt24.addActionListener(this);
//        bt25.addActionListener(this);

        add(bt1);
        add(bt2);
        add(bt3);
        add(bt4);
        add(bt5);
        add(bt6);
        add(bt7);
        add(bt8);
        add(bt9);
        add(bt10);
        add(bt11);
        add(bt12);
        add(bt13);
        add(bt14);
        add(bt15);
        add(bt16);
        add(bt17);
        add(bt18);
        add(bt19);
//        add(bt20);
//        add(bt21);
//        add(bt22);
//        add(bt23);
//        add(bt24);
//        add(bt25);

        setTitle("Processamento de Imagens");
        setSize(1400,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if(a.getSource() == bt1){
            Dithering.limiarSimples(lena,32).mostrar("Limiar Simples l = 32");
            Dithering.limiarSimples(lena,64).mostrar("Limiar Simples l = 64");
            Dithering.limiarSimples(lena,128).mostrar("Limiar Simples l = 128");
            Dithering.limiarSimples(lena,172).mostrar("Limiar Simples l = 172");
        }
        if(a.getSource() == bt2){
            Dithering.modulacaoAleatoria(lena,32).mostrar("Modulação Aleatória l = 32");
            Dithering.modulacaoAleatoria(lena,64).mostrar("Modulação Aleatória l = 64");
            Dithering.modulacaoAleatoria(lena,128).mostrar("Modulação Aleatória l = 128");
            Dithering.modulacaoAleatoria(lena,172).mostrar("Modulação Aleatória l = 172");
        }
        if(a.getSource() == bt3){
            Dithering.periodicoPorDispercao(lena,2).mostrar("Periódico por Dispersão n = 2");
            Dithering.periodicoPorDispercao(lena,3).mostrar("Periódico por Dispersão n = 3");
            Dithering.periodicoPorDispercao(lena,4).mostrar("Periódico por Dispersão n = 4");
        }
        if(a.getSource() == bt4){
            Dithering.periodicoPorAglomeracao(lena,2).mostrar("Periódico por Aglomeração n=2");
            Dithering.periodicoPorAglomeracao(lena,3).mostrar("Periódico por Aglomeração n=3");
            Dithering.periodicoPorAglomeracao(lena,4).mostrar("Periódico por Aglomeração n=4");
        }
        if(a.getSource() == bt5){
            Dithering.aperiodicoPorDispersao(lena,2).mostrar("Aperiódico por Dispersão Q  = 2");
            Dithering.aperiodicoPorDispersao(lena,8).mostrar("Aperiódico por Dispersão Q  = 4");
            Dithering.aperiodicoPorDispersao(lena,32).mostrar("Aperiódico por Dispersão Q  = 32");
            Dithering.aperiodicoPorDispersao(lena,64).mostrar("Aperiódico por Dispersão Q  = 64");
            Dithering.aperiodicoPorDispersao(lena,128).mostrar("Aperiódico por Dispersão Q  = 128");
        }
        if(a.getSource() == bt6){
            MorfologiaMatematica.erosao(imgB,ee1,1,1).mostrar("Erosão");
        }
        if(a.getSource() == bt7){
            MorfologiaMatematica.dilatacao(imgB,ee,2,2).mostrar("Dilatação");
        }
        if(a.getSource() == bt8){
            MorfologiaMatematica.abertura(imgB,ee,2,2).mostrar("Abertura");
        }
        if(a.getSource() == bt9)
            MorfologiaMatematica.fechamento(imgB,ee2,3,3).mostrar("Fechamento");
        if(a.getSource()== bt10)
            MorfologiaMatematica.bordaInterna(imgB,ee,2,2).mostrar("Borda Interna");
        if(a.getSource() == bt11)
            MorfologiaMatematica.bordaExterna(imgB,ee,2,2).mostrar("Borda Externa");
        if(a.getSource() == bt12){
            imgA.mostrar("Original");
            MorfologiaMatematica.acertoEerro(imgA,ee2,3,3).mostrar("Acerto e Erro");
            }
        if(a.getSource() == bt13)
            MorfologiaMatematica.erosaoCinza(lena,ee,2,2).mostrar("Erosão");
        if(a.getSource() == bt14)
            MorfologiaMatematica.dilatacaoCinza(lena,ee,2,2).mostrar("Dilatação");
        if(a.getSource() == bt15)
            MorfologiaMatematica.aberturaCinza(lena,ee,2,2).mostrar("Abertura");
        if(a.getSource() == bt16)
            MorfologiaMatematica.fechamentoCinza(lena,ee,2,2).mostrar("Fechamento");
        if(a.getSource() == bt17){
            MorfologiaMatematica.smoothing(lena,ee,2,2).mostrar("Smoothing");
        }
        if(a.getSource() == bt18){
            MorfologiaMatematica.gradiente(lena,ee,2,2).mostrar("Gradiente");
        }
        if(a.getSource() == bt19){
            Segmentacao.crescimentoDeRegiao(lena,20).mostrar("Crescimento de Região limiar = 20");
            Segmentacao.crescimentoDeRegiao(lena,40).mostrar("Crescimento de Região limiar = 40");
            Segmentacao.crescimentoDeRegiao(lena,100).mostrar("Crescimento de Região limiar = 100");
            Segmentacao.crescimentoDeRegiao(lena,200).mostrar("Crescimento de Região limiar = 200");
        }
//        if(a.getSource() == bt20)
//            bsc.sobel(mao).mostrar("Filtro de Sobel");
//        if(a.getSource() == bt21)
//            bsc.prewitt(mao).mostrar("Filtro de Prewitt");
//        if(a.getSource() == bt22)
//            bsc.isotropico(mao).mostrar("Filtro Isotrópico");
//        if(a.getSource() == bt23)
//            bsc.laplace(mao).mostrar("Filtro de Laplace");
//        if(a.getSource() == bt24)
//            bsc.roberts(mao).mostrar("Filtro de Roberts");
//        if(a.getSource() == bt25)
//            bsc.passaAlta(mao).mostrar("Filtro Passa Alta");
    }

}
