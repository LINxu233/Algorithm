public class PalindromeNumber {
    public  boolean isPalindrome(int x) {
        int nums = 1;
        if (x < 0) return false;

        String s = String.valueOf(x);
        int len = s.length();
        for(int i=0;i<len/2;i++)
            if(s.charAt(i)!=s.charAt(len-1-i))
            {
                nums=0;
                break;
            }
        if (1 == nums)
            return true;
        else
            return false;

    }

}

class TestMain {
    public static void main(String[]args) {

        int[] x = {121,123455, -2323, 0, 333333111};

        for (int k : x)
            System.out.println(new PalindromeNumber().isPalindrome(k));

    }

}


