package unit6;

import java.io.*;
import java.net.*;

public class egthree {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("www.prime.edu.np",80);
            System.out.println("Connected to " +socket.getInetAddress()+" on port "+socket.getPort()+" from port "+socket.getLocalPort()+" of "+socket.getLocalAddress());
        }
        catch (UnknownHostException ex){
            System.err.println("I cant find the host");
        }
        catch (SocketException ex){
            System.err.println("Could not connect to host");
        }
        catch (IOException ex){
            System.err.println(ex);
        }
    }
}
