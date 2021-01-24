import com.sun.tools.javac.util.List;

import java.util.ArrayList;


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

        int[] a = new int[7];
        for (int i = 0; i < arr.size()-1; i++) {
            if(arr.get(i).equals(arr.get(i+1))){
                a[i] = i;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if(a[i] != 0) {
                arr.remove(i);
            }
        }

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

