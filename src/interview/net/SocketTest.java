package interview.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class SocketTest {
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        ServerSocket serverSocket = new ServerSocket(8080,50,inetAddress);
        // un-binding ip address. ip is not certain 0.0.0.0
//        ServerSocket serverSocket = new ServerSocket(8081);
        String ip = serverSocket.getInetAddress().getHostAddress();
        String name = serverSocket.getInetAddress().getHostName();
        String cname = serverSocket.getInetAddress().getCanonicalHostName();
        System.out.println(name);
        System.out.println(cname);
        System.out.println(ip);
        serverSocket.accept();
    }
}
