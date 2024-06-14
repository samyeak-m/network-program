package unit6;

import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",443);
            System.out.println("Connected");
            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedReader in_user = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out_socket = new PrintWriter(socket.getOutputStream(),true);
            String message;
            while (true){
                message = in_user.readLine();
                if (message.endsWith("."))break;
                out_socket.println(message);
                System.out.println(in_socket.readLine());
            }
            in_socket.close();
            out_socket.close();
            socket.close();;
        }catch (UnknownHostException e){
            System.err.println("Unknown");
        }catch (IOException e){
            System.err.println("Socket cant be created");
        }
    }
}
