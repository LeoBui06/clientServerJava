package serverJava;
import java.io.*;
import java.net.*;

public class ServerJava {
	

	public static void main(String[] args) {

		int port = 31114; // La stessa porta usata dal client
        
        try {
            // Crea un server socket
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server in ascolto sulla porta " + port);
            
            // Accetta la connessione del client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connessione accettata dal client: " + clientSocket.getInetAddress());
            
            // Flussi di input e output per comunicare con il client
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();
            
            // Lettore per leggere i dati inviati dal client
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);
            
            String clientMessage;

                
            while(true)
            {
            	   
                // Legge il messaggio inviato dal client
                clientMessage = reader.readLine();
                System.out.println("Messaggio ricevuto dal client: " + clientMessage);
                
                if( clientMessage.equalsIgnoreCase("exit") ) {
                    System.out.println("connessione interrotta dal client: ");
                	break;
                }
                
                
                clientMessage = clientMessage.toUpperCase(  );

                //System.out.println("Messaggio in upper case: " + clientMessage);
                
                
                // Invia una risposta al client
                String response = clientMessage;
                writer.println(response);
                System.out.println("Risposta inviata al client: " + response);
            }
            

            
            // Chiude la connessione
            clientSocket.close();
            serverSocket.close();
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
}
