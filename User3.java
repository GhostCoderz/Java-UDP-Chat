import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class User3 {

    public static void main(String[] args) throws IOException {

        DatagramSocket dgSocket=new DatagramSocket();
        String msg;
        boolean newMsg=true;
        System.out.println("Enter message to be sent or else enter 'q' to quit");
        while(newMsg) {

            Scanner sc = new Scanner(System.in);
            msg = "User 3 : " + sc.nextLine();
            if(msg.trim().equals("User 3 : q"))
            {
                System.out.println("Closing the chat");
                dgSocket.close();
                newMsg=false;
            }
            else {
                byte[] response = msg.getBytes();
                DatagramPacket dp = new DatagramPacket(response, response.length, InetAddress.getLocalHost(), 8989);
                System.out.println("Sending the message to the server");
                dgSocket.send(dp);
                System.out.println("Enter message to be sent or else enter 'q' to quit");
            }
        }

    }

}
