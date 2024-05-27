package unit2;

import java.net.*;

public class subdom {
    public static void main(String[] args) {
        try{
            InetAddress ibibilo = InetAddress.getByName("furnex24.eventsolutionnepal.com.np");
            InetAddress helios = InetAddress.getByName("eventsolutionnepal.com.np");

            if (ibibilo.equals(helios)){
                System.out.println("www.ibiblio.org is same as helios.ibiblio.org");
            }
            else{
                System.out.println("not same");
            }
        }
        catch (UnknownHostException e){
            System.out.println("Host lookup failed");
        }
    }
}
