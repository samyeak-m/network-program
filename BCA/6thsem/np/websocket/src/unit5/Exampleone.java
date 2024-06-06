package unit5;

import java.io.*;
import java.net.*;

public class Exampleone {

    public static void main(String[] args) {
        try {
            URL u = new URL("https://prime.edu.np");
            URLConnection uc = u.openConnection();
            System.out.println("content : "+uc.getDate());
        }
        catch (MalformedURLException ex){
            System.err.println("it is not a parseable url");
        }
        catch (IOException ex){
            System.err.println(ex);
        }
    }

}
