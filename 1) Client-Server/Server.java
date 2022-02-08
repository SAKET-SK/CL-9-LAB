import java.io.*;
import java.net.*;

public class Server{
    private static Socket socket;

    public static void main(String args[]){
        try{
            int port = 2000;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("SERVER STARTS at port :- "+ port);
            
            while(true){
                socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String number = br.readLine();
                System.out.println("Message received from client = " + number);

                String returnMessage;
                try{
                    int outputNumber = Integer.parseInt(number);
                    int returnValue = outputNumber * 10;
                    returnMessage = String.valueOf(returnValue) + "\n";
                }catch(NumberFormatException e){
                    returnMessage = "Invalid input\n";
                }

                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println("Message sent to the client = " + returnMessage);
                bw.flush();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                socket.close();
            }catch (Exception e){

            }
        }
    }
}