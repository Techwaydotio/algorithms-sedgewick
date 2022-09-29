package Chap01.code;

public class Ex1315 {
    public static void main(String[] args) {
        int k = 2;
        var queue = new Queue<String>();
        var strings = new String[]{"hello", "world", "how", "are", "you"};
        for (int i = 1; i < strings.length; i += 1) {
            queue.enqueue(strings[i]);
        }

        // prints the kth from the last string
        while(queue.size()-k > 0) {
            queue.dequeue();
        }
        System.out.println(queue.dequeue());
    }
}