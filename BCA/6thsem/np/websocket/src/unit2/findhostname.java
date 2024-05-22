package unit2;

import java.net.*;

public class findhostname {
    public static void main(String[] args) {
        try {
            InetAddress machine = InetAddress.getByName("157.240.239.35");
            System.out.println(machine.getCanonicalHostName());
        }catch (UnknownHostException e){
            System.out.println("no hostname found");
        }
    }
}
