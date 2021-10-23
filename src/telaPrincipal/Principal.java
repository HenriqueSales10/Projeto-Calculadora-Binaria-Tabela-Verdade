
package telaPrincipal;

import java.awt.Color;
import paineis.LigarPainel;
import paineis.PainelCalculadora;
import paineis.PainelConversao;
import paineis.PnlHome;


/**
 *
 * @author henri
 */
public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(this);
        this.BtnHome.setSelected(true);
        new LigarPainel(pnPrincipal, new PnlHome());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnMenu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        BtnConversao = new rsbuttom.RSButtonMetro();
        BtnCalculadora = new rsbuttom.RSButtonMetro();
        BtnHome = new rsbuttom.RSButtonMetro();
        pnPrincipal = new javax.swing.JPanel();

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 80));

        pnMenu.setBackground(new java.awt.Color(0, 0, 0));
        pnMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 366, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pnMenu.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 366, -1));

        BtnConversao.setBackground(new java.awt.Color(0, 0, 0));
        BtnConversao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/codigo-binario.png"))); // NOI18N
        BtnConversao.setText("Conversão");
        BtnConversao.setColorHover(new java.awt.Color(0, 0, 0));
        BtnConversao.setColorNormal(new java.awt.Color(0, 0, 0));
        BtnConversao.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        BtnConversao.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BtnConversao.setIconTextGap(25);
        BtnConversao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtnConversaoMousePressed(evt);
            }
        });
        BtnConversao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConversaoActionPerformed(evt);
            }
        });
        pnMenu.add(BtnConversao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 280, 60));

        BtnCalculadora.setBackground(new java.awt.Color(0, 0, 0));
        BtnCalculadora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ImgCalculadora.png"))); // NOI18N
        BtnCalculadora.setText("Calculadora");
        BtnCalculadora.setColorHover(new java.awt.Color(0, 0, 0));
        BtnCalculadora.setColorNormal(new java.awt.Color(0, 0, 0));
        BtnCalculadora.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        BtnCalculadora.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BtnCalculadora.setIconTextGap(25);
        BtnCalculadora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtnCalculadoraMousePressed(evt);
            }
        });
        BtnCalculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCalculadoraActionPerformed(evt);
            }
        });
        BtnCalculadora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCalculadoraKeyPressed(evt);
            }
        });
        pnMenu.add(BtnCalculadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 280, 60));

        BtnHome.setBackground(new java.awt.Color(0, 0, 0));
        BtnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/silhueta-negra-de-casa-sem-porta.png"))); // NOI18N
        BtnHome.setText("Tela inicial");
        BtnHome.setColorHover(new java.awt.Color(0, 0, 0));
        BtnHome.setColorNormal(new java.awt.Color(0, 0, 0));
        BtnHome.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        BtnHome.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BtnHome.setIconTextGap(30);
        BtnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtnHomeMousePressed(evt);
            }
        });
        BtnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHomeActionPerformed(evt);
            }
        });
        pnMenu.add(BtnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 280, 60));

        jPanel1.add(pnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 280, 1000));

        pnPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnPrincipal.setMaximumSize(new java.awt.Dimension(1620, 950));
        pnPrincipal.setMinimumSize(new java.awt.Dimension(1620, 950));
        pnPrincipal.setPreferredSize(new java.awt.Dimension(1620, 950));
        pnPrincipal.setLayout(new javax.swing.BoxLayout(pnPrincipal, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(pnPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 1620, 950));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("Tela Principal");

        setBounds(0, 0, 1920, 1080);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHomeActionPerformed
        new LigarPainel(pnPrincipal, new PnlHome());
        if (this.BtnHome.isSelected()){

            this.BtnHome.setColorNormal(new Color(51,51,51));
            this.BtnHome.setColorHover(new Color(51,51,51));
            this.BtnHome.setColorPressed(new Color(51,51,51));

            this.BtnConversao.setColorNormal(new Color(0,0,0));
            this.BtnConversao.setColorHover(new Color(51,51,51));
            this.BtnConversao.setColorPressed(new Color(0,0,0));

            this.BtnCalculadora.setColorNormal(new Color(0,0,0));
            this.BtnCalculadora.setColorHover(new Color(51,51,51));
            this.BtnCalculadora.setColorPressed(new Color(0,0,0));

        }else{

            this.BtnHome.setColorNormal(new Color(0,0,0));
            this.BtnHome.setColorHover(new Color(51,51,51));
            this.BtnHome.setColorPressed(new Color(0,0,0));

        }
    }//GEN-LAST:event_BtnHomeActionPerformed

    private void BtnHomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnHomeMousePressed
        this.BtnHome.setSelected(true);
        this.BtnConversao.setSelected(false);
        this.BtnCalculadora.setSelected(false);
    }//GEN-LAST:event_BtnHomeMousePressed

    private void BtnCalculadoraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCalculadoraKeyPressed

    }//GEN-LAST:event_BtnCalculadoraKeyPressed

    private void BtnCalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCalculadoraActionPerformed
        new LigarPainel(pnPrincipal, new PainelCalculadora());
        if (this.BtnCalculadora.isSelected()){

            this.BtnHome.setColorNormal(new Color(0,0,0));
            this.BtnHome.setColorHover(new Color(51,51,51));
            this.BtnHome.setColorPressed(new Color(0,0,0));

            this.BtnCalculadora.setColorNormal(new Color(51,51,51));
            this.BtnCalculadora.setColorHover(new Color(51,51,51));
            this.BtnCalculadora.setColorPressed(new Color(51,51,51));

            this.BtnConversao.setColorNormal(new Color(0,0,0));
            this.BtnConversao.setColorHover(new Color(51,51,51));
            this.BtnConversao.setColorPressed(new Color(0,0,0));

        }else{

            this.BtnCalculadora.setColorNormal(new Color(0,0,0));
            this.BtnCalculadora.setColorHover(new Color(51,51,51));
            this.BtnCalculadora.setColorPressed(new Color(0,0,0));

        }
    }//GEN-LAST:event_BtnCalculadoraActionPerformed

    private void BtnCalculadoraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCalculadoraMousePressed
        this.BtnHome.setSelected(false);

        this.BtnConversao.setSelected(false);
        this.BtnCalculadora.setSelected(true);
    }//GEN-LAST:event_BtnCalculadoraMousePressed

    private void BtnConversaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConversaoActionPerformed
        new LigarPainel(pnPrincipal, new PainelConversao());
        if (this.BtnConversao.isSelected()){

            this.BtnHome.setColorNormal(new Color(0,0,0));
            this.BtnHome.setColorHover(new Color(51,51,51));
            this.BtnHome.setColorPressed(new Color(0,0,0));

            this.BtnCalculadora.setColorNormal(new Color(0,0,0));
            this.BtnCalculadora.setColorHover(new Color(51,51,51));
            this.BtnCalculadora.setColorPressed(new Color(0,0,0));

            this.BtnConversao.setColorNormal(new Color(51,51,51));
            this.BtnConversao.setColorHover(new Color(51,51,51));
            this.BtnConversao.setColorPressed(new Color(51,51,51));

        }else{

            this.BtnConversao.setColorNormal(new Color(0,0,0));
            this.BtnConversao.setColorHover(new Color(51,51,51));
            this.BtnConversao.setColorPressed(new Color(0,0,0));

        }
    }//GEN-LAST:event_BtnConversaoActionPerformed

    private void BtnConversaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnConversaoMousePressed
        this.BtnHome.setSelected(false);
        this.BtnCalculadora.setSelected(false);
        this.BtnConversao.setSelected(true);
    }//GEN-LAST:event_BtnConversaoMousePressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttom.RSButtonMetro BtnCalculadora;
    private rsbuttom.RSButtonMetro BtnConversao;
    private rsbuttom.RSButtonMetro BtnHome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnPrincipal;
    // End of variables declaration//GEN-END:variables
}
