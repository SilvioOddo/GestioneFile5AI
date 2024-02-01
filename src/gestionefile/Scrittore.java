package gestionefile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SO
 * @version 18/01/23
 */

public class Scrittore implements Runnable{
    String nomeFile1;
    String username;
    String password;
    
    public Scrittore(String nomeFile1, String username, String password){
        this.nomeFile1 = nomeFile1;
        this.username = username;
        this.password = password;
    }
    
    @Override
    public void run() {
        scrivi();
    }
    /**
     * Scrive un file di testo usando la classe BufferedWriter
     */
    public void scrivi(){
        
        try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile1))) {
            // scrivo nel buffer
            br.write(username + ";" + password); 
            br.write("\n\r");
            // svuoto il buffer e salvo nel file i dati
            br.flush();         
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
