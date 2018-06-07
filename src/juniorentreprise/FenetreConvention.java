/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juniorentreprise;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
//connexion BDD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//edition de documents
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;

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
        //Paramètrage du champ date d'édition
        LocalDate dateActuelle = LocalDate.now();
        dtPickDateEdition.setDate(Date.from(dateActuelle.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        //Paramètrage du champ de prix avec valeur minimale
        SpinnerModel spinPrixModel = new SpinnerNumberModel(0.0, 0.0, 999999.0, 1.0);
        //NB: pour enter des valeurs décimales en France, bien utiliser les , et non les .
        spinMontant.setModel(spinPrixModel);
        
        //Remplissage des combobox avec les valeurs de la BDD
        Connection con = null;
        Statement stmt = null;
        ResultSet resultat = null;
        try {
            //Ouverture de la connexion, initialisation d'un Statement, initialisation d'un ResultSet, etc.
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://iutdoua-web.univ-lyon1.fr:3306/p1702775", "p1702775", "296054");
            stmt=(Statement)con.createStatement();
            String request = "SELECT NomEtudiant, Prenom FROM Etudiant";
            
            /* Exécution d'une requête de lecture */
            resultat =  stmt.executeQuery(request);//query pour des requetes SELECT
            
            //String[] nomsEtudiants = (String[]) resultat.getArray("nomEtudiant").getArray(); NOT SUPORTED
            //will have to go through row by row, assign the value like in dashboad and add to an array of Strings
            //Iterator itrNomsEtu = nomsEtudiants.iterator();
            resultat.first();
            DefaultComboBoxModel modCbbEtu = new DefaultComboBoxModel();
            while(!resultat.isAfterLast()){
                modCbbEtu.addElement(resultat.getString("NomEtudiant").toUpperCase() +" "+ resultat.getString("Prenom"));
                resultat.next();
            }
            cbbEtu.setModel(modCbbEtu);
            
            //Entreprises
            Statement stmtEnt=(Statement)con.createStatement();
            String requestEnt = "SELECT NomEntreprise FROM Entreprise";

            /* Exécution d'une requête de lecture */
            resultat =  stmtEnt.executeQuery(requestEnt);//query pour des requetes SELECT
            
            DefaultComboBoxModel modCbbEnt = new DefaultComboBoxModel();
            resultat.first();
            while(!resultat.isAfterLast()){
                modCbbEnt.addElement(resultat.getString("NomEntreprise"));
                resultat.next();
            }
            cbbEnt.setModel(modCbbEnt);
            

            /* Traiter ici les valeurs récupérées. */
        } catch ( ClassNotFoundException | SQLException e ) {
            JOptionPane.showMessageDialog(null, e.getMessage() ,"Georges", 1);
        } finally {
            if ( resultat != null ) {
                try {
                    /* On commence par fermer le ResultSet */
                    resultat.close();
                } catch ( SQLException ignore ) {
                    JOptionPane.showMessageDialog(null, ignore.getMessage() ,"Error", 1);
                }
            }
            if ( stmt != null ) {
                try {
                    /* Puis on ferme le Statement */
                    stmt.close();
                } catch ( SQLException ignore ) {
                    JOptionPane.showMessageDialog(null, ignore.getMessage() ,"Error", 1);
                }
            }
            if ( con != null ) {
                try {
                    /* Et enfin on ferme la connexion */
                    con.close();
                } catch ( SQLException ignore ) {
                    JOptionPane.showMessageDialog(null, ignore.getMessage() ,"Error", 1);
                }
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogo = new javax.swing.JPanel();
        logoJE = new javax.swing.JLabel();
        pnlElementsConvention = new javax.swing.JPanel();
        lblTitre = new javax.swing.JLabel();
        lblNomEtu = new javax.swing.JLabel();
        cbbEtu = new javax.swing.JComboBox<>();
        lblNomEnt = new javax.swing.JLabel();
        cbbEnt = new javax.swing.JComboBox<>();
        lblDateEdition = new javax.swing.JLabel();
        lblDateDebut = new javax.swing.JLabel();
        lblDateFin = new javax.swing.JLabel();
        lblMontant = new javax.swing.JLabel();
        spinMontant = new javax.swing.JSpinner();
        sepHautDePage = new javax.swing.JSeparator();
        pnlBoutons = new javax.swing.JPanel();
        btnMod = new javax.swing.JButton();
        btnGen = new javax.swing.JButton();
        lblEuro = new javax.swing.JLabel();
        dtPickDateEdition = new org.jdesktop.swingx.JXDatePicker();
        dtPickDateDebut = new org.jdesktop.swingx.JXDatePicker();
        dtPickDateFin = new org.jdesktop.swingx.JXDatePicker();
        tfNomProjet = new javax.swing.JTextField();
        lblNomProjet = new javax.swing.JLabel();
        lblTacheProjet = new javax.swing.JLabel();
        tfTacheProjet = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logoJE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/JE_logo.png"))); // NOI18N

        javax.swing.GroupLayout pnlLogoLayout = new javax.swing.GroupLayout(pnlLogo);
        pnlLogo.setLayout(pnlLogoLayout);
        pnlLogoLayout.setHorizontalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoJE, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlLogoLayout.setVerticalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoJE, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTitre.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
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

        lblDateEdition.setText("Date d'édition");

        lblDateDebut.setText("Date de début");

        lblDateFin.setText("Date de fin");

        lblMontant.setText("Montant");

        spinMontant.setOpaque(false);

        btnMod.setText("<html>Modifier Texte <br>\nManuellement\n</html>");

        btnGen.setText("Générer PDF");
        btnGen.setToolTipText("");
        btnGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBoutonsLayout = new javax.swing.GroupLayout(pnlBoutons);
        pnlBoutons.setLayout(pnlBoutonsLayout);
        pnlBoutonsLayout.setHorizontalGroup(
            pnlBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBoutonsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnGen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        pnlBoutonsLayout.setVerticalGroup(
            pnlBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBoutonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGen, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblEuro.setText("€");

        tfNomProjet.setToolTipText("Nom du projet");

        lblNomProjet.setText("Saisir le nom du projet");

        lblTacheProjet.setText("Tâche à accomplir");

        tfTacheProjet.setToolTipText("Saisir la tâche que l'étutiant devra accomplir au cours de la mission");

        javax.swing.GroupLayout pnlElementsConventionLayout = new javax.swing.GroupLayout(pnlElementsConvention);
        pnlElementsConvention.setLayout(pnlElementsConventionLayout);
        pnlElementsConventionLayout.setHorizontalGroup(
            pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sepHautDePage)
            .addGroup(pnlElementsConventionLayout.createSequentialGroup()
                .addComponent(lblTitre)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlElementsConventionLayout.createSequentialGroup()
                .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlElementsConventionLayout.createSequentialGroup()
                        .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDateEdition, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNomProjet)
                            .addComponent(lblNomEtu, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTacheProjet))
                        .addGap(18, 18, 18)
                        .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfNomProjet, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(tfTacheProjet))
                            .addGroup(pnlElementsConventionLayout.createSequentialGroup()
                                .addComponent(cbbEtu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(145, 145, 145)
                                .addComponent(lblNomEnt)
                                .addGap(18, 18, 18)
                                .addComponent(cbbEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlElementsConventionLayout.createSequentialGroup()
                        .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblMontant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDateFin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDateDebut, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dtPickDateFin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dtPickDateDebut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dtPickDateEdition, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinMontant))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEuro))
                    .addComponent(pnlBoutons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        pnlElementsConventionLayout.setVerticalGroup(
            pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlElementsConventionLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblTitre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepHautDePage, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomEtu)
                    .addComponent(lblNomEnt)
                    .addComponent(cbbEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbEtu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNomProjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomProjet))
                .addGap(18, 18, 18)
                .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTacheProjet)
                    .addComponent(tfTacheProjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(pnlElementsConventionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDateEdition)
                    .addComponent(dtPickDateEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(51, 51, 51)
                .addComponent(pnlBoutons, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlElementsConvention, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlElementsConvention, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenActionPerformed
        // Verification que toutes les informations sont saisies et cohérnetes
        if(cbbEtu.getSelectedItem() == null){
            JOptionPane.showMessageDialog(this, "Aucun étudiant sélectionné", "Erreur : Manque d'informations", JOptionPane.ERROR_MESSAGE);
        }
        else if(cbbEnt.getSelectedItem() == null){
            JOptionPane.showMessageDialog(this, "Aucune entreprise sélectionnée", "Erreur : Manque d'informations", JOptionPane.ERROR_MESSAGE);
        }
        else if(tfNomProjet.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Aucun nom de projet défini", "Erreur : Manque d'informations", JOptionPane.ERROR_MESSAGE);
        }
        else if(tfTacheProjet.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Aucune tâche définie pour l'étudiant dans ce projet", "Erreur : Manque d'informations", JOptionPane.ERROR_MESSAGE);
        }
        else if(dtPickDateEdition.getDate() ==(null)){
            JOptionPane.showMessageDialog(this, "Date du Jour non sélectionnée", "Erreur : Manque d'informations", JOptionPane.ERROR_MESSAGE);
        }
        else if((dtPickDateDebut.getDate() == null)){
            JOptionPane.showMessageDialog(this, "Date de début non sélectionnée", "Erreur : Manque d'informations", JOptionPane.ERROR_MESSAGE);
        }
        else if(dtPickDateFin.getDate() == null){
            JOptionPane.showMessageDialog(this, "Date de fin non sélectionnée", "Erreur : Manque d'informations", JOptionPane.ERROR_MESSAGE);
        }
        else if(dtPickDateDebut.getDate().before(dtPickDateEdition.getDate())){
            JOptionPane.showMessageDialog(this, "Date de début programmée avant Date du jour", "Erreur : Informations incompatibles", JOptionPane.ERROR_MESSAGE);
        }
        else if(dtPickDateFin.getDate().before(dtPickDateEdition.getDate())){
            JOptionPane.showMessageDialog(this, "Date de fin programmée avant Date du jour", "Erreur : Informations incompatibles", JOptionPane.ERROR_MESSAGE);
        }
        else if(dtPickDateDebut.getDate().after(dtPickDateFin.getDate())){
            JOptionPane.showMessageDialog(this, "Date de fin programmée avant Date de début", "Erreur : Informations incompatibles", JOptionPane.ERROR_MESSAGE);
        }
        else if(Float.parseFloat(spinMontant.getValue().toString()) < 0){
            JOptionPane.showMessageDialog(this, "Le montant ne peut pas être négatif", "Erreur : Informations incompatibles", JOptionPane.ERROR_MESSAGE);
        }
        else if(tfNomProjet.getText().matches("[\\P{L}]+")){
            JOptionPane.showMessageDialog(this, "Le nom du projet ne doit contenir que des lettres", "Erreur : Informations incompatibles", JOptionPane.ERROR_MESSAGE);
        }
        else{
            //creation du document dans un emplacement choisi par l'utilisateur
            final JFileChooser fcSauvegardeConvention = new JFileChooser();
            fcSauvegardeConvention.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            String emplacementSauvegarde = (fcSauvegardeConvention.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) ? fcSauvegardeConvention.getSelectedFile().toString() : null ;
            Document docConvention = new Document();
            try {
                try {
                    if(emplacementSauvegarde != null){
                        PdfWriter.getInstance(docConvention, new FileOutputStream(new File(emplacementSauvegarde, "Convention"+cbbEnt.getSelectedItem().toString().replaceAll("\\s", "")+cbbEtu.getSelectedItem().toString().replaceAll("\\s", "")+".pdf")));
                        JOptionPane.showMessageDialog(this, "Votre convention à été sauvegardée dans le dossier\n"+emplacementSauvegarde, "Sauvegarde réussie ! ", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Aucun dossier sélectionné", "Erreur : Manque d'informations", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (DocumentException ex) {
                    Logger.getLogger(FenetreConvention.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FenetreConvention.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //edition du contenu du document
            docConvention.open();
            //création d'une table pour gérer les positions sur la page
            PdfPTable tableDisplay = new PdfPTable(3);
            tableDisplay.setWidthPercentage(100);
            //ligne vide de référence
            PdfPCell cellLargeurTrois = getCell(" ", PdfPCell.ALIGN_CENTER);
            cellLargeurTrois.setColspan(3);
            cellLargeurTrois.setMinimumHeight(20f);
            //1ère ligne
            tableDisplay.addCell(getCell(dtPickDateEdition.getDate().toString(), PdfPCell.ALIGN_LEFT));
            tableDisplay.addCell(getCell("", PdfPCell.ALIGN_CENTER));
            tableDisplay.addCell(getCell("", PdfPCell.ALIGN_RIGHT));
            //quelqeues lignes vides
            tableDisplay.addCell(cellLargeurTrois);
            tableDisplay.addCell(cellLargeurTrois);
            tableDisplay.addCell(cellLargeurTrois);
            //deuxième ligne
            tableDisplay.addCell(getCell("", PdfPCell.ALIGN_LEFT));
            tableDisplay.addCell(getCell("Convention avec l'entreprise "+cbbEnt.getSelectedItem().toString().trim(), PdfPCell.ALIGN_JUSTIFIED));
            tableDisplay.addCell(getCell("", PdfPCell.ALIGN_RIGHT));
            //quelques lignes (vides)
            tableDisplay.addCell(cellLargeurTrois);
            tableDisplay.addCell(cellLargeurTrois);
            tableDisplay.addCell(cellLargeurTrois);
            tableDisplay.addCell(cellLargeurTrois);
            tableDisplay.addCell(cellLargeurTrois);
            
            
            PdfPCell cellCorps = getCell("Convention avec l'entreprise "+cbbEnt.getSelectedItem().toString().trim()+" éditée le "+dtPickDateEdition.getDate()+".\n\nDans le cadre du projet \""+tfNomProjet.getText().trim()+"\", l'étudiant "+cbbEtu.getSelectedItem().toString()+" s'engage à accomplir la tâche de \""+tfTacheProjet.getText().trim()+"\", à partir du :"+dtPickDateDebut.getDate()+", avec une livraison prévue au "+dtPickDateFin.getDate()+". Cette tâche sera facturée "+String.format("%.2f", spinMontant.getValue())+" €." , PdfPCell.ALIGN_JUSTIFIED);
            cellCorps.setColspan(3);
            cellCorps.setNoWrap(false);
            tableDisplay.addCell(cellCorps);
            //quelques lignes (vides)
            tableDisplay.addCell(cellLargeurTrois);
            tableDisplay.addCell(cellLargeurTrois);
            tableDisplay.addCell(cellLargeurTrois);
            tableDisplay.addCell(cellLargeurTrois);
            tableDisplay.addCell(cellLargeurTrois);
            tableDisplay.addCell(cellLargeurTrois);
            tableDisplay.addCell(cellLargeurTrois);
            tableDisplay.addCell(cellLargeurTrois);
            tableDisplay.addCell(cellLargeurTrois);
            //ligne de signatures
            tableDisplay.addCell(getCell("Signature de l'entreprise "+cbbEnt.getSelectedItem().toString(), PdfPCell.ALIGN_LEFT));
            tableDisplay.addCell(getCell("", PdfPCell.ALIGN_CENTER));
            tableDisplay.addCell(getCell("Signature de l'étudiant "+cbbEtu.getSelectedItem().toString(), PdfPCell.ALIGN_RIGHT));
            
            try {
                docConvention.add(tableDisplay);
            } catch (DocumentException ex) {
                Logger.getLogger(FenetreConvention.class.getName()).log(Level.SEVERE, null, ex);
            }
            docConvention.close();
            
        }
            
    }//GEN-LAST:event_btnGenActionPerformed

    private void cbbEtuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbEtuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbEtuActionPerformed

    public PdfPCell getCell(String text, int alignment) {
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreConvention.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
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
    private org.jdesktop.swingx.JXDatePicker dtPickDateEdition;
    private org.jdesktop.swingx.JXDatePicker dtPickDateFin;
    private javax.swing.JLabel lblDateDebut;
    private javax.swing.JLabel lblDateEdition;
    private javax.swing.JLabel lblDateFin;
    private javax.swing.JLabel lblEuro;
    private javax.swing.JLabel lblMontant;
    private javax.swing.JLabel lblNomEnt;
    private javax.swing.JLabel lblNomEtu;
    private javax.swing.JLabel lblNomProjet;
    private javax.swing.JLabel lblTacheProjet;
    private javax.swing.JLabel lblTitre;
    private javax.swing.JLabel logoJE;
    private javax.swing.JPanel pnlBoutons;
    private javax.swing.JPanel pnlElementsConvention;
    private javax.swing.JPanel pnlLogo;
    private javax.swing.JSeparator sepHautDePage;
    private javax.swing.JSpinner spinMontant;
    private javax.swing.JTextField tfNomProjet;
    private javax.swing.JTextField tfTacheProjet;
    // End of variables declaration//GEN-END:variables
}
