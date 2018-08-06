import java.util.Stack;
import static java.lang.System.out;
/**
 * ClassName EasyTest
 * Author Lin
 * Date 2018/8/3 19:12
 **/

public class EasyTest {
    /**
     *
     * @param x
     * @param n
     * @ 迭代的策略，位运算保证二分法，判断每次二分为基数还是偶数
     */
    public static double myPow(double x, int n) {
        double re = 1.0;
        int flag = 0;

        if(n==0) return 1;

        else if(n<0) { n=-n;flag =1;x=1/x;}
        double tmp = x;
        for(int i = 0;i < 32 ;i++)
        {
            if((n & 1)== 1 ) {
                re = re * tmp;

            }
            n =  n>>1;
            tmp = tmp * tmp ;
        }

        return re;

    }
    /**
     *
     * @param x
     * @param n
     * @ 递归的策略，二分，判断指数是偶是还是奇，偶就平方
     */
    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow1(double x, int n) {
        int N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    public  static void main(String[] args){
//        String[] s = { "{}","{([])}"};
//        for(String ss : s)
//        out.print(isValid(ss+" "));
       // out.print(2>>1);
        out.print(myPow(2,10));
    }
}
