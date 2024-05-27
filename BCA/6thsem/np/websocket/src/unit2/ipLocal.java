package unit2;

import java.net.*;
public class ipLocal {

    public static void main(String[] args) {
        try{
            InetAddress machine = InetAddress.getLocalHost();
            System.out.println(machine.getHostAddress());
            System.out.println(machine.getCanonicalHostName());

        }
        catch (UnknownHostException e){
            System.out.println("no hostname found.");
        }
    }
}
