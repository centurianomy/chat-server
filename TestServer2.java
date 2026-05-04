/************   Note: use -java classsname- in terminal instaead of run    ************/
import java.net.ServerSocket;

public class TestServer2{
    public static void main(String args[]){
        try{ 
            System.out.println("Trying to start server2...");   
            ServerSocket server=new ServerSocket(1234); 
            /*using same port as TestServer.java to show that it is already in use and will throw an exception. (other usable ports: 5000, 8080)*/
            /* ports between 0-1023 are reserved for OS tasks and 1024-65000 are for normal use*/
            System.out.println("Server2 has started on port 1234...");
            Thread.sleep(10000); //waits for 10 seconds.
            server.close(); // to close the server after the sleep time is over.
            System.out.println("Server2 closed...");
        }

        catch(Exception e){
             System.out.println("Error occurred:");
            e.printStackTrace(); // printStackTrace() is an inbuilt method for detailed debugging info. (a java API) 
        }
    }
}
/* for now without using accept() method server starts and terminates instantly.
    it is  not alive, to keep it so use Thread.sleep(100000); inside try block*/
