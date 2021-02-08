import sun.jvm.hotspot.runtime.Bytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);

        Socket sc = ss.accept();
        InputStream is = sc.getInputStream();

        System.out.println(is.read());
        OutputStream os = sc.getOutputStream();

        os.write("收到谢谢".getBytes());

        sc.close();
        ss.close();



    }
}
