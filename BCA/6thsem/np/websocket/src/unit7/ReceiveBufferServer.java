package unit7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveBufferServer {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setReceiveBufferSize(65536); // Set receive buffer size to 64 KB
            System.out.println("ReceiveBufferServer is listening on port " + port);

            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("New client connected to ReceiveBufferServer with receive buffer size: " +
                            socket.getReceiveBufferSize());
                    // Handle the client connection
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}