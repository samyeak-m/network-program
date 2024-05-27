package unit2;

import java.net.*;

public class SpamCheck {

    public static final String BLACKHOLE = "sbl.spamhaus.org";

    public static void main(String[] args) throws UnknownHostException {

        for (String arg:args){
            if(isSpammer(arg)){
                System.out.println(arg + " is a know spammer.");

            }
            else{
                System.out.println(arg+" appears legitimate.");
            }
        }

    }

    private static boolean isSpammer(String arg){
        try{
            InetAddress address = InetAddress.getByName(arg);
            byte[] quad = address.getAddress();
            String query = BLACKHOLE;
            for(byte octet:quad){
                int unsingedByte = octet < 0 ? octet + 256 : octet;
                query = unsingedByte + "."+query;

            }
            InetAddress.getByName(query);
            return true;
        }catch (UnknownHostException e){
            return false;
        }
    }

}