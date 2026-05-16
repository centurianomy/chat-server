/************************************************(Module-3) Inputstream & OutputStream **********************************************/
//Client side

import java.net.*; // for using socket
import java.io.*; //for using input output stream
public class ClientSide{
    public static void main(String args[]){
        try{
            Socket socket= new Socket("localhost",1234);
            System.out.println("Client connected to the server.");

            /*Note: Raw streams work with bytes (No text directly) 
              so we use wrappers instead of input & outputstream
            */
            //InputStream in = socket.getInputstream();
            //OutputStream out = socket.getOutputStream();

            /*BufferedReader- read text & PrintWriter- send text*/
            PrintWriter writer =
                new PrintWriter(socket.getOutputStream(), true); 
                /*socket.getOutputStream() --Gets sending path*/
            writer.println("Hello server"); //println- send one line of text to the server, it will automatically flush the stream after sending the line. (true in constructor is for auto flush)
            writer.println("Vinland saga!");
            socket.close();//to close the connection after sending the messages to the server
            //reference Note 2(ServerSide)
        }   

        catch(Exception e){
            e.printStackTrace();
        }
    }
}