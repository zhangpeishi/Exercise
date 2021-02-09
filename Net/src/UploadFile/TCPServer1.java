package UploadFile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 *
 * 优化：一直监听 每次来一个客户端 就新建一个线程
 */
public class TCPServer1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        while (true) {
            Socket socket = ss.accept();
            new Thread(()->{
                try{

                    InputStream is = socket.getInputStream();

                    String filename = "zhangpeishi" + System.currentTimeMillis() + new Random().nextInt(99999);
                    FileOutputStream fos = new FileOutputStream("/Users/zhangpeishi/Desktop/" + filename + ".txt");
                    byte[] bytes = new byte[1024];
                    int len = 0;
                    while ((len = is.read(bytes)) != -1) {
                        fos.write(bytes);
                    }
                    OutputStream os = socket.getOutputStream();
                    os.write("上传完毕".getBytes());

                    fos.close();
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }

            }).start();

        }

    }
}
