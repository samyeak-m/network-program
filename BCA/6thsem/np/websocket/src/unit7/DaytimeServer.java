package unit7;

import java.net.*;
import java.io.*;
import java.util.Date;
public class DaytimeServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            while (true) {
                try {
                    Socket socket = server.accept();
                    Thread task = new DaytimeThread(socket);
                    task.start();
                } catch (IOException ex) {}
            }
        } catch (IOException ex) {
            System.err.println("Couldn't start server");
        }}
    private static class DaytimeThread extends Thread {
        private Socket socket;
        DaytimeThread(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                Writer out = new OutputStreamWriter(socket.getOutputStream());
                Date now = new Date();
                out.write(now.toString() +"\r\n");
                out.flush();
                socket.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}