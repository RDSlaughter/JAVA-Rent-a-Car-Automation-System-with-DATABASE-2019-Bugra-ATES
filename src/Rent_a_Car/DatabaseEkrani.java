/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rent_a_Car;

import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author bugra
 */
public class DatabaseEkrani extends javax.swing.JDialog {

    DefaultTableModel model ;
    DataBase islemler = new DataBase();
    /**
     * Creates new form DatabaseEkrani
     */
    public DatabaseEkrani(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        model = (DefaultTableModel) database_tablosu.getModel();
        DataBaseGoruntule();
    }

    DatabaseEkrani() {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        database_tablosu = new javax.swing.JTable();
        arama_alani = new javax.swing.JTextField();
        arama_logosu = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setTitle("User and Car Informations Database");
        setBounds(new java.awt.Rectangle(487, 200, 0, 0));

        database_tablosu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        database_tablosu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        database_tablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Surname", "Gender", "Phone Number", "ID Number", "Brand", "Model", "Model Year", "Daily Price", "Day", "Fuel Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        database_tablosu.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane1.setViewportView(database_tablosu);

        arama_alani.setBackground(new java.awt.Color(0, 153, 153));
        arama_alani.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        arama_alani.setForeground(new java.awt.Color(255, 255, 255));
        arama_alani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arama_alaniActionPerformed(evt);
            }
        });
        arama_alani.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                arama_alaniKeyReleased(evt);
            }
        });

        arama_logosu.setFont(new java.awt.Font("Berlin Sans FB", 0, 21)); // NOI18N
        arama_logosu.setForeground(new java.awt.Color(4, 87, 87));
        arama_logosu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rent_a_Car/arama-logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(arama_logosu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(arama_alani))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(arama_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arama_logosu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void arama_alaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arama_alaniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arama_alaniActionPerformed

    public void AramaYapma(String ara){
        
        TableRowSorter<DefaultTableModel> table_sorter = new TableRowSorter<DefaultTableModel>(model);
        database_tablosu.setRowSorter(table_sorter);
        table_sorter.setRowFilter(RowFilter.regexFilter(ara));
    }
    
    private void arama_alaniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_arama_alaniKeyReleased
    
        String ara = arama_alani.getText();
        AramaYapma(ara);
    }//GEN-LAST:event_arama_alaniKeyReleased

    /**
     * @param args the command line arguments
     */
    public void DataBaseGoruntule() {
        
        model.setRowCount(0);
        ArrayList<Musteri> musteriler = new ArrayList<Musteri>();
        musteriler = islemler.MusterileriGetir();
        
        if ( musteriler != null) {
            
            for ( Musteri musteri : musteriler) {
                
                Object[] eklenecek = {musteri.getName(),musteri.getSurname(),musteri.getGender(),musteri.getPhone_number(),musteri.getId_number(),musteri.getBrand(),musteri.getModel(),musteri.getModel_year(),musteri.getDaily_price(),musteri.getDay(),musteri.getFuel_type()};
                model.addRow(eklenecek);
            }
        }
        
    }
    
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
            java.util.logging.Logger.getLogger(DatabaseEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatabaseEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatabaseEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatabaseEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DatabaseEkrani dialog = new DatabaseEkrani(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField arama_alani;
    private javax.swing.JLabel arama_logosu;
    private javax.swing.JTable database_tablosu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
