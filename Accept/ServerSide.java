/*******************************(Module-2) Server side code for creating a server- [using accept() method] ************************************/
import java.net.*;
public class ServerSide{
    public static void main(String args[]){
        try(ServerSocket server= new ServerSocket(1234)){
            System.out.println("Server started on port 1234...");
            System.out.println("Waiting for the client.");

            Socket socket= server.accept();// accept is a blocking method, program stops here untill client connects to the server.
            //once the client connects it return a socket object, which represent the connection btwn server and client.
            System.out.println("Client connected.");
            System.out.println(socket.getInetAddress());//*optional* to get the IP address of the client. (getInetAddress() is a method of Socket class)
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

//use cd folder name to navigate to the foldder incase of file not found error.