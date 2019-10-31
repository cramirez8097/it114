import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner; 


public class Server{
public static void main(String args[]){


    Socket s=null;
    ServerSocket ss2=null;
    System.out.println("Waiting");
    try{
        ss2 = new ServerSocket(3001); 

    }
    catch(IOException e){
    e.printStackTrace();
    System.out.println("Error");

    }

    while(true){
        try{
            s= ss2.accept();
            System.out.println("Connection Made");
            ServerThread st=new ServerThread(s);
            st.start();

        }

    catch(Exception e){
        e.printStackTrace();
        System.out.println("Connection Error");

    }
    }

}

}

class ServerThread extends Thread{  

    String line=null;
    BufferedReader  is = null;
    PrintWriter os=null;
    Socket s=null;

    public ServerThread(Socket s){
        this.s=s;
    }

    public void run() {
    try{
        is= new BufferedReader(new InputStreamReader(s.getInputStream()));
        os=new PrintWriter(s.getOutputStream());

    }catch(IOException e){
        System.out.println("IO error");
    }

    try {
        line=is.readLine();
        while(line.compareTo("QUIT")!=0){

            os.println(line);
            os.flush();
            System.out.println("Client:  "+line);
            line=is.readLine();
        }   
    } catch (IOException e) {

        line=this.getName(); 
        System.out.println(" "+line+" terminated abruptly");
    }
    catch(NullPointerException e){
        line=this.getName(); 
        System.out.println("Client "+line+" Closed");
    }

    finally{    
    try{
        System.out.println("Closing");
        if (is!=null){
            is.close(); 
            System.out.println("Closed");
        }

        if(os!=null){
            os.close();
            System.out.println("Closed");
        }
        if (s!=null){
        s.close();
        System.out.println("Closed");
        }

        }
    catch(IOException ie){
        System.out.println("Close Error");
    }
    }
    }
}