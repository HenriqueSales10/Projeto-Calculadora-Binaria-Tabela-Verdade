package paineis;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Henrique
 */

public class PnlHome extends javax.swing.JPanel implements Runnable {

    String horas, minutos, segundos;
    Thread horaEdata;
    private String hora;
    private String minuto;
    private String segundo;

    /**
     * Creates new form pnlHome
     */
    public PnlHome() {

        initComponents();
        lblData.setText(data());
        horaEdata = new Thread(this);
        horaEdata.start();
        setVisible(true);

    }

    public void CalculaHora() {

        Calendar calendario = new GregorianCalendar();
        Date horaatual = new Date();
        calendario.setTime(horaatual);
        hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        minuto = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundo = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);

    }
    
    public static String data() {
        Date data = new Date();
        SimpleDateFormat formatardata = new SimpleDateFormat("dd/MM/YYYY");
        return formatardata.format(data);

    }

    @Override
    public void run() {
        
        Thread current = Thread.currentThread();
        while (current == horaEdata) {
            CalculaHora();
        
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1620, 950));
        setMinimumSize(new java.awt.Dimension(1620, 950));
        setPreferredSize(new java.awt.Dimension(1620, 950));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Nomes: Henrique, Filipe, Lucas Michel, William G, Michel e Pedro Luis");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 1640, 70));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("DATA");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 310, 186, 40));

        lblData.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData.setText("DD/MM/YYYY");
        lblData.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 820, 50));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("BEM VINDO AO SISTEMA");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1640, 70));
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblData;
    // End of variables declaration//GEN-END:variables
}
