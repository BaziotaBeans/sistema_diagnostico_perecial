/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Paciente;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.bean.Paciente;
import model.dao.PacienteDAO;
import view.login.LoginPaciente;

/**
 *
 * @author Baziota Beans
 */
public class addPaciente extends javax.swing.JFrame {

    /**
     * Creates new form addPaciente
     */
    int xMouse, yMouse;

    public addPaciente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnlTop = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nomeTXT = new javax.swing.JTextField();
        idadeTXT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        sexoTXT = new rojerusan.RSComboMetro();
        alturaTXT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        moradaTXT = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        emailTXT = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        telefoneTXT = new javax.swing.JTextField();
        senhaTXT = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        btn_salvar = new javax.swing.JPanel();
        label_salvar = new javax.swing.JLabel();
        btn_limpar = new javax.swing.JPanel();
        label_limpar = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JPanel();
        label_cancelar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout pnlTopLayout = new javax.swing.GroupLayout(pnlTop);
        pnlTop.setLayout(pnlTopLayout);
        pnlTopLayout.setHorizontalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 641, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(16, 16, 16))
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
                .addGap(24, 24, 24))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 206, 209));
        jLabel1.setText("Cadastra-se aqui!");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 206, 209));
        jLabel5.setText("Nome:");

        nomeTXT.setBackground(new java.awt.Color(255, 255, 255));
        nomeTXT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeTXT.setForeground(new java.awt.Color(0, 206, 209));
        nomeTXT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 206, 209)));
        nomeTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTXTActionPerformed(evt);
            }
        });

        idadeTXT.setBackground(new java.awt.Color(255, 255, 255));
        idadeTXT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        idadeTXT.setForeground(new java.awt.Color(0, 206, 209));
        idadeTXT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 206, 209)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 206, 209));
        jLabel6.setText("Idade:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 206, 209));
        jLabel7.setText("Sexo:");

        sexoTXT.setForeground(new java.awt.Color(0, 206, 209));
        sexoTXT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o seu gênero", "Masculino", "Feminino" }));
        sexoTXT.setColorArrow(new java.awt.Color(0, 206, 209));
        sexoTXT.setColorBorde(new java.awt.Color(0, 206, 209));
        sexoTXT.setColorFondo(new java.awt.Color(255, 255, 255));

        alturaTXT.setBackground(new java.awt.Color(255, 255, 255));
        alturaTXT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        alturaTXT.setForeground(new java.awt.Color(0, 206, 209));
        alturaTXT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 206, 209)));
        alturaTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alturaTXTActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 206, 209));
        jLabel8.setText("Altura:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 206, 209));
        jLabel9.setText("Morada:");

        moradaTXT.setBackground(new java.awt.Color(255, 255, 255));
        moradaTXT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        moradaTXT.setForeground(new java.awt.Color(0, 206, 209));
        moradaTXT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 206, 209)));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 206, 209));
        jLabel10.setText("Telefone:");

        emailTXT.setBackground(new java.awt.Color(255, 255, 255));
        emailTXT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emailTXT.setForeground(new java.awt.Color(0, 206, 209));
        emailTXT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 206, 209)));
        emailTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTXTActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 206, 209));
        jLabel11.setText("Email:");

        telefoneTXT.setBackground(new java.awt.Color(255, 255, 255));
        telefoneTXT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        telefoneTXT.setForeground(new java.awt.Color(0, 206, 209));
        telefoneTXT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 206, 209)));
        telefoneTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneTXTActionPerformed(evt);
            }
        });

        senhaTXT.setBackground(new java.awt.Color(255, 255, 255));
        senhaTXT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        senhaTXT.setForeground(new java.awt.Color(0, 206, 209));
        senhaTXT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 206, 209)));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 206, 209));
        jLabel14.setText("Senha:");

        btn_salvar.setBackground(new java.awt.Color(0, 206, 209));
        btn_salvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_salvarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_salvarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_salvarMouseExited(evt);
            }
        });

        label_salvar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_salvar.setForeground(new java.awt.Color(255, 255, 255));
        label_salvar.setText("Salvar");

        javax.swing.GroupLayout btn_salvarLayout = new javax.swing.GroupLayout(btn_salvar);
        btn_salvar.setLayout(btn_salvarLayout);
        btn_salvarLayout.setHorizontalGroup(
            btn_salvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_salvarLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(label_salvar)
                .addGap(20, 20, 20))
        );
        btn_salvarLayout.setVerticalGroup(
            btn_salvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_salvarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(label_salvar)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btn_limpar.setBackground(new java.awt.Color(0, 206, 209));
        btn_limpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_limparMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_limparMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_limparMouseExited(evt);
            }
        });

        label_limpar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_limpar.setForeground(new java.awt.Color(255, 255, 255));
        label_limpar.setText("Limpar");

        javax.swing.GroupLayout btn_limparLayout = new javax.swing.GroupLayout(btn_limpar);
        btn_limpar.setLayout(btn_limparLayout);
        btn_limparLayout.setHorizontalGroup(
            btn_limparLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_limparLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(label_limpar)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        btn_limparLayout.setVerticalGroup(
            btn_limparLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_limparLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(label_limpar)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 206, 209));
        jLabel17.setText("Por favor prencha cada campo  do formulário");

        btn_cancelar.setBackground(new java.awt.Color(0, 206, 209));
        btn_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cancelarMouseExited(evt);
            }
        });

        label_cancelar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        label_cancelar.setText("Cancelar");

        javax.swing.GroupLayout btn_cancelarLayout = new javax.swing.GroupLayout(btn_cancelar);
        btn_cancelar.setLayout(btn_cancelarLayout);
        btn_cancelarLayout.setHorizontalGroup(
            btn_cancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_cancelarLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(label_cancelar)
                .addGap(21, 21, 21))
        );
        btn_cancelarLayout.setVerticalGroup(
            btn_cancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_cancelarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(label_cancelar)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel17)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(25, 25, 25)
                                .addComponent(nomeTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sexoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(126, 126, 126)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(48, 48, 48)
                                .addComponent(telefoneTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel6))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(idadeTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(emailTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(senhaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btn_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(alturaTXT, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(moradaTXT))
                .addGap(535, 535, 535))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pnlTop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nomeTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(telefoneTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(sexoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idadeTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(alturaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(moradaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senhaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

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

    private void alturaTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alturaTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alturaTXTActionPerformed

    private void nomeTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeTXTActionPerformed

    private void emailTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTXTActionPerformed

    private void telefoneTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefoneTXTActionPerformed
    //Principal
    private void btn_salvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salvarMouseClicked
        // TODO add your handling code here:
        Paciente paciente = new Paciente();
        PacienteDAO dao = new PacienteDAO();
        
        paciente.setNome(nomeTXT.getText());
        paciente.setIdade(Integer.parseInt(idadeTXT.getText()));
        paciente.setSexo(sexoTXT.getSelectedItem().toString());
        paciente.setAltura(Float.parseFloat(alturaTXT.getText()));
        paciente.setMorada(moradaTXT.getText());
        paciente.setTelefone(telefoneTXT.getText());
        paciente.setEmail(emailTXT.getText());
        paciente.setSenha(senhaTXT.getText());
        
        if(dao.create(paciente))
        {
            new LoginPaciente().setVisible(true);
            this.dispose();
        }
        else
        {
            nomeTXT.setText("");
            idadeTXT.setText("");
            alturaTXT.setText("");
            moradaTXT.setText("");
            telefoneTXT.setText("");
            emailTXT.setText("");
            senhaTXT.setText("");
        }
        
    }//GEN-LAST:event_btn_salvarMouseClicked

    private void btn_limparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_limparMouseClicked
        // TODO add your handling code here:
        nomeTXT.setText("");
        idadeTXT.setText("");
        alturaTXT.setText("");
        telefoneTXT.setText("");
        emailTXT.setText("");
        senhaTXT.setText("");
    }//GEN-LAST:event_btn_limparMouseClicked

    private void btn_limparMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_limparMouseEntered
        // TODO add your handling code here:
        setColor(btn_limpar,label_limpar);
    }//GEN-LAST:event_btn_limparMouseEntered

    private void btn_limparMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_limparMouseExited
        // TODO add your handling code here:
        resetColor(btn_limpar,label_limpar);
    }//GEN-LAST:event_btn_limparMouseExited

    private void btn_salvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salvarMouseEntered
        // TODO add your handling code here:
        setColor(btn_salvar,label_salvar);
    }//GEN-LAST:event_btn_salvarMouseEntered

    private void btn_salvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salvarMouseExited
        // TODO add your handling code here:
        resetColor(btn_salvar,label_salvar);
    }//GEN-LAST:event_btn_salvarMouseExited

    private void btn_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarMouseClicked
        // TODO add your handling code here:
        new LoginPaciente().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cancelarMouseClicked

    private void btn_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarMouseEntered
        // TODO add your handling code here:
        setColor(btn_cancelar,label_cancelar);
    }//GEN-LAST:event_btn_cancelarMouseEntered

    private void btn_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarMouseExited
        // TODO add your handling code here:
        resetColor(btn_cancelar,label_cancelar);
    }//GEN-LAST:event_btn_cancelarMouseExited
    
    public void setColor(JPanel panel, JLabel label)
    {
        panel.setBackground(new Color(0,102,102));
        label.setForeground(Color.WHITE);
    }
    
    public void resetColor(JPanel panel, JLabel label)
    {
        panel.setBackground(new Color(0,206,209));
        label.setForeground(Color.WHITE);
    }
    
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
            java.util.logging.Logger.getLogger(addPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alturaTXT;
    private javax.swing.JPanel btn_cancelar;
    private javax.swing.JPanel btn_limpar;
    private javax.swing.JPanel btn_salvar;
    private javax.swing.JTextField emailTXT;
    private javax.swing.JTextField idadeTXT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JLabel label_cancelar;
    private javax.swing.JLabel label_limpar;
    private javax.swing.JLabel label_salvar;
    private javax.swing.JTextField moradaTXT;
    private javax.swing.JTextField nomeTXT;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JPasswordField senhaTXT;
    private rojerusan.RSComboMetro sexoTXT;
    private javax.swing.JTextField telefoneTXT;
    // End of variables declaration//GEN-END:variables
}
