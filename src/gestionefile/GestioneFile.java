package gestionefile;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
        
        String nomeFile1 = "output.csv"; //assegno il file "output.csv" ad una variabile
        String nomeFile2 = "copia.csv"; //assegno il file "copia.csv" ad una variabile
        String nomeFile3 = "user.json"; //assegno il file "user.json" ad una variabile
        String nomeFile4 = "user.csv"; //assegno il file "user.csv" ad una variabile
        
        //1)LETTURA
        Lettore lettore = new Lettore("user.json"); //legge il file .json
        lettore.start();
        
        //2)ELABORAZIONE
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Inserisci username: "); //richiede l'username in input
        String username = scanner.nextLine();//assegna l'username letto in input alla variabile "username"
        
        System.out.print("Inserisci password: "); //richiede la password in input
        String password = scanner.nextLine(); //assegna la password letta in input alla variabile "password"
        
        scanner.close(); // chiudo lo scanner
                
        //3) COPIA IL CONTENUTO DEL FILE OUTPUT.CSV IN COPIA.CSV
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile1)));
            (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeFile2))) {
            String line; //legge il file riga per riga per poi copiare il contenuto nel file di destinazione
            while ((line = reader.readLine()) != null) {
                writer.write(line); 
                writer.newLine(); //aggiunge una nuova linea nel file di destinazione dopo ogni riga
        catch (IOException e) {
            e.printStackTrace();
        }            
    
        //4) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv", username, password);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
        
       //5) SCRIVERE E LEGGERE IL FILE USER.CSV CON LE STESSE INFORMAZIONI DEL FILE USER.JSON
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile3)));
            (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeFile4))) {
            String line; //legge il file riga per riga per poi copiare il contenuto nel file di destinazione
            while ((line = reader.readLine()) != null) {
                writer.write(line); 
                writer.newLine(); //aggiunge una nuova linea nel file di destinazione dopo ogni riga
            }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
