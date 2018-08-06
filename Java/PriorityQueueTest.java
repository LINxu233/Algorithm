import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueTest {


        public static void main(String args[]){
            PriorityQueue<People> queue = new PriorityQueue<People>(11,
                    new Comparator<People>() {
                        public int compare(People p1, People p2) {
                            return p2.age - p1.age; //自然序是 p1 - p2  要让大的放前面就  -( p1-p2 )
                        }
                    });

            for (int i = 1; i <= 10; i++) {
                queue.add(new People("张"+ i, (new Random().nextInt(100))));
            }
            while (!queue.isEmpty()) {
                System.out.println(queue.poll().toString());
            }
        }


}


class People {
    String name;
    int age;
    public People(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return "姓名："+name + " 年龄：" + age;
    }
}
