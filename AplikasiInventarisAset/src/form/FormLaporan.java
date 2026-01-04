package form;

import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FormLaporan extends javax.swing.JFrame {

    // Tambahkan variabel JTable untuk preview
    private javax.swing.JTable tabelPreview;
    private javax.swing.JScrollPane scrollPreview;

    public FormLaporan() {
        initComponents();
        // Default load preview aset
        loadPreviewAset();
    }

    // ==================== METHOD PREVIEW ====================
    private void loadPreviewAset() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nama Aset");
            model.addColumn("Kategori");
            model.addColumn("Status");

            Connection c = koneksi.Koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT id_aset, nama_aset, kategori, status FROM tbl_aset");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_aset"),
                    rs.getString("nama_aset"),
                    rs.getString("kategori"),
                    rs.getString("status")
                });
            }
            tabelPreview.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error load preview: " + e.getMessage());
        }
    }

    private void loadPreviewPeminjaman() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Aset");
            model.addColumn("Pegawai");
            model.addColumn("Tgl Pinjam");
            model.addColumn("Status");

            Connection c = koneksi.Koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(
                "SELECT p.id_peminjaman, a.nama_aset, pg.nama_pegawai, p.tgl_pinjam, p.status " +
                "FROM tbl_peminjaman p " +
                "JOIN tbl_aset a ON p.id_aset = a.id_aset " +
                "JOIN tbl_pegawai pg ON p.id_pegawai = pg.id_pegawai"
            );

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_peminjaman"),
                    rs.getString("nama_aset"),
                    rs.getString("nama_pegawai"),
                    rs.getString("tgl_pinjam"),
                    rs.getString("status")
                });
            }
            tabelPreview.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error load preview: " + e.getMessage());
        }
    }
     // ==================== EXPORT ====================
    private void exportToExcel(String query, String filename) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File(filename + ".xls"));
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try (FileWriter fw = new FileWriter(fileChooser.getSelectedFile())) {
                Connection c = koneksi.Koneksi.getKoneksi();
                Statement s = c.createStatement();
                ResultSet rs = s.executeQuery(query);
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                // Tulis Header
                for (int i = 1; i <= columnCount; i++) {
                    fw.write(metaData.getColumnName(i) + "\t");
                }
                fw.write("\n");

                // Tulis Data
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        fw.write(rs.getString(i) + "\t");
                    }
                    fw.write("\n");
                }
                JOptionPane.showMessageDialog(this, "Export Excel Berhasil!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }

    private void exportToPDF(String query, String title) {
        try {
            Connection c = koneksi.Koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(query);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            DefaultTableModel model = new DefaultTableModel();
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnLabel(i));
            }
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }

            JTable tempTable = new JTable(model);
            MessageFormat header = new MessageFormat(title);
            MessageFormat footer = new MessageFormat("Halaman {0}");
            boolean complete = tempTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);

            if (complete) {
                JOptionPane.showMessageDialog(this, "Proses Cetak Selesai");
            }
        } catch (PrinterException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mencetak: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExportAset = new javax.swing.JButton();
        btnExportPeminjaman = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnExportAset.setBackground(new java.awt.Color(153, 153, 255));
        btnExportAset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExportAset.setText("Export Aset");
        btnExportAset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportAsetActionPerformed(evt);
            }
        });

        btnExportPeminjaman.setBackground(new java.awt.Color(204, 204, 255));
        btnExportPeminjaman.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExportPeminjaman.setText("Export Peminjaman");
        btnExportPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportPeminjamanActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("FORM LAPORAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jLabel1)
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/ikon/1.png"))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/ikon/kembali.png"))); // NOI18N
        jButton1.setText("kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnExportAset, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnExportPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnExportAset, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(btnExportPeminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportAsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportAsetActionPerformed
     String sql = "SELECT id_aset AS ID, nama_aset AS Nama, kategori AS Kategori, status AS Status FROM tbl_aset";
    String[] options = {"Excel (.xls)", "PDF (Print)"};
    int choice = JOptionPane.showOptionDialog(this, "Pilih Format Laporan:", "Export Aset",
                 JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

    if (choice == 0) {
        exportToExcel(sql, "Laporan_Aset");
    } else if (choice == 1) {
        exportToPDF(sql, "LAPORAN DATA ASET");
    }
    }//GEN-LAST:event_btnExportAsetActionPerformed

    private void btnExportPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportPeminjamanActionPerformed
       String sql = "SELECT p.id_peminjaman AS ID, a.nama_aset AS Aset, pg.nama_pegawai AS Pegawai, "
               + "p.tgl_pinjam AS 'Tgl Pinjam', p.status AS Status "
               + "FROM tbl_peminjaman p "
               + "JOIN tbl_aset a ON p.id_aset = a.id_aset "
               + "JOIN tbl_pegawai pg ON p.id_pegawai = pg.id_pegawai";
               
    String[] options = {"Excel (.xls)", "PDF (Print)"};
    int choice = JOptionPane.showOptionDialog(this, "Pilih Format Laporan:", "Export Peminjaman",
                 JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

    if (choice == 0) {
        exportToExcel(sql, "Laporan_Peminjaman");
    } else if (choice == 1) {
        exportToPDF(sql, "LAPORAN PEMINJAMAN ASET");
    }
    }//GEN-LAST:event_btnExportPeminjamanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportAset;
    private javax.swing.JButton btnExportPeminjaman;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
