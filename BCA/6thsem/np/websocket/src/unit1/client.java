package unit1;

import java.io.*;
import java.net.*;
public class client {
    public static void main(String[] args) {
        try{
            System.out.println("Waiting for connection...");
            Socket socket = new Socket("localhost", 8080);
            System.out.println("Connection established.");
            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out_socket = new PrintWriter(socket.getOutputStream(), true);
            String msg = "";
            msg = in_socket.readLine();
            System.out.println(msg);

            out_socket.println("Hello Server.");


            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
