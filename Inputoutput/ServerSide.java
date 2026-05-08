/************************************************(Module-3) Inputstream & OutputStream **********************************************/
//Server side

import java.net.*; // for using socket
import java.io.*; //for using input output stream
public class ServerSide{
    public static void main(String args[]){
        try(ServerSocket server= new ServerSocket(1234)){
            System.out.println("Server is starting on port 1234...");
            System.out.println("Waiting for client to connect");
            Socket socket= server.accept();

            /*Note: Raw streams work with bytes (No text directly) 
              so we use wrappers instead of input & outputstream
            */
            //InputStream in = socket.getInputstream();
            //OutputStream out = socket.getOutputStream();

            /*BufferedReader-read text & PrintWriter- send text*/
            BufferedReader reader = 
                new BufferedReader( 
                    new InputStreamReader(socket.getInputStream()));

            String msg = reader.readLine(); //read lines- receive one line of text from the client, it will block until it receives a line of text from the client.
            System.out.println(msg);       
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}