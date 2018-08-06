import static java.lang.Math.pow;

public class ReverseInteger {

    public static void main(String[] args) {

        int [] values = {-2147483648,2147483647,123, 1200,1534236469};
        System.out.println(String.valueOf(Math.pow(2,31)));
        for(int i =0 ;i<values.length;i++){
            System.out.print(inverse(values[i])+" ");
        }
    }
    public static int inverse(int x) {
        int cnt = 0;
        int flag = 1;
        long  num =0,k=x,t;
        int low=0;
        if(k>Integer.MAX_VALUE|| k<Integer.MIN_VALUE) return 0;
        if(k<0) { flag=-1; k = -k;}
        while(k>0&&k%10==0) k = k/10;
        while(k!=0){
            t = num * 10+ k- k/10 * 10;//必须用t储存中间结果，不然溢出了if不会成立，默认的int保存结果
            if(t>Integer.MAX_VALUE&& flag==-1)
                return 0;
            if(t>=Integer.MAX_VALUE&&flag ==1)
                return 0;
           num = num * 10+ k- k/10 * 10;
           k=k/10;
           cnt++;
        }
      /*  if(num>=Integer.MAX_VALUE&& flag==-1)
            return 0;
        if(num>Integer.MAX_VALUE&&flag ==1)
        {
            //System.out.println("溢出了!!");
            return 0;
        }
*/
        return  flag*(int)num;
    }
}
