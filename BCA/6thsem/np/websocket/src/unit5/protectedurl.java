package unit5;

import java.io.*;
import java.net.*;

public class protectedurl {
    public static void main(String[] args) {
        try {
            URL u = new URL("https://www.oreilly.com/");
            URLConnection uc = u.openConnection();
            System.out.println(uc.getURL());
        }catch (IOException ex){
            System.err.println(ex);
        }
    }
}
