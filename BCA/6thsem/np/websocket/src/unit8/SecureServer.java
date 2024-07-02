package unit8;

import java.io.*;
import java.security.KeyStore;
import javax.net.ssl.*;

public class SecureServer {
    public static void main(String[] args) throws Exception {
        // Load the keystore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        String keystorePath = "D:/samyeak/BCA/6thsem/np/serverkeystore.jks";
        try (FileInputStream keyStoreFis = new FileInputStream(keystorePath)) {
            keyStore.load(keyStoreFis, "password".toCharArray());
        }

        // Initialize the KeyManagerFactory with the keystore
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, "password".toCharArray());

        // Initialize the SSLContext with the KeyManagers from the KeyManagerFactory
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), null, null);

        // Create SSL server socket factory from SSLContext
        SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();

        // Create SSL server socket
        int serverPort = 8443;
        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(serverPort);

        // Enable client authentication if needed
        serverSocket.setNeedClientAuth(false);
        System.out.println("Server started. Listening on port " + serverPort + "...");

        // Server loop
        while (true) {
            // Accept client connection
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

            // Handle client communication in a separate thread or process
            new Thread(new ClientHandler(clientSocket)).start();
        }
    }

    // Example client handler thread
    static class ClientHandler extends Thread {
        private SSLSocket clientSocket;

        public ClientHandler(SSLSocket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Read from and write to the client socket as needed
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                // Example: Echo server functionality
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received: " + line);
                    writer.write(line + "\n");
                    writer.flush();
                }

                // Close client socket
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}