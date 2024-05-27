package unit2;

import  java.net.*;
public class ipav {
    public static void main(String[] args) {
        try{
            InetAddress machine = InetAddress.getByName("ungleich.ch");
            byte[]address = machine.getAddress();
            if (address.length==4)
                System.out.println("IPv4 in used");
            else
                System.out.println("IPv6 in used");
        }
        catch (UnknownHostException e){
            System.out.println("NO host found");
        }
    }
}
