package form;

import javax.swing.*;

public class Main extends JFrame {
     // Simpan frame global agar tidak dobel
    private FormMasterAset asetFrame;
    private FormMasterPegawai pegawaiFrame;
    private FormTransaksi transaksiFrame;
    private FormLaporan laporanFrame;

    public Main() {
        initComponents();
        setTitle("APLIKASI INVENTARIS ASET");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnLaporan = new javax.swing.JButton();
        btnMasterAset = new javax.swing.JButton();
        btnMasterPegawai = new javax.swing.JButton();
        btnTransaksi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("APLIKASI INVENTARIS ASET");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        btnLaporan.setBackground(new java.awt.Color(204, 204, 255));
        btnLaporan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLaporan.setText("Laporan");
        btnLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaporanActionPerformed(evt);
            }
        });
        getContentPane().add(btnLaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 260, 40));

        btnMasterAset.setBackground(new java.awt.Color(153, 153, 255));
        btnMasterAset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMasterAset.setText("Master Aset");
        btnMasterAset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterAsetActionPerformed(evt);
            }
        });
        getContentPane().add(btnMasterAset, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 260, 40));

        btnMasterPegawai.setBackground(new java.awt.Color(153, 153, 255));
        btnMasterPegawai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMasterPegawai.setText("Master Pegawai");
        btnMasterPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterPegawaiActionPerformed(evt);
            }
        });
        getContentPane().add(btnMasterPegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 260, 40));

        btnTransaksi.setBackground(new java.awt.Color(204, 204, 255));
        btnTransaksi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnTransaksi.setText("Transaksi");
        btnTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaksiActionPerformed(evt);
            }
        });
        getContentPane().add(btnTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 260, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/ikon/5.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 150, 160));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMasterAsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterAsetActionPerformed
          if (asetFrame == null || !asetFrame.isDisplayable()) {
        asetFrame = new FormMasterAset();
    }
    asetFrame.setVisible(true);
    asetFrame.toFront();
    asetFrame.requestFocus();
    }//GEN-LAST:event_btnMasterAsetActionPerformed

    private void btnMasterPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterPegawaiActionPerformed
      if (pegawaiFrame == null || !pegawaiFrame.isDisplayable()) {
        pegawaiFrame = new FormMasterPegawai();
    }
    pegawaiFrame.setVisible(true);
    pegawaiFrame.toFront();
    pegawaiFrame.requestFocus();
    }//GEN-LAST:event_btnMasterPegawaiActionPerformed

    private void btnTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaksiActionPerformed
                                                  
    if (transaksiFrame == null || !transaksiFrame.isDisplayable()) {
        transaksiFrame = new FormTransaksi();
    }
    transaksiFrame.setVisible(true);
    transaksiFrame.toFront();
    transaksiFrame.requestFocus();
    }//GEN-LAST:event_btnTransaksiActionPerformed

    private void btnLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaporanActionPerformed
        if (laporanFrame == null || !laporanFrame.isDisplayable()) {
        laporanFrame = new FormLaporan();
    }
    laporanFrame.setVisible(true);
    laporanFrame.toFront();
    laporanFrame.requestFocus();
    }//GEN-LAST:event_btnLaporanActionPerformed

   
    // ===================== MAIN METHOD =====================
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> new Main().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLaporan;
    private javax.swing.JButton btnMasterAset;
    private javax.swing.JButton btnMasterPegawai;
    private javax.swing.JButton btnTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
