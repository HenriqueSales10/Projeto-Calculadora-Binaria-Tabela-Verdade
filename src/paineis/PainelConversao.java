/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paineis;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import conversao.Conversor;

/**
 *
 * @author henri
 */
public class PainelConversao extends javax.swing.JPanel {

    Conversor calc = new Conversor();
    private boolean calculado = false;
    private boolean selecionouN1 = false;
    String N1, N2;

    public PainelConversao() {
        initComponents();
    }

    public void setCalculado() {
        
        if (calculado || txtSaida.getText().equals("0")) {
            
            calculado = false;
            txtSaida.setText("");
            
        }
        
    }
    
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtSaida = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxDe = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxPara = new javax.swing.JComboBox<>();
        jButtonConverter = new javax.swing.JButton();
        jButtonA = new javax.swing.JButton();
        jButtonB = new javax.swing.JButton();
        jButtonC = new javax.swing.JButton();
        jButtonD = new javax.swing.JButton();
        jButtonE = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonF = new javax.swing.JButton();
        jButtonApagar = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton0 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButto3 = new javax.swing.JButton();
        txtResultado = new javax.swing.JLabel();
        lblResultado = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1680, 940));
        setMinimumSize(new java.awt.Dimension(1680, 940));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1620, 950));
        jPanel1.setMinimumSize(new java.awt.Dimension(1620, 950));
        jPanel1.setPreferredSize(new java.awt.Dimension(1620, 950));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel3.setText("Conversão");

        txtSaida.setColumns(0);
        txtSaida.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txtSaida.setForeground(new java.awt.Color(51, 51, 51));
        txtSaida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSaida.setText("0");
        txtSaida.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaidaActionPerformed(evt);
            }
        });
        txtSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSaidaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaidaKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText(" DE:");

        jComboBoxDe.setBackground(new java.awt.Color(0, 51, 102));
        jComboBoxDe.setForeground(new java.awt.Color(0, 51, 102));
        jComboBoxDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Decimal", "Binário", "Hexadecimal" }));
        jComboBoxDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("PARA:");

        jComboBoxPara.setBackground(new java.awt.Color(0, 51, 102));
        jComboBoxPara.setForeground(new java.awt.Color(0, 51, 102));
        jComboBoxPara.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Binário", "Decimal", "Hexadecimal" }));
        jComboBoxPara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxParaActionPerformed(evt);
            }
        });

        jButtonConverter.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jButtonConverter.setForeground(new java.awt.Color(0, 51, 102));
        jButtonConverter.setText("CONVERTER");
        jButtonConverter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConverterActionPerformed(evt);
            }
        });

        jButtonA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonA.setForeground(new java.awt.Color(0, 51, 102));
        jButtonA.setText("A");
        jButtonA.setEnabled(false);
        jButtonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAActionPerformed(evt);
            }
        });

        jButtonB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonB.setForeground(new java.awt.Color(0, 51, 102));
        jButtonB.setText("B");
        jButtonB.setEnabled(false);
        jButtonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBActionPerformed(evt);
            }
        });

        jButtonC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonC.setForeground(new java.awt.Color(0, 51, 102));
        jButtonC.setText("C");
        jButtonC.setEnabled(false);
        jButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCActionPerformed(evt);
            }
        });

        jButtonD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonD.setForeground(new java.awt.Color(0, 51, 102));
        jButtonD.setText("D");
        jButtonD.setEnabled(false);
        jButtonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDActionPerformed(evt);
            }
        });

        jButtonE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonE.setForeground(new java.awt.Color(0, 51, 102));
        jButtonE.setText("E");
        jButtonE.setEnabled(false);
        jButtonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEActionPerformed(evt);
            }
        });

        jButtonVoltar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonVoltar.setForeground(new java.awt.Color(0, 51, 102));
        jButtonVoltar.setText("<--");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 51, 102));
        jButton7.setText("7");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 51, 102));
        jButton4.setText("4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 102));
        jButton1.setText("1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonF.setForeground(new java.awt.Color(0, 51, 102));
        jButtonF.setText("F");
        jButtonF.setEnabled(false);
        jButtonF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFActionPerformed(evt);
            }
        });

        jButtonApagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonApagar.setForeground(new java.awt.Color(0, 51, 102));
        jButtonApagar.setText("CE");
        jButtonApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarActionPerformed(evt);
            }
        });
        jButtonApagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonApagarKeyPressed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 51, 102));
        jButton8.setText("8");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 51, 102));
        jButton5.setText("5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 51, 102));
        jButton2.setText("2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton0.setForeground(new java.awt.Color(0, 51, 102));
        jButton0.setText("0");
        jButton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton0ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(0, 51, 102));
        jButton9.setText("9");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 51, 102));
        jButton6.setText("6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButto3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButto3.setForeground(new java.awt.Color(0, 51, 102));
        jButto3.setText("3");
        jButto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButto3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(jComboBoxDe, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxPara, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jButtonConverter))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButtonF, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jButton0, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonA, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonB, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jButtonApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jButtonE, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButto3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButtonC, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButtonD, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxDe, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPara, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))))
                .addGap(18, 18, 18)
                .addComponent(jButtonConverter)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonA)
                        .addGap(7, 7, 7)
                        .addComponent(jButtonB))
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonApagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonC)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonD)
                    .addComponent(jButton4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton6))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButto3))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonF)
                    .addComponent(jButton0))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        txtResultado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lblResultado.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(748, 748, 748)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(671, 671, 671)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(350, 350, 350))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(lblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(223, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1704, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaidaActionPerformed

    }//GEN-LAST:event_txtSaidaActionPerformed

    private void txtSaidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaidaKeyPressed

        setCalculado();

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            
            txtSaida.setText("0");

        }
    }//GEN-LAST:event_txtSaidaKeyPressed

    private void txtSaidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaidaKeyTyped

        String caracteres = "";

        if (calc.getBase1() == 16) {
            
            caracteres = "0123456789ABCDEF";
            
        } 
        
        else if (calc.getBase1() == 10) {
            
            caracteres = "0123456789";
            
        } 
        
        else if (calc.getBase1() == 2) {
            
            caracteres = "01";
            
        }

        if (!caracteres.contains(evt.getKeyChar() + "")) {
            
            evt.consume();

        }
    }//GEN-LAST:event_txtSaidaKeyTyped

    private void jComboBoxDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDeActionPerformed

        setCalculado();
        int base1 = 0;

        //Decimal
        if (jComboBoxDe.getSelectedItem() == "Decimal") {
            
            txtSaida.setText("0");
            base1 = 10;

            calc.setBase1(base1);

            jButton2.setEnabled(true);
            jButto3.setEnabled(true);
            jButton4.setEnabled(true);
            jButton5.setEnabled(true);
            jButton6.setEnabled(true);
            jButton7.setEnabled(true);
            jButton8.setEnabled(true);
            jButton9.setEnabled(true);
            jButtonA.setEnabled(false);
            jButtonB.setEnabled(false);
            jButtonC.setEnabled(false);
            jButtonD.setEnabled(false);
            jButtonE.setEnabled(false);
            jButtonF.setEnabled(false);

            txtSaida.grabFocus();

        } 

        //Binário
        else if (jComboBoxDe.getSelectedItem() == "Binário") {
            
            txtSaida.setText("0");
            base1 = 2;

            calc.setBase1(base1);

            jButton2.setEnabled(false);
            jButto3.setEnabled(false);
            jButton4.setEnabled(false);
            jButton5.setEnabled(false);
            jButton6.setEnabled(false);
            jButton7.setEnabled(false);
            jButton8.setEnabled(false);
            jButton9.setEnabled(false);
            jButtonA.setEnabled(false);
            jButtonB.setEnabled(false);
            jButtonC.setEnabled(false);
            jButtonD.setEnabled(false);
            jButtonE.setEnabled(false);
            jButtonF.setEnabled(false);

            txtSaida.grabFocus();

        } 

        //Hexadecimal
        else {

            txtSaida.setText("0");
            base1 = 16;

            calc.setBase1(base1);

            jButton2.setEnabled(true);
            jButto3.setEnabled(true);
            jButton4.setEnabled(true);
            jButton5.setEnabled(true);
            jButton6.setEnabled(true);
            jButton7.setEnabled(true);
            jButton8.setEnabled(true);
            jButton9.setEnabled(true);
            jButtonA.setEnabled(true);
            jButtonB.setEnabled(true);
            jButtonC.setEnabled(true);
            jButtonD.setEnabled(true);
            jButtonE.setEnabled(true);
            jButtonF.setEnabled(true);

            txtSaida.grabFocus();

        }

    }//GEN-LAST:event_jComboBoxDeActionPerformed

    private void jComboBoxParaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxParaActionPerformed

        if (!txtSaida.getText().equals("0")) {
            
            setCalculado();
            txtSaida.grabFocus();
            
        }

        int base2 = 0;

        if (jComboBoxPara.getSelectedItem() == "Decimal") {
            
            base2 = 10;
            txtSaida.grabFocus();

        } 
        
        else if (jComboBoxPara.getSelectedItem() == "Binário") {
            
            base2 = 2;
            txtSaida.grabFocus();
 
        } 
        
         //Hexadecimal
        else if (jComboBoxPara.getSelectedItem() == "Hexadecimal") {
            
            base2 = 16;
            txtSaida.grabFocus();
            
        }

        try {
            
            calc.setBase2(base2);

        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(this, ex);
            
        }
    }//GEN-LAST:event_jComboBoxParaActionPerformed

    private void jButtonConverterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConverterActionPerformed

        try {

            if (txtSaida.getText().equals(null) || txtSaida.getText().equals("")|| txtSaida.getText().equals("0")) {
                JOptionPane.showMessageDialog(null, "Favor informar um número para conversão!");
            } 
            
            else if (calc.getBase1() == calc.getBase2()) {
                JOptionPane.showMessageDialog(null, "As Bases selecionadas são iguais \n" + "Selecione uma base diferente para realizar a conversão!");
            } 
            
            else {
                
                N1 = txtSaida.getText();
                calc.setN1(N1);

                txtSaida.setText(calc.mudarBase());
                
                lblResultado.setText((String) jComboBoxPara.getSelectedItem());
                txtResultado.setText(calc.getResultado());
                
                calculado = true;
                txtSaida.grabFocus();

            }

        } 
        
        catch (Exception ex) {
            
            JOptionPane.showMessageDialog(this, ex);
            
        }

    }//GEN-LAST:event_jButtonConverterActionPerformed

    private void jButtonAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAActionPerformed
        // TODO add your handling code here:
        if (txtSaida.getText().equals("0")) {
            
            txtSaida.setText("");
            
        }
        
        txtSaida.setText(txtSaida.getText() + jButtonA.getActionCommand());
        txtSaida.grabFocus();
    }//GEN-LAST:event_jButtonAActionPerformed

    private void jButtonBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBActionPerformed
        // TODO add your handling code here:
        if (txtSaida.getText().equals("0")) {
            
            txtSaida.setText("");
            
        }
        
        txtSaida.setText(txtSaida.getText() + jButtonB.getActionCommand());
        txtSaida.grabFocus();
    }//GEN-LAST:event_jButtonBActionPerformed

    private void jButtonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCActionPerformed
        // TODO add your handling code here:
        if (txtSaida.getText().equals("0")) {
            
            txtSaida.setText("");
        }
        
        txtSaida.setText(txtSaida.getText() + jButtonC.getActionCommand());
        txtSaida.grabFocus();
    }//GEN-LAST:event_jButtonCActionPerformed

    private void jButtonDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDActionPerformed
        // TODO add your handling code here:
        if (txtSaida.getText().equals("0")) {
            
            txtSaida.setText("");
        }
        
        txtSaida.setText(txtSaida.getText() + jButtonD.getActionCommand());
        txtSaida.grabFocus();
    }//GEN-LAST:event_jButtonDActionPerformed

    private void jButtonEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEActionPerformed
        // TODO add your handling code here:
        if (txtSaida.getText().equals("0")) {
            
            txtSaida.setText("");
            
        }
        
        txtSaida.setText(txtSaida.getText() + jButtonE.getActionCommand());
        txtSaida.grabFocus();
    }//GEN-LAST:event_jButtonEActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
        String voltar = txtSaida.getText();
        if (voltar.length() == 1) {
            
            txtSaida.setText("0");
            
        } 
        
        else {
            
            txtSaida.setText(voltar.substring(0, voltar.length() - 1));
            
        }
        txtSaida.grabFocus();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        setCalculado();
        txtSaida.setText(txtSaida.getText() + jButton7.getActionCommand());
        txtSaida.grabFocus();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        setCalculado();
        txtSaida.setText(txtSaida.getText() + jButton4.getActionCommand());
        txtSaida.grabFocus();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        setCalculado();
        txtSaida.setText(txtSaida.getText() + jButton1.getActionCommand());
        txtSaida.grabFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFActionPerformed

        if (txtSaida.getText().equals("0")) {
            
            txtSaida.setText("");
            
        }
        
        txtSaida.setText(txtSaida.getText() + jButtonF.getActionCommand());
        txtSaida.grabFocus();
    }//GEN-LAST:event_jButtonFActionPerformed

    private void jButtonApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarActionPerformed

        txtSaida.setText("0");
        txtSaida.grabFocus();
    }//GEN-LAST:event_jButtonApagarActionPerformed

    private void jButtonApagarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonApagarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            
            txtSaida.setText("0");

        }
    }//GEN-LAST:event_jButtonApagarKeyPressed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        setCalculado();
        txtSaida.setText(txtSaida.getText() + "8");
        txtSaida.grabFocus();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        setCalculado();
        txtSaida.setText(txtSaida.getText() + jButton5.getActionCommand());
        txtSaida.grabFocus();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        setCalculado();
        txtSaida.setText(txtSaida.getText() + jButton2.getActionCommand());
        txtSaida.grabFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton0ActionPerformed

        setCalculado();

        txtSaida.setText(txtSaida.getText() + "0");
        txtSaida.grabFocus();
    }//GEN-LAST:event_jButton0ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        setCalculado();
        txtSaida.setText(txtSaida.getText() + "9");
        txtSaida.grabFocus();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        setCalculado();
        txtSaida.setText(txtSaida.getText() + "6");
        txtSaida.grabFocus();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButto3ActionPerformed

        setCalculado();
        txtSaida.setText(txtSaida.getText() + jButto3.getActionCommand());
        txtSaida.grabFocus();
    }//GEN-LAST:event_jButto3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButto3;
    private javax.swing.JButton jButton0;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonA;
    private javax.swing.JButton jButtonApagar;
    private javax.swing.JButton jButtonB;
    private javax.swing.JButton jButtonC;
    private javax.swing.JButton jButtonConverter;
    private javax.swing.JButton jButtonD;
    private javax.swing.JButton jButtonE;
    private javax.swing.JButton jButtonF;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxDe;
    private javax.swing.JComboBox<String> jComboBoxPara;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JLabel txtResultado;
    private javax.swing.JTextField txtSaida;
    // End of variables declaration//GEN-END:variables
}
