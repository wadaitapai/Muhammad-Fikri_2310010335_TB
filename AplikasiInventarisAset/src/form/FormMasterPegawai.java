package form;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi; // Pastikan ini sesuai dengan lokasi file Koneksi Anda

public class FormMasterPegawai extends javax.swing.JFrame {

    public FormMasterPegawai() {
        initComponents();
        int row = tabelPegawai.getSelectedRow();
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
        btnKembali = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("MASTER PEGAWAI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/ikon/ubah.png"))); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/ikon/tambah.png"))); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/ikon/delete_remove_close_icon_181533.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/ikon/kembali.png"))); // NOI18N
        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/ikon/2.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNama)
                                        .addGap(12, 12, 12))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblJabatan, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblUnit, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnHapus)
                                        .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(btnTambah)
                                .addGap(35, 35, 35)
                                .addComponent(btnUbah)))
                        .addGap(18, 18, 18)
                        .addComponent(btnKembali)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel2)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lblNama))
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblJabatan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUnit))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTambah)
                            .addComponent(btnUbah)
                            .addComponent(btnHapus)
                            .addComponent(btnKembali))))
                .addContainerGap(31, Short.MAX_VALUE))
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
       if(txtNama.getText().isEmpty() || txtJabatan.getText().isEmpty() || txtUnit.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
            return;
}
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
        
        if(row == -1){
        JOptionPane.showMessageDialog(this, "Pilih data yang ingin diubah/hapus!");
        return;
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Pilih data yang akan diubah!");
    }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if(txtNama.getText().isEmpty() || txtJabatan.getText().isEmpty() || txtUnit.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
             return;
}
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
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diubah/hapus!");
             return;
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!");
    }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
