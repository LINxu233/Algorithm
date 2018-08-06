import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int flag = 0;
        ListNode p1 = l1, p2 = l2;
        ListNode p = new ListNode(0);
        ListNode head = p;

        while (p1 != null || p2 != null || flag == 1) {
            int tmp = 0;
            if (p1 != null) {
                tmp += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                tmp += p2.val;
                p2 = p2.next;
            }
            if (flag == 1) {
                tmp += flag;
            }
            flag = tmp >= 10 ? 1 : 0;
            tmp = tmp - tmp / 10 * 10;
            p.val = tmp;
            if (p1 != null || p2 != null || flag == 1)
                p.next = new ListNode(0);
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode t1, t2, t3;
        t1 = new ListNode(1);
        t2 = new ListNode(4);
        t3 = new ListNode(5);
        t1.next = t2;
        t2.next = t3;
        t3.next = null;
        ListNode k1, k2, k3;
        k1 = new ListNode(4);
        k2 = new ListNode(5);
        k3 = new ListNode(6);
        k1.next = k2;
        k2.next = k3;
        k3.next = null;

        ListNode k = AddTwoNumbers.addTwoNumbers(t1, k1);
        //ListNode k = mergeTwoLists(t1,k1);
        while (k.next != null) {
            System.out.print(k.val + "->");
            k = k.next;
        }
/*        System.out.println(k.val);*/
   /*     Stack<Character> s = new Stack<>();
        if(s.isEmpty()) return false;
        s.*/
        //Queue<Character> queue = new ArrayDeque<>();
        //Queue<Integer> qu1 = new PriorityQueue<>();
        //Queue<Integer> qu2 = new ArrayBlockingQueue<Integer>(5);

    }
}
