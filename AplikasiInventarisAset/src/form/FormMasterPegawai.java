package form;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi; // Pastikan ini sesuai dengan lokasi file Koneksi Anda

public class FormMasterPegawai extends javax.swing.JFrame {

    public FormMasterPegawai() {
        initComponents();
        load_data(); 
    } // Pastikan kurung penutup constructor ada di sini

    private void kosongkan_form() {
        txtNama.setText("");
        txtJabatan.setText("");
        txtUnit.setText("");
        txtNama.requestFocus();
    }

    private void load_data() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama Pegawai");
        model.addColumn("Jabatan");
        model.addColumn("Unit Kerja"); // Nama kolom di tabel UI

        try {
            Connection c = koneksi.Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM tbl_pegawai";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                model.addRow(new Object[]{
                    r.getString("id_pegawai"),
                    r.getString("nama_pegawai"),
                    r.getString("jabatan"),
                    r.getString("unit_kerja") // DISESUAIKAN dengan MySQL
                });
            }
            tabelPegawai.setModel(model);
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPegawai = new javax.swing.JTable();
        lblNama = new javax.swing.JLabel();
        lblJabatan = new javax.swing.JLabel();
        lblUnit = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtUnit = new javax.swing.JTextField();
        txtJabatan = new javax.swing.JTextField();
        btnUbah = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("MASTER PEGAWAI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel1)
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        tabelPegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPegawaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelPegawai);

        lblNama.setText("Nama ");

        lblJabatan.setText("Jabatan");

        lblUnit.setText("Unit");

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNama)
                                .addGap(12, 12, 12)
                                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblJabatan)
                                .addGap(4, 4, 4)
                                .addComponent(txtJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblUnit)
                                .addGap(25, 25, 25)
                                .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(btnTambah)
                                .addGap(73, 73, 73)
                                .addComponent(btnUbah)
                                .addGap(72, 72, 72)
                                .addComponent(btnHapus)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblNama))
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblJabatan))
                    .addComponent(txtJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblUnit))
                    .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTambah)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPegawaiMouseClicked
       int row = tabelPegawai.getSelectedRow();
    txtNama.setText(tabelPegawai.getValueAt(row, 1).toString());
    txtJabatan.setText(tabelPegawai.getValueAt(row, 2).toString());
    txtUnit.setText(tabelPegawai.getValueAt(row, 3).toString());
    }//GEN-LAST:event_tabelPegawaiMouseClicked

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
       try {
        int row = tabelPegawai.getSelectedRow();
        String id = tabelPegawai.getValueAt(row, 0).toString();
        
        String sql = "UPDATE tbl_pegawai SET nama_pegawai=?, jabatan=?, unit_kerja=? WHERE id_pegawai=?";
        Connection c = koneksi.Koneksi.getKoneksi();
        PreparedStatement p = c.prepareStatement(sql);
        p.setString(1, txtNama.getText());
        p.setString(2, txtJabatan.getText());
        p.setString(3, txtUnit.getText());
        p.setString(4, id);
        
        p.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
        load_data();
        kosongkan_form();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Pilih data yang akan diubah!");
    }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        try {
        String sql = "INSERT INTO tbl_pegawai (nama_pegawai, jabatan, unit_kerja) VALUES (?, ?, ?)";
        Connection c = koneksi.Koneksi.getKoneksi();
        PreparedStatement p = c.prepareStatement(sql);
        p.setString(1, txtNama.getText());
        p.setString(2, txtJabatan.getText());
        p.setString(3, txtUnit.getText());
        
        p.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Pegawai Berhasil Ditambah");
        load_data();
        kosongkan_form();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {
        int row = tabelPegawai.getSelectedRow();
        String id = tabelPegawai.getValueAt(row, 0).toString();
        
        int k = JOptionPane.showConfirmDialog(null, "Hapus pegawai ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(k == JOptionPane.YES_OPTION){
            String sql = "DELETE FROM tbl_pegawai WHERE id_pegawai=?";
            Connection c = koneksi.Koneksi.getKoneksi();
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, id);
            p.executeUpdate();
            load_data();
            kosongkan_form();
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!");
    }
    }//GEN-LAST:event_btnHapusActionPerformed

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
            java.util.logging.Logger.getLogger(FormMasterPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMasterPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMasterPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMasterPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMasterPegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblJabatan;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblUnit;
    private javax.swing.JTable tabelPegawai;
    private javax.swing.JTextField txtJabatan;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtUnit;
    // End of variables declaration//GEN-END:variables
}
