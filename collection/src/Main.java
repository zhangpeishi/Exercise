import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }

    private static int findMissingNumber(int start, int end, List<Integer> list) {
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer-t1;
            }
        });
        for (int i = 0; i <= end-start; i++) {
            if( list.get(i)!= (start+i)){
                return i+start;
            }
        }
        return 0;
    }

}