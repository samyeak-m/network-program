package unit8;

import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SecureClients {
    public static void main(String[] args) throws Exception {
        // Load the truststore
        KeyStore trustStore = KeyStore.getInstance("JKS");
        String keystorePath = "D:/samyeak/BCA/6thsem/np/clienttruststore.jks";
        try (FileInputStream trustStoreFis = new FileInputStream(keystorePath)) {
            trustStore.load(trustStoreFis, "truststorepassword".toCharArray());
        }

        // Initialize the TrustManagerFactory with the truststore
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustStore);

        // Initialize the SSLContext with the trust managers
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);

        // Create an SSLSocketFactory from the SSLContext
        SSLSocketFactory factory = sslContext.getSocketFactory();

        // Create an SSLSocket connected to the specified host and port
        SSLSocket socket = (SSLSocket) factory.createSocket("localhost", 8443);


        // Retrieve the SSLSession associated with the socket
        SSLSession session = socket.getSession();

        // Display session details
        System.out.println("SSLSession Details:");
        System.out.println("Cipher suite: " + session.getCipherSuite());
        System.out.println("Protocol: " + session.getProtocol());
        System.out.println("Session ID: " + session.getId());
        System.out.println("Peer Host: " + session.getPeerHost());
        System.out.println("Peer Port: " + session.getPeerPort());

        // Initialize output and input streams for communication
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Send a message to the server
        out.println("Hello, secure server!");

        // Read and print the server's response
        System.out.println("Server says: " + in.readLine());

        // Close the streams and the socket
        out.close();
        in.close();
        socket.close();
    }
}