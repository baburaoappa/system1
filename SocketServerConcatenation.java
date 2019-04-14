import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerConcatenation 
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
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            
            //convert ObjectInputStream object to String
            String string1 = (String) ois.readObject();
            System.out.println(" \n First string is : " + string1) ;
            
            String string2 = (String) ois.readObject();
            System.out.println(" \n First string is : " + string2) ;            
                      
            String Concatenated_output = string1+string2 ;
            
            System.out.println(" \n Concatenated string is : " + Concatenated_output) ; 
            
            //create ObjectOutputStream object
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            
            //write object to Socket
            oos.writeObject(" \n Concatenated string is : " + Concatenated_output) ;
            
            //close resources
            ois.close();
            oos.close();
            socket.close();
            
            //terminate the server if client sends exit request
            if(string1.equalsIgnoreCase("exit") || string2.equalsIgnoreCase("exit")) 
            {
            	break;
            }
        }
        
        System.out.println(" \n Shutting down Socket server!!");
        //close the ServerSocket object
        server.close();
    }
    
}
