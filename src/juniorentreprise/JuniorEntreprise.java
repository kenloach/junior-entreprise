/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juniorentreprise;

import javax.swing.JFrame;

/**
 *
 * @author Arthur
 */
public class JuniorEntreprise {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame fenetre= new FenetreAccueil();
        fenetre.pack();
        // Q5 : Avec pack(), la fenêtre adapte sa taille de manière à ce que tous les composants de la fenêtre tiennent à l'intérieur.
        fenetre.setVisible(true);
        // Q9 : Le layout est très différent
        
        JFrame fenetre2= new FenetreAccueil("Junior Entreprise");
        fenetre2.pack();
        fenetre2.setVisible(true);
    }
    
}
