package ass.bill.src1;

import java.io.*;
import java.net.*;

public class udptest {
	
	public static void main(String[] args)throws IOException{
        DatagramSocket  server = new DatagramSocket(5050);								//port
        byte[] recvBuf = new byte[100];
        
        System.out.print("I'm udp server\n");
        
        DatagramPacket recvPacket 
            = new DatagramPacket(recvBuf , recvBuf.length);
        server.receive(recvPacket);
        String recvStr = new String(recvPacket.getData() , 0 , recvPacket.getLength());
        System.out.println("Got:" + recvStr);									//print data from client
        int port = recvPacket.getPort();
        InetAddress addr = recvPacket.getAddress();
        String sendStr = "Hello ! I'm Server";											//send to client
        byte[] sendBuf;
        sendBuf = sendStr.getBytes();
        DatagramPacket sendPacket 
            = new DatagramPacket(sendBuf , sendBuf.length , addr , port );
        server.send(sendPacket);
        server.close();
    }
}
