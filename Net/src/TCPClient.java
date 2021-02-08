import sun.jvm.hotspot.runtime.Bytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);

        OutputStream os = socket.getOutputStream();

        os.write("你好，服务器".getBytes());
        byte [] bytes = new byte[1024];
        InputStream is = socket.getInputStream();
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));
        socket.close();

    }
}

