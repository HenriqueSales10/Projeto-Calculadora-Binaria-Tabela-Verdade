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
import calculos.Calculador;
import conversao.Conversor;

/**
 *
 * @author henri
 */
public class PainelCalculadora extends javax.swing.JPanel {

    Conversor calc = new Conversor();
    private boolean calculado = false;
    Calculador calculador = new Calculador();
    String valor1, valor2;
    char sinal;

    public PainelCalculadora() {
        initComponents();
        validarCombo1();
        validarCombo2();
 
    }
   

    public void setCalculado() {
        
        if (calculado || txtSaida.getText().equals("0")) {
            calculado = false;
            txtSaida.setText("");
        }
        
    }
    
    public void validarCombo1(){
        
        jComboBase2.setVisible(false);
        jLabelN2.setVisible(false);
        
        int base1 = 0;
        
        //Decimal
        if (jComboBase1.getSelectedItem() == "Decimal") {
            
            txtSaida.setText("0");

            base1 = 10;

            calculador.setBaseN1(base1);

            jButton0.setEnabled(true);
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
            jButton5.setEnabled(true);
            jButton6.setEnabled(true);
            jButton7.setEnabled(true);
            jButton8.setEnabled(true);
            jButton9.setEnabled(true);
            jButtonMultiplicacao.setEnabled(true);
            jButtonSoma.setEnabled(true);
            jButtonSubtracao.setEnabled(true);
            jButtonIgual.setEnabled(false);
            jButtonA.setEnabled(false);
            jButtonB.setEnabled(false);
            jButtonC.setEnabled(false);
            jButtonD.setEnabled(false);
            jButtonE.setEnabled(false);
            jButtonF.setEnabled(false);

        }
        
        //Binário
        else if (jComboBase1.getSelectedItem() == "Binário") {
            
            txtSaida.setText("0");

            base1 = 2;

            calculador.setBaseN1(base1);

            jButton0.setEnabled(true);
            jButtonMultiplicacao.setEnabled(true);
            jButtonSoma.setEnabled(true);
            jButtonSubtracao.setEnabled(true);
            jButtonIgual.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
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

        } 
        
        //Hexadecimal
        else {

            txtSaida.setText("0");

            base1 = 16;

            calculador.setBaseN1(base1);

            jButtonMultiplicacao.setEnabled(true);
            jButtonSoma.setEnabled(true);
            jButtonSubtracao.setEnabled(true);
            jButtonIgual.setEnabled(false);
            jButton0.setEnabled(true);
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
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

        }
    }
    
    public void validarCombo2(){
         if (!txtSaida.getText().equals("0")) {
            
            setCalculado();
            txtSaida.grabFocus();
            
        }

        int base2 = 0;

        //Decimal
        if (jComboBase2.getSelectedItem() == "Decimal") {
            
            base2 = 10;
            
            calculador.setBaseN2(base2);
            
            jButton0.setEnabled(true);
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
            jButton5.setEnabled(true);
            jButton6.setEnabled(true);
            jButton7.setEnabled(true);
            jButton8.setEnabled(true);
            jButton9.setEnabled(true);
            jButtonMultiplicacao.setEnabled(false);
            jButtonSoma.setEnabled(false);
            jButtonSubtracao.setEnabled(false);
            jButtonIgual.setEnabled(true);
            jButtonA.setEnabled(false);
            jButtonB.setEnabled(false);
            jButtonC.setEnabled(false);
            jButtonD.setEnabled(false);
            jButtonE.setEnabled(false);
            jButtonF.setEnabled(false);
              
            txtSaida.grabFocus();

        } 
        
        //Binário
        else if (jComboBase2.getSelectedItem() == "Binário") {
            
            base2 = 2;
            
            calculador.setBaseN2(base2);
            
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
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
            jButtonMultiplicacao.setEnabled(false);
            jButtonSoma.setEnabled(false);
            jButtonSubtracao.setEnabled(false);
            jButtonIgual.setEnabled(true);
            
            txtSaida.grabFocus();

           
        } 
        
         //Hexadecimal
        else if (jComboBase2.getSelectedItem() == "Hexadecimal") {
            base2 = 16;
            
            calculador.setBaseN2(base2);
            
            jButton0.setEnabled(true);
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
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
            jButtonMultiplicacao.setEnabled(false);
            jButtonSoma.setEnabled(false);
            jButtonSubtracao.setEnabled(false);
            jButtonIgual.setEnabled(true);
            
            txtSaida.grabFocus();
        }

        try {
            calculador.setBaseN2(base2);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jComboBase1 = new javax.swing.JComboBox<>();
        jLabelN1 = new javax.swing.JLabel();
        jButtonCE = new javax.swing.JButton();
        jButtonA = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton0 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButtonC = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButtonE = new javax.swing.JButton();
        jButtonB = new javax.swing.JButton();
        jButtonD = new javax.swing.JButton();
        jButtonF = new javax.swing.JButton();
        jButtonIgual = new javax.swing.JButton();
        txtSaida = new javax.swing.JTextField();
        jButtonSoma = new javax.swing.JButton();
        jButtonSubtracao = new javax.swing.JButton();
        jButtonMultiplicacao = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jLabelN2 = new javax.swing.JLabel();
        jComboBase2 = new javax.swing.JComboBox<>();

        setMaximumSize(new java.awt.Dimension(1680, 940));
        setMinimumSize(new java.awt.Dimension(1680, 940));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1620, 950));
        jPanel1.setMinimumSize(new java.awt.Dimension(1620, 950));
        jPanel1.setPreferredSize(new java.awt.Dimension(1620, 950));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel3.setText("Calculadora");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 57, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jComboBase1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Decimal", "Binário", "Hexadecimal" }));
        jComboBase1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBase1ActionPerformed(evt);
            }
        });

        jLabelN1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelN1.setText("BASE PRIMEIRO NÚMERO");

        jButtonCE.setText("CE");
        jButtonCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCEActionPerformed(evt);
            }
        });

        jButtonA.setText("A");
        jButtonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAActionPerformed(evt);
            }
        });

        jButton4.setText("4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton8.setText("8");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton7.setText("7");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton0.setText("0");
        jButton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton0ActionPerformed(evt);
            }
        });

        jButton5.setText("5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButtonC.setText("C");
        jButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCActionPerformed(evt);
            }
        });

        jButton2.setText("2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton9.setText("9");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton6.setText("6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton3.setText("3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButtonE.setText("E");
        jButtonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEActionPerformed(evt);
            }
        });

        jButtonB.setText("B");
        jButtonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBActionPerformed(evt);
            }
        });

        jButtonD.setText("D");
        jButtonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDActionPerformed(evt);
            }
        });

        jButtonF.setText("F");
        jButtonF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFActionPerformed(evt);
            }
        });

        jButtonIgual.setText("=");
        jButtonIgual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIgualActionPerformed(evt);
            }
        });

        txtSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaidaActionPerformed(evt);
            }
        });

        jButtonSoma.setText("+");
        jButtonSoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSomaActionPerformed(evt);
            }
        });

        jButtonSubtracao.setText("-");
        jButtonSubtracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubtracaoActionPerformed(evt);
            }
        });

        jButtonMultiplicacao.setText("X");
        jButtonMultiplicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMultiplicacaoActionPerformed(evt);
            }
        });

        jButtonVoltar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVoltar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonVoltar.setForeground(new java.awt.Color(0, 51, 102));
        jButtonVoltar.setText("←");
        jButtonVoltar.setBorder(null);
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jLabelN2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelN2.setText("BASE SEGUNDO NÚMERO");

        jComboBase2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Decimal", "Binário", "Hexadecimal" }));
        jComboBase2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBase2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(txtSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButtonCE, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButtonIgual, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jButtonSoma, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jButtonSubtracao, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jButtonMultiplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jButton0, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButtonA, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButtonC, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonE, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButtonB, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButtonD, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonF, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelN2)
                        .addGap(28, 28, 28)
                        .addComponent(jComboBase2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelN1)
                        .addGap(28, 28, 28)
                        .addComponent(jComboBase1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(txtSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelN1)
                    .addComponent(jComboBase1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelN2)
                    .addComponent(jComboBase2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jButtonCE, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonIgual, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSoma, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSubtracao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMultiplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonE, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonF, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 130, 610, -1));

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

    private void jComboBase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBase1ActionPerformed
        validarCombo1();
        setCalculado();        
    }//GEN-LAST:event_jComboBase1ActionPerformed

    private void jButtonCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCEActionPerformed

        jComboBase1.setVisible(true);
        jLabelN1.setVisible(true);
        jComboBase2.setVisible(false);
        jLabelN2.setVisible(false);
        txtSaida.setText("0");
    }//GEN-LAST:event_jButtonCEActionPerformed

    private void jButtonAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAActionPerformed
        
        if (txtSaida.getText().equals("0")) {
            
            txtSaida.setText("");
            
        }
        txtSaida.setText(txtSaida.getText() + jButtonA.getActionCommand());

    }//GEN-LAST:event_jButtonAActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setCalculado();
        txtSaida.setText(txtSaida.getText() + "4");

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setCalculado();
        txtSaida.setText(txtSaida.getText() + "1");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        setCalculado();
        txtSaida.setText(txtSaida.getText() + "8");

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        setCalculado();
        txtSaida.setText(txtSaida.getText() + "7");

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton0ActionPerformed
        setCalculado();
        txtSaida.setText(txtSaida.getText() + "0");

    }//GEN-LAST:event_jButton0ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        setCalculado();
        txtSaida.setText(txtSaida.getText() + "5");

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButtonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCActionPerformed
        if (txtSaida.getText().equals("0")) {
            
            txtSaida.setText("");
            
        }
        txtSaida.setText(txtSaida.getText() + jButtonC.getActionCommand());

    }//GEN-LAST:event_jButtonCActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setCalculado();
        txtSaida.setText(txtSaida.getText() + "2");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        setCalculado();
        txtSaida.setText(txtSaida.getText() + "9");

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        setCalculado();
        txtSaida.setText(txtSaida.getText() + "6");

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setCalculado();
        txtSaida.setText(txtSaida.getText() + "3");

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEActionPerformed
        if (txtSaida.getText().equals("0")) {
            
            txtSaida.setText("");
        }
        txtSaida.setText(txtSaida.getText() + jButtonE.getActionCommand());

    }//GEN-LAST:event_jButtonEActionPerformed

    private void jButtonBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBActionPerformed
        if (txtSaida.getText().equals("0")) {
            
            txtSaida.setText("");
            
        }
        txtSaida.setText(txtSaida.getText() + jButtonB.getActionCommand());

    }//GEN-LAST:event_jButtonBActionPerformed

    private void jButtonDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDActionPerformed
        if (txtSaida.getText().equals("0")) {
            
            txtSaida.setText("");
            
        }
        txtSaida.setText(txtSaida.getText() + jButtonD.getActionCommand());

    }//GEN-LAST:event_jButtonDActionPerformed

    private void jButtonFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFActionPerformed
        if (txtSaida.getText().equals("0")) {
            
            txtSaida.setText("");
            
        }
        txtSaida.setText(txtSaida.getText() + jButtonF.getActionCommand());

    }//GEN-LAST:event_jButtonFActionPerformed

    private void jButtonIgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIgualActionPerformed

        valor2 = txtSaida.getText();

        try {

            if (valor1.equals("0")|| valor2.equals("0") || valor1.equals(null) || valor2.equals(null)) {
                
                JOptionPane.showMessageDialog(null, "Favor informar os dois números para o cálculo!");
                
            } 
            
            else {

                calculador.setN1(valor1);
                calculador.setN2(valor2);

                txtSaida.setText(calculador.calcular());

                calculado = true;
                txtSaida.grabFocus();

            }

        } 
        
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }//GEN-LAST:event_jButtonIgualActionPerformed

    private void jButtonSomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSomaActionPerformed
        jComboBase1.setVisible(false);
        jLabelN1.setVisible(false);
        jComboBase2.setVisible(true);
        jLabelN2.setVisible(true);
        valor1 = txtSaida.getText();
        txtSaida.setText("");
        sinal = '+';
        calculador.setOp(sinal);
    }//GEN-LAST:event_jButtonSomaActionPerformed

    private void jButtonSubtracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubtracaoActionPerformed
       jComboBase1.setVisible(false);
       jLabelN1.setVisible(false);
       jComboBase2.setVisible(true);
       jLabelN2.setVisible(true); 
       valor1 = txtSaida.getText();
       txtSaida.setText("");
       sinal = '-';
       calculador.setOp(sinal);
    }//GEN-LAST:event_jButtonSubtracaoActionPerformed

    private void jButtonMultiplicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMultiplicacaoActionPerformed
        jComboBase1.setVisible(false);
        jLabelN1.setVisible(false);
        jComboBase2.setVisible(true);
        jLabelN2.setVisible(true);
        valor1 = txtSaida.getText();
        txtSaida.setText("");
        sinal = '*';
        calculador.setOp(sinal);
    }//GEN-LAST:event_jButtonMultiplicacaoActionPerformed

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

    private void txtSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaidaActionPerformed

    }//GEN-LAST:event_txtSaidaActionPerformed

    private void jComboBase2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBase2ActionPerformed
        validarCombo2();
    }//GEN-LAST:event_jComboBase2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton0;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonA;
    private javax.swing.JButton jButtonB;
    private javax.swing.JButton jButtonC;
    private javax.swing.JButton jButtonCE;
    private javax.swing.JButton jButtonD;
    private javax.swing.JButton jButtonE;
    private javax.swing.JButton jButtonF;
    private javax.swing.JButton jButtonIgual;
    private javax.swing.JButton jButtonMultiplicacao;
    private javax.swing.JButton jButtonSoma;
    private javax.swing.JButton jButtonSubtracao;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBase1;
    private javax.swing.JComboBox<String> jComboBase2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelN1;
    private javax.swing.JLabel jLabelN2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtSaida;
    // End of variables declaration//GEN-END:variables
}
