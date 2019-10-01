package ProcImg;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame implements ActionListener {

    Imagem imgA = new Imagem("A.PNG");
    Imagem imgB = new Imagem("B.PNG");
    Imagem mao = new Imagem("mao.png");

    Ops operacoes = new Ops();
    Logic logica = new Logic();
    Stretching st = new Stretching();
    Basicas bsc = new Basicas();

    JButton bt1 = new JButton("1 - Soma");
    JButton bt2 = new JButton("2 - Subtração");
    JButton bt3 = new JButton("3 - Multiplicação");
    JButton bt4 = new JButton("4 - Divisão");

    JButton bt5 = new JButton("5 - AND");
    JButton bt6 = new JButton("6 - OR");
    JButton bt7 = new JButton("7 - NOT");
    JButton bt8 = new JButton("8 - SUB");
    JButton bt9 = new JButton("9 - XOR");
    JButton bt10 = new JButton("10 - Média");

    JButton bt11 = new JButton("11 - Stretching Linear");
    JButton bt12 = new JButton("12 - Stretching Raiz Quadrada");
    JButton bt13 = new JButton("13 - Stretching Quadrático");
    JButton bt14 = new JButton("14 - Stretching Logarítmico");
    JButton bt15 = new JButton("15 - Stretching Negativo");

    JButton bt16 = new JButton("16 - Equalização");
    JButton bt17 = new JButton("17 - Quantização");
    JButton bt18 = new JButton("18 - Filtro da Média");
    JButton bt19 = new JButton("19 - Filtro da Mediana");

    JButton bt20 = new JButton("20 - Sobel");
    JButton bt21 = new JButton("21 - Prewitt");
    JButton bt22 = new JButton("22 - Isotrópico");
    JButton bt23 = new JButton("23 - Laplace");
    JButton bt24 = new JButton("24 - Roberts");

    public Janela(){
        Font ft = new Font("Ubuntu", Font.BOLD,25);
        setLayout(new GridLayout(8,3));
        bt1.setFont(ft);
        bt2.setFont(ft);
        bt3.setFont(ft);
        bt4.setFont(ft);
        bt5.setFont(ft);
        bt6.setFont(ft);
        bt7.setFont(ft);
        bt8.setFont(ft);
        bt9.setFont(ft);
        bt10.setFont(ft);
        bt11.setFont(ft);
        bt12.setFont(ft);
        bt13.setFont(ft);
        bt14.setFont(ft);
        bt15.setFont(ft);
        bt16.setFont(ft);
        bt17.setFont(ft);
        bt18.setFont(ft);
        bt19.setFont(ft);
        bt20.setFont(ft);
        bt21.setFont(ft);
        bt22.setFont(ft);
        bt23.setFont(ft);
        bt24.setFont(ft);

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
        bt20.addActionListener(this);
        bt21.addActionListener(this);
        bt22.addActionListener(this);
        bt23.addActionListener(this);
        bt24.addActionListener(this);

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
        add(bt20);
        add(bt21);
        add(bt22);
        add(bt23);
        add(bt24);

        setTitle("Processamento de Imagens");
        setSize(1200,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if(a.getSource() == bt1)
            operacoes.soma(imgA,imgB).mostrar("A + B");
        if(a.getSource() == bt2){
            operacoes.subtracao(imgA,imgB).mostrar("A - B");
            operacoes.subtracao(imgB,imgA).mostrar("B - A");
        }
        if(a.getSource() == bt3)
            operacoes.multiplicacao(imgA,imgB).mostrar("A * B");
        if(a.getSource() == bt4){
            operacoes.divisao(imgA,imgB).mostrar("A / B");
            operacoes.divisao(imgB,imgA).mostrar("B / A");
        }
        if(a.getSource() == bt5)
            logica.and(imgA,imgB).mostrar("A and B");
        if(a.getSource() == bt6)
            logica.or(imgA,imgB).mostrar("A or B");
        if(a.getSource() == bt7){
            logica.nao(imgA).mostrar("Not A");
            logica.nao(imgB).mostrar("Not B");
        }
        if(a.getSource() == bt8){
            logica.sub(imgA,imgB).mostrar("A sub B");
            logica.sub(imgB,imgA).mostrar("B sub A");
        }
        if(a.getSource() == bt9)
            logica.xor(imgA,imgB).mostrar("A xor B");
        if(a.getSource()== bt10)
            operacoes.media(imgA,imgB).mostrar("Média A e B");
        if(a.getSource() == bt11)
            st.linear(mao,190,40).mostrar("Linear");
        if(a.getSource() == bt12)
            st.raizQuadrada(mao,200).mostrar("Raiz Quadrada");
        if(a.getSource() == bt13)
            st.quadrado(mao,200).mostrar("Quadratico");
        if(a.getSource() == bt14)
            st.logaritmico(mao,95).mostrar("Logarítmico");
        if(a.getSource() == bt15)
            st.negativo(mao,180,80).mostrar("Negativo");
        if(a.getSource() == bt16)
            bsc.equalizacao(mao).mostrar("Equalização");
        if(a.getSource() == bt17){
            bsc.quantizacao(mao,2).mostrar("Quantização 2 cores");
            bsc.quantizacao(mao,4).mostrar("Quantização 4 cores");
            bsc.quantizacao(mao,8).mostrar("Quantização 8 cores");
            bsc.quantizacao(mao,16).mostrar("Quantização 16 cores");
            bsc.quantizacao(mao,32).mostrar("Quantização 32 cores");
            bsc.quantizacao(mao,64).mostrar("Quantização 64 cores");
            bsc.quantizacao(mao,128).mostrar("Quantização 128 cores");
        }
        if(a.getSource() == bt18){
            bsc.filtroDaMedia(mao,1).mostrar("Filtro da Média Raio = 1");
            bsc.filtroDaMedia(mao,2).mostrar("Filtro da Média Raio = 2");
            bsc.filtroDaMedia(mao,3).mostrar("Filtro da Média Raio = 3");
            bsc.filtroDaMedia(mao,4).mostrar("Filtro da Média Raio = 4");
            bsc.filtroDaMedia(mao,5).mostrar("Filtro da Média Raio = 5");
        }
        if(a.getSource() == bt19){
            bsc.filtroDaMediana(mao,1).mostrar("Filtro da Mediana Raio = 1");
            bsc.filtroDaMediana(mao,2).mostrar("Filtro da Mediana Raio = 2");
            bsc.filtroDaMediana(mao,3).mostrar("Filtro da Mediana Raio = 3");
            bsc.filtroDaMediana(mao,4).mostrar("Filtro da Mediana Raio = 4");
            bsc.filtroDaMediana(mao,5).mostrar("Filtro da Mediana Raio = 5");
        }
        if(a.getSource() == bt20)
            bsc.sobel(mao).mostrar("Filtro de Sobel");
        if(a.getSource() == bt21)
            bsc.prewitt(mao).mostrar("Filtro de Prewitt");
        if(a.getSource() == bt22)
            bsc.isotropico(mao).mostrar("Filtro Isotrópico");
        if(a.getSource() == bt23)
            bsc.laplace(mao).mostrar("Filtro de Laplace");
        if(a.getSource() == bt24)
            bsc.roberts(mao).mostrar("Filtro de Roberts");
    }

}
