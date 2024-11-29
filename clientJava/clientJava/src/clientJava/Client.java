package clientJava;
import java.io.*;
import java.net.*;

public class Client {

	public static void main(String[] args) {
		String serverAddress = "127.0.0.1"; // IP del server
        int port = 12345; // Porta del server
        
        try {
            // Crea un socket per connettersi al server
            Socket socket = new Socket(serverAddress, port);
            
            // Flussi di input e output per comunicare con il server
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            
            // Scrittore per inviare i dati al server
            PrintWriter writer = new PrintWriter(outputStream, true);
            
            // Lettore per leggere la risposta dal server
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            
            // Crea un oggetto BufferedReader per leggere input da riga di comando
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            
            String messageToSend;
            System.out.println("Scrivi un messaggio da inviare al server (digita 'exit' per uscire):");
            
            while (true) {
                // Legge un messaggio dalla riga di comando
                messageToSend = consoleReader.readLine();
                
                // Se l'utente digita 'exit', esce dal ciclo e chiude la connessione
                if (messageToSend.equalsIgnoreCase("exit")) {
                    System.out.println("Chiusura della connessione.");
                    break;
                }

                // Invia il messaggio al server
                writer.println(messageToSend);
                System.out.println("Messaggio inviato al server: " + messageToSend);
                
                // Legge la risposta del server
                String serverResponse = reader.readLine();
                System.out.println("Risposta dal server: " + serverResponse);
            }

            // Chiude la connessione
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
