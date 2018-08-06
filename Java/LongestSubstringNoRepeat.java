import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepeat {
    public static int lengthOfLongestSubstring(String s) {

        int  nums=0,k=0 ;
        int len =s.length();
        Map<Character,Integer> map = new HashMap<>();


        for(int i =0;i<len;i++){
         if(map.get(s.charAt(i))!=null){
             k = Math.max(k,map.get(s.charAt(i))+1);//更新左指针到达重复字符的下一个位置上
         }
         map.put(s.charAt(i),i);//记录当前重复的索引
         nums = Math.max(nums,i-k+1);//更新最大长度 i-->j

        }

        return nums;

    }
    //DP解法
    public static int length2(String s ){
        Integer[] temp = new Integer[128];
        int[] dp = new int[s.length()+1];
        int count=0, left=0;
        for(int index=1; index<dp.length; index++) {
            int current = index-1;
            int position = (int) s.charAt(current);
            if(temp[position] != null) {
                if(temp[position] > left)
                    left = temp[position];
                count = current - left;
            } else
                count++;
            temp[position] = current;
            dp[index] = Math.max(count,dp[current]);
        }
        return dp[s.length()];
    }


    public static  void main ( String [] args){
        String[]  strings = {"abcabcbb","bbbbb","pwwkew"};
        for(String s : strings ){
            System.out.println(lengthOfLongestSubstring(s));
        }
        for(String s : strings ){
            System.out.println(length2(s));
        }

    }
}
