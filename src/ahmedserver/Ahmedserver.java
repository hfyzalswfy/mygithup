
package ahmedserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Ahmedserver {

    
    public static void main(String[] args) throws IOException {
         Socket socket=null;
        InputStreamReader inputstreamreader=null;
        OutputStreamWriter outputstreamwriter=null;
        BufferedReader bufferedreader=null;
        BufferedWriter bufferedwriter=null;
        ServerSocket serversocket=null;
        serversocket =new ServerSocket(1234);
        while(true){
            try{
                
            
            socket=serversocket.accept();
            inputstreamreader =new InputStreamReader(socket.getInputStream());
            outputstreamwriter=new OutputStreamWriter(socket.getOutputStream());
            bufferedreader =new BufferedReader(inputstreamreader);
            bufferedwriter =new BufferedWriter(outputstreamwriter);
            while(true){
                String msgfromcline=bufferedreader.readLine();
                System.out.println("cline: "+msgfromcline);
                bufferedwriter.write("msg received");
                bufferedwriter.newLine();
                bufferedwriter.flush();
                if(msgfromcline.equalsIgnoreCase("BYE"))
                    break;
            }
            socket.close();
            inputstreamreader.close();
            outputstreamwriter.close();
            bufferedreader.close();
            bufferedwriter.close();
        }
            catch(IOException e){
                e.printStackTrace();
            }
        
    }
    
}}
