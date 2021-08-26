import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

    public static void main(String[] args) throws IOException {

        DatagramSocket dgSocket = new DatagramSocket(8989);

        while(true) {

            byte[] response = new byte[1000];
            DatagramPacket dp = new DatagramPacket(response, response.length, InetAddress.getLocalHost(), 8989);
            dgSocket.receive(dp);
            String msg=new String(dp.getData()).trim();

            System.out.println("User add. : " + dp.getSocketAddress()+"\t Message : "+ msg);

        }

    }

}
