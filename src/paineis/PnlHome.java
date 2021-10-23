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
            lblHora.setText(hora + ":" + minuto + ":" + segundo);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1620, 950));
        setMinimumSize(new java.awt.Dimension(1620, 950));
        setPreferredSize(new java.awt.Dimension(1620, 950));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("HORA");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 370, 186, 50));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("BEM VINDO AO SISTEMA");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1640, 70));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("DATA");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, 186, 40));

        lblData.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData.setText("DD/MM/YYYY");
        lblData.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 820, 50));

        lblHora.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHora.setText("00:00:00");
        lblHora.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 460, 810, 50));
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHora;
    // End of variables declaration//GEN-END:variables
}
