/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juniorentreprise;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author p1705387
 */
public class FenetreConvention extends javax.swing.JFrame {
    
    /**
     * Creates new form FenetreConvention
     */
    public FenetreConvention() {
        initComponents();
        LocalDate dateActuelle = LocalDate.now();
        dtPickDateDuJour.setDate(Date.from(dateActuelle.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        SpinnerModel spinPrixModel = new SpinnerNumberModel(0.0, 0.0, 999999.0, 1.0);
        spinMontant.setModel(spinPrixModel);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        pnlElementsConvention = new javax.swing.JPanel();
        logoJE = new javax.swing.JLabel();
        lblTitre = new javax.swing.JLabel();
        lblNomEtu = new javax.swing.JLabel();
        cbbEtu = new javax.swing.JComboBox<>();
        lblNomEnt = new javax.swing.JLabel();
        cbbEnt = new javax.swing.JComboBox<>();
        lblDateDuJour = new javax.swing.JLabel();
        lblDateDebut = new javax.swing.JLabel();
        lblDateFin = new javax.swing.JLabel();
        lblMontant = new javax.swing.JLabel();
        spinMontant = new javax.swing.JSpinner();
        sepHautDePage = new javax.swing.JSeparator();
        pnlBoutons = new javax.swing.JPanel();
        btnGen = new javax.swing.JButton();
        btnMod = new javax.swing.JButton();
        lblEuro = new javax.swing.JLabel();
        dtPickDateDuJour = new org.jdesktop.swingx.JXDatePicker();
        dtPickDateDebut = new org.jdesktop.swingx.JXDatePicker();
        dtPickDateFin = new org.jdesktop.swingx.JXDatePicker();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        logoJE.setText("jLabel1");

        lblTitre.setText("Edition de Convention");

        lblNomEtu.setText("Nom Etudiant");

        cbbEtu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbEtu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbEtuActionPerformed(evt);
            }
        });

        lblNomEnt.setText("Nom Entreprise");

        cbbEnt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblDateDuJour.setText("Date du jour");

        lblDateDebut.setText("Date de début");

        lblDateFin.setText("Date de fin");

        lblMontant.setText("Montant");

        btnGen.setText("Générer PDF");
        btnGen.setToolTipText("");
        btnGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenActionPerformed(evt);
            }
        });

        btnMod.setText("<html>Modifier Texte <br>\nManuellement\n</html>");

        javax.swing.GroupLayout pnlBoutonsLayout = new javax.swing.GroupLayout(pnlBoutons);
        pnlBoutons.setLayout(pnlBoutonsLayout);
        pnlBoutonsLayout.setHorizontalGroup(
            pnlBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBoutonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnlBoutonsLayout.setVerticalGroup(
            pnlBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBoutonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGen)
                .addGap(41, 41, 41))
        );

        lblEuro.setText("€");

        javax.swing.GroupLayout pnlElementsConventionLayout = new javax.swing.GroupLayout(pnlElementsConvention);
        pnlElementsConvention.setLayout(pnlElementsConventionLayout);
        pnlElementsConventionLayout.setHorizontalGroup(
            pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlElementsConventionLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(logoJE, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlElementsConventionLayout.createSequentialGroup()
                .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlElementsConventionLayout.createSequentialGroup()
                        .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblMontant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDateFin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDateDebut, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlElementsConventionLayout.createSequentialGroup()
                                .addComponent(spinMontant)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblEuro)
                                .addGap(84, 84, 84))
                            .addGroup(pnlElementsConventionLayout.createSequentialGroup()
                                .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dtPickDateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dtPickDateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnlElementsConventionLayout.createSequentialGroup()
                        .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlElementsConventionLayout.createSequentialGroup()
                                .addComponent(lblNomEtu, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbEtu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlElementsConventionLayout.createSequentialGroup()
                                .addComponent(lblDateDuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dtPickDateDuJour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 107, Short.MAX_VALUE)))
                .addGap(40, 40, 40)
                .addComponent(lblNomEnt)
                .addGap(18, 18, 18)
                .addComponent(cbbEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(pnlBoutons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(sepHautDePage)
        );
        pnlElementsConventionLayout.setVerticalGroup(
            pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlElementsConventionLayout.createSequentialGroup()
                .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoJE, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepHautDePage, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlElementsConventionLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(pnlBoutons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlElementsConventionLayout.createSequentialGroup()
                        .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlElementsConventionLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNomEtu)
                                    .addComponent(lblNomEnt)
                                    .addComponent(cbbEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlElementsConventionLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbEtu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDateDuJour)
                            .addComponent(dtPickDateDuJour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDateDebut)
                            .addComponent(dtPickDateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDateFin)
                            .addComponent(dtPickDateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMontant)
                            .addComponent(spinMontant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEuro))
                        .addContainerGap(399, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlElementsConvention, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlElementsConvention, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbEtuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbEtuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbEtuActionPerformed

    private void btnGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenActionPerformed
        // TODO add your handling code here:
        if(cbbEtu.getSelectedItem() == null){
            JOptionPane.showMessageDialog(this, "Aucun étudiant sélectionné", "Erreur : Manque d'informations", JOptionPane.ERROR_MESSAGE);
        }
        else if(cbbEnt.getSelectedItem() == null){
            JOptionPane.showMessageDialog(this, "Aucune entreprise sélectionnée", "Erreur : Manque d'informations", JOptionPane.ERROR_MESSAGE);
        }
        else if(dtPickDateDuJour.getDate() ==(null)){
            JOptionPane.showMessageDialog(this, "Date du Jour non sélectionnée", "Erreur : Manque d'informations", JOptionPane.ERROR_MESSAGE);
        }
        else if((dtPickDateDebut.getDate() == null)){
            JOptionPane.showMessageDialog(this, "Date de début non sélectionnée", "Erreur : Manque d'informations", JOptionPane.ERROR_MESSAGE);
        }
        else if(dtPickDateFin.getDate() == null){
            JOptionPane.showMessageDialog(this, "Date de fin non sélectionnée", "Erreur : Manque d'informations", JOptionPane.ERROR_MESSAGE);
        }
        else if(dtPickDateDebut.getDate().before(dtPickDateDuJour.getDate())){
            JOptionPane.showMessageDialog(this, "Date de début programmée avant Date du jour", "Erreur : Informations incompatibles", JOptionPane.ERROR_MESSAGE);
        }
        else if(dtPickDateFin.getDate().before(dtPickDateDuJour.getDate())){
            JOptionPane.showMessageDialog(this, "Date de fin programmée avant Date du jour", "Erreur : Informations incompatibles", JOptionPane.ERROR_MESSAGE);
        }
        else if(dtPickDateDebut.getDate().after(dtPickDateFin.getDate())){
            JOptionPane.showMessageDialog(this, "Date de fin programmée avant Date de début", "Erreur : Informations incompatibles", JOptionPane.ERROR_MESSAGE);
        }
        else if(Float.parseFloat(spinMontant.getValue().toString()) < 0){
            JOptionPane.showMessageDialog(this, "Le montant ne peut pas être négatif", "Erreur : Informations incompatibles", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnGenActionPerformed

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
            java.util.logging.Logger.getLogger(FenetreConvention.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreConvention.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreConvention.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreConvention.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetreConvention().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGen;
    private javax.swing.JButton btnMod;
    private javax.swing.JComboBox<String> cbbEnt;
    private javax.swing.JComboBox<String> cbbEtu;
    private org.jdesktop.swingx.JXDatePicker dtPickDateDebut;
    private org.jdesktop.swingx.JXDatePicker dtPickDateDuJour;
    private org.jdesktop.swingx.JXDatePicker dtPickDateFin;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDateDebut;
    private javax.swing.JLabel lblDateDuJour;
    private javax.swing.JLabel lblDateFin;
    private javax.swing.JLabel lblEuro;
    private javax.swing.JLabel lblMontant;
    private javax.swing.JLabel lblNomEnt;
    private javax.swing.JLabel lblNomEtu;
    private javax.swing.JLabel lblTitre;
    private javax.swing.JLabel logoJE;
    private javax.swing.JPanel pnlBoutons;
    private javax.swing.JPanel pnlElementsConvention;
    private javax.swing.JSeparator sepHautDePage;
    private javax.swing.JSpinner spinMontant;
    // End of variables declaration//GEN-END:variables
}
