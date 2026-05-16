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

            /*Note 1 : Raw streams work with bytes (No text directly) 
              so we use wrappers instead of input & outputstream
            */
            //InputStream in = socket.getInputstream();
            //OutputStream out = socket.getOutputStream();

            /*BufferedReader-read text & PrintWriter- send text*/
            BufferedReader reader = 
                new BufferedReader( 
                    new InputStreamReader(socket.getInputStream()));

            String msg; //read lines- receive one line of text from the client, it will block until it receives a line of text from the client.
            while((msg=reader.readLine()) != null){
                System.out.println(msg);
            }  

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

/* Note 2- in current scenario since we are using while loop to  read the data coming from client,
    also we haven't used socket.close() in client side code.
    And when the client side messages ends. it abruptly closes the connection but the server is still trying to read the messages from the client,
    this resulted in connection reset exception */

/* Note 3-printStackTrace()- is not preferred beacuse it exposes internal implemenmtations,
    its better to use show user-friendly msgs useing- logger.error("...", e) ,etc */