package Chap01.code;

public class Ex1321 {
    public static void main(String[] args) {

    }

    public static <T> boolean find(LinkedList<T> l, String key) {
        var i = l.iterator();
        while(i.hasNext()) {
            if (i.next().equals(key)) {
                return true;
            }
        }
        return false;
    }
}
