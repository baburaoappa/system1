import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClientCalculator 
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
            
            int number1 = 0 ;
            int number2 = 0 ;
            
            System.out.print(" \n\n Enter first number : ") ;
            number1 = sc.nextInt() ;
            
            System.out.print(" \n Enter second number : ") ;
            number2 = sc.nextInt() ;
            
            //write to socket using ObjectOutputStream
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            System.out.print(" \n Sending request to Socket Server");
            
            if(i==1)
            {	
            	dos.writeInt(0) ;
            	dos.writeInt(0);
            }
            else 
            {
            	dos.writeInt(number1) ;
            	dos.writeInt(number2);
            }
            
            //read the server response message
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            int Addition = dis.readInt();
            int Substraction = dis.readInt();
            int Multiplication = dis.readInt();
            int Division = dis.readInt();
            
            System.out.print(" \n Addition is : " + Addition);
            System.out.print(" \n Substraction is : " + Substraction);
            System.out.print(" \n Multiplication is : " + Multiplication);
            System.out.print(" \n Division is : " + Division);
            
            //close resources
            dis.close();
            dos.close();
            socket.close() ;
            Thread.sleep(100);
        }
        
        sc.close() ;
    }
}
