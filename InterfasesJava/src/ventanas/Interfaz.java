/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

/**
 *
 * @author user
 */
import java.awt.Image;
import java.awt.Toolkit;
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public Image getIconImage(){
         Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/cards.png"));
         return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JButton();
        jLabelicono = new javax.swing.JLabel();
        jButtonboton = new javax.swing.JButton();
        jLabeltitulo = new javax.swing.JLabel();
        jLabelsubtitulo = new javax.swing.JLabel();
        jLabelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(100);
        setIconImage(getIconImage());
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, 160, -1));

        jLabelicono.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\InterfasesJava\\img\\Interfases\\cartas.png")); // NOI18N
        getContentPane().add(jLabelicono, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 490));

        jButtonboton.setBackground(new java.awt.Color(0, 51, 51));
        jButtonboton.setForeground(new java.awt.Color(255, 255, 255));
        jButtonboton.setText("Iniciar Juego");
        jButtonboton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButtonboton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonbotonActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonboton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, 160, 50));

        jLabeltitulo.setFont(new java.awt.Font("Open Sans", 1, 48)); // NOI18N
        jLabeltitulo.setForeground(new java.awt.Color(0, 153, 153));
        jLabeltitulo.setText("Carta Intermedia");
        jLabeltitulo.setInheritsPopupMenu(false);
        getContentPane().add(jLabeltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 420, 80));

        jLabelsubtitulo.setFont(new java.awt.Font("Open Sans", 1, 60)); // NOI18N
        jLabelsubtitulo.setForeground(new java.awt.Color(0, 153, 153));
        jLabelsubtitulo.setText("El Juego!");
        getContentPane().add(jLabelsubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 260, -1));

        jLabelfondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\InterfasesJava\\img\\Interfases\\fondo.jpg")); // NOI18N
        getContentPane().add(jLabelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonbotonActionPerformed
        ventanaDeJuego paso = new ventanaDeJuego();
        paso.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonbotonActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButtonboton;
    private javax.swing.JLabel jLabelfondo;
    private javax.swing.JLabel jLabelicono;
    private javax.swing.JLabel jLabelsubtitulo;
    private javax.swing.JLabel jLabeltitulo;
    // End of variables declaration//GEN-END:variables
}
