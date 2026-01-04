package form;

import javax.swing.*;

public class Main extends JFrame {

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("APLIKASI INVENTARIS ASET");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        btnLaporan.setText("Laporan");
        btnLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaporanActionPerformed(evt);
            }
        });
        getContentPane().add(btnLaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 260, -1));

        btnMasterAset.setText("Master Aset");
        btnMasterAset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterAsetActionPerformed(evt);
            }
        });
        getContentPane().add(btnMasterAset, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 260, -1));

        btnMasterPegawai.setText("Master Pegawai");
        btnMasterPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterPegawaiActionPerformed(evt);
            }
        });
        getContentPane().add(btnMasterPegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 260, -1));

        btnTransaksi.setText("Transaksi");
        btnTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaksiActionPerformed(evt);
            }
        });
        getContentPane().add(btnTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 260, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMasterAsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterAsetActionPerformed
        FormMasterAset asetFrame = new FormMasterAset();
        asetFrame.setVisible(true);
    }//GEN-LAST:event_btnMasterAsetActionPerformed

    private void btnMasterPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterPegawaiActionPerformed
        FormMasterPegawai pegawaiFrame = new FormMasterPegawai();
        pegawaiFrame.setVisible(true);
    }//GEN-LAST:event_btnMasterPegawaiActionPerformed

    private void btnTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaksiActionPerformed
        FormTransaksi transaksiFrame = new FormTransaksi();
        transaksiFrame.setVisible(true);
    }//GEN-LAST:event_btnTransaksiActionPerformed

    private void btnLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaporanActionPerformed
        FormLaporan laporanFrame = new FormLaporan();
        laporanFrame.setVisible(true);
    }//GEN-LAST:event_btnLaporanActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLaporan;
    private javax.swing.JButton btnMasterAset;
    private javax.swing.JButton btnMasterPegawai;
    private javax.swing.JButton btnTransaksi;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
