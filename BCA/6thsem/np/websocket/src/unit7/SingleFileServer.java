package unit7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SingleFileServer {
    public static void main(String[] args) {
        int port = 8080;
        String fileUrl = "https://raw.githubusercontent.com/Sharatmaharjan/Np/main/code/index.html"; // Raw file URL from GitHub

        try {
            // Fetch the HTML content from the URL
            String content = fetchContentFromUrl(fileUrl);

            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("SingleFileServer is listening on port " + port);

                while (true) {
                    try (Socket socket = serverSocket.accept()) {
                        System.out.println("New client connected");

                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                        // Read the HTTP request (only the first line for simplicity)
                        String requestLine = in.readLine();
                        System.out.println("Request: " + requestLine);

                        if (requestLine != null && requestLine.startsWith("GET")) {
                            // Send HTTP response
                            out.println("HTTP/1.1 200 OK");
                            out.println("Content-Type: text/html");
                            out.println("Content-Length: " + content.length());
                            out.println();
                            out.println(content);
                        }

                        socket.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String fetchContentFromUrl(String fileUrl) throws IOException {
        StringBuilder content = new StringBuilder();
        URL url = new URL(fileUrl);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine).append("\n");
            }
        }
        return content.toString();
    }
}