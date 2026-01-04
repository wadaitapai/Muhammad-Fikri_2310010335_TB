package form;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;

public class FormMasterAset extends javax.swing.JFrame {

    public FormMasterAset() {
        initComponents();
        load_data();
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
        model.addColumn("Tgl Register");
        model.addColumn("Status");

        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery("SELECT * FROM tbl_aset");
            while(r.next()){
                model.addRow(new Object[]{
                    r.getString("id_aset"),
                    r.getString("nama_aset"),
                    r.getString("kategori"),
                    r.getString("jumlah"),
                    r.getString("harga"),
                    r.getString("tgl_register"),
                    r.getString("status")
                });
            }
            tabelAset.setModel(model);
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
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
        btnKembali = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

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

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORM INVENTARIS ASET");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/ikon/kembali.png"))); // NOI18N
        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/ikon/4.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                                .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addGap(27, 27, 27)
                        .addComponent(btnUbah)
                        .addGap(26, 26, 26)
                        .addComponent(btnHapus)
                        .addGap(18, 18, 18)
                        .addComponent(btnKembali)))
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnKembali))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
    if(txtNama.getText().isEmpty() || txtKategori.getText().isEmpty() || 
     txtJumlah.getText().isEmpty() || txtHarga.getText().isEmpty()) {
     JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
        return;
}
        try {
            String sql = "INSERT INTO tbl_aset (nama_aset, kategori, jumlah, harga, tgl_register, status) VALUES (?, ?, ?, ?, CURDATE(), 'Tersedia')";
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
    int baris = tabelAset.getSelectedRow();
        if(baris == -1){
            JOptionPane.showMessageDialog(this, "Pilih data yang akan diubah!");
            return;
        }
        try {
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
            JOptionPane.showMessageDialog(this, "Data berhasil diubah");
            load_data();
            kosongkan_form();
            
             if(tabelAset.getValueAt(baris, 6).toString().equals("Dipinjam")) {
            JOptionPane.showMessageDialog(this, "Aset sedang dipinjam, tidak bisa dihapus!");
            return;}
             
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
          int baris = tabelAset.getSelectedRow();
        if(baris == -1){
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!");
            return;
        }
        int konfirmasi = JOptionPane.showConfirmDialog(null, "Hapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(konfirmasi == JOptionPane.YES_OPTION){
            try {
                String id = tabelAset.getValueAt(baris, 0).toString();
                Connection c = Koneksi.getKoneksi();
                PreparedStatement p = c.prepareStatement("DELETE FROM tbl_aset WHERE id_aset=?");
                p.setString(1, id);
                p.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
                load_data();
                kosongkan_form();
        if(tabelAset.getValueAt(baris, 6).toString().equals("Dipinjam")) {
            JOptionPane.showMessageDialog(this, "Aset sedang dipinjam, tidak bisa dihapus!");
            return;}
            } catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tabelAsetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelAsetMouseClicked
    int baris = tabelAset.getSelectedRow();
    if(baris != -1){
        txtNama.setText(tabelAset.getValueAt(baris, 1).toString());
        txtKategori.setText(tabelAset.getValueAt(baris, 2).toString());
        txtJumlah.setText(tabelAset.getValueAt(baris, 3).toString());
        txtHarga.setText(tabelAset.getValueAt(baris, 4).toString());
    }
    }//GEN-LAST:event_tabelAsetMouseClicked

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
      dispose();  // TODO add your handling code here:
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
