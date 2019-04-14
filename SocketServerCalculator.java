import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerCalculator
{
    //static ServerSocket variable
    private static ServerSocket server;
    
    //socket server port on which it will listen
    private static int port = 8080;
    
    public static void main(String args[]) throws IOException, ClassNotFoundException
    {
        //create the socket server object
        server = new ServerSocket(port);
        
        //keep listens indefinitely until receives 'exit' call or program terminates
        while(true)
        {
            System.out.println(" \n Waiting for client request");
            
            //creating socket and waiting for client connection
            Socket socket = server.accept();
            
            //read from socket to ObjectInputStream object
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            
            //convert ObjectInputStream object to String
            int number1 = dis.readInt();
            System.out.println(" \n First number is : " + number1) ;
            
            int number2 = dis.readInt();
            System.out.println(" \n Second number is : " + number2) ;            
                      
            int Addition = number1 + number2 ;
            int Substraction = number1 - number2 ;
            int Multiplication = number1 * number2 ;
            int Division = number1 / number2 ;
            
            System.out.println(" \n Addition is : " + Addition) ; 
            System.out.println(" \n Substraction is : " + Substraction) ; 
            System.out.println(" \n Multiplication is : " + Multiplication) ; 
            System.out.println(" \n Division is : " + Division) ; 
            
            //create ObjectOutputStream object
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            
            //write object to Socket
            dos.writeInt(Addition) ;
            dos.writeInt(Substraction) ;
            dos.writeInt(Multiplication) ;
            dos.writeInt(Division) ;
            
            //close resources
            dis.close();
            dos.close();
            socket.close();
            
            //terminate the server if client sends exit request
            if(number1 == 0 || number2 == 0 ) 
            {
            	break;
            }
        }
        
        System.out.println(" \n Shutting down Socket server!!");
        //close the ServerSocket object
        server.close();
    }
}
