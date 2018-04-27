package juniorentreprise;


import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arthur
 */
public class FenetreAccueil extends JFrame {

    private JLabel labelEC, labelNom, labelPrenom, labelAn, labelLoisir, labelComm, labelIcon;
    private JComboBox comboBoxEC;
    private JTextField textN, textP;
    private JRadioButton radio1A, radio2A;
    private JCheckBox cbCine, cbSport, cbLecture;
    private JTextArea textArea;
    private JButton boutonAjout, boutonModif, boutonSuppr;
    private final String[] ECStrings = { "", "M.", "Mme"}; //tableau de caractère avec le contenu de comboBoxEC
    private JPanel c, pann1, pann2, pann3, pann4, pann5, pann6; //un panneau par ligne
    
    //Constructeur par défaut
    public FenetreAccueil (){
        this.initComponents(); //appel de la fonction
    }
    
    //Constructeur ou on choisit le nom de la fenêtre
    public FenetreAccueil(String nomFenetre){
        this.initComponents(); //appel de la fonction
        this.setTitle(nomFenetre);
    }
    
    private void initComponents(){
        //Création des composants
        labelEC = new JLabel("Etat Civil : ");
        labelNom = new JLabel("Nom : ");
        labelPrenom = new JLabel("Prénom : ");
        labelAn = new JLabel("Année : ");
        labelLoisir = new JLabel("Loisirs : ");
        labelComm = new JLabel("Commentaire : ");
        comboBoxEC = new JComboBox (ECStrings);
        /* ou
        add.item(...
        */
        textN = new JTextField("",8);
        textP = new JTextField("",8);
        radio1A = new JRadioButton("1A", true); //coche par défaut
        radio2A = new JRadioButton("2A");
        //Q3 : on ajoute chaque bouton radio dans un même groupe pour qu'ils soient liés 
        ButtonGroup group = new ButtonGroup();
        group.add(radio1A);
        group.add(radio2A);
        cbCine = new JCheckBox("Cinéma");
        cbSport = new JCheckBox("Sport");
        cbLecture = new JCheckBox("Lecture");
        //Q3 : construction d'une zone de texte 5 lignes et 18 colonnes
        textArea = new JTextArea("Saisir votre commentaire", 5, 18);
        boutonAjout = new JButton("Ajouter");
        boutonModif = new JButton("Modifier");
        boutonSuppr = new JButton("Supprimer");
        // Ajout d'une image et changement de sa taille
        ImageIcon userIcon = new ImageIcon("user-icon.png"); // dossier courant = le projet JuniorEntreprise
        Image image = userIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        userIcon = new ImageIcon(newimg);  // transform it back
        labelIcon = new JLabel(userIcon); 
        
        
        //Choix du conteneur : grille de 6 lignes, 1 colonne
        c =(JPanel) getContentPane();
        //c.setLayout( new GridLayout(6,1,10,10));
        c.setLayout(new BoxLayout(c, BoxLayout.PAGE_AXIS)); //suite de boites suivant la hauteur de la page
        
        //On arrête le processus quand on ferme le programme avec EXIT_ON_CLOSE
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //On définit le titre de la fenêtre
        this.setTitle("Etudiant");
        
        definePanel();
        // ajout des panneaux au conteneur ContentPane
        c.add(pann1);
        c.add(pann2);
        c.add(pann3);
        c.add(pann4);
        c.add(pann5);
        c.add(pann6);
        
    }

    private void definePanel() {
        //définition de la disposition générale de la fenêtre
        LayoutManager FlowLayout1 = new FlowLayout(FlowLayout.LEFT);
        LayoutManager FlowLayout2 = new FlowLayout(FlowLayout.CENTER,20,30);
        
        pann1 = new JPanel(FlowLayout2);
        pann2 = new JPanel(FlowLayout1);
        pann3 = new JPanel(FlowLayout1);
        pann4 = new JPanel(FlowLayout1);
        pann5 = new JPanel(FlowLayout1);
        pann6 = new JPanel(FlowLayout2);
        
        //Ajout des composants à chaque panneau
        pann1.add(labelIcon);
        pann1.add(labelEC);
        pann1.add(comboBoxEC);
        pann2.add(labelNom);
        pann2.add(textN);
        pann2.add(labelPrenom);
        pann2.add(textP);
        pann3.add(labelAn);
        pann3.add(radio1A);
        pann3.add(radio2A);
        pann4.add(labelLoisir);
        pann4.add(cbCine);
        pann4.add(cbSport);
        pann4.add(cbLecture);
        pann5.add(labelComm);
        pann5.add(textArea);
        pann6.add(boutonSuppr);
        pann6.add(boutonModif);
        pann6.add(boutonAjout);
    }
}