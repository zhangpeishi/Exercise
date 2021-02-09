package UploadFile;

import java.io.*;
import java.net.Socket;

/**
 *
 * 模拟文件上传到服务器
 * 步骤：
 *  创建Socket对象，连接到服务器
 *  获取FileInputSream对象，读取文件
 *  创建Socket 的OutputStram 对象 写入服务器
 *  释放资源
 */
public class TCPClient1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        FileInputStream fis = new FileInputStream("/Users/zhangpeishi/Desktop/a.txt");
        OutputStream os = socket.getOutputStream();
        byte [] bytes = new byte[1024];
        int len = 0;
        while((len = fis.read(bytes)) != -1){
            os.write(bytes);
        }
        socket.shutdownOutput();
        //添加结束标记

        InputStream is = socket.getInputStream();
//        byte [] bytes1 = new byte[1024];
//        int len1 = 0;

        while((len = is.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));
        }



        fis.close();
        socket.close();


    }
}
