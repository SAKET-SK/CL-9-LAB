import java.io.BufferedReader;
import java.net.InetAddress;
import java.io.*;
import java.net.*;
import java.util.*;
public class Client{
    private static Socket socket;

    public static void main(String args[]){
        try{
            String host = "localhost";
            int port = 20100;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address,port);
            
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number meassage to be sent to the server : ");
            String number = sc.next();

            String sendMessage = number + "\n";
            bw.write(sendMessage);
            bw.flush();
            System.out.println("Message sent to the Server = " + sendMessage);

            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();
            System.out.println("Message received from server = " + message);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                socket.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
