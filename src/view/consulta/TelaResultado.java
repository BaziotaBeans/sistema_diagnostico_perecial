/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.consulta;
import Main.Home;
import java.awt.Color;
import javax.swing.JFrame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author Baziota Beans
 */
public class TelaResultado extends javax.swing.JFrame {

    /**
     * Creates new form TelaResultado
     */
    private int xMouse, yMouse;
    BufferedReader leitura;
    String conteudoArquivo;
    String doencaFILE = null, perc_FILE_GERAL = null, perc_FILE_M = null, 
    perc_FILE_H = null, perc_FILE_G = null, perc_FILE_F = null;
    
    public TelaResultado() {
        initComponents();
        try
        {
            leitura = new BufferedReader(new FileReader("src/Ficheiros/Doenca.txt"));
            doencaFILE = leitura.readLine();
            doenca.setText(doencaFILE);
            leitura.close();
            ///////////////////////////////////////////////////////////////////////////////////
            leitura = new BufferedReader(new FileReader("src/Ficheiros/Percentagem_GERAL.txt"));
            perc_FILE_GERAL = leitura.readLine();
            percentagemGeral.setText(perc_FILE_GERAL+"%");
            leitura.close();
            ///////////////////////////////////////////////////////////////////////////////////
            leitura = new BufferedReader(new FileReader("src/Ficheiros/Percentagem_M.txt"));
            perc_FILE_M = leitura.readLine();
            percM.setText(perc_FILE_M+"%");
            leitura.close();
            ///////////////////////////////////////////////////////////////////////////////////
            leitura = new BufferedReader(new FileReader("src/Ficheiros/Percentagem_H.txt"));
            perc_FILE_H = leitura.readLine();
            percH.setText(perc_FILE_H+"%");
            leitura.close();
            ///////////////////////////////////////////////////////////////////////////////////
            leitura = new BufferedReader(new FileReader("src/Ficheiros/Percentagem_G.txt"));
            perc_FILE_G = leitura.readLine();
            percG.setText(perc_FILE_G+"%");
            leitura.close();
            ///////////////////////////////////////////////////////////////////////////////////
            leitura = new BufferedReader(new FileReader("src/Ficheiros/Percentagem_H.txt"));
            perc_FILE_F = leitura.readLine();
            percF.setText(perc_FILE_F+"%");
            leitura.close();
            if(doencaFILE.equals("'Malaria'"))
            {
                justificacaoJTArea.setText("O senhor(a) foi diagnósticado com Malaria porque apresentou"+ "\n" + "Todos ou alguns dos seguintes sintomas:"
                        + "\n" + "Temperatura alta, Tremor, Dor de Cabeça, Vomito, Fadiga, Suor");
            }
            else if(doencaFILE.equals("'HIV'"))justificacaoJTArea.setText("O senhor(a) foi diagnósticado com Hiv porque apresentou"+ "\n" + "Todos ou alguns dos seguintes sintomas:"
                        + "\n" + "Temperatura, Tosse, Suor, Dor de Cabeça, Fadiga, Colica, Ferida");
            else if(doencaFILE.equals("'Gestacao'"))justificacaoJTArea.setText("O senhor(a) foi diagnósticado com Gestação porque apresentou"+ "\n" + "Todos ou alguns dos seguintes sintomas:"
                        + "\n" + "Colica, Temperatura, Fadiga, Vomito, Dor de Cabeça, Tontura");
            else if(doencaFILE.equals("'Febre Tifoide'"))justificacaoJTArea.setText("O senhor(a) foi diagnósticado com hiv porque apresentou"+ "\n" + "Todos ou alguns dos seguintes sintomas:"
                        + "\n" + "Temperatura, Dor Cabeça, Dor Abdominal, Tosse, Colica, Falta de Apetite");
            else justificacaoJTArea.setText("O senhor(a) não foi diagnósticado com nenhuma doença, para medidas "+ "\n" + " de prevenção vai ao hospital mais próxima."
                        + "\n" + "");
            
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null,"Impossivel abrir o ficheiro");
            e.printStackTrace();
        }
    }
    
    public void leitura(BufferedReader leitura, BufferedReader caminho, String conteudoArquivo)
    {
        try
        {
            leitura = caminho;
            conteudoArquivo = leitura.readLine();
            leitura.close();
            
        }catch(IOException e)
        {
            JOptionPane.showMessageDialog(null,"Impossivel abrir o ficheiro");
            e.printStackTrace();
        }
    }
    
    public void preencher() throws FileNotFoundException
    {
        BufferedReader leitor = null;
        String conteudoArquivo = null;
        String doencaFILE = null, perc_FILE_GERAL = null, perc_FILE_M = null, perc_FILE_H = null, perc_FILE_G = null, perc_FILE_F = null;
        leitura(leitor, new BufferedReader(new FileReader("src/Ficheiros/Doenca.txt")),doencaFILE);
        leitura(leitor, new BufferedReader(new FileReader("src/Ficheiros/Percentagem_GERAL.txt")),perc_FILE_GERAL);
        leitura(leitor, new BufferedReader(new FileReader("src/Ficheiros/Percentagem_M.txt")),perc_FILE_M);
        leitura(leitor, new BufferedReader(new FileReader("src/Ficheiros/Percentagem_H.txt")),perc_FILE_H);
        leitura(leitor, new BufferedReader(new FileReader("src/Ficheiros/Percentagem_G.txt")),perc_FILE_G);
        leitura(leitor, new BufferedReader(new FileReader("src/Ficheiros/Percentagem_F.txt")),perc_FILE_F);
        doenca.setText(doencaFILE);
        percentagemGeral.setText(perc_FILE_GERAL);
        percM.setText(perc_FILE_M);
        percH.setText(perc_FILE_H);
        percG.setText(perc_FILE_G);
        percF.setText(perc_FILE_M);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        doenca = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        justificacaoJTArea = new javax.swing.JTextArea();
        percM = new javax.swing.JLabel();
        percH = new javax.swing.JLabel();
        percG = new javax.swing.JLabel();
        percF = new javax.swing.JLabel();
        percentagemGeral = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_sair = new javax.swing.JPanel();
        label_registrar = new javax.swing.JLabel();
        btn_retest = new javax.swing.JPanel();
        label_login = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 485, Short.MAX_VALUE)
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

        getContentPane().add(pnlTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 206, 209));
        jLabel1.setText("Resultado do Exame");

        doenca.setBackground(new java.awt.Color(0, 206, 209));
        doenca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        doenca.setForeground(new java.awt.Color(0, 206, 209));
        doenca.setText("DOENÇA");

        justificacaoJTArea.setEditable(false);
        justificacaoJTArea.setBackground(new java.awt.Color(255, 255, 255));
        justificacaoJTArea.setColumns(20);
        justificacaoJTArea.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        justificacaoJTArea.setRows(5);
        justificacaoJTArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        justificacaoJTArea.setCaretColor(new java.awt.Color(255, 255, 255));
        justificacaoJTArea.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(justificacaoJTArea);

        percM.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        percM.setText("Percentagem M");

        percH.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        percH.setText("Percentagem H");

        percG.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        percG.setText("Percentagem G");

        percF.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        percF.setText("Percentagem F");

        percentagemGeral.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        percentagemGeral.setText("Percentagem Geral");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Doença:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Percentagem de Malaria:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Percentagem de Gestação:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Percentagem de Febre Tifoide:");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Percentagem de HIV:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Percentagem da Doença:");

        btn_sair.setBackground(new java.awt.Color(0, 206, 209));
        btn_sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_sairMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_sairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_sairMouseExited(evt);
            }
        });

        label_registrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_registrar.setForeground(new java.awt.Color(255, 255, 255));
        label_registrar.setText("Sair");

        javax.swing.GroupLayout btn_sairLayout = new javax.swing.GroupLayout(btn_sair);
        btn_sair.setLayout(btn_sairLayout);
        btn_sairLayout.setHorizontalGroup(
            btn_sairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_sairLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(label_registrar)
                .addGap(16, 16, 16))
        );
        btn_sairLayout.setVerticalGroup(
            btn_sairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_sairLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_registrar)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        btn_retest.setBackground(new java.awt.Color(0, 206, 209));
        btn_retest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_retestMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_retestMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_retestMouseExited(evt);
            }
        });

        label_login.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_login.setForeground(new java.awt.Color(255, 255, 255));
        label_login.setText("Realizar o exame novamente");

        javax.swing.GroupLayout btn_retestLayout = new javax.swing.GroupLayout(btn_retest);
        btn_retest.setLayout(btn_retestLayout);
        btn_retestLayout.setHorizontalGroup(
            btn_retestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_retestLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_login)
                .addGap(16, 16, 16))
        );
        btn_retestLayout.setVerticalGroup(
            btn_retestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_retestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_login)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(45, 45, 45)
                        .addComponent(doenca))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(percM))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel8))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(percF)
                                        .addComponent(percH)
                                        .addComponent(percG))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(62, 62, 62)
                                .addComponent(percentagemGeral))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_retest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btn_sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 144, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doenca)
                    .addComponent(jLabel5))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(percentagemGeral)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(percM)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(percG)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(percH)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(percF)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_retest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 704, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void btn_sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sairMouseClicked
        // TODO add your handling code here:
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_sairMouseClicked

    private void btn_sairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sairMouseEntered
        // TODO add your handling code here:
        setColor(btn_sair, label_registrar);

    }//GEN-LAST:event_btn_sairMouseEntered

    private void btn_sairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sairMouseExited
        // TODO add your handling code here:
        resetColor(btn_sair, label_registrar);
    }//GEN-LAST:event_btn_sairMouseExited
    
    public void setColor(JPanel panel, JLabel label)
    {
        panel.setBackground(Color.WHITE);
        label.setForeground(new Color(0,206,209));
    }
    
    public void resetColor(JPanel panel, JLabel label)
    {
        panel.setBackground(new Color(0,206,209));
        label.setForeground(Color.WHITE);
    }
    
    private void btn_retestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_retestMouseClicked
        // TODO add your handling code here:
        new TelaExame().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btn_retestMouseClicked

    private void btn_retestMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_retestMouseEntered
        // TODO add your handling code here:
        setColor(btn_retest, label_login);
    }//GEN-LAST:event_btn_retestMouseEntered

    private void btn_retestMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_retestMouseExited
        // TODO add your handling code here:
        resetColor(btn_retest, label_login);
    }//GEN-LAST:event_btn_retestMouseExited

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
            java.util.logging.Logger.getLogger(TelaResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaResultado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_retest;
    private javax.swing.JPanel btn_sair;
    private javax.swing.JLabel doenca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea justificacaoJTArea;
    private javax.swing.JLabel label_login;
    private javax.swing.JLabel label_registrar;
    private javax.swing.JLabel percF;
    private javax.swing.JLabel percG;
    private javax.swing.JLabel percH;
    private javax.swing.JLabel percM;
    private javax.swing.JLabel percentagemGeral;
    private javax.swing.JPanel pnlTop;
    // End of variables declaration//GEN-END:variables
}
