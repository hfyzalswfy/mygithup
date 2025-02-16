
package ahmedcline;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;


public class Ahmedsocet {

    public static void main(String[] args) throws IOException {
        Socket socket=null;
        InputStreamReader inputstreamreader=null;
        OutputStreamWriter outputstreamwriter=null;
        BufferedReader bufferedreader=null;
        BufferedWriter bufferedwriter=null;
        try{
            socket=new Socket( "localhost",  1234);
            inputstreamreader =new InputStreamReader(socket.getInputStream());
            outputstreamwriter=new OutputStreamWriter(socket.getOutputStream());
            bufferedreader =new BufferedReader(inputstreamreader);
            bufferedwriter =new BufferedWriter(outputstreamwriter);
            Scanner scanner=new Scanner(System.in);
            while(true){
                String msgtosend=scanner.nextLine();
                bufferedwriter.write(msgtosend);
                bufferedwriter.newLine();
                bufferedwriter.flush();
                System.out.println("Server: " +bufferedreader.readLine());
                if(msgtosend.equalsIgnoreCase("BYE")){
                    break;
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
            
        }
        finally{
            try{
                if(socket !=null)
                    socket.close();
                if(inputstreamreader !=null)
                    inputstreamreader.close();
                if(outputstreamwriter !=null)
                    outputstreamwriter.close();
                if(bufferedreader !=null)
                    bufferedreader.close();
                if(bufferedwriter !=null)
                    bufferedwriter.close();
                    
                
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        
    
    }
}
