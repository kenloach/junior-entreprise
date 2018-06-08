/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juniorentreprise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import javax.swing.*;
/**
 *
 * @author 
 */
public class menuConnexionStartProgramme extends javax.swing.JFrame {
    
    
    /**
     * Creates new form menuConnexionStartProgramme
     */
    public menuConnexionStartProgramme() {
        initComponents();
        this.getRootPane().setDefaultButton(bt_Connexion);
    }
    

    
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXLoginPaneMain = new org.jdesktop.swingx.JXLoginPane();
        bt_Connexion = new javax.swing.JButton();
        bt_Exit = new javax.swing.JButton();
        bt_Contact = new javax.swing.JButton();
        lbl_Contact = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bt_Connexion.setText("Connexion");
        bt_Connexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ConnexionActionPerformed(evt);
            }
        });

        bt_Exit.setText("Quitter");
        bt_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ExitActionPerformed(evt);
            }
        });

        bt_Contact.setText("Contact");
        bt_Contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ContactActionPerformed(evt);
            }
        });

        lbl_Contact.setText("Mot de passe oublié ?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jXLoginPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_Contact, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_Contact)
                                .addGap(45, 45, 45))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(bt_Connexion)
                        .addGap(40, 40, 40)
                        .addComponent(bt_Exit)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jXLoginPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Exit)
                    .addComponent(bt_Connexion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Contact, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_Contact))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Methode pour vérifier si email est valide
    
    public static boolean isValid(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    
    private void bt_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bt_ExitActionPerformed

    private void bt_ConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ConnexionActionPerformed
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            //Ouverture de la connexion, initialisation d'un Statement, initialisation d'un ResultSet, etc.
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://iutdoua-web.univ-lyon1.fr:3306/p1702775", "p1702775", "296054");
            
            String nomCon = jXLoginPaneMain.getUserName();
            String passCon = String.valueOf(jXLoginPaneMain.getPassword());
            PreparedStatement stmt=con.prepareStatement("SELECT * FROM MembreJE WHERE login=? AND password=?");
            stmt.setString(1, nomCon);
            stmt.setString(2, passCon);
            
            /* Exécution d'une requête de lecture */
            resultat =  stmt.executeQuery();//query pour des requetes SELECT
            if(resultat.next())
            {
                int idUtilisateur = resultat.getInt( "id" );
                String emailUtilisateur = resultat.getString( "email" );
                String motDePasseUtilisateur = resultat.getString( "password" );
                String nomUtilisateur = resultat.getString( "nom" );
                System.out.println("Données retournées par la requête : id = " + idUtilisateur + ", email = " + emailUtilisateur
                    + ", motdepasse = "
                    + motDePasseUtilisateur + ", nom = " + nomUtilisateur + "." );
                this.dispose();
               Dashboard dashb = new Dashboard();
               dashb.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Identifiants invalides" ,"Erreur", 1);
            }

            /* Traiter ici les valeurs récupérées. */
        } catch ( Exception e ) {
            JOptionPane.showMessageDialog(null, "Erreur : "+e.getMessage() ,"Error", 1);
        } finally {
            if ( resultat != null ) {
                try {
                    /* On commence par fermer le ResultSet */
                    resultat.close();
                } catch ( SQLException ignore ) {
                    JOptionPane.showMessageDialog(null, "Serveur indisponible : "+ignore.getMessage() ,"Error", 1);
                }
            }
            if ( statement != null ) {
                try {
                    /* Puis on ferme le Statement */
                    statement.close();
                } catch ( SQLException ignore ) {
                    JOptionPane.showMessageDialog(null, ignore.getMessage() ,"Error", 1);
                }
            }
            if ( connexion != null ) {
                try {
                    /* Et enfin on ferme la connexion */
                    connexion.close();
                } catch ( SQLException ignore ) {
                    JOptionPane.showMessageDialog(null, ignore.getMessage() ,"Error", 1);
                }
            }
        }        
    }//GEN-LAST:event_bt_ConnexionActionPerformed

    private void bt_ContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ContactActionPerformed
       String m = JOptionPane.showInputDialog(null, "Entrez votre email : ", "");
       // Utilisation de la méthode isValid définie plus haut
       if(isValid(m)){
           JOptionPane.showMessageDialog(null,"Un email contenant les instructions pour réinitialiser votre mot de passe vous sera envoyé dans les prochaines 48h.", "Message envoyé avec succès", JOptionPane.INFORMATION_MESSAGE);
       }
       else if(!isValid(m)){
           JOptionPane.showMessageDialog(null,"Vous n'avez pas entré une adresse email valide. Veuillez recommencer.", "Erreur", JOptionPane.ERROR_MESSAGE);
       }
       else{
           JOptionPane.showMessageDialog(null,"Une erreur est apparue. Veuillez recommencer.", "Erreur", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_bt_ContactActionPerformed

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
            java.util.logging.Logger.getLogger(menuConnexionStartProgramme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuConnexionStartProgramme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuConnexionStartProgramme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuConnexionStartProgramme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuConnexionStartProgramme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Connexion;
    private javax.swing.JButton bt_Contact;
    private javax.swing.JButton bt_Exit;
    private org.jdesktop.swingx.JXLoginPane jXLoginPaneMain;
    private javax.swing.JLabel lbl_Contact;
    // End of variables declaration//GEN-END:variables
}
