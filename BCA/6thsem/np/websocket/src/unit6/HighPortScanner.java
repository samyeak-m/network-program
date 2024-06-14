package unit6;

import java.io.*;
import java.net.*;

public class HighPortScanner {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("Localhost");
            for (int i=1024; i<65536;i++){
                try {
                    Socket socket = new Socket(address, i);
                    System.out.println("There is a server on port "+i+"of Localhost.");
                }catch (IOException e){
//                    System.err.println("There is a server off port "+i+" of localhost");
                }
            }
        }catch (UnknownHostException e1){
            System.out.println("unknwon Host.");
        }
    }
}
