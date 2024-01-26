package gestionefile;

import java.util.Scanner;
/**
 *
 * @author SO
 * @version 18/01/23
 */


public class GestioneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //1)LETTURA
        Lettore lettore = new Lettore("user.json"); //legge il file .json
        lettore.start();
        
        //2)ELABORAZIONE
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Inserisci username: "); //richiede l'username in input
        String username = scanner.nextLine();//assegna l'username letto in input alla variabile "username"
        
        System.out.print("Inserisci password: "); //richiede la password in input
        String password = scanner.nextLine(); //assegna lla password letta in input alla variabile "password"
        
        scanner.close(); // chiudi lo scanner

        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv", "copia.csv", username, password);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    }
    
}
