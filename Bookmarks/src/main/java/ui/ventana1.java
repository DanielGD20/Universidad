package ui;

import clases.bookmark;
import clases.sqlConnect;
import javax.swing.JOptionPane;
import controlador.*;
import static controlador.Main.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFileChooser;

public class ventana1 extends javax.swing.JFrame {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public ventana1() {
        initComponents();
        centrarJFrame();
        con = sqlConnect.ConnecrDB();
    }

    public void centrarJFrame() {
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIngresarFavorito = new javax.swing.JButton();
        btnVerFavoritos = new javax.swing.JButton();
        btnIngresarCategoria = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnIngresarFavorito.setText("Ingresar Favorito");
        btnIngresarFavorito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarFavoritoActionPerformed(evt);
            }
        });

        btnVerFavoritos.setText("Ver Favoritos");
        btnVerFavoritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerFavoritosActionPerformed(evt);
            }
        });

        btnIngresarCategoria.setText("Ingresar Categoria");
        btnIngresarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarCategoriaActionPerformed(evt);
            }
        });

        btnExportar.setText("Exportar JSON");
        btnExportar.setPreferredSize(new java.awt.Dimension(114, 44));
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnIngresarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(btnVerFavoritos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnIngresarFavorito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnIngresarFavorito, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnVerFavoritos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnIngresarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarFavoritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarFavoritoActionPerformed
        Main.iterarCategorias();
        
        
        for (int i = 0; i < categorias.size(); i++) {
            ventana2.comboBox.addItem(categorias.get(i));
        }

        this.setVisible(false);
        ventana2.setVisible(true);
    }//GEN-LAST:event_btnIngresarFavoritoActionPerformed

    private void btnVerFavoritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerFavoritosActionPerformed

        for (int i = 0; i < listaFavoritos.size(); i++) {
            ventana3.comboBox.addItem(listaFavoritos.get(i).getNombreFavorito());
        }

        this.setVisible(false);
        ventana3.setVisible(true);
        
    }//GEN-LAST:event_btnVerFavoritosActionPerformed

    private void btnIngresarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarCategoriaActionPerformed

        String ingresito;
        ingresito = JOptionPane.showInputDialog(this, "Ingrese en nombre de la nueva categoria", "Categoria Nueva", JOptionPane.DEFAULT_OPTION);
        Main.categorias.add(ingresito);
        System.out.println(ingresito);
        
        sqlConnect app = new sqlConnect();
        app.insert(ingresito);

    }//GEN-LAST:event_btnIngresarCategoriaActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
         bookmark bookmark = new bookmark();
        JFileChooser chooser = new JFileChooser();
            int ok = chooser.showSaveDialog(ventana1.this);
            if (ok == JFileChooser.APPROVE_OPTION) {
                bookmark.guardarEncuesta(chooser.getSelectedFile());
            }   
    }//GEN-LAST:event_btnExportarActionPerformed

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
            java.util.logging.Logger.getLogger(ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnExportar;
    public javax.swing.JButton btnIngresarCategoria;
    public javax.swing.JButton btnIngresarFavorito;
    public javax.swing.JButton btnVerFavoritos;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
