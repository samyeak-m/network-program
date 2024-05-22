package unit2;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class findip {

    public static void main(String[] args) {
        try {

            InetAddress address=InetAddress.getByName("www.facebook.com");
            System.out.println(address);
        }
        catch (UnknownHostException e){
            System.out.println("Couldn't find the host");
        }
    }

}
