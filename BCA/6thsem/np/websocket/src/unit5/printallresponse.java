package unit5;

import java.io.*;
import java.net.*;

public class printallresponse {
    public static void main(String[] args) {

            try {
              URL u = new URL("https://eventsolutionnepal.com.np/");
                HttpURLConnection uc = (HttpURLConnection) u.openConnection();
                int code = uc.getResponseCode();//200
                String response = uc.getResponseMessage();//OK
                System.out.println("HTTP/1.x " + code + " " + response);
                int i=1;
                while(uc.getHeaderField(i)!=null) {//value check in key:value pair
                    System.out.println(uc.getHeaderFieldKey(i)+":"+uc.getHeaderField(i));
                    i++;
                }
                System.out.println();
                BufferedReader in_data = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                String entry;
                while((entry=in_data.readLine())!=null) {
                    System.out.println(entry);
                }} catch (MalformedURLException ex) {
                System.err.println("It is not a parseable URL");
            } catch (IOException ex) {
                System.err.println(ex);}}}

