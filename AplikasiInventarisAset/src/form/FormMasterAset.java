package form;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi; 

public class FormMasterAset extends javax.swing.JFrame {

public FormMasterAset() {
        initComponents();
        load_data(); // Memanggil data saat form dibuka
    }

    private void kosongkan_form() {
        txtNama.setText("");
        txtKategori.setText("");
        txtJumlah.setText("");
        txtHarga.setText("");
        txtNama.requestFocus();
    }

    private void load_data() {
        DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("Nama Aset");
    model.addColumn("Kategori");
    model.addColumn("Jumlah");
    model.addColumn("Harga");
    model.addColumn("Tgl Register"); // Tambahkan ini

    try {
        Connection c = Koneksi.getKoneksi();
        Statement s = c.createStatement();
        String sql = "SELECT * FROM tbl_aset";
        ResultSet r = s.executeQuery(sql);

        while (r.next()) {
            model.addRow(new Object[]{
                r.getString("id_aset"),
                r.getString("nama_aset"),
                r.getString("kategori"),
                r.getString("jumlah"),
                r.getString("harga"),
                r.getString("tgl_register") // Ambil datanya
            });
        }
        tabelAset.setModel(model);
    } catch (SQLException e) {
        System.out.println("Terjadi Kesalahan: " + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelAset = new javax.swing.JTable();
        lblNama = new javax.swing.JLabel();
        lblJumlah = new javax.swing.JLabel();
        lblKategori = new javax.swing.JLabel();
        lblHarga = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtKategori = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        btnUbah = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelAset.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelAset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelAsetMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelAset);

        lblNama.setText("Nama ");

        lblJumlah.setText("Jumlah");

        lblKategori.setText("Kategori");

        lblHarga.setText("Harga");

        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/icons/update.png"))); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/icons/add.png"))); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/icons/delete.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORM INVENTARIS ASET");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(94, 94, 94))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(btnTambah)
                        .addGap(45, 45, 45)
                        .addComponent(btnUbah))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNama)
                            .addComponent(lblJumlah)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHarga)
                                    .addComponent(lblKategori))
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnHapus)
                                        .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNama)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJumlah)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKategori)
                    .addComponent(txtKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHarga)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTambah)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
     try {
            String sql = "INSERT INTO tbl_aset (nama_aset, kategori, jumlah, harga, tgl_register) VALUES (?, ?, ?, ?, CURDATE())";
            Connection c = Koneksi.getKoneksi();
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, txtNama.getText());
            p.setString(2, txtKategori.getText());
            p.setString(3, txtJumlah.getText());
            p.setString(4, txtHarga.getText());
            
            p.executeUpdate();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            load_data();
            kosongkan_form();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        try {
            int baris = tabelAset.getSelectedRow();
            if (baris == -1) {
                JOptionPane.showMessageDialog(this, "Pilih data di tabel yang ingin diubah!");
                return;
            }
            String id = tabelAset.getValueAt(baris, 0).toString();
            
            String sql = "UPDATE tbl_aset SET nama_aset=?, kategori=?, jumlah=?, harga=? WHERE id_aset=?";
            Connection c = Koneksi.getKoneksi();
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, txtNama.getText());
            p.setString(2, txtKategori.getText());
            p.setString(3, txtJumlah.getText());
            p.setString(4, txtHarga.getText());
            p.setString(5, id);
            
            p.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            load_data();
            kosongkan_form();
            if(txtNama.getText().equals("") || txtHarga.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong!");
             return;
}
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal Update: " + e.getMessage());
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {
            int baris = tabelAset.getSelectedRow();
            if (baris == -1) {
                JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!");
                return;
            }
            String id = tabelAset.getValueAt(baris, 0).toString();
            
            int confirm = JOptionPane.showConfirmDialog(null, "Hapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM tbl_aset WHERE id_aset=?";
                Connection c = Koneksi.getKoneksi();
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, id);
                p.executeUpdate();
                load_data();
                kosongkan_form();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tabelAsetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelAsetMouseClicked
        int baris = tabelAset.getSelectedRow();
        txtNama.setText(tabelAset.getValueAt(baris, 1).toString());
        txtKategori.setText(tabelAset.getValueAt(baris, 2).toString());
        txtJumlah.setText(tabelAset.getValueAt(baris, 3).toString());
        txtHarga.setText(tabelAset.getValueAt(baris, 4).toString());
    }//GEN-LAST:event_tabelAsetMouseClicked

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
            java.util.logging.Logger.getLogger(FormMasterAset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMasterAset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMasterAset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMasterAset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMasterAset().setVisible(true);
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
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblKategori;
    private javax.swing.JLabel lblNama;
    private javax.swing.JTable tabelAset;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKategori;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
