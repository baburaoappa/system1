import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClientConcatenation 
{
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException
    {
    	Scanner sc = new Scanner(System.in) ;
    	
        //get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        
        for(int i=0; i<1;i++)
        {
            //establish socket connection to server
            Socket socket = new Socket(host.getHostName(), 8080);
            
            String string1 = null ;
            String string2 = null ;
            
            System.out.print(" \n Enter first string : ") ;
            string1 = sc.next() ;
            
            System.out.print(" \n Enter second string : ") ;
            string2 = sc.next() ;
            
            //write to socket using ObjectOutputStream
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.print(" \n Sending request to Socket Server");
            
            if(i==1)
            {	
            	oos.writeObject("exit") ;
            	oos.writeObject("exit") ;
            }
            else 
            {
            	oos.writeObject(""+ string1);
            	oos.writeObject(""+ string2);
            }
            
            //read the server response message
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String Concatenated_output = (String) ois.readObject();
            System.out.print(" \n " + Concatenated_output);
            
            //close resources
            ois.close();
            oos.close();
            socket.close() ;
            Thread.sleep(100);
        }
        
        sc.close() ;
    }
}

