import java.io.*;
import java.net.*;
public class server {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Waiting for connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Connected to client");
            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out_socket = new PrintWriter(socket.getOutputStream(), true);
            out_socket.println("Hello Client.");
            String msg = "";
            msg = in_socket.readLine();
            System.out.println(msg);

            socket.close();
            serverSocket.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
