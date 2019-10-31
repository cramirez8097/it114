import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner; 

public class Client {

public static void main(String args[]) throws IOException{


    InetAddress address=InetAddress.getLocalHost();
    Socket s1=null;
    String line=null;
    BufferedReader br=null;
    BufferedReader is=null;
    PrintWriter os=null;

    try {
        s1=new Socket(address, 3001); 
        br= new BufferedReader(new InputStreamReader(System.in));
        is=new BufferedReader(new InputStreamReader(s1.getInputStream()));
        os= new PrintWriter(s1.getOutputStream());
    }
    catch (IOException e){
        e.printStackTrace();
        System.err.print("IO Exception");
    }
    Scanner sc = new Scanner(System.in); 
    System.out.println("Enter your name:");
    //String Pname = sc.nextLine(); 
    System.out.println("Enter Message, Enter QUIT to end:");

    String response=null;
    try{
        line=br.readLine(); 
        while(line.compareTo("QUIT")!=0){
                os.println(line);
                os.flush();
                response=is.readLine();
                System.out.println(Pname+": "+response);
                line=br.readLine();

            }



    }
    catch(IOException e){
        e.printStackTrace();
    System.out.println("Read Error");
    }
    finally{

        is.close();os.close();br.close();s1.close();
                System.out.println("Connection Terminated");

    }

}
}