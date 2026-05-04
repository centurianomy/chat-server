/************************************** Client side code for connecting to the server *********************************************************/
import java.net.*;
public class ClientSide{
    public static void main(String args[]){
        try{
            Socket socket = new Socket("localhost", 1234); //sends connection req to server, server returns a socket object to client.
            System.out.println("Connected to the server.");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

/* dont use ->(ServerSocket server=  new ServerSocket(1234)) along try
            because client side doesn't need to create a server socket,
            it will req the connection from the server 
*/