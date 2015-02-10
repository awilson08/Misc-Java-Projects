
import java.net.*;
import java.io.*;


public class URLConnectionReader {
    public static void main(String[] args) throws Exception {
        URL randomword = new URL("http://randomword.setgetgo.com/get.php");
        URLConnection yc = randomword.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(),"UTF8" ));
        String inputLine;
        inputLine = in.readLine();
        
        String secretword = inputLine.substring(1, inputLine.length());
        System.out.println(secretword);

        in.close();
    }
}