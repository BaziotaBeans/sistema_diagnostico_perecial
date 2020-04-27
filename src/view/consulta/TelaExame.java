/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.consulta;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Map;
import javax.swing.JOptionPane;
import org.jpl7.Query;
import org.jpl7.Term;


//////////////////////////
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Baziota Beans
 */
public class TelaExame extends javax.swing.JFrame {
    
    private int temperatura_alta, colica, vomito, tontura, tremor, tosse, fadiga, dor_abdominal, 
    dor_de_Cabeca, ferida_na_Pele, falta_Apetite, suor;
    private int MAX = 12, indexPrev = -1, indexProx = 2, pos =1;
    ArrayList<Integer> sintomaFeita = new ArrayList<Integer>();
    ArrayList<Boolean> sontomaAcessada = new ArrayList<Boolean>();
    private int xMouse, yMouse;
    private boolean checked1 = false, checked2 = false, checked3 = false, checked4 = false, 
    checked5 = false, checked6 = false, checked7 = false, checked8 = false, checked9 = false, 
    checked10 = false, checked11 = false, checked12 = false;
    private String percentagemMalaria, percentagemHIV, percentagemGestacao, percentagemFebreTifoide;
    private String maiorPercentagem;
    private String resultado_final;
    private BufferedReader leitor;
    /**
     * Creates new form TelaExame
     */
    public TelaExame() {
        initComponents();
        setSintomaFeitasArr();
        setPanelProva();
    }
    
    
    public void realizarDiagnostico() throws IOException
    {
        FileWriter escritor = null;
        String conexao = "consult('hospital.pl')";
        Query q1 = new Query(conexao);
        if (q1.hasSolution()) System.out.println("Conectado com na KB com sucesso");
        else System.out.println("Não foi possivel conectar");
        String superRule = "calcularDoenca(NOME, RESULTADO, M, H, G, F,"+temperatura_alta+
        ","+tosse+","+fadiga+","+dor_de_Cabeca+","+colica+","+vomito+","+suor+","+tremor+","+ferida_na_Pele+","+
        tontura+","+dor_abdominal+","+falta_Apetite+")";
        Query q2 = new Query(superRule);
        
        while(q2.hasMoreSolutions())
        {
            Map<String, Term> solution = q2.nextSolution();
            
            resultado_final = solution.get("NOME").toString();
            maiorPercentagem = solution.get("RESULTADO").toString();
            percentagemMalaria = solution.get("M").toString();
            percentagemHIV = solution.get("H").toString();
            percentagemGestacao = solution.get("G").toString();
            percentagemFebreTifoide = solution.get("F").toString();
            System.out.println(resultado_final);
            System.out.println(maiorPercentagem);
            System.out.println(percentagemMalaria);
            System.out.println(percentagemHIV);
            System.out.println(percentagemGestacao);
            System.out.println(percentagemFebreTifoide);
            escrever(escritor, new FileWriter("src/Ficheiros/Doenca.txt"),resultado_final);
            escrever(escritor, new FileWriter("src/Ficheiros/Percentagem_Geral.txt"),maiorPercentagem);
            escrever(escritor, new FileWriter("src/Ficheiros/Percentagem_M.txt"),percentagemMalaria);
            escrever(escritor, new FileWriter("src/Ficheiros/Percentagem_H.txt"),percentagemHIV);
            escrever(escritor, new FileWriter("src/Ficheiros/Percentagem_G.txt"),percentagemGestacao);
            escrever(escritor, new FileWriter("src/Ficheiros/Percentagem_F.txt"),percentagemFebreTifoide);
        } 
    }
    
    public void escreverSintomas(int temperatura_alta, int tosse,int fadiga,int dor_de_Cabeca,int colica,int vomito,int suor,int tremor,int ferida_na_Pele, 
        int tontura,int dor_abdominal, int falta_Apetite)
    {
        //if(temperatura_alta>0)
        
    }
    
    /*
    
    */
    public void escrever(FileWriter recebe, FileWriter caminho, String str)
    {
        try
        {
            recebe = caminho;
            recebe.write(str);
            recebe.close();
            
        }catch(IOException e)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel salvar os seus dados");
            e.printStackTrace();
        }
    }
    
    
    public void validar()
    {
        if(checked1) sintoma1.setBackground(new Color(0,206,209));
        if(checked2) sintoma2.setBackground(new Color(0,206,209));
        if(checked3) sintoma3.setBackground(new Color(0,206,209));
        if(checked4) sintoma4.setBackground(new Color(0,206,209));
        if(checked5) sintoma5.setBackground(new Color(0,206,209));
        if(checked6) sintoma6.setBackground(new Color(0,206,209));
        if(checked7) sintoma7.setBackground(new Color(0,206,209));
        if(checked8) sintoma8.setBackground(new Color(0,206,209));
        if(checked9) sintoma9.setBackground(new Color(0,206,209));
        if(checked10) sintoma10.setBackground(new Color(0,206,209));
        if(checked11) sintoma11.setBackground(new Color(0,206,209));
        if(checked12) sintoma12.setBackground(new Color(0,206,209));
        
    }
    
    public void setPanelProva()
    {
        if (pos == 1) sintoma1MouseClicked(null);
        else if (pos == 2) sintoma2MouseClicked(null);
        else if (pos == 3) sintoma3MouseClicked(null);
        else if (pos == 4) sintoma4MouseClicked(null);
        else if (pos == 5) sintoma5MouseClicked(null);
        else if (pos == 6) sintoma6MouseClicked(null);
        else if (pos == 7) sintoma7MouseClicked(null);
        else if (pos == 8) sintoma8MouseClicked(null);
        else if (pos == 9) sintoma9MouseClicked(null);
        else if (pos == 10) sintoma10MouseClicked(null);
        else if (pos == 11) sintoma11MouseClicked(null);
        else if (pos == 12) sintoma12MouseClicked(null);
        
        resetSintomaColor();    
    }
    
    public void setSintomaFeitasArr()
    {
        sintomaFeita.add(0, 1);
        sintomaFeita.add(1, 2);
        sintomaFeita.add(2, 3);
        sintomaFeita.add(3, 4);
        sintomaFeita.add(4, 5);
        sintomaFeita.add(5, 6);
        sintomaFeita.add(6, 7);
        sintomaFeita.add(7, 8);
        sintomaFeita.add(8, 9);
        sintomaFeita.add(9, 10);
        sintomaFeita.add(10,11);
        sintomaFeita.add(11,12);
    }
    
    public void resetSintomaColor()
    {        
        int k = sintomaFeita.size();
        for (int i = 0; i < k; i++) {
            if (sintomaFeita.get(pos) == 1) setColorPos(pos); 
        }             
    }
    
    public void setColorPos(int pos)
    {        
        if (pos == 0) sintoma1.setBackground(new Color(0,128,128)); 
        if (pos == 1) sintoma2.setBackground(new Color(0,128,128)); 
        else if (pos == 2) sintoma3.setBackground(new Color(0,128,128)); 
        else if (pos == 3) sintoma4.setBackground(new Color(0,128,128)); 
        else if (pos == 4) sintoma5.setBackground(new Color(0,128,128)); 
        else if (pos == 5) sintoma6.setBackground(new Color(0,128,128)); 
        else if (pos == 6) sintoma7.setBackground(new Color(0,128,128)); 
        else if (pos == 7) sintoma8.setBackground(new Color(0,128,128)); 
        else if (pos == 8) sintoma9.setBackground(new Color(0,128,128)); 
        else  if (pos == 9) sintoma10.setBackground(new Color(0,128,128));
        else  if (pos == 10) sintoma11.setBackground(new Color(0,128,128));
        else  if (pos == 11) sintoma12.setBackground(new Color(0,128,128));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTop = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pnl_home = new javax.swing.JPanel();
        pnl_body = new javax.swing.JPanel();
        panel_12 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        faltaapetite_sim = new javax.swing.JRadioButton();
        faltaapetite_nao = new javax.swing.JRadioButton();
        faltaapetite_talvezsim = new javax.swing.JRadioButton();
        faltaapetite_talveznao = new javax.swing.JRadioButton();
        faltaapetite_naosei = new javax.swing.JRadioButton();
        line13 = new javax.swing.JPanel();
        panel_11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        ferida_sim = new javax.swing.JRadioButton();
        ferida_nao = new javax.swing.JRadioButton();
        ferida_talvezsim = new javax.swing.JRadioButton();
        ferida_talveznao = new javax.swing.JRadioButton();
        ferida_naosei = new javax.swing.JRadioButton();
        line12 = new javax.swing.JPanel();
        panel_10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        fadiga_sim = new javax.swing.JRadioButton();
        fadiga_nao = new javax.swing.JRadioButton();
        fadiga_talvezsim = new javax.swing.JRadioButton();
        fadiga_talveznao = new javax.swing.JRadioButton();
        fadiga_naosei = new javax.swing.JRadioButton();
        line11 = new javax.swing.JPanel();
        panel_9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        dorcabeca_sim = new javax.swing.JRadioButton();
        dorcabeca_nao = new javax.swing.JRadioButton();
        dorcabeca_talvezsim = new javax.swing.JRadioButton();
        dorcabeca_talveznao = new javax.swing.JRadioButton();
        dorcabeca_naosei = new javax.swing.JRadioButton();
        line10 = new javax.swing.JPanel();
        panel_8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        dorabdomen_sim = new javax.swing.JRadioButton();
        dorabdomen_nao = new javax.swing.JRadioButton();
        dorabdomen_talvezsim = new javax.swing.JRadioButton();
        dorabdomen_talveznao = new javax.swing.JRadioButton();
        dorabdomen_naosei = new javax.swing.JRadioButton();
        line9 = new javax.swing.JPanel();
        panel_7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        colica_sim = new javax.swing.JRadioButton();
        colica_nao = new javax.swing.JRadioButton();
        colica_talvezsim = new javax.swing.JRadioButton();
        colica_talveznao = new javax.swing.JRadioButton();
        colica_naosei = new javax.swing.JRadioButton();
        line8 = new javax.swing.JPanel();
        panel_6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        vomito_sim = new javax.swing.JRadioButton();
        vomito_nao = new javax.swing.JRadioButton();
        vomito_talvezsim = new javax.swing.JRadioButton();
        vomito_talveznao = new javax.swing.JRadioButton();
        vomito_naosei = new javax.swing.JRadioButton();
        line7 = new javax.swing.JPanel();
        panel_5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tremor_sim = new javax.swing.JRadioButton();
        tremor_nao = new javax.swing.JRadioButton();
        tremor_talvezsim = new javax.swing.JRadioButton();
        tremor_talveznao = new javax.swing.JRadioButton();
        tremor_naosei = new javax.swing.JRadioButton();
        line6 = new javax.swing.JPanel();
        panel_4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tontura_sim = new javax.swing.JRadioButton();
        tontura_nao = new javax.swing.JRadioButton();
        tontura_talvezsim = new javax.swing.JRadioButton();
        tontura_talveznao = new javax.swing.JRadioButton();
        tontura_naosei = new javax.swing.JRadioButton();
        line5 = new javax.swing.JPanel();
        panel_3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tosse_sim = new javax.swing.JRadioButton();
        tosse_nao = new javax.swing.JRadioButton();
        tosse_talvezsim = new javax.swing.JRadioButton();
        tosse_talveznao = new javax.swing.JRadioButton();
        tosse_naosei = new javax.swing.JRadioButton();
        line4 = new javax.swing.JPanel();
        panel_2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        suor_sim = new javax.swing.JRadioButton();
        suor_nao = new javax.swing.JRadioButton();
        suor_talvezsim = new javax.swing.JRadioButton();
        suor_talveznao = new javax.swing.JRadioButton();
        suor_naosei = new javax.swing.JRadioButton();
        line3 = new javax.swing.JPanel();
        panel_1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        temperaturaAlta_sim = new javax.swing.JRadioButton();
        temperaturaAlta_nao = new javax.swing.JRadioButton();
        temperaturaAlta_talvez_sim = new javax.swing.JRadioButton();
        temperaturaAlta_talvez_nao = new javax.swing.JRadioButton();
        temperaturaAlta_nao_sei = new javax.swing.JRadioButton();
        line2 = new javax.swing.JPanel();
        info_principal = new javax.swing.JLabel();
        line1 = new javax.swing.JPanel();
        sintoma1 = new javax.swing.JPanel();
        sintoma2 = new javax.swing.JPanel();
        sintoma3 = new javax.swing.JPanel();
        sintoma4 = new javax.swing.JPanel();
        sintoma5 = new javax.swing.JPanel();
        sintoma6 = new javax.swing.JPanel();
        sintoma7 = new javax.swing.JPanel();
        sintoma8 = new javax.swing.JPanel();
        sintoma9 = new javax.swing.JPanel();
        sintoma10 = new javax.swing.JPanel();
        sintoma11 = new javax.swing.JPanel();
        sintoma12 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btn_avancar = new javax.swing.JButton();
        btn_recuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlTop.setBackground(new java.awt.Color(0, 206, 209));
        pnlTop.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlTopMouseDragged(evt);
            }
        });
        pnlTop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlTopMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("-");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ProDoctor System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlTopLayout = new javax.swing.GroupLayout(pnlTop);
        pnlTop.setLayout(pnlTopLayout);
        pnlTopLayout.setHorizontalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(16, 16, 16))
            .addGroup(pnlTopLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlTopLayout.setVerticalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopLayout.createSequentialGroup()
                .addGroup(pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnl_home.setBackground(new java.awt.Color(255, 255, 255));

        pnl_body.setBackground(new java.awt.Color(255, 255, 255));
        pnl_body.setLayout(new java.awt.CardLayout());

        panel_12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("12. Estás com falta de apetite?");

        faltaapetite_sim.setBackground(new java.awt.Color(255, 255, 255));
        faltaapetite_sim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        faltaapetite_sim.setForeground(new java.awt.Color(51, 51, 51));
        faltaapetite_sim.setText("Sim");
        faltaapetite_sim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        faltaapetite_sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faltaapetite_simActionPerformed(evt);
            }
        });

        faltaapetite_nao.setBackground(new java.awt.Color(255, 255, 255));
        faltaapetite_nao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        faltaapetite_nao.setForeground(new java.awt.Color(51, 51, 51));
        faltaapetite_nao.setText("Não");
        faltaapetite_nao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        faltaapetite_nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faltaapetite_naoActionPerformed(evt);
            }
        });

        faltaapetite_talvezsim.setBackground(new java.awt.Color(255, 255, 255));
        faltaapetite_talvezsim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        faltaapetite_talvezsim.setForeground(new java.awt.Color(51, 51, 51));
        faltaapetite_talvezsim.setText("Talvez Sim");
        faltaapetite_talvezsim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        faltaapetite_talvezsim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faltaapetite_talvezsimActionPerformed(evt);
            }
        });

        faltaapetite_talveznao.setBackground(new java.awt.Color(255, 255, 255));
        faltaapetite_talveznao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        faltaapetite_talveznao.setForeground(new java.awt.Color(51, 51, 51));
        faltaapetite_talveznao.setText("Talvez Não");
        faltaapetite_talveznao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        faltaapetite_talveznao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faltaapetite_talveznaoActionPerformed(evt);
            }
        });

        faltaapetite_naosei.setBackground(new java.awt.Color(255, 255, 255));
        faltaapetite_naosei.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        faltaapetite_naosei.setForeground(new java.awt.Color(51, 51, 51));
        faltaapetite_naosei.setText("Não Sei");
        faltaapetite_naosei.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        faltaapetite_naosei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faltaapetite_naoseiActionPerformed(evt);
            }
        });

        line13.setBackground(new java.awt.Color(0, 206, 209));
        line13.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout line13Layout = new javax.swing.GroupLayout(line13);
        line13.setLayout(line13Layout);
        line13Layout.setHorizontalGroup(
            line13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line13Layout.setVerticalGroup(
            line13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_12Layout = new javax.swing.GroupLayout(panel_12);
        panel_12.setLayout(panel_12Layout);
        panel_12Layout.setHorizontalGroup(
            panel_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_12Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panel_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(faltaapetite_sim)
                    .addComponent(faltaapetite_nao)
                    .addComponent(faltaapetite_talvezsim)
                    .addComponent(faltaapetite_talveznao)
                    .addComponent(faltaapetite_naosei)
                    .addComponent(jLabel16))
                .addContainerGap(477, Short.MAX_VALUE))
            .addComponent(line13, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        panel_12Layout.setVerticalGroup(
            panel_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(line13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(faltaapetite_sim)
                .addGap(18, 18, 18)
                .addComponent(faltaapetite_nao)
                .addGap(18, 18, 18)
                .addComponent(faltaapetite_talvezsim)
                .addGap(18, 18, 18)
                .addComponent(faltaapetite_talveznao)
                .addGap(18, 18, 18)
                .addComponent(faltaapetite_naosei)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pnl_body.add(panel_12, "card13");

        panel_11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("11. Estás com feridas na pele?");

        ferida_sim.setBackground(new java.awt.Color(255, 255, 255));
        ferida_sim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        ferida_sim.setForeground(new java.awt.Color(51, 51, 51));
        ferida_sim.setText("Sim");
        ferida_sim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        ferida_sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ferida_simActionPerformed(evt);
            }
        });

        ferida_nao.setBackground(new java.awt.Color(255, 255, 255));
        ferida_nao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        ferida_nao.setForeground(new java.awt.Color(51, 51, 51));
        ferida_nao.setText("Não");
        ferida_nao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        ferida_nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ferida_naoActionPerformed(evt);
            }
        });

        ferida_talvezsim.setBackground(new java.awt.Color(255, 255, 255));
        ferida_talvezsim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        ferida_talvezsim.setForeground(new java.awt.Color(51, 51, 51));
        ferida_talvezsim.setText("Talvez Sim");
        ferida_talvezsim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        ferida_talvezsim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ferida_talvezsimActionPerformed(evt);
            }
        });

        ferida_talveznao.setBackground(new java.awt.Color(255, 255, 255));
        ferida_talveznao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        ferida_talveznao.setForeground(new java.awt.Color(51, 51, 51));
        ferida_talveznao.setText("Talvez Não");
        ferida_talveznao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        ferida_talveznao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ferida_talveznaoActionPerformed(evt);
            }
        });

        ferida_naosei.setBackground(new java.awt.Color(255, 255, 255));
        ferida_naosei.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        ferida_naosei.setForeground(new java.awt.Color(51, 51, 51));
        ferida_naosei.setText("Não Sei");
        ferida_naosei.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        ferida_naosei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ferida_naoseiActionPerformed(evt);
            }
        });

        line12.setBackground(new java.awt.Color(0, 206, 209));
        line12.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout line12Layout = new javax.swing.GroupLayout(line12);
        line12.setLayout(line12Layout);
        line12Layout.setHorizontalGroup(
            line12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line12Layout.setVerticalGroup(
            line12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_11Layout = new javax.swing.GroupLayout(panel_11);
        panel_11.setLayout(panel_11Layout);
        panel_11Layout.setHorizontalGroup(
            panel_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_11Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panel_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ferida_sim)
                    .addComponent(ferida_nao)
                    .addComponent(ferida_talvezsim)
                    .addComponent(ferida_talveznao)
                    .addComponent(ferida_naosei)
                    .addComponent(jLabel15))
                .addContainerGap(488, Short.MAX_VALUE))
            .addComponent(line12, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        panel_11Layout.setVerticalGroup(
            panel_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(line12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(ferida_sim)
                .addGap(18, 18, 18)
                .addComponent(ferida_nao)
                .addGap(18, 18, 18)
                .addComponent(ferida_talvezsim)
                .addGap(18, 18, 18)
                .addComponent(ferida_talveznao)
                .addGap(18, 18, 18)
                .addComponent(ferida_naosei)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pnl_body.add(panel_11, "card12");

        panel_10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("10. Estás com fadiga?");

        fadiga_sim.setBackground(new java.awt.Color(255, 255, 255));
        fadiga_sim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        fadiga_sim.setForeground(new java.awt.Color(51, 51, 51));
        fadiga_sim.setText("Sim");
        fadiga_sim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        fadiga_sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fadiga_simActionPerformed(evt);
            }
        });

        fadiga_nao.setBackground(new java.awt.Color(255, 255, 255));
        fadiga_nao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        fadiga_nao.setForeground(new java.awt.Color(51, 51, 51));
        fadiga_nao.setText("Não");
        fadiga_nao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        fadiga_nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fadiga_naoActionPerformed(evt);
            }
        });

        fadiga_talvezsim.setBackground(new java.awt.Color(255, 255, 255));
        fadiga_talvezsim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        fadiga_talvezsim.setForeground(new java.awt.Color(51, 51, 51));
        fadiga_talvezsim.setText("Talvez Sim");
        fadiga_talvezsim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        fadiga_talvezsim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fadiga_talvezsimActionPerformed(evt);
            }
        });

        fadiga_talveznao.setBackground(new java.awt.Color(255, 255, 255));
        fadiga_talveznao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        fadiga_talveznao.setForeground(new java.awt.Color(51, 51, 51));
        fadiga_talveznao.setText("Talvez Não");
        fadiga_talveznao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        fadiga_talveznao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fadiga_talveznaoActionPerformed(evt);
            }
        });

        fadiga_naosei.setBackground(new java.awt.Color(255, 255, 255));
        fadiga_naosei.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        fadiga_naosei.setForeground(new java.awt.Color(51, 51, 51));
        fadiga_naosei.setText("Não Sei");
        fadiga_naosei.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        fadiga_naosei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fadiga_naoseiActionPerformed(evt);
            }
        });

        line11.setBackground(new java.awt.Color(0, 206, 209));
        line11.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout line11Layout = new javax.swing.GroupLayout(line11);
        line11.setLayout(line11Layout);
        line11Layout.setHorizontalGroup(
            line11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line11Layout.setVerticalGroup(
            line11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_10Layout = new javax.swing.GroupLayout(panel_10);
        panel_10.setLayout(panel_10Layout);
        panel_10Layout.setHorizontalGroup(
            panel_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_10Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panel_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fadiga_sim)
                    .addComponent(fadiga_nao)
                    .addComponent(fadiga_talvezsim)
                    .addComponent(fadiga_talveznao)
                    .addComponent(fadiga_naosei)
                    .addComponent(jLabel14))
                .addContainerGap(581, Short.MAX_VALUE))
            .addComponent(line11, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        panel_10Layout.setVerticalGroup(
            panel_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(line11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(fadiga_sim)
                .addGap(18, 18, 18)
                .addComponent(fadiga_nao)
                .addGap(18, 18, 18)
                .addComponent(fadiga_talvezsim)
                .addGap(18, 18, 18)
                .addComponent(fadiga_talveznao)
                .addGap(18, 18, 18)
                .addComponent(fadiga_naosei)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pnl_body.add(panel_10, "card11");

        panel_9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("9. Estás com dores na cabeça?");

        dorcabeca_sim.setBackground(new java.awt.Color(255, 255, 255));
        dorcabeca_sim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        dorcabeca_sim.setForeground(new java.awt.Color(51, 51, 51));
        dorcabeca_sim.setText("Sim");
        dorcabeca_sim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        dorcabeca_sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dorcabeca_simActionPerformed(evt);
            }
        });

        dorcabeca_nao.setBackground(new java.awt.Color(255, 255, 255));
        dorcabeca_nao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        dorcabeca_nao.setForeground(new java.awt.Color(51, 51, 51));
        dorcabeca_nao.setText("Não");
        dorcabeca_nao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        dorcabeca_nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dorcabeca_naoActionPerformed(evt);
            }
        });

        dorcabeca_talvezsim.setBackground(new java.awt.Color(255, 255, 255));
        dorcabeca_talvezsim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        dorcabeca_talvezsim.setForeground(new java.awt.Color(51, 51, 51));
        dorcabeca_talvezsim.setText("Talvez Sim");
        dorcabeca_talvezsim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        dorcabeca_talvezsim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dorcabeca_talvezsimActionPerformed(evt);
            }
        });

        dorcabeca_talveznao.setBackground(new java.awt.Color(255, 255, 255));
        dorcabeca_talveznao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        dorcabeca_talveznao.setForeground(new java.awt.Color(51, 51, 51));
        dorcabeca_talveznao.setText("Talvez Não");
        dorcabeca_talveznao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        dorcabeca_talveznao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dorcabeca_talveznaoActionPerformed(evt);
            }
        });

        dorcabeca_naosei.setBackground(new java.awt.Color(255, 255, 255));
        dorcabeca_naosei.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        dorcabeca_naosei.setForeground(new java.awt.Color(51, 51, 51));
        dorcabeca_naosei.setText("Não Sei");
        dorcabeca_naosei.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        dorcabeca_naosei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dorcabeca_naoseiActionPerformed(evt);
            }
        });

        line10.setBackground(new java.awt.Color(0, 206, 209));
        line10.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout line10Layout = new javax.swing.GroupLayout(line10);
        line10.setLayout(line10Layout);
        line10Layout.setHorizontalGroup(
            line10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line10Layout.setVerticalGroup(
            line10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_9Layout = new javax.swing.GroupLayout(panel_9);
        panel_9.setLayout(panel_9Layout);
        panel_9Layout.setHorizontalGroup(
            panel_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_9Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panel_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dorcabeca_sim)
                    .addComponent(dorcabeca_nao)
                    .addComponent(dorcabeca_talvezsim)
                    .addComponent(dorcabeca_talveznao)
                    .addComponent(dorcabeca_naosei)
                    .addComponent(jLabel13))
                .addContainerGap(487, Short.MAX_VALUE))
            .addComponent(line10, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        panel_9Layout.setVerticalGroup(
            panel_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(line10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(dorcabeca_sim)
                .addGap(18, 18, 18)
                .addComponent(dorcabeca_nao)
                .addGap(18, 18, 18)
                .addComponent(dorcabeca_talvezsim)
                .addGap(18, 18, 18)
                .addComponent(dorcabeca_talveznao)
                .addGap(18, 18, 18)
                .addComponent(dorcabeca_naosei)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pnl_body.add(panel_9, "card10");

        panel_8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("8. Estás com dores no abdomen?");

        dorabdomen_sim.setBackground(new java.awt.Color(255, 255, 255));
        dorabdomen_sim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        dorabdomen_sim.setForeground(new java.awt.Color(51, 51, 51));
        dorabdomen_sim.setText("Sim");
        dorabdomen_sim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        dorabdomen_sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dorabdomen_simActionPerformed(evt);
            }
        });

        dorabdomen_nao.setBackground(new java.awt.Color(255, 255, 255));
        dorabdomen_nao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        dorabdomen_nao.setForeground(new java.awt.Color(51, 51, 51));
        dorabdomen_nao.setText("Não");
        dorabdomen_nao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        dorabdomen_nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dorabdomen_naoActionPerformed(evt);
            }
        });

        dorabdomen_talvezsim.setBackground(new java.awt.Color(255, 255, 255));
        dorabdomen_talvezsim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        dorabdomen_talvezsim.setForeground(new java.awt.Color(51, 51, 51));
        dorabdomen_talvezsim.setText("Talvez Sim");
        dorabdomen_talvezsim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        dorabdomen_talvezsim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dorabdomen_talvezsimActionPerformed(evt);
            }
        });

        dorabdomen_talveznao.setBackground(new java.awt.Color(255, 255, 255));
        dorabdomen_talveznao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        dorabdomen_talveznao.setForeground(new java.awt.Color(51, 51, 51));
        dorabdomen_talveznao.setText("Talvez Não");
        dorabdomen_talveznao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        dorabdomen_talveznao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dorabdomen_talveznaoActionPerformed(evt);
            }
        });

        dorabdomen_naosei.setBackground(new java.awt.Color(255, 255, 255));
        dorabdomen_naosei.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        dorabdomen_naosei.setForeground(new java.awt.Color(51, 51, 51));
        dorabdomen_naosei.setText("Não Sei");
        dorabdomen_naosei.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        dorabdomen_naosei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dorabdomen_naoseiActionPerformed(evt);
            }
        });

        line9.setBackground(new java.awt.Color(0, 206, 209));
        line9.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout line9Layout = new javax.swing.GroupLayout(line9);
        line9.setLayout(line9Layout);
        line9Layout.setHorizontalGroup(
            line9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line9Layout.setVerticalGroup(
            line9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_8Layout = new javax.swing.GroupLayout(panel_8);
        panel_8.setLayout(panel_8Layout);
        panel_8Layout.setHorizontalGroup(
            panel_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_8Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panel_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dorabdomen_sim)
                    .addComponent(dorabdomen_nao)
                    .addComponent(dorabdomen_talvezsim)
                    .addComponent(dorabdomen_talveznao)
                    .addComponent(dorabdomen_naosei)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(line9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_8Layout.setVerticalGroup(
            panel_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(line9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(dorabdomen_sim)
                .addGap(18, 18, 18)
                .addComponent(dorabdomen_nao)
                .addGap(18, 18, 18)
                .addComponent(dorabdomen_talvezsim)
                .addGap(18, 18, 18)
                .addComponent(dorabdomen_talveznao)
                .addGap(18, 18, 18)
                .addComponent(dorabdomen_naosei)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_body.add(panel_8, "card9");

        panel_7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("7. Estás com colica?");

        colica_sim.setBackground(new java.awt.Color(255, 255, 255));
        colica_sim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        colica_sim.setForeground(new java.awt.Color(51, 51, 51));
        colica_sim.setText("Sim");
        colica_sim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        colica_sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colica_simActionPerformed(evt);
            }
        });

        colica_nao.setBackground(new java.awt.Color(255, 255, 255));
        colica_nao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        colica_nao.setForeground(new java.awt.Color(51, 51, 51));
        colica_nao.setText("Não");
        colica_nao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        colica_nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colica_naoActionPerformed(evt);
            }
        });

        colica_talvezsim.setBackground(new java.awt.Color(255, 255, 255));
        colica_talvezsim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        colica_talvezsim.setForeground(new java.awt.Color(51, 51, 51));
        colica_talvezsim.setText("Talvez Sim");
        colica_talvezsim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        colica_talvezsim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colica_talvezsimActionPerformed(evt);
            }
        });

        colica_talveznao.setBackground(new java.awt.Color(255, 255, 255));
        colica_talveznao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        colica_talveznao.setForeground(new java.awt.Color(51, 51, 51));
        colica_talveznao.setText("Talvez Não");
        colica_talveznao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        colica_talveznao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colica_talveznaoActionPerformed(evt);
            }
        });

        colica_naosei.setBackground(new java.awt.Color(255, 255, 255));
        colica_naosei.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        colica_naosei.setForeground(new java.awt.Color(51, 51, 51));
        colica_naosei.setText("Não Sei");
        colica_naosei.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        colica_naosei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colica_naoseiActionPerformed(evt);
            }
        });

        line8.setBackground(new java.awt.Color(0, 206, 209));
        line8.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout line8Layout = new javax.swing.GroupLayout(line8);
        line8.setLayout(line8Layout);
        line8Layout.setHorizontalGroup(
            line8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line8Layout.setVerticalGroup(
            line8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_7Layout = new javax.swing.GroupLayout(panel_7);
        panel_7.setLayout(panel_7Layout);
        panel_7Layout.setHorizontalGroup(
            panel_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_7Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panel_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(colica_sim)
                    .addComponent(colica_nao)
                    .addComponent(colica_talvezsim)
                    .addComponent(colica_talveznao)
                    .addComponent(colica_naosei)
                    .addComponent(jLabel11))
                .addContainerGap(597, Short.MAX_VALUE))
            .addComponent(line8, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        panel_7Layout.setVerticalGroup(
            panel_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(line8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(colica_sim)
                .addGap(18, 18, 18)
                .addComponent(colica_nao)
                .addGap(18, 18, 18)
                .addComponent(colica_talvezsim)
                .addGap(18, 18, 18)
                .addComponent(colica_talveznao)
                .addGap(18, 18, 18)
                .addComponent(colica_naosei)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pnl_body.add(panel_7, "card8");

        panel_6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("6. Estás com vomito?");

        vomito_sim.setBackground(new java.awt.Color(255, 255, 255));
        vomito_sim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        vomito_sim.setForeground(new java.awt.Color(51, 51, 51));
        vomito_sim.setText("Sim");
        vomito_sim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        vomito_sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vomito_simActionPerformed(evt);
            }
        });

        vomito_nao.setBackground(new java.awt.Color(255, 255, 255));
        vomito_nao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        vomito_nao.setForeground(new java.awt.Color(51, 51, 51));
        vomito_nao.setText("Não");
        vomito_nao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        vomito_nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vomito_naoActionPerformed(evt);
            }
        });

        vomito_talvezsim.setBackground(new java.awt.Color(255, 255, 255));
        vomito_talvezsim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        vomito_talvezsim.setForeground(new java.awt.Color(51, 51, 51));
        vomito_talvezsim.setText("Talvez Sim");
        vomito_talvezsim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        vomito_talvezsim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vomito_talvezsimActionPerformed(evt);
            }
        });

        vomito_talveznao.setBackground(new java.awt.Color(255, 255, 255));
        vomito_talveznao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        vomito_talveznao.setForeground(new java.awt.Color(51, 51, 51));
        vomito_talveznao.setText("Talvez Não");
        vomito_talveznao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        vomito_talveznao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vomito_talveznaoActionPerformed(evt);
            }
        });

        vomito_naosei.setBackground(new java.awt.Color(255, 255, 255));
        vomito_naosei.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        vomito_naosei.setForeground(new java.awt.Color(51, 51, 51));
        vomito_naosei.setText("Não Sei");
        vomito_naosei.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        vomito_naosei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vomito_naoseiActionPerformed(evt);
            }
        });

        line7.setBackground(new java.awt.Color(0, 206, 209));
        line7.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout line7Layout = new javax.swing.GroupLayout(line7);
        line7.setLayout(line7Layout);
        line7Layout.setHorizontalGroup(
            line7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line7Layout.setVerticalGroup(
            line7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_6Layout = new javax.swing.GroupLayout(panel_6);
        panel_6.setLayout(panel_6Layout);
        panel_6Layout.setHorizontalGroup(
            panel_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_6Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panel_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vomito_sim)
                    .addComponent(vomito_nao)
                    .addComponent(vomito_talvezsim)
                    .addComponent(vomito_talveznao)
                    .addComponent(vomito_naosei)
                    .addComponent(jLabel10))
                .addContainerGap(586, Short.MAX_VALUE))
            .addComponent(line7, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        panel_6Layout.setVerticalGroup(
            panel_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(line7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(vomito_sim)
                .addGap(18, 18, 18)
                .addComponent(vomito_nao)
                .addGap(18, 18, 18)
                .addComponent(vomito_talvezsim)
                .addGap(18, 18, 18)
                .addComponent(vomito_talveznao)
                .addGap(18, 18, 18)
                .addComponent(vomito_naosei)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pnl_body.add(panel_6, "card7");

        panel_5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("5. Estás com tremor?");

        tremor_sim.setBackground(new java.awt.Color(255, 255, 255));
        tremor_sim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tremor_sim.setForeground(new java.awt.Color(51, 51, 51));
        tremor_sim.setText("Sim");
        tremor_sim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        tremor_sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tremor_simActionPerformed(evt);
            }
        });

        tremor_nao.setBackground(new java.awt.Color(255, 255, 255));
        tremor_nao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tremor_nao.setForeground(new java.awt.Color(51, 51, 51));
        tremor_nao.setText("Não");
        tremor_nao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        tremor_nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tremor_naoActionPerformed(evt);
            }
        });

        tremor_talvezsim.setBackground(new java.awt.Color(255, 255, 255));
        tremor_talvezsim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tremor_talvezsim.setForeground(new java.awt.Color(51, 51, 51));
        tremor_talvezsim.setText("Talvez Sim");
        tremor_talvezsim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        tremor_talvezsim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tremor_talvezsimActionPerformed(evt);
            }
        });

        tremor_talveznao.setBackground(new java.awt.Color(255, 255, 255));
        tremor_talveznao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tremor_talveznao.setForeground(new java.awt.Color(51, 51, 51));
        tremor_talveznao.setText("Talvez Não");
        tremor_talveznao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        tremor_talveznao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tremor_talveznaoActionPerformed(evt);
            }
        });

        tremor_naosei.setBackground(new java.awt.Color(255, 255, 255));
        tremor_naosei.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tremor_naosei.setForeground(new java.awt.Color(51, 51, 51));
        tremor_naosei.setText("Não Sei");
        tremor_naosei.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        tremor_naosei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tremor_naoseiActionPerformed(evt);
            }
        });

        line6.setBackground(new java.awt.Color(0, 206, 209));
        line6.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout line6Layout = new javax.swing.GroupLayout(line6);
        line6.setLayout(line6Layout);
        line6Layout.setHorizontalGroup(
            line6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line6Layout.setVerticalGroup(
            line6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_5Layout = new javax.swing.GroupLayout(panel_5);
        panel_5.setLayout(panel_5Layout);
        panel_5Layout.setHorizontalGroup(
            panel_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panel_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tremor_sim)
                    .addComponent(tremor_nao)
                    .addComponent(tremor_talvezsim)
                    .addComponent(tremor_talveznao)
                    .addComponent(tremor_naosei)
                    .addComponent(jLabel9))
                .addContainerGap(587, Short.MAX_VALUE))
            .addComponent(line6, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        panel_5Layout.setVerticalGroup(
            panel_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(line6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(tremor_sim)
                .addGap(18, 18, 18)
                .addComponent(tremor_nao)
                .addGap(18, 18, 18)
                .addComponent(tremor_talvezsim)
                .addGap(18, 18, 18)
                .addComponent(tremor_talveznao)
                .addGap(18, 18, 18)
                .addComponent(tremor_naosei)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pnl_body.add(panel_5, "card6");

        panel_4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("4. Estás com tontura?");

        tontura_sim.setBackground(new java.awt.Color(255, 255, 255));
        tontura_sim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tontura_sim.setForeground(new java.awt.Color(51, 51, 51));
        tontura_sim.setText("Sim");
        tontura_sim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        tontura_sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tontura_simActionPerformed(evt);
            }
        });

        tontura_nao.setBackground(new java.awt.Color(255, 255, 255));
        tontura_nao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tontura_nao.setForeground(new java.awt.Color(51, 51, 51));
        tontura_nao.setText("Não");
        tontura_nao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        tontura_nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tontura_naoActionPerformed(evt);
            }
        });

        tontura_talvezsim.setBackground(new java.awt.Color(255, 255, 255));
        tontura_talvezsim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tontura_talvezsim.setForeground(new java.awt.Color(51, 51, 51));
        tontura_talvezsim.setText("Talvez Sim");
        tontura_talvezsim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        tontura_talvezsim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tontura_talvezsimActionPerformed(evt);
            }
        });

        tontura_talveznao.setBackground(new java.awt.Color(255, 255, 255));
        tontura_talveznao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tontura_talveznao.setForeground(new java.awt.Color(51, 51, 51));
        tontura_talveznao.setText("Talvez Não");
        tontura_talveznao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        tontura_talveznao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tontura_talveznaoActionPerformed(evt);
            }
        });

        tontura_naosei.setBackground(new java.awt.Color(255, 255, 255));
        tontura_naosei.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tontura_naosei.setForeground(new java.awt.Color(51, 51, 51));
        tontura_naosei.setText("Não Sei");
        tontura_naosei.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        tontura_naosei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tontura_naoseiActionPerformed(evt);
            }
        });

        line5.setBackground(new java.awt.Color(0, 206, 209));
        line5.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout line5Layout = new javax.swing.GroupLayout(line5);
        line5.setLayout(line5Layout);
        line5Layout.setHorizontalGroup(
            line5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line5Layout.setVerticalGroup(
            line5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_4Layout = new javax.swing.GroupLayout(panel_4);
        panel_4.setLayout(panel_4Layout);
        panel_4Layout.setHorizontalGroup(
            panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tontura_sim)
                    .addComponent(tontura_nao)
                    .addComponent(tontura_talvezsim)
                    .addComponent(tontura_talveznao)
                    .addComponent(tontura_naosei)
                    .addComponent(jLabel8))
                .addContainerGap(580, Short.MAX_VALUE))
            .addComponent(line5, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        panel_4Layout.setVerticalGroup(
            panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(line5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(tontura_sim)
                .addGap(18, 18, 18)
                .addComponent(tontura_nao)
                .addGap(18, 18, 18)
                .addComponent(tontura_talvezsim)
                .addGap(18, 18, 18)
                .addComponent(tontura_talveznao)
                .addGap(18, 18, 18)
                .addComponent(tontura_naosei)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pnl_body.add(panel_4, "card5");

        panel_3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("3. Estás com tosse?");

        tosse_sim.setBackground(new java.awt.Color(255, 255, 255));
        tosse_sim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tosse_sim.setForeground(new java.awt.Color(51, 51, 51));
        tosse_sim.setText("Sim");
        tosse_sim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        tosse_sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tosse_simActionPerformed(evt);
            }
        });

        tosse_nao.setBackground(new java.awt.Color(255, 255, 255));
        tosse_nao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tosse_nao.setForeground(new java.awt.Color(51, 51, 51));
        tosse_nao.setText("Não");
        tosse_nao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        tosse_nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tosse_naoActionPerformed(evt);
            }
        });

        tosse_talvezsim.setBackground(new java.awt.Color(255, 255, 255));
        tosse_talvezsim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tosse_talvezsim.setForeground(new java.awt.Color(51, 51, 51));
        tosse_talvezsim.setText("Talvez Sim");
        tosse_talvezsim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        tosse_talvezsim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tosse_talvezsimActionPerformed(evt);
            }
        });

        tosse_talveznao.setBackground(new java.awt.Color(255, 255, 255));
        tosse_talveznao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tosse_talveznao.setForeground(new java.awt.Color(51, 51, 51));
        tosse_talveznao.setText("Talvez Não");
        tosse_talveznao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        tosse_talveznao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tosse_talveznaoActionPerformed(evt);
            }
        });

        tosse_naosei.setBackground(new java.awt.Color(255, 255, 255));
        tosse_naosei.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tosse_naosei.setForeground(new java.awt.Color(51, 51, 51));
        tosse_naosei.setText("Não Sei");
        tosse_naosei.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        tosse_naosei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tosse_naoseiActionPerformed(evt);
            }
        });

        line4.setBackground(new java.awt.Color(0, 206, 209));
        line4.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout line4Layout = new javax.swing.GroupLayout(line4);
        line4.setLayout(line4Layout);
        line4Layout.setHorizontalGroup(
            line4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line4Layout.setVerticalGroup(
            line4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_3Layout = new javax.swing.GroupLayout(panel_3);
        panel_3.setLayout(panel_3Layout);
        panel_3Layout.setHorizontalGroup(
            panel_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panel_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tosse_sim)
                    .addComponent(tosse_nao)
                    .addComponent(tosse_talvezsim)
                    .addComponent(tosse_talveznao)
                    .addComponent(tosse_naosei)
                    .addComponent(jLabel7))
                .addContainerGap(605, Short.MAX_VALUE))
            .addComponent(line4, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        panel_3Layout.setVerticalGroup(
            panel_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(line4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(tosse_sim)
                .addGap(18, 18, 18)
                .addComponent(tosse_nao)
                .addGap(18, 18, 18)
                .addComponent(tosse_talvezsim)
                .addGap(18, 18, 18)
                .addComponent(tosse_talveznao)
                .addGap(18, 18, 18)
                .addComponent(tosse_naosei)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pnl_body.add(panel_3, "card4");

        panel_2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("2. Estás com suor?");

        suor_sim.setBackground(new java.awt.Color(255, 255, 255));
        suor_sim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        suor_sim.setForeground(new java.awt.Color(51, 51, 51));
        suor_sim.setText("Sim");
        suor_sim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        suor_sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suor_simActionPerformed(evt);
            }
        });

        suor_nao.setBackground(new java.awt.Color(255, 255, 255));
        suor_nao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        suor_nao.setForeground(new java.awt.Color(51, 51, 51));
        suor_nao.setText("Não");
        suor_nao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        suor_nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suor_naoActionPerformed(evt);
            }
        });

        suor_talvezsim.setBackground(new java.awt.Color(255, 255, 255));
        suor_talvezsim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        suor_talvezsim.setForeground(new java.awt.Color(51, 51, 51));
        suor_talvezsim.setText("Talvez Sim");
        suor_talvezsim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        suor_talvezsim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suor_talvezsimActionPerformed(evt);
            }
        });

        suor_talveznao.setBackground(new java.awt.Color(255, 255, 255));
        suor_talveznao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        suor_talveznao.setForeground(new java.awt.Color(51, 51, 51));
        suor_talveznao.setText("Talvez Não");
        suor_talveznao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        suor_talveznao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suor_talveznaoActionPerformed(evt);
            }
        });

        suor_naosei.setBackground(new java.awt.Color(255, 255, 255));
        suor_naosei.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        suor_naosei.setForeground(new java.awt.Color(51, 51, 51));
        suor_naosei.setText("Não Sei");
        suor_naosei.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        suor_naosei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suor_naoseiActionPerformed(evt);
            }
        });

        line3.setBackground(new java.awt.Color(0, 206, 209));
        line3.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout line3Layout = new javax.swing.GroupLayout(line3);
        line3.setLayout(line3Layout);
        line3Layout.setHorizontalGroup(
            line3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line3Layout.setVerticalGroup(
            line3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_2Layout = new javax.swing.GroupLayout(panel_2);
        panel_2.setLayout(panel_2Layout);
        panel_2Layout.setHorizontalGroup(
            panel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(suor_sim)
                    .addComponent(suor_nao)
                    .addComponent(suor_talvezsim)
                    .addComponent(suor_talveznao)
                    .addComponent(suor_naosei)
                    .addComponent(jLabel6))
                .addContainerGap(616, Short.MAX_VALUE))
            .addComponent(line3, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        panel_2Layout.setVerticalGroup(
            panel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(line3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(suor_sim)
                .addGap(18, 18, 18)
                .addComponent(suor_nao)
                .addGap(18, 18, 18)
                .addComponent(suor_talvezsim)
                .addGap(18, 18, 18)
                .addComponent(suor_talveznao)
                .addGap(18, 18, 18)
                .addComponent(suor_naosei)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pnl_body.add(panel_2, "card3");

        panel_1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("1. Estás com temperatura alta?");

        temperaturaAlta_sim.setBackground(new java.awt.Color(255, 255, 255));
        temperaturaAlta_sim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        temperaturaAlta_sim.setForeground(new java.awt.Color(51, 51, 51));
        temperaturaAlta_sim.setText("Sim");
        temperaturaAlta_sim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        temperaturaAlta_sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temperaturaAlta_simActionPerformed(evt);
            }
        });

        temperaturaAlta_nao.setBackground(new java.awt.Color(255, 255, 255));
        temperaturaAlta_nao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        temperaturaAlta_nao.setForeground(new java.awt.Color(51, 51, 51));
        temperaturaAlta_nao.setText("Não");
        temperaturaAlta_nao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        temperaturaAlta_nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temperaturaAlta_naoActionPerformed(evt);
            }
        });

        temperaturaAlta_talvez_sim.setBackground(new java.awt.Color(255, 255, 255));
        temperaturaAlta_talvez_sim.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        temperaturaAlta_talvez_sim.setForeground(new java.awt.Color(51, 51, 51));
        temperaturaAlta_talvez_sim.setText("Talvez Sim");
        temperaturaAlta_talvez_sim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        temperaturaAlta_talvez_sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temperaturaAlta_talvez_simActionPerformed(evt);
            }
        });

        temperaturaAlta_talvez_nao.setBackground(new java.awt.Color(255, 255, 255));
        temperaturaAlta_talvez_nao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        temperaturaAlta_talvez_nao.setForeground(new java.awt.Color(51, 51, 51));
        temperaturaAlta_talvez_nao.setText("Talvez Não");
        temperaturaAlta_talvez_nao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        temperaturaAlta_talvez_nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temperaturaAlta_talvez_naoActionPerformed(evt);
            }
        });

        temperaturaAlta_nao_sei.setBackground(new java.awt.Color(255, 255, 255));
        temperaturaAlta_nao_sei.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        temperaturaAlta_nao_sei.setForeground(new java.awt.Color(51, 51, 51));
        temperaturaAlta_nao_sei.setText("Não Sei");
        temperaturaAlta_nao_sei.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 206, 209), 3, true));
        temperaturaAlta_nao_sei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temperaturaAlta_nao_seiActionPerformed(evt);
            }
        });

        line2.setBackground(new java.awt.Color(0, 206, 209));
        line2.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout line2Layout = new javax.swing.GroupLayout(line2);
        line2.setLayout(line2Layout);
        line2Layout.setHorizontalGroup(
            line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line2Layout.setVerticalGroup(
            line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_1Layout = new javax.swing.GroupLayout(panel_1);
        panel_1.setLayout(panel_1Layout);
        panel_1Layout.setHorizontalGroup(
            panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(temperaturaAlta_sim)
                    .addComponent(temperaturaAlta_nao)
                    .addComponent(temperaturaAlta_talvez_sim)
                    .addComponent(temperaturaAlta_talvez_nao)
                    .addComponent(temperaturaAlta_nao_sei)
                    .addComponent(jLabel1))
                .addContainerGap(475, Short.MAX_VALUE))
            .addComponent(line2, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        panel_1Layout.setVerticalGroup(
            panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(line2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(temperaturaAlta_sim)
                .addGap(18, 18, 18)
                .addComponent(temperaturaAlta_nao)
                .addGap(18, 18, 18)
                .addComponent(temperaturaAlta_talvez_sim)
                .addGap(18, 18, 18)
                .addComponent(temperaturaAlta_talvez_nao)
                .addGap(18, 18, 18)
                .addComponent(temperaturaAlta_nao_sei)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pnl_body.add(panel_1, "card2");

        info_principal.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        info_principal.setForeground(new java.awt.Color(0, 206, 209));
        info_principal.setText("Analise as questões e seleciona os sintomas que apresentas");

        line1.setBackground(new java.awt.Color(0, 206, 209));
        line1.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout line1Layout = new javax.swing.GroupLayout(line1);
        line1.setLayout(line1Layout);
        line1Layout.setHorizontalGroup(
            line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line1Layout.setVerticalGroup(
            line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        sintoma1.setBackground(new java.awt.Color(204, 204, 204));
        sintoma1.setPreferredSize(new java.awt.Dimension(25, 25));
        sintoma1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sintoma1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout sintoma1Layout = new javax.swing.GroupLayout(sintoma1);
        sintoma1.setLayout(sintoma1Layout);
        sintoma1Layout.setHorizontalGroup(
            sintoma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        sintoma1Layout.setVerticalGroup(
            sintoma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        sintoma2.setBackground(new java.awt.Color(204, 204, 204));
        sintoma2.setPreferredSize(new java.awt.Dimension(25, 25));
        sintoma2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sintoma2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout sintoma2Layout = new javax.swing.GroupLayout(sintoma2);
        sintoma2.setLayout(sintoma2Layout);
        sintoma2Layout.setHorizontalGroup(
            sintoma2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        sintoma2Layout.setVerticalGroup(
            sintoma2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        sintoma3.setBackground(new java.awt.Color(204, 204, 204));
        sintoma3.setPreferredSize(new java.awt.Dimension(25, 25));
        sintoma3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sintoma3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout sintoma3Layout = new javax.swing.GroupLayout(sintoma3);
        sintoma3.setLayout(sintoma3Layout);
        sintoma3Layout.setHorizontalGroup(
            sintoma3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        sintoma3Layout.setVerticalGroup(
            sintoma3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        sintoma4.setBackground(new java.awt.Color(204, 204, 204));
        sintoma4.setPreferredSize(new java.awt.Dimension(25, 25));
        sintoma4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sintoma4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout sintoma4Layout = new javax.swing.GroupLayout(sintoma4);
        sintoma4.setLayout(sintoma4Layout);
        sintoma4Layout.setHorizontalGroup(
            sintoma4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        sintoma4Layout.setVerticalGroup(
            sintoma4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        sintoma5.setBackground(new java.awt.Color(204, 204, 204));
        sintoma5.setPreferredSize(new java.awt.Dimension(25, 25));
        sintoma5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sintoma5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout sintoma5Layout = new javax.swing.GroupLayout(sintoma5);
        sintoma5.setLayout(sintoma5Layout);
        sintoma5Layout.setHorizontalGroup(
            sintoma5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        sintoma5Layout.setVerticalGroup(
            sintoma5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        sintoma6.setBackground(new java.awt.Color(204, 204, 204));
        sintoma6.setPreferredSize(new java.awt.Dimension(25, 25));
        sintoma6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sintoma6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout sintoma6Layout = new javax.swing.GroupLayout(sintoma6);
        sintoma6.setLayout(sintoma6Layout);
        sintoma6Layout.setHorizontalGroup(
            sintoma6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        sintoma6Layout.setVerticalGroup(
            sintoma6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        sintoma7.setBackground(new java.awt.Color(204, 204, 204));
        sintoma7.setPreferredSize(new java.awt.Dimension(25, 25));
        sintoma7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sintoma7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout sintoma7Layout = new javax.swing.GroupLayout(sintoma7);
        sintoma7.setLayout(sintoma7Layout);
        sintoma7Layout.setHorizontalGroup(
            sintoma7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        sintoma7Layout.setVerticalGroup(
            sintoma7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        sintoma8.setBackground(new java.awt.Color(204, 204, 204));
        sintoma8.setPreferredSize(new java.awt.Dimension(25, 25));
        sintoma8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sintoma8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout sintoma8Layout = new javax.swing.GroupLayout(sintoma8);
        sintoma8.setLayout(sintoma8Layout);
        sintoma8Layout.setHorizontalGroup(
            sintoma8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        sintoma8Layout.setVerticalGroup(
            sintoma8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        sintoma9.setBackground(new java.awt.Color(204, 204, 204));
        sintoma9.setPreferredSize(new java.awt.Dimension(25, 25));
        sintoma9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sintoma9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout sintoma9Layout = new javax.swing.GroupLayout(sintoma9);
        sintoma9.setLayout(sintoma9Layout);
        sintoma9Layout.setHorizontalGroup(
            sintoma9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        sintoma9Layout.setVerticalGroup(
            sintoma9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        sintoma10.setBackground(new java.awt.Color(204, 204, 204));
        sintoma10.setPreferredSize(new java.awt.Dimension(25, 25));
        sintoma10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sintoma10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout sintoma10Layout = new javax.swing.GroupLayout(sintoma10);
        sintoma10.setLayout(sintoma10Layout);
        sintoma10Layout.setHorizontalGroup(
            sintoma10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        sintoma10Layout.setVerticalGroup(
            sintoma10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        sintoma11.setBackground(new java.awt.Color(204, 204, 204));
        sintoma11.setPreferredSize(new java.awt.Dimension(25, 25));
        sintoma11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sintoma11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout sintoma11Layout = new javax.swing.GroupLayout(sintoma11);
        sintoma11.setLayout(sintoma11Layout);
        sintoma11Layout.setHorizontalGroup(
            sintoma11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        sintoma11Layout.setVerticalGroup(
            sintoma11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        sintoma12.setBackground(new java.awt.Color(204, 204, 204));
        sintoma12.setPreferredSize(new java.awt.Dimension(25, 25));
        sintoma12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sintoma12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout sintoma12Layout = new javax.swing.GroupLayout(sintoma12);
        sintoma12.setLayout(sintoma12Layout);
        sintoma12Layout.setHorizontalGroup(
            sintoma12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        sintoma12Layout.setVerticalGroup(
            sintoma12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_avancar.setText("Avançar");
        btn_avancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_avancarActionPerformed(evt);
            }
        });

        btn_recuar.setText("Recuar");
        btn_recuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_recuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_homeLayout = new javax.swing.GroupLayout(pnl_home);
        pnl_home.setLayout(pnl_homeLayout);
        pnl_homeLayout.setHorizontalGroup(
            pnl_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(line1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
            .addComponent(pnl_body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_homeLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(info_principal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnl_homeLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(sintoma1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sintoma2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sintoma3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sintoma4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sintoma5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sintoma6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sintoma7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sintoma8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sintoma9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sintoma10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sintoma11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sintoma12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_recuar)
                .addGap(18, 18, 18)
                .addComponent(btn_avancar)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(16, 16, 16))
        );
        pnl_homeLayout.setVerticalGroup(
            pnl_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_homeLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(info_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(line1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_body, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(pnl_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sintoma1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sintoma3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sintoma6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sintoma4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sintoma5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sintoma9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sintoma7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sintoma8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sintoma10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sintoma2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sintoma11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sintoma12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(btn_avancar)
                        .addComponent(btn_recuar)))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void setColor(JPanel panel)
    {
        panel.setBackground(new Color(0,102,102));
    }
    
    public void resetColor(JPanel panel)
    {
        panel.setBackground(new Color(204,204,204));
    }
    
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void pnlTopMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_pnlTopMouseDragged

    private void pnlTopMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlTopMousePressed
    
    
    
    private void sintoma1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sintoma1MouseClicked
        // TODO add your handling code here:
        /*alterarCor(btn_ajuda);
    kl    voltarCor(btn_exame);
        voltarCor(btn_principal);
        voltarCor(btn_sobre);
        voltarCor(btn_resultado);*/
        checked1 = true;
        resetColor(sintoma2);
        resetColor(sintoma3);
        resetColor(sintoma4);
        resetColor(sintoma5);
        resetColor(sintoma6);
        resetColor(sintoma7);
        resetColor(sintoma8);
        resetColor(sintoma9);
        resetColor(sintoma10);
        resetColor(sintoma11);
        resetColor(sintoma12);
        pnl_body.removeAll();
        pnl_body.repaint();
        pnl_body.revalidate();
        validar();
        setColor(sintoma1);
        pnl_body.add(panel_1);
        //this.pos = 1;
        //resetSintomaColor();
    }//GEN-LAST:event_sintoma1MouseClicked

    private void sintoma2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sintoma2MouseClicked
        // TODO add your handling code here:
        checked2 = true;
        resetColor(sintoma1);
        resetColor(sintoma3);
        resetColor(sintoma4);
        resetColor(sintoma5);
        resetColor(sintoma6);
        resetColor(sintoma7);
        resetColor(sintoma8);
        resetColor(sintoma9);
        resetColor(sintoma10);
        resetColor(sintoma11);
        resetColor(sintoma12);
        pnl_body.removeAll();
        pnl_body.repaint();
        pnl_body.revalidate();
        validar();
        setColor(sintoma2);
        pnl_body.add(panel_2);
        //this.pos = 2;
        //resetSintomaColor();
    }//GEN-LAST:event_sintoma2MouseClicked

    private void sintoma3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sintoma3MouseClicked
        // TODO add your handling code here:
        checked3 = true;
        resetColor(sintoma2);
        resetColor(sintoma1);
        resetColor(sintoma4);
        resetColor(sintoma5);
        resetColor(sintoma6);
        resetColor(sintoma7);
        resetColor(sintoma8);
        resetColor(sintoma9);
        resetColor(sintoma10);
        resetColor(sintoma11);
        resetColor(sintoma12);
        pnl_body.removeAll();
        pnl_body.repaint();
        pnl_body.revalidate();
        validar();
        setColor(sintoma3);
        pnl_body.add(panel_3);
        //this.pos = 3;
        //resetSintomaColor();
    }//GEN-LAST:event_sintoma3MouseClicked

    private void sintoma4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sintoma4MouseClicked
        // TODO add your handling code here:
        checked4 = true;
        
        resetColor(sintoma2);
        resetColor(sintoma3);
        resetColor(sintoma1);
        resetColor(sintoma5);
        resetColor(sintoma6);
        resetColor(sintoma7);
        resetColor(sintoma8);
        resetColor(sintoma9);
        resetColor(sintoma10);
        resetColor(sintoma11);
        resetColor(sintoma12);
        pnl_body.removeAll();
        pnl_body.repaint();
        pnl_body.revalidate();
        validar();
        setColor(sintoma4);
        pnl_body.add(panel_4);
        //this.pos = 4;
        //resetSintomaColor();
    }//GEN-LAST:event_sintoma4MouseClicked

    private void sintoma5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sintoma5MouseClicked
        // TODO add your handling code here:
        checked5 = true;
        
        resetColor(sintoma2);
        resetColor(sintoma3);
        resetColor(sintoma4);
        resetColor(sintoma1);
        resetColor(sintoma6);
        resetColor(sintoma7);
        resetColor(sintoma8);
        resetColor(sintoma9);
        resetColor(sintoma10);
        resetColor(sintoma11);
        resetColor(sintoma12);
        pnl_body.removeAll();
        pnl_body.repaint();
        pnl_body.revalidate();
        validar();
        setColor(sintoma5);
        pnl_body.add(panel_5);
        //this.pos = 5;
        //resetSintomaColor();
    }//GEN-LAST:event_sintoma5MouseClicked

    private void sintoma6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sintoma6MouseClicked
        // TODO add your handling code here:
        checked6 = true;
        
        resetColor(sintoma2);
        resetColor(sintoma3);
        resetColor(sintoma4);
        resetColor(sintoma5);
        resetColor(sintoma1);
        resetColor(sintoma7);
        resetColor(sintoma8);
        resetColor(sintoma9);
        resetColor(sintoma10);
        resetColor(sintoma11);
        resetColor(sintoma12);
        pnl_body.removeAll();
        pnl_body.repaint();
        pnl_body.revalidate();
        validar();
        setColor(sintoma6);
        pnl_body.add(panel_6);
        //this.pos = 6;
        //resetSintomaColor();
    }//GEN-LAST:event_sintoma6MouseClicked

    private void sintoma7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sintoma7MouseClicked
        // TODO add your handling code here:
        checked7 = true;
        
        resetColor(sintoma2);
        resetColor(sintoma3);
        resetColor(sintoma4);
        resetColor(sintoma5);
        resetColor(sintoma6);
        resetColor(sintoma1);
        resetColor(sintoma8);
        resetColor(sintoma9);
        resetColor(sintoma10);
        resetColor(sintoma11);
        resetColor(sintoma12);
        pnl_body.removeAll();
        pnl_body.repaint();
        pnl_body.revalidate();
        validar();
        setColor(sintoma7);
        pnl_body.add(panel_7);
        //this.pos = 7;
        //resetSintomaColor();
    }//GEN-LAST:event_sintoma7MouseClicked

    private void sintoma8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sintoma8MouseClicked
        // TODO add your handling code here:
        checked8 = true;
        
        resetColor(sintoma2);
        resetColor(sintoma3);
        resetColor(sintoma4);
        resetColor(sintoma5);
        resetColor(sintoma6);
        resetColor(sintoma7);
        resetColor(sintoma1);
        resetColor(sintoma9);
        resetColor(sintoma10);
        resetColor(sintoma11);
        resetColor(sintoma12);
        pnl_body.removeAll();
        pnl_body.repaint();
        pnl_body.revalidate();
        validar();
        setColor(sintoma8);
        pnl_body.add(panel_8);
        //this.pos = 8;
        //resetSintomaColor();
    }//GEN-LAST:event_sintoma8MouseClicked

    private void sintoma9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sintoma9MouseClicked
        // TODO add your handling code here:
        checked9 = true;
        
        resetColor(sintoma2);
        resetColor(sintoma3);
        resetColor(sintoma4);
        resetColor(sintoma5);
        resetColor(sintoma6);
        resetColor(sintoma7);
        resetColor(sintoma8);
        resetColor(sintoma1);
        resetColor(sintoma10);
        resetColor(sintoma11);
        resetColor(sintoma12);
        pnl_body.removeAll();
        pnl_body.repaint();
        pnl_body.revalidate();
        validar();
        setColor(sintoma9);
        pnl_body.add(panel_9);
        //this.pos = 9;
        //resetSintomaColor();
    }//GEN-LAST:event_sintoma9MouseClicked

    private void sintoma10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sintoma10MouseClicked
        // TODO add your handling code here:
        checked10 = true;
        
        resetColor(sintoma2);
        resetColor(sintoma3);
        resetColor(sintoma4);
        resetColor(sintoma5);
        resetColor(sintoma6);
        resetColor(sintoma7);
        resetColor(sintoma8);
        resetColor(sintoma9);
        resetColor(sintoma1);
        resetColor(sintoma11);
        resetColor(sintoma12);
        
        pnl_body.removeAll();
        pnl_body.repaint();
        pnl_body.revalidate();
        validar();
        setColor(sintoma10);
        pnl_body.add(panel_10);
        //this.pos = 10;
        //resetSintomaColor();
    }//GEN-LAST:event_sintoma10MouseClicked

    private void sintoma12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sintoma12MouseClicked
        // TODO add your handling code here:
        checked12 = true;
        
        resetColor(sintoma2);
        resetColor(sintoma3);
        resetColor(sintoma4);
        resetColor(sintoma5);
        resetColor(sintoma6);
        resetColor(sintoma7);
        resetColor(sintoma8);
        resetColor(sintoma9);
        resetColor(sintoma1);
        resetColor(sintoma10);
        resetColor(sintoma11);
        pnl_body.removeAll();
        pnl_body.repaint();
        pnl_body.revalidate();
        validar();
        setColor(sintoma12);
        pnl_body.add(panel_12);
    }//GEN-LAST:event_sintoma12MouseClicked

    private void sintoma11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sintoma11MouseClicked
        // TODO add your handling code here:
        checked11 = true;
        
        resetColor(sintoma2);
        resetColor(sintoma3);
        resetColor(sintoma4);
        resetColor(sintoma5);
        resetColor(sintoma6);
        resetColor(sintoma7);
        resetColor(sintoma8);
        resetColor(sintoma9);
        resetColor(sintoma1);
        resetColor(sintoma10);
        resetColor(sintoma12);
        pnl_body.removeAll();
        pnl_body.repaint();
        pnl_body.revalidate();
        validar();
        setColor(sintoma11);
        pnl_body.add(panel_11);
    }//GEN-LAST:event_sintoma11MouseClicked

    private void temperaturaAlta_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temperaturaAlta_simActionPerformed
        sintomaFeita.set(0, 1);
        temperatura_alta = 100;
    }//GEN-LAST:event_temperaturaAlta_simActionPerformed

    private void temperaturaAlta_naoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temperaturaAlta_naoActionPerformed
        sintomaFeita.set(0, 1);
        temperatura_alta = 0;
    }//GEN-LAST:event_temperaturaAlta_naoActionPerformed

    private void temperaturaAlta_talvez_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temperaturaAlta_talvez_simActionPerformed
        sintomaFeita.set(0, 1);
        temperatura_alta = 75;
    }//GEN-LAST:event_temperaturaAlta_talvez_simActionPerformed

    private void temperaturaAlta_talvez_naoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temperaturaAlta_talvez_naoActionPerformed
        sintomaFeita.set(0, 1);
        temperatura_alta = 25;
    }//GEN-LAST:event_temperaturaAlta_talvez_naoActionPerformed

    private void temperaturaAlta_nao_seiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temperaturaAlta_nao_seiActionPerformed
        // TODO add your handling code here:
        temperatura_alta = 50;
    }//GEN-LAST:event_temperaturaAlta_nao_seiActionPerformed

    private void suor_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suor_simActionPerformed
        // TODO add your handling code here:
        suor = 100;
    }//GEN-LAST:event_suor_simActionPerformed

    private void suor_naoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suor_naoActionPerformed
        // TODO add your handling code here:
        suor = 0;
    }//GEN-LAST:event_suor_naoActionPerformed

    private void suor_talvezsimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suor_talvezsimActionPerformed
        // TODO add your handling code here:
        suor = 75;
    }//GEN-LAST:event_suor_talvezsimActionPerformed

    private void suor_talveznaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suor_talveznaoActionPerformed
        // TODO add your handling code here:
        suor = 25;
    }//GEN-LAST:event_suor_talveznaoActionPerformed

    private void suor_naoseiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suor_naoseiActionPerformed
        // TODO add your handling code here:
        suor = 50;
    }//GEN-LAST:event_suor_naoseiActionPerformed

    private void tosse_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tosse_simActionPerformed
        // TODO add your handling code here:
        tosse = 100;
    }//GEN-LAST:event_tosse_simActionPerformed

    private void tosse_naoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tosse_naoActionPerformed
        // TODO add your handling code here:
        tosse = 0;
    }//GEN-LAST:event_tosse_naoActionPerformed

    private void tosse_talvezsimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tosse_talvezsimActionPerformed
        // TODO add your handling code here:
        tosse = 75;
    }//GEN-LAST:event_tosse_talvezsimActionPerformed

    private void tosse_talveznaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tosse_talveznaoActionPerformed
        // TODO add your handling code here:
        tosse = 25;
    }//GEN-LAST:event_tosse_talveznaoActionPerformed

    private void tosse_naoseiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tosse_naoseiActionPerformed
        // TODO add your handling code here:
        tosse = 50;
    }//GEN-LAST:event_tosse_naoseiActionPerformed

    private void tontura_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tontura_simActionPerformed
        // TODO add your handling code here:
        tontura = 100;
    }//GEN-LAST:event_tontura_simActionPerformed

    private void tontura_naoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tontura_naoActionPerformed
        // TODO add your handling code here:
        tontura = 0;
    }//GEN-LAST:event_tontura_naoActionPerformed

    private void tontura_talvezsimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tontura_talvezsimActionPerformed
        // TODO add your handling code here:
        tontura = 75;
    }//GEN-LAST:event_tontura_talvezsimActionPerformed

    private void tontura_talveznaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tontura_talveznaoActionPerformed
        // TODO add your handling code here:
        tontura = 25;
    }//GEN-LAST:event_tontura_talveznaoActionPerformed

    private void tontura_naoseiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tontura_naoseiActionPerformed
        // TODO add your handling code here:
        tontura = 50;
    }//GEN-LAST:event_tontura_naoseiActionPerformed

    private void tremor_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tremor_simActionPerformed
        // TODO add your handling code here:
        tremor = 100;
    }//GEN-LAST:event_tremor_simActionPerformed

    private void tremor_naoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tremor_naoActionPerformed
        // TODO add your handling code here:
        tremor = 0;
    }//GEN-LAST:event_tremor_naoActionPerformed

    private void tremor_talvezsimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tremor_talvezsimActionPerformed
        // TODO add your handling code here:
        tremor = 75;
    }//GEN-LAST:event_tremor_talvezsimActionPerformed

    private void tremor_talveznaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tremor_talveznaoActionPerformed
        // TODO add your handling code here:
        tremor = 25;
    }//GEN-LAST:event_tremor_talveznaoActionPerformed

    private void tremor_naoseiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tremor_naoseiActionPerformed
        // TODO add your handling code here:
        tremor = 50;
    }//GEN-LAST:event_tremor_naoseiActionPerformed

    private void vomito_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vomito_simActionPerformed
        // TODO add your handling code here:
        vomito = 100;
    }//GEN-LAST:event_vomito_simActionPerformed

    private void vomito_naoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vomito_naoActionPerformed
        // TODO add your handling code here:
        vomito = 0;
    }//GEN-LAST:event_vomito_naoActionPerformed

    private void vomito_talvezsimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vomito_talvezsimActionPerformed
        // TODO add your handling code here:
        vomito = 75;
    }//GEN-LAST:event_vomito_talvezsimActionPerformed

    private void vomito_talveznaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vomito_talveznaoActionPerformed
        // TODO add your handling code here:
        vomito = 25;
    }//GEN-LAST:event_vomito_talveznaoActionPerformed

    private void vomito_naoseiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vomito_naoseiActionPerformed
        // TODO add your handling code here:
        vomito = 50;
    }//GEN-LAST:event_vomito_naoseiActionPerformed

    private void colica_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colica_simActionPerformed
        // TODO add your handling code here:
        colica = 100;
    }//GEN-LAST:event_colica_simActionPerformed

    private void colica_naoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colica_naoActionPerformed
        // TODO add your handling code here:
        colica = 0;
    }//GEN-LAST:event_colica_naoActionPerformed

    private void colica_talvezsimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colica_talvezsimActionPerformed
        // TODO add your handling code here:
        colica = 75;
    }//GEN-LAST:event_colica_talvezsimActionPerformed

    private void colica_talveznaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colica_talveznaoActionPerformed
        // TODO add your handling code here:
        colica = 25;
    }//GEN-LAST:event_colica_talveznaoActionPerformed

    private void colica_naoseiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colica_naoseiActionPerformed
        // TODO add your handling code here:
        colica = 50;
    }//GEN-LAST:event_colica_naoseiActionPerformed

    private void dorabdomen_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dorabdomen_simActionPerformed
        // TODO add your handling code here:
        dor_de_Cabeca = 100;
    }//GEN-LAST:event_dorabdomen_simActionPerformed

    private void dorabdomen_naoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dorabdomen_naoActionPerformed
        // TODO add your handling code here:
        dor_de_Cabeca = 0;
    }//GEN-LAST:event_dorabdomen_naoActionPerformed

    private void dorabdomen_talvezsimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dorabdomen_talvezsimActionPerformed
        // TODO add your handling code here:
        dor_de_Cabeca = 75;
    }//GEN-LAST:event_dorabdomen_talvezsimActionPerformed

    private void dorabdomen_talveznaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dorabdomen_talveznaoActionPerformed
        // TODO add your handling code here:
        dor_de_Cabeca = 25;
    }//GEN-LAST:event_dorabdomen_talveznaoActionPerformed

    private void dorabdomen_naoseiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dorabdomen_naoseiActionPerformed
        // TODO add your handling code here:
        dor_abdominal = 50;
    }//GEN-LAST:event_dorabdomen_naoseiActionPerformed

    private void dorcabeca_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dorcabeca_simActionPerformed
        // TODO add your handling code here:
        dor_de_Cabeca = 100;
    }//GEN-LAST:event_dorcabeca_simActionPerformed

    private void dorcabeca_naoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dorcabeca_naoActionPerformed
        // TODO add your handling code here:
        dor_de_Cabeca = 0;
    }//GEN-LAST:event_dorcabeca_naoActionPerformed

    private void dorcabeca_talvezsimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dorcabeca_talvezsimActionPerformed
        // TODO add your handling code here:
        dor_de_Cabeca = 75;
    }//GEN-LAST:event_dorcabeca_talvezsimActionPerformed

    private void dorcabeca_talveznaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dorcabeca_talveznaoActionPerformed
        // TODO add your handling code here:
        dor_de_Cabeca = 25;
    }//GEN-LAST:event_dorcabeca_talveznaoActionPerformed

    private void dorcabeca_naoseiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dorcabeca_naoseiActionPerformed
        // TODO add your handling code here:
        dor_de_Cabeca = 50;
    }//GEN-LAST:event_dorcabeca_naoseiActionPerformed

    private void fadiga_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fadiga_simActionPerformed
        // TODO add your handling code here:
        fadiga = 100;
    }//GEN-LAST:event_fadiga_simActionPerformed

    private void fadiga_naoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fadiga_naoActionPerformed
        // TODO add your handling code here:
        fadiga = 0;
    }//GEN-LAST:event_fadiga_naoActionPerformed

    private void fadiga_talvezsimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fadiga_talvezsimActionPerformed
        // TODO add your handling code here:
        fadiga = 75;
    }//GEN-LAST:event_fadiga_talvezsimActionPerformed

    private void fadiga_talveznaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fadiga_talveznaoActionPerformed
        // TODO add your handling code here:
        fadiga = 25;
    }//GEN-LAST:event_fadiga_talveznaoActionPerformed

    private void fadiga_naoseiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fadiga_naoseiActionPerformed
        // TODO add your handling code here:
        fadiga = 50;
    }//GEN-LAST:event_fadiga_naoseiActionPerformed

    private void ferida_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ferida_simActionPerformed
        // TODO add your handling code here:
        ferida_na_Pele = 100;
    }//GEN-LAST:event_ferida_simActionPerformed

    private void ferida_naoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ferida_naoActionPerformed
        // TODO add your handling code here:
        ferida_na_Pele = 0;
    }//GEN-LAST:event_ferida_naoActionPerformed

    private void ferida_talvezsimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ferida_talvezsimActionPerformed
        // TODO add your handling code here:
        ferida_na_Pele = 75;
    }//GEN-LAST:event_ferida_talvezsimActionPerformed

    private void ferida_talveznaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ferida_talveznaoActionPerformed
        // TODO add your handling code here:
        ferida_na_Pele = 25;
    }//GEN-LAST:event_ferida_talveznaoActionPerformed

    private void ferida_naoseiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ferida_naoseiActionPerformed
        // TODO add your handling code here:
        ferida_na_Pele = 50;
    }//GEN-LAST:event_ferida_naoseiActionPerformed

    private void faltaapetite_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faltaapetite_simActionPerformed
        // TODO add your handling code here:
        falta_Apetite = 100;
    }//GEN-LAST:event_faltaapetite_simActionPerformed

    private void faltaapetite_naoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faltaapetite_naoActionPerformed
        // TODO add your handling code here:
        falta_Apetite = 0;
    }//GEN-LAST:event_faltaapetite_naoActionPerformed

    private void faltaapetite_talvezsimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faltaapetite_talvezsimActionPerformed
        // TODO add your handling code here:
        falta_Apetite = 75;
    }//GEN-LAST:event_faltaapetite_talvezsimActionPerformed

    private void faltaapetite_talveznaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faltaapetite_talveznaoActionPerformed
        // TODO add your handling code here:
        falta_Apetite = 25;
    }//GEN-LAST:event_faltaapetite_talveznaoActionPerformed

    private void faltaapetite_naoseiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faltaapetite_naoseiActionPerformed
        // TODO add your handling code here:
        falta_Apetite = 50;
    }//GEN-LAST:event_faltaapetite_naoseiActionPerformed

    private void btn_recuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_recuarActionPerformed
        if (pos != 1)
        {
            this.pos -=1;
            setPanelProva();
        }
    }//GEN-LAST:event_btn_recuarActionPerformed

    private void btn_avancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_avancarActionPerformed
        if (pos != 12)
        {
            this.pos +=1;
            setPanelProva();
        }
    }//GEN-LAST:event_btn_avancarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            realizarDiagnostico();
            new TelaResultado().setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(TelaExame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaExame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_avancar;
    private javax.swing.JButton btn_recuar;
    private javax.swing.JRadioButton colica_nao;
    private javax.swing.JRadioButton colica_naosei;
    private javax.swing.JRadioButton colica_sim;
    private javax.swing.JRadioButton colica_talveznao;
    private javax.swing.JRadioButton colica_talvezsim;
    private javax.swing.JRadioButton dorabdomen_nao;
    private javax.swing.JRadioButton dorabdomen_naosei;
    private javax.swing.JRadioButton dorabdomen_sim;
    private javax.swing.JRadioButton dorabdomen_talveznao;
    private javax.swing.JRadioButton dorabdomen_talvezsim;
    private javax.swing.JRadioButton dorcabeca_nao;
    private javax.swing.JRadioButton dorcabeca_naosei;
    private javax.swing.JRadioButton dorcabeca_sim;
    private javax.swing.JRadioButton dorcabeca_talveznao;
    private javax.swing.JRadioButton dorcabeca_talvezsim;
    private javax.swing.JRadioButton fadiga_nao;
    private javax.swing.JRadioButton fadiga_naosei;
    private javax.swing.JRadioButton fadiga_sim;
    private javax.swing.JRadioButton fadiga_talveznao;
    private javax.swing.JRadioButton fadiga_talvezsim;
    private javax.swing.JRadioButton faltaapetite_nao;
    private javax.swing.JRadioButton faltaapetite_naosei;
    private javax.swing.JRadioButton faltaapetite_sim;
    private javax.swing.JRadioButton faltaapetite_talveznao;
    private javax.swing.JRadioButton faltaapetite_talvezsim;
    private javax.swing.JRadioButton ferida_nao;
    private javax.swing.JRadioButton ferida_naosei;
    private javax.swing.JRadioButton ferida_sim;
    private javax.swing.JRadioButton ferida_talveznao;
    private javax.swing.JRadioButton ferida_talvezsim;
    private javax.swing.JLabel info_principal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel line1;
    private javax.swing.JPanel line10;
    private javax.swing.JPanel line11;
    private javax.swing.JPanel line12;
    private javax.swing.JPanel line13;
    private javax.swing.JPanel line2;
    private javax.swing.JPanel line3;
    private javax.swing.JPanel line4;
    private javax.swing.JPanel line5;
    private javax.swing.JPanel line6;
    private javax.swing.JPanel line7;
    private javax.swing.JPanel line8;
    private javax.swing.JPanel line9;
    private javax.swing.JPanel panel_1;
    private javax.swing.JPanel panel_10;
    private javax.swing.JPanel panel_11;
    private javax.swing.JPanel panel_12;
    private javax.swing.JPanel panel_2;
    private javax.swing.JPanel panel_3;
    private javax.swing.JPanel panel_4;
    private javax.swing.JPanel panel_5;
    private javax.swing.JPanel panel_6;
    private javax.swing.JPanel panel_7;
    private javax.swing.JPanel panel_8;
    private javax.swing.JPanel panel_9;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JPanel pnl_body;
    private javax.swing.JPanel pnl_home;
    private javax.swing.JPanel sintoma1;
    private javax.swing.JPanel sintoma10;
    private javax.swing.JPanel sintoma11;
    private javax.swing.JPanel sintoma12;
    private javax.swing.JPanel sintoma2;
    private javax.swing.JPanel sintoma3;
    private javax.swing.JPanel sintoma4;
    private javax.swing.JPanel sintoma5;
    private javax.swing.JPanel sintoma6;
    private javax.swing.JPanel sintoma7;
    private javax.swing.JPanel sintoma8;
    private javax.swing.JPanel sintoma9;
    private javax.swing.JRadioButton suor_nao;
    private javax.swing.JRadioButton suor_naosei;
    private javax.swing.JRadioButton suor_sim;
    private javax.swing.JRadioButton suor_talveznao;
    private javax.swing.JRadioButton suor_talvezsim;
    private javax.swing.JRadioButton temperaturaAlta_nao;
    private javax.swing.JRadioButton temperaturaAlta_nao_sei;
    private javax.swing.JRadioButton temperaturaAlta_sim;
    private javax.swing.JRadioButton temperaturaAlta_talvez_nao;
    private javax.swing.JRadioButton temperaturaAlta_talvez_sim;
    private javax.swing.JRadioButton tontura_nao;
    private javax.swing.JRadioButton tontura_naosei;
    private javax.swing.JRadioButton tontura_sim;
    private javax.swing.JRadioButton tontura_talveznao;
    private javax.swing.JRadioButton tontura_talvezsim;
    private javax.swing.JRadioButton tosse_nao;
    private javax.swing.JRadioButton tosse_naosei;
    private javax.swing.JRadioButton tosse_sim;
    private javax.swing.JRadioButton tosse_talveznao;
    private javax.swing.JRadioButton tosse_talvezsim;
    private javax.swing.JRadioButton tremor_nao;
    private javax.swing.JRadioButton tremor_naosei;
    private javax.swing.JRadioButton tremor_sim;
    private javax.swing.JRadioButton tremor_talveznao;
    private javax.swing.JRadioButton tremor_talvezsim;
    private javax.swing.JRadioButton vomito_nao;
    private javax.swing.JRadioButton vomito_naosei;
    private javax.swing.JRadioButton vomito_sim;
    private javax.swing.JRadioButton vomito_talveznao;
    private javax.swing.JRadioButton vomito_talvezsim;
    // End of variables declaration//GEN-END:variables
}
