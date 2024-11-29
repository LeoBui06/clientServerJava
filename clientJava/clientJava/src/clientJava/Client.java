package clientJava;
import java.io.*;
import java.net.*;

public class Client {

	public static void main(String[] args) {
	        // Indirizzo del server e la porta su cui ascolta il server
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
	            
	            // Invia un messaggio al server
	            String messageToSend = "Ciao Server!";
	            writer.println(messageToSend);
	            System.out.println("Messaggio inviato al server: " + messageToSend);
	            
	            // Legge la risposta del server
	            String serverResponse = reader.readLine();
	            System.out.println("Risposta dal server: " + serverResponse);
	            
	            // Chiude il socket
	            socket.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	}

}
