package unit5;

import java.net.*;
import java.util.Date;
import java.io.*;

public class three {

    public static void main(String[] args) {
        try {
            URL u = new URL("https://www.prime.edu.np/");
            URLConnection uc = u.openConnection();
            System.out.println("Content-type : "+uc.getContentType());
            if (uc.getContentEncoding() != null){
                System.out.println("content-encoding : "+ uc.getContentEncoding());
            }
            if (uc.getDate() != -1) {
                System.out.println("Date: " + new Date(uc.getDate()));}
            if (uc.getLastModified() != -1) {
                System.out.println("Last modified: "+ new Date(uc.getLastModified()));}
            if (uc.getExpiration() != -1) {
                System.out.println("Expiration date: "+ new Date(uc.getExpiration()));}
            if (uc.getContentLength() != -1) {
                System.out.println("Content-length: " + uc.getContentLength());}
        } catch (MalformedURLException ex) {
            System.err.println("It is not a valid URL.");
        } catch (IOException ex) {
            System.err.println(ex);}
        System.out.println();
    }
}