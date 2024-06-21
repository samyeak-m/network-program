package unit7;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class BinaryDataClient {

    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            DataInputStream input = new DataInputStream(socket.getInputStream());

            // Read binary data from the server
            byte[] binaryData = new byte[5];
            input.readFully(binaryData);

            System.out.println("Received binary data from server:");
            for (byte b : binaryData) {
                System.out.print(b + " ");
            }

        } catch (IOException ex) {
            System.out.println("Client exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}