package form;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class FormTransaksi extends javax.swing.JFrame {

   public FormTransaksi() {
    initComponents();
    load_cb_pegawai();
    load_cb_aset();
    load_data();
    dateTanggalPinjam.setDate(new Date()); // Set tanggal hari ini secara default
}

// Mengambil Nama Pegawai untuk ComboBox
private void load_cb_pegawai() {
    try {
        cbPegawai.removeAllItems();
        cbPegawai.addItem("- Pilih Pegawai -");
        Connection c = koneksi.Koneksi.getKoneksi();
        Statement s = c.createStatement();
        ResultSet r = s.executeQuery("SELECT nama_pegawai FROM tbl_pegawai");
        while (r.next()) {
            cbPegawai.addItem(r.getString("nama_pegawai"));
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

// Mengambil Nama Aset untuk ComboBox (Hanya yang statusnya 'Tersedia')
private void load_cb_aset() {
    try {
        cbAset.removeAllItems();
        cbAset.addItem("- Pilih Aset -");
        Connection c = koneksi.Koneksi.getKoneksi();
        Statement s = c.createStatement();
        // Pastikan di tbl_aset ada kolom status
        ResultSet r = s.executeQuery("SELECT nama_aset FROM tbl_aset WHERE status='Tersedia'");
        while (r.next()) {
            cbAset.addItem(r.getString("nama_aset"));
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

private void load_data() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("Pegawai");
    model.addColumn("Aset");
    model.addColumn("Tgl Pinjam");
    model.addColumn("Tgl Kembali");
    model.addColumn("Status");

    try {
        Connection c = koneksi.Koneksi.getKoneksi();
        String sql = "SELECT p.id_peminjaman, pg.nama_pegawai, a.nama_aset, p.tgl_pinjam, p.tgl_kembali, p.status " +
                     "FROM tbl_peminjaman p " +
                     "JOIN tbl_pegawai pg ON p.id_pegawai = pg.id_pegawai " +
                     "JOIN tbl_aset a ON p.id_aset = a.id_aset ORDER BY p.id_peminjaman DESC";
        Statement s = c.createStatement();
        ResultSet r = s.executeQuery(sql);

        while (r.next()) {
            model.addRow(new Object[]{
                r.getString(1), r.getString(2), r.getString(3), 
                r.getString(4), r.getString(5), r.getString(6)
            });
        }
        tabelPeminjaman.setModel(model);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPeminjaman = new javax.swing.JTable();
        lblPegawai = new javax.swing.JLabel();
        lblAset = new javax.swing.JLabel();
        lblTanggalPinjam = new javax.swing.JLabel();
        lblTanggalKembali = new javax.swing.JLabel();
        btnKembalikan = new javax.swing.JButton();
        btnPinjam = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        cbPegawai = new javax.swing.JComboBox<>();
        cbAset = new javax.swing.JComboBox<>();
        dateTanggalPinjam = new com.toedter.calendar.JDateChooser();
        dateTanggalKembali = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPeminjamanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelPeminjaman);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 380, 90));

        lblPegawai.setText("Pegawai");
        getContentPane().add(lblPegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 161, -1, -1));

        lblAset.setText("Aset");
        getContentPane().add(lblAset, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 187, -1, -1));

        lblTanggalPinjam.setText("Tanggal Pinjam ");
        getContentPane().add(lblTanggalPinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 213, -1, -1));

        lblTanggalKembali.setText("Tanggal Kembali");
        getContentPane().add(lblTanggalKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 239, -1, -1));

        btnKembalikan.setText("Kembalikan");
        btnKembalikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembalikanActionPerformed(evt);
            }
        });
        getContentPane().add(btnKembalikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, -1, -1));

        btnPinjam.setText("Pinjam");
        btnPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPinjamActionPerformed(evt);
            }
        });
        getContentPane().add(btnPinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, -1));

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));

        cbPegawai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbPegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 290, -1));

        cbAset.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbAset, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 290, -1));
        getContentPane().add(dateTanggalPinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 290, -1));
        getContentPane().add(dateTanggalKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 290, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Form Transaksi");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 380, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPeminjamanMouseClicked
        
    }//GEN-LAST:event_tabelPeminjamanMouseClicked

    private void btnKembalikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembalikanActionPerformed
        try {
        int row = tabelPeminjaman.getSelectedRow();
        String id_pinjam = tabelPeminjaman.getValueAt(row, 0).toString();
        String nama_aset = tabelPeminjaman.getValueAt(row, 2).toString();
        String status = tabelPeminjaman.getValueAt(row, 5).toString();

        if(status.equals("Kembali")) {
            JOptionPane.showMessageDialog(this, "Aset ini sudah dikembalikan!");
            return;
        }

        Connection c = koneksi.Koneksi.getKoneksi();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tglK = sdf.format(new Date()); // Tanggal kembali hari ini

        // 1. Update tbl_peminjaman
        PreparedStatement p = c.prepareStatement("UPDATE tbl_peminjaman SET tgl_kembali=?, status='Kembali' WHERE id_peminjaman=?");
        p.setString(1, tglK);
        p.setString(2, id_pinjam);
        p.executeUpdate();

        // 2. Update status aset jadi 'Tersedia' kembali
        c.createStatement().executeUpdate("UPDATE tbl_aset SET status='Tersedia' WHERE nama_aset='" + nama_aset + "'");

        JOptionPane.showMessageDialog(null, "Aset Telah Dikembalikan");
        load_data();
        load_cb_aset();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Pilih data di tabel!");
    }
    }//GEN-LAST:event_btnKembalikanActionPerformed

    private void btnPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPinjamActionPerformed
        try {
        if(cbPegawai.getSelectedIndex() == 0 || cbAset.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Pilih Pegawai dan Aset!");
            return;
        }

        Connection c = koneksi.Koneksi.getKoneksi();
        
        // 1. Ambil ID Pegawai berdasarkan Nama
        PreparedStatement ps1 = c.prepareStatement("SELECT id_pegawai FROM tbl_pegawai WHERE nama_pegawai=?");
        ps1.setString(1, cbPegawai.getSelectedItem().toString());
        ResultSet rs1 = ps1.executeQuery();
        rs1.next(); int idPegawai = rs1.getInt(1);

        // 2. Ambil ID Aset berdasarkan Nama
        PreparedStatement ps2 = c.prepareStatement("SELECT id_aset FROM tbl_aset WHERE nama_aset=?");
        ps2.setString(1, cbAset.getSelectedItem().toString());
        ResultSet rs2 = ps2.executeQuery();
        rs2.next(); int idAset = rs2.getInt(1);

        // 3. Insert ke tbl_peminjaman
        String sql = "INSERT INTO tbl_peminjaman (id_aset, id_pegawai, tgl_pinjam, status) VALUES (?, ?, ?, 'Dipinjam')";
        PreparedStatement p = c.prepareStatement(sql);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tgl = sdf.format(dateTanggalPinjam.getDate());
        
        p.setInt(1, idAset);
        p.setInt(2, idPegawai);
        p.setString(3, tgl);
        p.executeUpdate();

        // 4. Update status aset jadi 'Dipinjam'
        c.createStatement().executeUpdate("UPDATE tbl_aset SET status='Dipinjam' WHERE id_aset=" + idAset);

        JOptionPane.showMessageDialog(null, "Peminjaman Berhasil");
        load_data();
        load_cb_aset(); // Refresh list aset tersedia
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    }//GEN-LAST:event_btnPinjamActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {
        int row = tabelPeminjaman.getSelectedRow();
        String id = tabelPeminjaman.getValueAt(row, 0).toString();
        int k = JOptionPane.showConfirmDialog(null, "Hapus riwayat ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(k == JOptionPane.YES_OPTION){
            Connection c = koneksi.Koneksi.getKoneksi();
            c.createStatement().executeUpdate("DELETE FROM tbl_peminjaman WHERE id_peminjaman=" + id);
            load_data();
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
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembalikan;
    private javax.swing.JButton btnPinjam;
    private javax.swing.JComboBox<String> cbAset;
    private javax.swing.JComboBox<String> cbPegawai;
    private com.toedter.calendar.JDateChooser dateTanggalKembali;
    private com.toedter.calendar.JDateChooser dateTanggalPinjam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAset;
    private javax.swing.JLabel lblPegawai;
    private javax.swing.JLabel lblTanggalKembali;
    private javax.swing.JLabel lblTanggalPinjam;
    private javax.swing.JTable tabelPeminjaman;
    // End of variables declaration//GEN-END:variables
}
