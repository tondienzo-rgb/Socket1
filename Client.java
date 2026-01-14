import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;


public class Client {

    
    public static void main(String[] args) {
      // ✅ Client cerca di connettersi al Server in ascolto sulla porta 6789
        // Un solo costrutto try-with-resources per tutte le risorse
        
        // === STABILIRE LA CONNESSIONE E INIZIALIZZARE GLI STREAM ===
        try (Socket socket = new Socket("localhost", 6789);
             BufferedReader inputStream = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             PrintWriter outputStream = new PrintWriter(
                     socket.getOutputStream(), true)) { 
            
            System.out.println("✅ Connesso al server - pronto per comunicazione");
            


            // === SEZIONE CLIENT INVIO MESSAGGIO AL SERVER ===
            String message = "Ciao, Server!";
           
	    outputStream.println(message);	
            
            System.out.println("✅ Messaggio inviato al Server: " + message);
            


            // === SEZIONE CLIENT RICEZIONE RISPOSTA DAL SERVER ===
            System.out.println("⏳ In attesa di risposta dal server...");
            
            
            String messaggioServer = inputStream.readLine();
            System.out.println("Messaggio dal server: " + messaggioServer);
		        
            System.out.println("📨 Messaggio ricevuto dal Server: " + messaggioServer);
            
            System.out.println("🎉 Comunicazione completata con successo!");
            
        } catch (IOException e) {
            System.err.println("❌ Errore durante la comunicazione: " + e.getMessage());
            e.printStackTrace();
        }
        // ✅ Risorse chiuse automaticamente (socket, outputStream, inputStream)
    }
}
