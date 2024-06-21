package unit7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggedClient {
    private static final Logger logger = Logger.getLogger(LoggedClient.class.getName());

    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            logger.info("Connected to server");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverTime = input.readLine();
            logger.info("Received server time: " + serverTime);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Client exception", ex);
        }
    }
}