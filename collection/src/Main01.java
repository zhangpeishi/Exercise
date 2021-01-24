import com.sun.tools.javac.util.List;

import java.util.ArrayList;

/**
 * @author zhangpeishi
 *
 * 需求：在聊天软件中，给对方发送消息时，遇到网络超时后，就会自动重发，因此，对方可能接受到重复的消息。在显示给对方看的时候，首先要去重。练习使用Set去重消息。
 *
 * @version 1.0
 *
 * 没有使用set 用的List数据结构，重写Message的equals方法：sequence值一样即判定Messagge相同。把题目中的List转换为ArrayList,
 *
 * 因为List有序，所以遍历用一个数组记录下相同的下标，然后遍历ArrayList,删除数组中不为0的元素的下标对应元素。或者直接遍历arr,发现前一个元素与后一个元素相等
 *
 * 直接把这个元素删除。
 *
 * issues:刚开始没有将List转换为ArrayList,直接遍历List进行删除，会报异常，因为List接口源码的remove方法返回异常对象。
 *
 * unworked:使用Set去重特性优化
 *
 *
 */
/*原题目：
public class Main {
    public static void main(String[] args) {
        List<Message> received = List.of(
            new Message(1, "Hello!"),
            new Message(2, "发工资了吗？"),
            new Message(2, "发工资了吗？"),
            new Message(3, "去哪吃饭？"),
            new Message(3, "去哪吃饭？"),
            new Message(4, "Bye")
        );
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }

    static List<Message> process(List<Message> received) {
        // TODO: 按sequence去除重复消息
        return received;
    }
}

class Message {
    public final int sequence;
    public final String text;
    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }
}
 */
//解答：
public class Main01 {

    public static void main (String[]args){
        List<Message> received = List.of(
                new Message(1, "Hello!"),
                new Message(2, "发工资了吗？"),
                new Message(2, "发工资了吗？"),
                new Message(3, "去哪吃饭？"),
                new Message(3, "去哪吃饭？"),
                new Message(4, "Bye")
        );
        ArrayList<Message> arr = new ArrayList<>(received);
        ArrayList<Message> displayMessages = process(arr);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }

    static ArrayList<Message> process (ArrayList < Message > arr) {

        // TODO: 按sequence去除重复消息

        //int[] a = new int[7];
        for (int i = 0; i < arr.size()-1; i++) {
            if(arr.get(i).equals(arr.get(i+1))){
                arr.remove(i);
            }
        }
//        for (int i = 0; i < a.length; i++) {
//            if(a[i] != 0) {
//                arr.remove(i);
//            }
//        }

        return arr;
    }

}

class Message {
    public final int sequence;
    public final String text;

    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Message) {
            Message message = (Message)o;
            return this.sequence == message.sequence;
        }
        return false;
    }
}

