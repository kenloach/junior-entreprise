/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juniorentreprise;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author David
 */
public class WriteFile {
    private final String path;
    
    
    public WriteFile(String path){
        this.path = path;
    }
    
    public void writeToFile(String texte) throws IOException{
        FileWriter write = new FileWriter(path, false);//false car on veut toujours créer un nouveau fichier
        try (PrintWriter printText = new PrintWriter(write)) {
            printText.printf("%s" + "%n", texte);
        }
    }
}
