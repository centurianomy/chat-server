/******************************************************** (Module-1) **************************************************************/
//Note: use -java classsname- in terminal instaead of run.
import java.net.ServerSocket;

public class TestServer{
    public static void main(String args[]){
        try(ServerSocket server=new ServerSocket(1234)) //try with resource statement
        {        
            //other usable ports: 5000, 8080 
            /* ports between 0-1023 are reserved for OS tasks and 1024-65000 are for normal use*/
            System.out.println("Server has started on port 1234...");
            // to keep the server running for a while, otherwise it will start and end immediately. (10000 milliseconds = 10 seconds)
            for(int i=0; i<5; i++){
                if(i==4){
                    System.out.println("Server is closing...");
                    break;
                }
                System.out.println("Server is alive.");
                Thread.sleep(2000); // to print the message every 2 seconds.
            }
            System.out.println("Server closed.");
        }

        catch(Exception e){
            e.printStackTrace(); // printStackTrace() is an inbuilt method for detailed debugging info. (a java API) 
        }
    }

}

/* */
/*for now without using accept() method server starts and terminates instantly.
    it is  not alive, to keep it so use Thread.sleep(100000); inside try block*/


 /* try(ServerSocket server=new ServerSocket(1234); ){}
    internal working: automatically calls server.close() 
     it is- try{
                ServerSocket server=new ServerSocket(1234);
                //code to use the server
            }
            finally{ 
            server.close();
            }
*/