package form;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;

public class FormTransaksi extends javax.swing.JFrame {

    public FormTransaksi() {
        initComponents();
        refreshForm();
    }

    public void refreshForm() {
        load_cb_pegawai();
        load_cb_aset();
        load_data();
        dateTanggalPinjam.setDate(new Date());
        dateTanggalKembali.setDate(null);
    }

    // Load Pegawai
    private void load_cb_pegawai() {
        try {
            cbPegawai.removeAllItems();
            cbPegawai.addItem("- Pilih Pegawai -");
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery("SELECT nama_pegawai FROM tbl_pegawai");
            while (r.next()) {
                cbPegawai.addItem(r.getString("nama_pegawai"));
            }
        } catch (Exception e) {
            System.out.println("Error load pegawai: " + e.getMessage());
        }
    }

    // Load Aset Tersedia
    private void load_cb_aset() {
        try {
            cbAset.removeAllItems();
            cbAset.addItem("- Pilih Aset -");
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery("SELECT nama_aset FROM tbl_aset WHERE status='Tersedia'");
            boolean ada = false;
            while (r.next()) {
                cbAset.addItem(r.getString("nama_aset"));
                ada = true;
            }
            if(!ada){
                System.out.println("Tidak ada aset yang tersedia");
            }
        } catch (Exception e) {
            System.out.println("Error load aset: " + e.getMessage());
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
        Connection c = Koneksi.getKoneksi();
        Statement s = c.createStatement();
        String query = "SELECT p.id_peminjaman, peg.nama_pegawai, a.nama_aset, "
                     + "p.tgl_pinjam, p.tgl_kembali, p.status "
                     + "FROM tbl_peminjaman p "
                     + "JOIN tbl_pegawai peg ON p.id_pegawai = peg.id_pegawai "
                     + "JOIN tbl_aset a ON p.id_aset = a.id_aset "
                     + "ORDER BY p.id_peminjaman DESC";
        ResultSet r = s.executeQuery(query);

        while(r.next()){
            model.addRow(new Object[]{
                r.getInt("id_peminjaman"),
                r.getString("nama_pegawai"),
                r.getString("nama_aset"),
                r.getString("tgl_pinjam"),
                r.getString("tgl_kembali"),
                r.getString("status")
            });
        }

        tabelPeminjaman.setModel(model);
    } catch(Exception e) {
        JOptionPane.showMessageDialog(this, "Error load data: " + e.getMessage());
    }
}
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        btnKembali = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelPeminjaman = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPegawai.setText("Pegawai");
        getContentPane().add(lblPegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, 10));

        lblAset.setText("Aset");
        getContentPane().add(lblAset, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        lblTanggalPinjam.setText("Tanggal Pinjam ");
        getContentPane().add(lblTanggalPinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, -1));

        lblTanggalKembali.setText("Tanggal Kembali");
        getContentPane().add(lblTanggalKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, -1));

        btnKembalikan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/ikon/sesuai.png"))); // NOI18N
        btnKembalikan.setText("Kembalikan");
        btnKembalikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembalikanActionPerformed(evt);
            }
        });
        getContentPane().add(btnKembalikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, -1, -1));

        btnPinjam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/ikon/tambah.png"))); // NOI18N
        btnPinjam.setText("Pinjam");
        btnPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPinjamActionPerformed(evt);
            }
        });
        getContentPane().add(btnPinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, -1, -1));

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/ikon/delete_remove_close_icon_181533.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, -1, -1));

        cbPegawai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbPegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 380, -1));

        cbAset.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbAset, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 380, -1));
        getContentPane().add(dateTanggalPinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 290, -1));
        getContentPane().add(dateTanggalKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 290, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Form Transaksi");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 720, 50));

        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/ikon/kembali.png"))); // NOI18N
        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });
        getContentPane().add(btnKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, -1, -1));

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
        jScrollPane2.setViewportView(tabelPeminjaman);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 720, 130));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/ikon/3.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 430, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembalikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembalikanActionPerformed
          try {
            int row = tabelPeminjaman.getSelectedRow();
            if(row == -1){
                JOptionPane.showMessageDialog(this, "Pilih data peminjaman!");
                return;
            }

            String status = tabelPeminjaman.getValueAt(row, 5).toString();
            if(status.equals("Kembali")){
                JOptionPane.showMessageDialog(this, "Aset sudah dikembalikan!");
                return;
            }

            int idPeminjaman = (int) tabelPeminjaman.getValueAt(row, 0);
            String namaAset = tabelPeminjaman.getValueAt(row, 2).toString();

            Connection c = Koneksi.getKoneksi();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String tglKembali = sdf.format(new Date());

            // Update peminjaman
            PreparedStatement ps1 = c.prepareStatement("UPDATE tbl_peminjaman SET tgl_kembali=?, status='Kembali' WHERE id_peminjaman=?");
            ps1.setString(1, tglKembali);
            ps1.setInt(2, idPeminjaman);
            ps1.executeUpdate();

            // Update status aset
            PreparedStatement ps2 = c.prepareStatement("UPDATE tbl_aset SET status='Tersedia' WHERE nama_aset=?");
            ps2.setString(1, namaAset);
            ps2.executeUpdate();

            JOptionPane.showMessageDialog(this, "Aset Telah Dikembalikan");
            refreshForm();

        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnKembalikanActionPerformed

    private void btnPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPinjamActionPerformed
       try {
            if(cbPegawai.getSelectedIndex() == 0 || cbAset.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Pilih Pegawai dan Aset!");
                return;
            }
            if(dateTanggalPinjam.getDate() == null){
                JOptionPane.showMessageDialog(this, "Pilih tanggal pinjam!");
                return;
            }

            Connection c = Koneksi.getKoneksi();

            // Ambil ID Pegawai
            PreparedStatement ps1 = c.prepareStatement("SELECT id_pegawai FROM tbl_pegawai WHERE nama_pegawai=?");
            ps1.setString(1, cbPegawai.getSelectedItem().toString());
            ResultSet rs1 = ps1.executeQuery();
            rs1.next(); 
            int idPegawai = rs1.getInt(1);

            // Ambil ID Aset
            PreparedStatement ps2 = c.prepareStatement("SELECT id_aset FROM tbl_aset WHERE nama_aset=? AND status='Tersedia'");
            ps2.setString(1, cbAset.getSelectedItem().toString());
            ResultSet rs2 = ps2.executeQuery();
            if(!rs2.next()){
                JOptionPane.showMessageDialog(this, "Aset sudah tidak tersedia!");
                load_cb_aset();
                return;
            }
            int idAset = rs2.getInt(1);

            // Insert peminjaman
            String sql = "INSERT INTO tbl_peminjaman (id_aset, id_pegawai, tgl_pinjam, status) VALUES (?, ?, ?, 'Dipinjam')";
            PreparedStatement p = c.prepareStatement(sql);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String tgl = sdf.format(dateTanggalPinjam.getDate());
            p.setInt(1, idAset);
            p.setInt(2, idPegawai);
            p.setString(3, tgl);
            p.executeUpdate();

            // Update status aset
            PreparedStatement ps3 = c.prepareStatement("UPDATE tbl_aset SET status='Dipinjam' WHERE id_aset=?");
            ps3.setInt(1, idAset);
            ps3.executeUpdate();

            JOptionPane.showMessageDialog(this, "Peminjaman Berhasil");
            refreshForm();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnPinjamActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try{
            int row = tabelPeminjaman.getSelectedRow();
            if(row == -1){
                JOptionPane.showMessageDialog(this, "Pilih data untuk dihapus!");
                return;
            }

            int konfirmasi = JOptionPane.showConfirmDialog(null, "Hapus riwayat ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if(konfirmasi == JOptionPane.YES_OPTION){
                int idPeminjaman = (int) tabelPeminjaman.getValueAt(row, 0);
                Connection c = Koneksi.getKoneksi();
                c.createStatement().executeUpdate("DELETE FROM tbl_peminjaman WHERE id_peminjaman=" + idPeminjaman);
                refreshForm();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void tabelPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPeminjamanMouseClicked
    int baris = tabelPeminjaman.getSelectedRow();
        if(baris != -1){
            cbPegawai.setSelectedItem(tabelPeminjaman.getValueAt(baris, 1).toString());
            cbAset.setSelectedItem(tabelPeminjaman.getValueAt(baris, 2).toString());
            try {
                String tglPinjamStr = tabelPeminjaman.getValueAt(baris, 3).toString();
                dateTanggalPinjam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tglPinjamStr));

                String tglKembaliStr = tabelPeminjaman.getValueAt(baris, 4).toString();
                if(!tglKembaliStr.equals("null")){
                    dateTanggalKembali.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tglKembaliStr));
                } else {
                    dateTanggalKembali.setDate(null);
                }
            } catch(Exception e) {}
        }
    }//GEN-LAST:event_tabelPeminjamanMouseClicked

    private String getIdAsetByNama(String namaAset) {
        try {
            Connection c = Koneksi.getKoneksi();
            PreparedStatement ps = c.prepareStatement("SELECT id_aset FROM tbl_aset WHERE nama_aset=?");
            ps.setString(1, namaAset);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) return rs.getString(1);
        } catch(Exception e) { System.out.println(e.getMessage()); }
        return "0";
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnKembalikan;
    private javax.swing.JButton btnPinjam;
    private javax.swing.JComboBox<String> cbAset;
    private javax.swing.JComboBox<String> cbPegawai;
    private com.toedter.calendar.JDateChooser dateTanggalKembali;
    private com.toedter.calendar.JDateChooser dateTanggalPinjam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAset;
    private javax.swing.JLabel lblPegawai;
    private javax.swing.JLabel lblTanggalKembali;
    private javax.swing.JLabel lblTanggalPinjam;
    private javax.swing.JTable tabelPeminjaman;
    // End of variables declaration//GEN-END:variables
}
