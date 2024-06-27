package unit7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Redirector {
    public static void main(String[] args) {
        int port = 0;
        String redirectUrl = "http://example.com";

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Redirector is listening on port " + serverSocket.getLocalPort());
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("New client connected");

                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                    // Read the HTTP request (only the first line for simplicity)
                    String requestLine = in.readLine();
                    System.out.println("Request: " + requestLine);

                    if (requestLine != null && requestLine.startsWith("GET")) {
                        // Send HTTP redirect response
                        out.println("HTTP/1.1 302 Found");
                        out.println("Location: " + redirectUrl);
                        out.println();
                    }

                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}