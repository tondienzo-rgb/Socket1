import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Server {

   
    public static void main(String[] args) {
                try (ServerSocket serverSocket = new ServerSocket(6789)) {
            
   System.out.println("🚀 Server avviato - in attesa di connessioni sulla porta 6789...");
            
            // ⏳ Il server rimane in attesa di un client
          // === STABILIRE LA CONNESSIONE E INIZIALIZZARE GLI STREAM ===
            try (Socket clientSocket = serverSocket.accept();
                 BufferedReader inputStream =  new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter outputStream = new PrintWriter(clientSocket.getOutputStream(), true)) {
                
                System.out.println("✅ Client connesso ");


                // === SEZIONE SERVER RICEZIONE MESSAGGIO DAL CLIENT ===
                System.out.println("⏳ In attesa di messaggio dal client...");
                
                String clientMessage = inputStream.readLine();
                               
	        System.out.println("📨 Messaggio ricevuto dal Client: " + clientMessage);


                // === SEZIONE SERVER INVIO RISPOSTA AL CLIENT ===
                String responseMessage = "Ciao dal server!";
                outputStream.println(responseMessage);
                
                System.out.println("✅ Risposta inviata al Client: " + responseMessage);
                System.out.println("🎉 Comunicazione con client completata!");

            } catch (IOException e) {
                System.err.println("❌ Errore nella comunicazione con il client: " + e.getMessage());
                e.printStackTrace();
            }
            // ✅ Risorse client chiuse automaticamente (clientSocket, inputStream, outputStream)
            
        } catch (IOException e) {
            System.err.println("❌ Errore nell'avvio del server: " + e.getMessage());
            e.printStackTrace();
        }
        // ✅ ServerSocket chiuso automaticamente
    }

    
    
}
