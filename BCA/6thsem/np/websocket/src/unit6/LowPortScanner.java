package unit6;

import java.io.*;
import java.net.*;

public class LowPortScanner {

    public static void main(String[] args) {
        for (int i=1;i<1024;i++){
            try{
                Socket socket = new Socket("localhost",80);
                System.out.println("There is server on port "+i+" of localhost.");
            }
            catch (UnknownHostException e){
                System.out.println(e);
            }
            catch (IOException e){
                System.err.println("there is server off port "+i+" of localhost");
            }
        }
    }

}
